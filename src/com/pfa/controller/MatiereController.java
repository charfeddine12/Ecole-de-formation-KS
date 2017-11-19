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

import com.pfa.dao.MatiereDao;
import com.pfa.model.Matiere;

@Controller
public class MatiereController {
	@Autowired
	private MatiereDao matiereDao;
	@RequestMapping("/matiereList/addMatiere")
	public String addMatiere(Model model){
		Matiere matiere=new Matiere();
		model.addAttribute("matiere", matiere);
		return "addMatiere";
	}
	
	
	@RequestMapping("/matiereList")
	public String getMatieres(Model model){
		List<Matiere> matiereList=matiereDao.getAllMatieres();
		model.addAttribute("matieres",matiereList);
		return "matiereList";
	}
	
	
	
	@RequestMapping("/matiereList/ViewMatiere/{idMat}")
	public String ViewMatiere(@PathVariable int idMat, Model model)throws IOException{
		Matiere matiere=matiereDao.getMatiereById(idMat);
		model.addAttribute("matiere",matiere);
		
		return "ViewMatiere";
	}
	
	@RequestMapping(value="/matiereList/addMatiere",method=RequestMethod.POST)
	public String addMatierePost(@ModelAttribute("matiere") Matiere matiere,HttpServletRequest request){
		matiereDao.addMatiere(matiere);
		return "redirect:/matiereList";
	}
	
	
	
	
	@RequestMapping("/matiereList/deleteMatiere/{idMat}")
	public String deleteMatiere(@PathVariable int idMat, Model model,HttpServletRequest request){
		matiereDao.deleteMatiere(idMat);	
		return "redirect:/matiereList";
	}
	
	
	@RequestMapping(value="/matiereList/editMatiere/{idMat}")
	public String editMatiere(@PathVariable("idMat") int idMat,Model model){
		Matiere matiere=matiereDao.getMatiereById(idMat);
		model.addAttribute("matiere", matiere);
		return "editMatiere";
	}
	
	@RequestMapping(value="/matiereList/editMatiere",method=RequestMethod.POST)
	public String editMatierePost(@ModelAttribute("matiere")Matiere matiere,
			Model model,HttpServletRequest request){
		matiereDao.editMatiere(matiere);
		return "redirect:/matiereList";
		
	}


}
