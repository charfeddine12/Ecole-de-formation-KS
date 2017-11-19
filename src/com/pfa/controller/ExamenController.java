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

import com.pfa.dao.ExamenDao;
import com.pfa.model.Examen;

@Controller
public class ExamenController {
	@Autowired
	private ExamenDao examenDao;
	@RequestMapping("/examenList/addExamen")
	public String addExamen(Model model){
		Examen examen=new Examen();
		model.addAttribute("examen", examen);
		return "addExamen";
	}
	
	
	@RequestMapping("/examenList")
	public String getExamens(Model model){
		List<Examen> examens=examenDao.getAllExamens();
		model.addAttribute("examens",examens);
		return "examenList";
	}
	
	
	
	@RequestMapping("/examenList/ViewExamen/{idExam}")
	public String ViewExamen(@PathVariable int idExam, Model model)throws IOException{
		Examen examen=examenDao.getExamenById(idExam);
		model.addAttribute("examen",examen);
		
		return "ViewExamen";
	}
	
	@RequestMapping(value="/examenList/addExamen",method=RequestMethod.POST)
	public String addExamenPost(@ModelAttribute("examen") Examen examen,HttpServletRequest request){
		examenDao.addExamen(examen);
		return "redirect:/examenList";
	}
	
	
	
	
	@RequestMapping("/examenList/deleteExamen/{idExam}")
	public String deleteExamen(@PathVariable int idExam, Model model,HttpServletRequest request){
		examenDao.deleteExamen(idExam);	
		return "redirect:/examenList";
	}
	
	
	@RequestMapping(value="/examenList/editExamen/{idExam}")
	public String editExamen(@PathVariable("idExam") int idExam,Model model){
		Examen examen=examenDao.getExamenById(idExam);
		model.addAttribute("examen", examen);
		return "editExamen";
	}
	
	@RequestMapping(value="/examenList/editExamen",method=RequestMethod.POST)
	public String editExamenPost(@ModelAttribute("examen")Examen examen,
			Model model,HttpServletRequest request){
		examenDao.editExamen(examen);
		return "redirect:/examenList";
		
	}


}
