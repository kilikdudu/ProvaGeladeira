package br.com.carloseduardo.spring.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.carloseduardo.spring.model.Compra;
import br.com.carloseduardo.spring.model.Produto;
import br.com.carloseduardo.spring.model.ProdutoCompra;
import br.com.carloseduardo.spring.service.CompraService;
import br.com.carloseduardo.spring.service.MercadoService;
import br.com.carloseduardo.spring.service.ProdutoCompraService;
import br.com.carloseduardo.spring.service.ProdutoService;

@Controller
public class CompraController {
	
	
	private CompraService compraService;
	
	@Autowired(required=true)
	@Qualifier(value="compraService")
	public void setMarcaService(CompraService cs){
		this.compraService = cs;
	}
	
	private ProdutoCompraService produtocompraService;
	
	@Autowired(required=true)
	@Qualifier(value="produtocompraService")
	public void setProdutocompraService(ProdutoCompraService produtocompraService){
		this.produtocompraService = produtocompraService;
	}
	
	private MercadoService mercadoService;
	
	@Autowired(required=true)
	@Qualifier(value="mercadoService")
	public void setMercadoService(MercadoService mercadoService){
		this.mercadoService = mercadoService;
	}
	
	private ProdutoService produtoService;
	
	@Autowired(required=true)
	@Qualifier(value="produtoService")
	public void setProdutoService(ProdutoService produtoService){
		this.produtoService = produtoService;
	}
	
	@InitBinder  
	 public void initBinder(WebDataBinder binder)   
	 {  
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	  dateFormat.setLenient(false);  
	  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
	 }
	
	@RequestMapping(value = "/compras", method = RequestMethod.GET)
	public String listCompras(Model model, HttpSession session) {
		if(session.getAttribute("geladeira_id") == null){
			return "redirect:/geladeiras";
		}
		model.addAttribute("geladeira_id", (Integer)session.getAttribute("geladeira_id"));
		model.addAttribute("compra", new Compra());
		model.addAttribute("produtocompra", new ProdutoCompra());
		model.addAttribute("listCompras", this.compraService.listCompras((Integer)session.getAttribute("usuario_id")));
		model.addAttribute("listMercados", this.mercadoService.listMercados());
		model.addAttribute("listProdutos", new ArrayList<Produto>());
		model.addAttribute("listProdutoscompras", new ArrayList<ProdutoCompra>());
		return "compras";
	}
	
	@RequestMapping(value= "/compras/add", method = RequestMethod.POST)
	public String addCompra(@ModelAttribute("compra") Compra c, @RequestParam("mercado_id") int mercado_id, @RequestParam("geladeira_id") int geladeira_id, HttpSession session){	
		if(c.getId() == 0){
			this.compraService.addCompra(c, mercado_id, (Integer)session.getAttribute("usuario_id"));
		}else{
			this.compraService.updateCompra(c, mercado_id, (Integer)session.getAttribute("usuario_id"));
		}
		return "redirect:/compras";
	}
	
	@RequestMapping("/compras/edit")
    public String editCompra(@RequestParam("id") int id, @RequestParam("geladeira_id") int geladeira_id, Model model, HttpSession session){
		model.addAttribute("compra", compraService.getCompraById(id));
		model.addAttribute("geladeira_id", geladeira_id);
		model.addAttribute("produtocompra", new ProdutoCompra());
		model.addAttribute("listCompras", this.compraService.listCompras((Integer)session.getAttribute("usuario_id")));
		model.addAttribute("listMercados", this.mercadoService.listMercados());
		model.addAttribute("listProdutos", this.produtoService.listProdutos());
		model.addAttribute("listProdutoscompras", this.produtocompraService.listProdutosCompras(geladeira_id, id));
        return "compras";
    }
	
	@RequestMapping("/compras/remove")
    public String removeCompra(@RequestParam("id") int id){
		
        this.compraService.removeCompra(id);
        return "redirect:/compras";
    }
	
	@RequestMapping(value= "/compras/addProduto", method = RequestMethod.POST)
	public String addProdutoCompra(@ModelAttribute("produtocompra") ProdutoCompra pc, @RequestParam("compra_id") int compra_id, 
			@RequestParam("geladeira_id") int geladeira_id, @RequestParam("produto_id") int produto_id){	
		this.produtocompraService.addProdutoCompra(pc, produto_id, compra_id, geladeira_id);
		return "redirect:/compras/edit?id="+compra_id+"&geladeira_id="+geladeira_id;
	}
	
	@RequestMapping("/compras/removeProduto")
    public String removeCompra(@RequestParam("compra_id") int compra_id, @RequestParam("geladeira_id") int geladeira_id, @RequestParam("id") int id){
        this.produtocompraService.removeProdutoCompra(id);
        return "redirect:/compras/edit?id="+compra_id+"&geladeira_id="+geladeira_id;
    }
	
}
