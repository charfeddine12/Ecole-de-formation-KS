package com.pfa.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.dao.ProfesseurDao;
import com.pfa.model.Professeur;

@Controller
public class HomeController {
	@Autowired
	private ProfesseurDao profDao;
	
	
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	
	
	@RequestMapping("/professeurList")
	public String getProfesseurs(Model model){
		List<Professeur> professeurList=profDao.getAllProfesseurs();
		model.addAttribute("profs",professeurList);
		return "professeurList";
	}
	
	
	
	@RequestMapping("/professeurList/ViewProfesseur/{idProf}")
	public String ViewProfesseur(@PathVariable int idProf, Model model)throws IOException{
		Professeur professeur=profDao.getProfesseurById(idProf);
		model.addAttribute("professeur",professeur);
		
		return "ViewProfesseur";
	}
	
	}
