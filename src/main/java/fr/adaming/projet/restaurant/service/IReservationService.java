package fr.adaming.projet.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Reservation;

@Service
public interface IReservationService {
	
	public Reservation saveReservation(Reservation reservation);

	public void deleteReservation(long id);

	public boolean deleteReservation1(long id);

	public Reservation getOneReservation(long id);

	public List<Reservation> getAll();

	List<Reservation> findALL();


}
