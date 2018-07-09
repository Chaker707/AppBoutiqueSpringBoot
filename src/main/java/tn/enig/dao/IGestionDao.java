package tn.enig.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.enig.model.Produit;

public interface IGestionDao extends JpaRepository<Produit, Integer> {

	@Query("select p from Produit p where p.description like %:s%")
	public List<Produit> getAllProduitsByNom(@Param("s") String nom);
	
	@Query("select p from Produit p where  p.cat.id = :id ")
	public List<Produit> getAllProdByIDCat( @Param("id") int id);
}
