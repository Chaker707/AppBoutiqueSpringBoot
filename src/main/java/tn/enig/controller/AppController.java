package tn.enig.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tn.enig.dao.IGestionCategorie;
import tn.enig.dao.IGestionDao;
import tn.enig.dao.IGstionUser;
import tn.enig.model.Categorie;
import tn.enig.model.Panier;
import tn.enig.model.Produit;
import tn.enig.model.User;

@Controller

public class AppController {
	
	@Autowired
	IGestionDao dao;
	
	@Autowired
	IGstionUser daouser;
	
	@Autowired
	IGestionCategorie daocat;
	
	public void setDaocat(IGestionCategorie daocat) {
		this.daocat = daocat;
	}
	
	public void setDaouser(IGstionUser daouser) {
		this.daouser = daouser;
	}
	
	public void setDao(IGestionDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/liste1", method=RequestMethod.GET)
	public String getproduit(ModelMap model) {
		List<Produit> liste=dao.findAll();
		List<Categorie> listec=daocat.findAll();
		model.addAttribute("liste", liste);
		model.addAttribute("listec",listec);
		return "catalogue";
		
	}
	
	
	@RequestMapping(value="/liste3/{id}", method=RequestMethod.GET)
	public String getproduit22(ModelMap model, @PathVariable("id") int id) {
		List<Produit> liste=dao.getAllProdByIDCat(id);
		List<Categorie> listec=daocat.findAll();
		model.addAttribute("liste", liste);
		model.addAttribute("listec",listec);
		return "catalogue";
		
	}
	
	@RequestMapping(value="/addpanier/{id}" , method=RequestMethod.GET)
	public String ajouterpanier(ModelMap model, @PathVariable("id") int id, HttpSession session) {
		Produit p= dao.findOne(id);
		List<Panier> panier= (List<Panier>) session.getAttribute("panier");
		
		if(panier==null) {
			List<Panier> pan= new ArrayList<Panier>();
			pan.add(new Panier(p, 1));
			session.setAttribute("panier", pan);
		}else {
			int index=-1;
			for(Panier pp:panier) {
				if(pp.getP().getId()==id) {
					index=panier.indexOf(pp);
				}
			}
			
			if(index==-1) {
				panier.add(new Panier(p, 1));
			}else {
				panier.get(index).setQte(panier.get(index).getQte()+1);
			}
				
			session.setAttribute("panier", panier);			
		}
		
		return "redirect:/monpanier";
		
	}
	
	@RequestMapping(value="/monpanier", method=RequestMethod.GET)
	public String affichepan(ModelMap model, HttpSession session ) {
		
		List<Panier> listepan= (List<Panier>) session.getAttribute("panier");
		model.addAttribute("panier", listepan);
		return "panier";
		
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getForm (ModelMap model) {
		Produit p= new Produit();
		model.addAttribute("p",p);
		return "formajout";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String ajouter(ModelMap model, @ModelAttribute Produit p) {
		dao.save(p);
		return "redirect:/liste1";
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String fotrll(ModelMap model) {
		return "connexion";
	}
	
	@RequestMapping(value="/panier", method=RequestMethod.GET)
	public String monpanier(ModelMap model) {
		return "panier";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deletepan(ModelMap model, HttpSession session, @PathVariable("id") int id) {
		List<Panier> listepan= (List<Panier>) session.getAttribute("panier");
		
		int index=-1;
		for(Panier pp:listepan) {
				if(pp.getP().getId()==id) {
					index=listepan.indexOf(pp);
				}
		}
		
		listepan.remove(index);
		
		session.setAttribute("panier", listepan);
		
		return "redirect:/monpanier";
		
	}
	
	
	@RequestMapping(value="/verif", method=RequestMethod.GET)
	public String chercher1(ModelMap model, HttpServletRequest request, HttpSession session) {
		String s1=request.getParameter("login");
		String s2=request.getParameter("pass");
		
		List<User> liste= daouser.findAll();
		User u1=null;
		for(User u:liste) {
			if((u.getLogin().equals(s1))&&u.getPassword().equals(s2))
				u1=u;
		}
		
		if(u1==null)
			return "redirect:/login";
		else {
			session.setAttribute("user", u1);
			return "redirect:/liste1";
		}
		
	}
	
}
