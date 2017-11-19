package com.pfa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pfa.dao.ClasseDao;
import com.pfa.model.Classe;

@Controller
public class ClasseController {

	@Autowired
	private ClasseDao classeDao;
	@RequestMapping("/classeList/addClasse")
	public String addClasse(Model model){
		Classe classe=new Classe();
		model.addAttribute("classe", classe);
		return "addClasse";
	}
	
	
	@RequestMapping("/classeList")
	public String getClasses(Model model){
		List<Classe> classeList=classeDao.getAllClasses();
		model.addAttribute("classes",classeList);
		return "classeList";
	}
	
	
	
	@RequestMapping("/classeList/ViewClasse/{idCl}")
	public String ViewClasse(@PathVariable int idCl, Model model)throws IOException{
		Classe classe=classeDao.getClasseById(idCl);
		model.addAttribute("classe",classe);
		
		return "ViewClasse";
	}
	
	@RequestMapping(value="/classeList/addClasse",method=RequestMethod.POST)
	public String addClassePost(@ModelAttribute("classe") Classe classe,HttpServletRequest request){
		classeDao.addClasse(classe);
		return "redirect:/classeList";
	}
	
	
	
	
	@RequestMapping("/classeList/deleteClasse/{idCl}")
	public String deleteClasse(@PathVariable int idCl, Model model,HttpServletRequest request){
		classeDao.deleteClasse(idCl);	
		return "redirect:/classeList";
	}
	
	
	@RequestMapping(value="/classeList/editClasse/{idCl}")
	public String editClasse(@PathVariable("idCl") int idCl,Model model){
		Classe classe=classeDao.getClasseById(idCl);
		model.addAttribute("classe", classe);
		return "editClasse";
	}
	
	@RequestMapping(value="/classeList/editClasse",method=RequestMethod.POST)
	public String editClassePost(@ModelAttribute("classe")Classe classe,
			Model model,HttpServletRequest request){
		classeDao.editClasse(classe);
		return "redirect:/classeList";
		
	}

}
