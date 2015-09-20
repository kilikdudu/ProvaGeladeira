package br.com.carloseduardo.spring.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.carloseduardo.spring.model.Geladeira;
import br.com.carloseduardo.spring.model.Geladeiras;
import br.com.carloseduardo.spring.model.ProdutoCompra;
import br.com.carloseduardo.spring.service.GeladeiraService;
import br.com.carloseduardo.spring.service.ProdutoCompraService;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;

@Controller
public class GeladeiraController {
	
	
	private GeladeiraService geladeiraService;
	
	@Autowired(required=true)
	@Qualifier(value="geladeiraService")
	public void setGeladeiraService(GeladeiraService geladeiraService){
		this.geladeiraService = geladeiraService;
	}
	
	private ProdutoCompraService produtocompraService;
	
	@Autowired(required=true)
	@Qualifier(value="produtocompraService")
	public void setProdutocompraService(ProdutoCompraService produtocompraService){
		this.produtocompraService = produtocompraService;
	}
	
	@RequestMapping(value = "/geladeiras", method = RequestMethod.GET)
	public String listGeladeiras(Model model, HttpSession session) {
		model.addAttribute("geladeira", new Geladeira());
		model.addAttribute("listGeladeiras", this.geladeiraService.listGeladeiras((Integer)session.getAttribute("usuario_id")));
		model.addAttribute("listProdutoCompra", new ArrayList<ProdutoCompra>());
		return "geladeiras";
	}
	
	@RequestMapping(value = "/geladeiras/exportar", method = RequestMethod.GET)
	public void exportarGeladeiras(Model model, HttpSession session, HttpServletResponse response) throws JAXBException, IOException {
		
		String xmlFileName = "usuario-"+session.getAttribute("usuario_id")+"-geladeiras.xml"; 
		
		List<Geladeira> geladeiras = this.geladeiraService.listGeladeiras((Integer)session.getAttribute("usuario_id"));
		Geladeiras geladeirasRoot = new Geladeiras();
		geladeirasRoot.setGeladeiras(geladeiras);
		
		response.setContentType("application/xml");
        response.setHeader("Content-Disposition",
                "attachment; filename=" + xmlFileName);
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Geladeiras.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        jaxbMarshaller.marshal(geladeirasRoot,  response.getOutputStream());
        
        response.flushBuffer();
       
	}
	
	@RequestMapping(value= "/geladeiras/add", method = RequestMethod.POST)
	public String addGeladeira(@ModelAttribute("geladeira") Geladeira g, HttpSession session){
		
		if(g.getId() == 0){
			this.geladeiraService.addGeladeira(g, (Integer)session.getAttribute("usuario_id"));
		}else{
			this.geladeiraService.updateGeladeira(g, (Integer)session.getAttribute("usuario_id"));
		}
		
		return "redirect:/geladeiras";
		
	}
	
	@RequestMapping("/geladeiras/remove/{id}")
    public String removeGeladeira(@PathVariable("id") int id){
        this.geladeiraService.removeGeladeira(id);
        return "redirect:/geladeiras";
    }
 
    @RequestMapping("/geladeiras/edit/{id}")
    public String editGeladeira(@PathVariable("id") int id, Model model, HttpSession session){
        model.addAttribute("geladeira", this.geladeiraService.getGeladeiraById(id));
        model.addAttribute("listGeladeiras", this.geladeiraService.listGeladeiras((Integer)session.getAttribute("usuario_id")));
        model.addAttribute("listProdutoCompra", produtocompraService.listProdutosCompras(id));
        return "geladeiras";
    }
    
    @RequestMapping(value="/geladeiras/consumir", method = RequestMethod.GET)
    public String consumir(@RequestParam("id") int id, @RequestParam("geladeira_id") int geladeira_id, Model model, HttpSession session){
    	produtocompraService.consumirProdutoCompra(id);
        model.addAttribute("geladeira", this.geladeiraService.getGeladeiraById(geladeira_id));
        model.addAttribute("listGeladeiras", this.geladeiraService.listGeladeiras((Integer)session.getAttribute("usuario_id")));
        model.addAttribute("listProdutoCompra", produtocompraService.listProdutosCompras(geladeira_id));
        return "geladeiras";
    }
    
    @RequestMapping("/geladeiras/redirect/{geladeira_id}")
	public String welcome(@PathVariable("geladeira_id") int geladeira_id, HttpSession session) {
		session.setAttribute("geladeira_id", geladeira_id);
		return "redirect:/compras";
	}
    
}
