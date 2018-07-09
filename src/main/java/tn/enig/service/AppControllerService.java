package tn.enig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.enig.dao.IGestionDao;
import tn.enig.model.Produit;

@RestController
@RequestMapping("/rest")
public class AppControllerService {

	@Autowired
	IGestionDao daoprod;
	
	public void setDaoprod(IGestionDao daoprod) {
		this.daoprod = daoprod;
	}
	
	@RequestMapping(value="/produits", method=RequestMethod.GET)
	public List<Produit> getAllproduuit( ){
		List<Produit> liste1= daoprod.findAll();		
		return liste1;
		
	}
	
}
