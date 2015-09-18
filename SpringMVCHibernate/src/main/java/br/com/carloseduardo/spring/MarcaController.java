package br.com.carloseduardo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.carloseduardo.spring.model.Marca;
import br.com.carloseduardo.spring.service.MarcaService;

@Controller
public class MarcaController {
	
	
	private MarcaService marcaService;
	
	@Autowired(required=true)
	@Qualifier(value="marcaService")
	public void setMarcaService(MarcaService ma){
		this.marcaService = ma;
	}
	
	@RequestMapping(value = "/marcas", method = RequestMethod.GET)
	public String listMarcas(Model model) {
		model.addAttribute("marca", new Marca());
		model.addAttribute("listMarcas", this.marcaService.listMarcas());
		return "marcas";
	}
	
	@RequestMapping(value= "/marcas/add", method = RequestMethod.POST)
	public String addMarca(@ModelAttribute("marca") Marca m){
		
		if(m.getId() == 0){
			this.marcaService.addMarca(m);
		}else{
			this.marcaService.updateMarca(m);
		}
		
		return "redirect:/marcas";
		
	}
	
	@RequestMapping("/marcas/remove/{id}")
    public String removeMarca(@PathVariable("id") int id){
		
        this.marcaService.removeMarca(id);
        return "redirect:/marcas";
    }
 
    @RequestMapping("/marcas/edit/{id}")
    public String editMarca(@PathVariable("id") int id, Model model){
        model.addAttribute("marca", this.marcaService.getMarcaById(id));
        model.addAttribute("listMarcas", this.marcaService.listMarcas());
        return "marcas";
    }
	
}
