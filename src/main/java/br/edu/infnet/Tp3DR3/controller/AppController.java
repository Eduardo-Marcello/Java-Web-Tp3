package br.edu.infnet.Tp3DR3.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.Tp3DR3.model.negocio.Usuario;
import br.edu.infnet.Tp3DR3.service.UsuarioService;


@Controller
public class AppController {
	@Autowired
	private UsuarioService usuarioService;
	
    @RequestMapping(value = "/cadastro")
    public String cadastro(Model model) 
    {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "cadastro";
    }
    
    @RequestMapping(value = "/cadastrar")
    public String cadastrar(Model model, Usuario usuario) throws SQLException {
    	usuarioService.salvar(usuario);
        return "redirect:/confirmacao";
    }
    
    @RequestMapping(value = "/confirmacao")
    public String confirmacao(Model model) {
    	model.addAttribute("usuario", usuarioService.consultarCadastro());
        return "confirmacao";
    }
    
    @RequestMapping(value = "/login")
    public String login(){
    	return "login";
    }
    

    
}