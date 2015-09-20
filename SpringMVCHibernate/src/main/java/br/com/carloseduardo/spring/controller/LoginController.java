package br.com.carloseduardo.spring.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.carloseduardo.spring.service.UsuarioService;

@Controller
public class LoginController {
	
	
	private UsuarioService usuarioService;
	
	@Autowired(required=true)
	@Qualifier(value="usuarioService")
	public void setUsuarioService(UsuarioService usuarioService){
		this.usuarioService = usuarioService;
	}
	
	@RequestMapping("/welcome")
	public String welcome(HttpSession session) {
		session.setAttribute("usuario_id", -2);
		return "welcome";
	}
	
	//For add and update person both
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	public String login(@RequestParam("login") String login, @RequestParam("senha") String senha, HttpSession session){
		int usuario_id = this.usuarioService.loginUsuario(login, senha);
		if(usuario_id == -1){
			session.setAttribute("usuario_id", -1);
			return "welcome";
		}else{
			session.setAttribute("usuario_id", usuario_id);
			return "redirect:/geladeiras";
		}
		
	}
}

