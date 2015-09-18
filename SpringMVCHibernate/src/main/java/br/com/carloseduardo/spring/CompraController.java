package br.com.carloseduardo.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.carloseduardo.spring.model.Compra;
import br.com.carloseduardo.spring.service.CompraService;

@Controller
public class CompraController {
	
	
	private CompraService compraService;
	
	@Autowired(required=true)
	@Qualifier(value="compraService")
	public void setMarcaService(CompraService cs){
		this.compraService = cs;
	}
	
	@InitBinder  
	 public void initBinder(WebDataBinder binder)   
	 {  
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	  dateFormat.setLenient(false);  
	  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
	 }
	
	@RequestMapping(value = "/compras", method = RequestMethod.GET)
	public String listCompras(Model model) {
		model.addAttribute("compra", new Compra());
		model.addAttribute("listCompras", this.compraService.listCompras());
		return "compras";
	}
	
	//For add and update person both
	@RequestMapping(value= "/compras/add", method = RequestMethod.POST)
	public String addCompra(@ModelAttribute("compra") Compra c){
		this.compraService.addCompra(c);;
		return "redirect:/compras";
		
	}
	
	@RequestMapping("/compras/remove/{id}")
    public String removeCompra(@PathVariable("id") int id){
		
        this.compraService.removeCompra(id);
        return "redirect:/compras";
    }
	
}
