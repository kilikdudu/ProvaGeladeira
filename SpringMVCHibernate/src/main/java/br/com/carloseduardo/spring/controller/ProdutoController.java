package br.com.carloseduardo.spring.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.carloseduardo.spring.model.Produto;
import br.com.carloseduardo.spring.service.MarcaService;
import br.com.carloseduardo.spring.service.ProdutoService;
import br.com.carloseduardo.spring.service.TipoService;

@Controller
public class ProdutoController {
	
	private ProdutoService produtoService;
	private TipoService tipoService;
	private MarcaService marcaService;
	
	@Autowired(required=true)
	@Qualifier(value="produtoService")
	public void setProdutoService(ProdutoService ps){
		this.produtoService = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="tipoService")
	public void setTipoService(TipoService ts){
		this.tipoService = ts;
	}
	
	@Autowired(required=true)
	@Qualifier(value="marcaService")
	public void setMarcaService(MarcaService ma){
		this.marcaService = ma;
	} 
	
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public String listProdutos(Model model) {
		model.addAttribute("produto", new Produto());
		model.addAttribute("listTipos", this.tipoService.listTipo());
		model.addAttribute("listMarcas", this.marcaService.listMarcas());
		model.addAttribute("listProdutos", this.produtoService.listProdutos());
		return "produtos";
	}
	
	//For add and update person both
	@RequestMapping(value= "/produtos/add", method = RequestMethod.POST)
	public String addProduto(@ModelAttribute("produto") Produto p, @RequestParam int tipoId, @RequestParam int marcaId){
		if(p.getId() == 0){
			//new person, add it
			this.produtoService.addProduto(p, tipoId, marcaId);
		}else{
			//existing person, call update
			this.produtoService.updateProduto(p, tipoId, marcaId);
		}
		
		return "redirect:/produtos";
		
	}
	
	@RequestMapping("/produtos/remove/{id}")
    public String removeProduto(@PathVariable("id") int id){
		
        this.produtoService.removeProduto(id);
        return "redirect:/produtos";
    }
 
    @RequestMapping("/produtos/edit/{id}")
    public String editProduto(@PathVariable("id") int id, Model model){
        model.addAttribute("produto", this.produtoService.getProdutoById(id));
        model.addAttribute("listTipos", this.tipoService.listTipo());
		model.addAttribute("listMarcas", this.marcaService.listMarcas());
        model.addAttribute("listProdutos", this.produtoService.listProdutos());
        return "produtos";
    }
	
}
