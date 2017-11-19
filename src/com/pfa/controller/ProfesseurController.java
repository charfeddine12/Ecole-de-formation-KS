package com.pfa.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.pfa.dao.ProfesseurDao;
import com.pfa.model.Professeur;

@Controller
public class ProfesseurController {
	
	private Path path;
	@Autowired
	private ProfesseurDao profDao;
	@RequestMapping("/professeurList/addProfesseur")
	public String addProfesseur(Model model){
		Professeur professeur=new Professeur();
		model.addAttribute("professeur", professeur);
		return "addProfesseur";
	}
	
	
	
	@RequestMapping(value="/professeurList/addProfesseur",method=RequestMethod.POST)
	public String addProfesseurPost(@ModelAttribute("professeur") Professeur professeur,HttpServletRequest request){
		profDao.addProfesseur(professeur);
		MultipartFile imgProf=professeur.getImgProf();
		String rootDirectory=request.getSession().getServletContext().getRealPath("/");
		path=Paths.get(rootDirectory+"\\WEB-INF\\resources\\img\\"+professeur.getIdProf()+".png");
		if(imgProf!=null&&!imgProf.isEmpty()){
			try{
				imgProf.transferTo(new File(path.toString()));
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException("Erreur d'enregistrement d'image",e);
			}
		}
		return "redirect:/professeurList";
	}
	
	
	
	
	@RequestMapping("/professeurList/deleteProfesseur/{idProf}")
	public String deleteProfesseur(@PathVariable int idProf, Model model,HttpServletRequest request){
		
		String rootDirectory=request.getSession().getServletContext().getRealPath("/");
		path=Paths.get(rootDirectory+"\\WEB-INF\\resources\\img\\"+idProf+".png");
		if(Files.exists(path)){
			try{
				Files.delete(path);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		profDao.deleteProfesseur(idProf);	
		
		return "redirect:/professeurList";
	}
	
	
	@RequestMapping(value="/professeurList/editProfesseur/{idProf}")
	public String editProfesseur(@PathVariable("idProf") int idProf,Model model){
		Professeur professeur=profDao.getProfesseurById(idProf);
		model.addAttribute("professeur", professeur);
		return "editProfesseur";
	}
	
	@RequestMapping(value="/professeurList/editProfesseur",method=RequestMethod.POST)
	public String editProfesseurPost(@ModelAttribute("professeur")Professeur professeur,
			Model model,HttpServletRequest request){
		MultipartFile imgProf=professeur.getImgProf();
		String rootDirectory=request.getSession().getServletContext().getRealPath("/");
		path=Paths.get(rootDirectory+"\\WEB-INF\\resources\\img\\"+professeur.getIdProf()+".png");
		if(imgProf!=null&&!imgProf.isEmpty()){
			try{
				imgProf.transferTo(new File(path.toString()));
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException("Erreur d'enregistrement d'image",e);
			}
		}
		profDao.editProfesseur(professeur);
		return "redirect:/professeurList";
		
	}
}
