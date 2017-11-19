package com.pfa.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.pfa.dao.EleveDao;
import com.pfa.model.Eleve;
@Controller
public class EleveController {
	private Path path;
	@Autowired
	private EleveDao eleveDao;
	@RequestMapping("/eleveList/addEleve")
	public String addEleve(Model model){
		Eleve eleve=new Eleve();
		model.addAttribute("eleve", eleve);
		return "addEleve";
	}
	
	
	@RequestMapping("/eleveList")
	public String getEleves(Model model){
		List<Eleve> eleveList=eleveDao.getAllEleves();
		model.addAttribute("eleves",eleveList);
		return "eleveList";
	}
	
	
	
	@RequestMapping("/eleveList/ViewEleve/{matricule}")
	public String ViewEleve(@PathVariable int matricule, Model model)throws IOException{
		Eleve eleve=eleveDao.getEleveById(matricule);
		model.addAttribute("eleve",eleve);
		
		return "ViewEleve";
	}
	
	@RequestMapping(value="/eleveList/addEleve",method=RequestMethod.POST)
	public String addElevePost(@ModelAttribute("eleve") Eleve eleve,HttpServletRequest request){
		eleveDao.addEleve(eleve);
		MultipartFile imgEl=eleve.getImgEl();
		String rootDirectory=request.getSession().getServletContext().getRealPath("/");
		path=Paths.get(rootDirectory+"\\WEB-INF\\resources\\img\\eleve\\"+eleve.getMatricule()+".png");
		if(imgEl!=null&&!imgEl.isEmpty()){
			try{
				imgEl.transferTo(new File(path.toString()));
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException("Erreur d'enregistrement d'image",e);
			}
		}
		return "redirect:/eleveList";
	}
	
	
	
	
	@RequestMapping("/eleveList/deleteEleve/{matricule}")
	public String deleteEleve(@PathVariable int matricule, Model model,HttpServletRequest request){
		
		String rootDirectory=request.getSession().getServletContext().getRealPath("/");
		path=Paths.get(rootDirectory+"\\WEB-INF\\resources\\img\\eleve\\"+matricule+".png");
		if(Files.exists(path)){
			try{
				Files.delete(path);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		eleveDao.deleteEleve(matricule);	
		
		return "redirect:/eleveList";
	}
	
	
	@RequestMapping(value="/eleveList/editEleve/{matricule}")
	public String editEleve(@PathVariable("matricule") int matricule,Model model){
		Eleve eleve=eleveDao.getEleveById(matricule);
		model.addAttribute("eleve", eleve);
		return "editEleve";
	}
	
	@RequestMapping(value="/eleveList/editEleve",method=RequestMethod.POST)
	public String editElevePost(@ModelAttribute("eleve")Eleve eleve,
			Model model,HttpServletRequest request){
		MultipartFile imgEl=eleve.getImgEl();
		String rootDirectory=request.getSession().getServletContext().getRealPath("/");
		path=Paths.get(rootDirectory+"\\WEB-INF\\resources\\img\\eleve\\"+eleve.getMatricule()+".png");
		if(imgEl!=null&&!imgEl.isEmpty()){
			try{
				imgEl.transferTo(new File(path.toString()));
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException("Erreur d'enregistrement d'image",e);
			}
		}
		eleveDao.editEleve(eleve);
		return "redirect:/eleveList";
		
	}

}
