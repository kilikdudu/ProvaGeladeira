package br.com.carloseduardo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.carloseduardo.spring.model.Mercado;
import br.com.carloseduardo.spring.service.MercadoService;

@Controller
public class MercadoController {
	
	
	private MercadoService mercadoService;
	
	@Autowired(required=true)
	@Qualifier(value="mercadoService")
	public void setMercadoService(MercadoService ma){
		this.mercadoService = ma;
	}
	
	@RequestMapping(value = "/mercados", method = RequestMethod.GET)
	public String listMercados(Model model) {
		model.addAttribute("mercado", new Mercado());
		model.addAttribute("listMercados", this.mercadoService.listMercados());
		return "mercados";
	}
	
	@RequestMapping(value= "/mercados/add", method = RequestMethod.POST)
	public String addMercado(@ModelAttribute("mercado") Mercado m){
		
		if(m.getId() == 0){
			this.mercadoService.addMercado(m);
		}else{
			this.mercadoService.updateMercado(m);
		}
		
		return "redirect:/mercados";
		
	}
	
	@RequestMapping("/mercados/remove/{id}")
    public String removeMercado(@PathVariable("id") int id){
		
        this.mercadoService.removeMercado(id);
        return "redirect:/mercados";
    }
 
    @RequestMapping("/mercados/edit/{id}")
    public String editMercado(@PathVariable("id") int id, Model model){
        model.addAttribute("mercado", this.mercadoService.getMercadoById(id));
        model.addAttribute("listMercados", this.mercadoService.listMercados());
        return "mercados";
    }
	
}
