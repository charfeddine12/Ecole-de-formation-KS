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

import com.pfa.dao.SalleDao;
import com.pfa.model.Salle;

@Controller
public class SalleController {
	@Autowired
	private SalleDao salleDao;
	@RequestMapping("/salleList/addSalle")
	public String addSalle(Model model){
		Salle salle=new Salle();
		model.addAttribute("salle", salle);
		return "addSalle";
	}
	
	
	@RequestMapping("/salleList")
	public String getSalles(Model model){
		List<Salle> salleList=salleDao.getAllSalles();
		model.addAttribute("salles",salleList);
		return "salleList";
	}
	
	
	
	@RequestMapping("/salleList/ViewSalle/{idSalle}")
	public String ViewSalle(@PathVariable int idSalle, Model model)throws IOException{
		Salle salle=salleDao.getSalleById(idSalle);
		model.addAttribute("salle",salle);
		
		return "ViewSalle";
	}
	
	@RequestMapping(value="/salleList/addSalle",method=RequestMethod.POST)
	public String addSallePost(@ModelAttribute("salle") Salle salle,HttpServletRequest request){
		salleDao.addSalle(salle);
		return "redirect:/salleList";
	}
	
	
	
	
	@RequestMapping("/salleList/deleteSalle/{idSalle}")
	public String deleteSalle(@PathVariable int idSalle, Model model,HttpServletRequest request){
		salleDao.deleteSalle(idSalle);	
		return "redirect:/salleList";
	}
	
	
	@RequestMapping(value="/salleList/editSalle/{idSalle}")
	public String editSalle(@PathVariable("idSalle") int idSalle,Model model){
		Salle salle=salleDao.getSalleById(idSalle);
		model.addAttribute("salle", salle);
		return "editSalle";
	}
	
	@RequestMapping(value="/salleList/editSalle",method=RequestMethod.POST)
	public String editSallePost(@ModelAttribute("salle")Salle salle,
			Model model,HttpServletRequest request){
		salleDao.editSalle(salle);
		return "redirect:/salleList";
		
	}

}
