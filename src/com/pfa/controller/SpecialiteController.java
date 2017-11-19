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

import com.pfa.dao.SpecialiteDao;
import com.pfa.model.Specialite;

@Controller
public class SpecialiteController {
	@Autowired
	private SpecialiteDao specialiteDao;
	@RequestMapping("/specialiteList/addSpecialite")
	public String addSpecialite(Model model){
		Specialite specialite=new Specialite();
		model.addAttribute("specialite", specialite);
		return "addSpecialite";
	}
	
	
	@RequestMapping("/specialiteList")
	public String getSpecialites(Model model){
		List<Specialite> specialites=specialiteDao.getAllSpecialites();
		model.addAttribute("specialites",specialites);
		return "specialiteList";
	}
	
	
	
	@RequestMapping("/specialiteList/ViewSpecialite/{idExam}")
	public String ViewSpecialite(@PathVariable int idExam, Model model)throws IOException{
		Specialite specialite=specialiteDao.getSpecialiteById(idExam);
		model.addAttribute("specialite",specialite);
		
		return "ViewSpecialite";
	}
	
	@RequestMapping(value="/specialiteList/addSpecialite",method=RequestMethod.POST)
	public String addSpecialitePost(@ModelAttribute("specialite") Specialite specialite,HttpServletRequest request){
		specialiteDao.addSpecialite(specialite);
		return "redirect:/specialiteList";
	}
	
	
	
	
	@RequestMapping("/specialiteList/deleteSpecialite/{idSpec}")
	public String deleteSpecialite(@PathVariable int idSpec, Model model,HttpServletRequest request){
		specialiteDao.deleteSpecialite(idSpec);	
		return "redirect:/specialiteList";
	}
	
	
	@RequestMapping(value="/specialiteList/editSpecialite/{idSpec}")
	public String editSpecialite(@PathVariable("idSpec") int idSpec,Model model){
		Specialite specialite=specialiteDao.getSpecialiteById(idSpec);
		model.addAttribute("specialite", specialite);
		return "editSpecialite";
	}
	
	@RequestMapping(value="/specialiteList/editSpecialite",method=RequestMethod.POST)
	public String editSpecialitePost(@ModelAttribute("specialite")Specialite specialite,
			Model model,HttpServletRequest request){
		specialiteDao.editSpecialite(specialite);
		return "redirect:/specialiteList";
		
	}

}
