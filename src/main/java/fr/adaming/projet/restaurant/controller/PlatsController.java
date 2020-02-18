package fr.adaming.projet.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.projet.restaurant.model.Plats;
import fr.adaming.projet.restaurant.service.IPlatsService;

@RestController
@RequestMapping("plats")
@CrossOrigin("http://localhost:4200")
public class PlatsController {
	@Autowired
	IPlatsService platsService;
	
	// WEBSERVICE POUR AJOUTER UNE TABLE
	@PostMapping
	public Plats addOne(@RequestBody Plats plats) {
		return platsService.savePlats(plats);
	}
	
	// WEBSERVICE boolean POUR SUPPRIMER UNE TABLE 
	@DeleteMapping("{id}")
	public boolean deletePlats(@PathVariable long id){
		try {
			platsService.deletePlats(id);
		} catch (Exception e) {
		return false;
		}
		return true;
	}

	//WEBSERVICE POUR AFFICHER UNE TABLE EN PARTICULIER 
	@GetMapping("{id}")
	public Plats getOnePlats(@PathVariable long id) {
		return platsService.getOnePlats(id);
	}

	// WEBSERVBICE POUR AVOIR TOUTES LES  TABLE
	@GetMapping
	public List<Plats> getAll(){
		return platsService.getAll();
	}
	
	// WEBSERVICE POUR MODIFIER LES INFOS D  UNE TABLE
	@PutMapping("{id}")
	public Plats UpdatePlats(@PathVariable long id, @RequestBody Plats plats) {
		Plats p1=new Plats();
		p1= platsService.getOnePlats(id);
		p1.setCommande(plats.getCommande());
		p1.setLibelle(plats.getLibelle());
		p1.setPrix(plats.getPrix());
		p1.setQuantite(plats.getQuantite());
		return platsService.savePlats(p1);
		
	}

	

}
