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
import fr.adaming.projet.restaurant.model.Commande;
import fr.adaming.projet.restaurant.service.ICommandeService;

@RestController
@RequestMapping("commande")
@CrossOrigin("http://localhost:4200")
public class CommandeController {
	@Autowired
	ICommandeService commandeService;
	
	
	// WEBSERVICE POUR AJOUTER UN EMPLOYE
	@PostMapping
	public Commande addOne(@RequestBody Commande commande) {
		return commandeService.saveCommande(commande);
	}
	
	// WEBSERVICE boolean POUR SUPPRIMER UN EMPLOYE
	@DeleteMapping("{id}")
	public boolean deleteCommande(@PathVariable long id){
		try {
			commandeService.deleteCommande(id);
		} catch (Exception e) {
		return false;
		}
		return true;
	}

	//WEBSERVICE POUR AFFICHER UN EMPLOYE EN PARTICULIER 
	@GetMapping("{id}")
	public Commande getOneEmployes(@PathVariable long id) {
		return commandeService.getOneCommande(id);
	}

	// WEBSERVBICE POUR AVOIR TOUS LES EMPLOYE
	@GetMapping
	public List<Commande> getAll(){
		return commandeService.getAll();
	}
	
	
	// WEBSERVICE POUR MODIFIER LES INFOS D'UN EMPLOYE
	@PutMapping("{id}")
	public Commande UpdateCommande(@PathVariable long id, @RequestBody Commande commande) {
		Commande c1=new Commande();
		c1= commandeService.getOneCommande(id);
		c1.setDateDeCommande(commande.getDateDeCommande());
		return commandeService.saveCommande(c1);
		
	}


}
