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

import fr.adaming.projet.restaurant.model.Reservation;
import fr.adaming.projet.restaurant.service.IReservationService;

@RestController
@RequestMapping("reservation")
@CrossOrigin("http://localhost:4200")
public class ReservationController {
	
	@Autowired
	IReservationService reservationService;
	
	// WEBSERVICE POUR AJOUTER UNE RESA
	@PostMapping
	public Reservation addOne(@RequestBody Reservation reservation) {
		return reservationService.saveReservation(reservation);
	}
	
	// WEBSERVICE boolean POUR SUPPRIMER UNE RESA
	@DeleteMapping("{id}")
	public boolean deleteReservation(@PathVariable long id){
		try {
			reservationService.deleteReservation(id);
		} catch (Exception e) {
		return false;
		}
		return true;
	}

	//WEBSERVICE POUR AFFICHER  UNE RESA EN PARTICULIER 
	@GetMapping("{id}")
	public Reservation getOneClients(@PathVariable long id) {
		return reservationService.getOneReservation(id);
	}

	// WEBSERVBICE POUR AVOIR TOUTES LES RESA
	
	@GetMapping
	public List<Reservation> getAll(){
		return reservationService.getAll();
	}
	
	// WEBSERVICE POUR MODIFIER LES INFOS D  UNE RESA
	@PutMapping("{id}")
	public Reservation UpdateReservation(@PathVariable long id, @RequestBody Reservation reservation) {
		Reservation R1=new Reservation();
		R1= reservationService.getOneReservation(id);
		R1.setNom(reservation.getNom());
		R1.setTelephone(reservation.getTelephone());
		R1.setNbrePersonne(reservation.getNbrePersonne());
		R1.setDateDeResa(reservation.getDateDeResa());
		R1.setHeure(reservation.getHeure());
		R1.setClient(reservation.getClient());
		R1.setTables(reservation.getTables());
		return reservationService.saveReservation(R1);
		
	}

	
	

}
