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
import fr.adaming.projet.restaurant.model.Clients;
import fr.adaming.projet.restaurant.service.IClientsService;

@RestController
@RequestMapping("clients")
@CrossOrigin("http://localhost:4200")
public class ClientsController {
	
	@Autowired
	IClientsService clientsService;
	
	// WEBSERVICE POUR AJOUTER UN CLIENT
	@PostMapping
	public Clients addOne(@RequestBody Clients clients) {
		return clientsService.saveClients(clients);
	}
	
	// WEBSERVICE boolean POUR SUPPRIMER UN CLIENT
	@DeleteMapping("{id}")
	public boolean deleteClients(@PathVariable long id){
		try {
			clientsService.deleteClients(id);
		} catch (Exception e) {
		return false;
		}
		return true;
	}

	//WEBSERVICE POUR AFFICHER UN CLIENT EN PARTICULIER 
	@GetMapping("{id}")
	public Clients getOneClients(@PathVariable long id) {
		return clientsService.getOneClients(id);
	}

	// WEBSERVBICE POUR AVOIR TOUS LES CLIENTS
	
	@GetMapping
	public List<Clients> getAll(){
		return clientsService.getAll();
	}
	
//	@GetMapping
//	List<Clients> findALL(){
//		return clientsService.findALL();
//	}
//	
	// WEBSERVICE POUR MODIFIER LES INFOS DU  CLIENTS
	@PutMapping("{id}")
	public Clients UpdateClients(@PathVariable long id, @RequestBody Clients clients) {
		Clients C1=new Clients();
		C1= clientsService.getOneClients(id);
		C1.setNom(clients.getNom());
		C1.setPrenom(clients.getPrenom());
		C1.setTelephone(clients.getTelephone());
		return clientsService.saveClients(C1);
		
	}

}
