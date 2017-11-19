package com.pfa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/")
	public String login(@RequestParam(value="error",required=false)String error,
			@RequestParam(value="logout",required=false)String logout, Model model){
		if(error!=null){
			model.addAttribute("error", "Login ou mot de passe invalide");
		}
		if(logout!=null){
			model.addAttribute("error", "Deconnexion avec succées");
		}
		return"login";
	}

}
