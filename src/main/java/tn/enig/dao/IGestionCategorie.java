package tn.enig.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tn.enig.model.Categorie;

public interface IGestionCategorie extends JpaRepository<Categorie, Integer>{
	

}
