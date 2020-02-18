package fr.adaming.projet.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Reservation;
import fr.adaming.projet.restaurant.repository.IReservationRepository;

@Service
public class ReservationService implements IReservationService{

	@Autowired
	IReservationRepository reservationRespository;

	public Reservation saveReservation(Reservation reservation) {
		return reservationRespository.save(reservation);
	}

	public void deleteReservation(long id) {
		reservationRespository.deleteById(id);

	}

	public boolean deleteReservation1(long id) {
		try {
			reservationRespository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Reservation getOneReservation(long id) {
		Optional<Reservation> ReservationOptional = reservationRespository.findById(id);
		Reservation reservation = new Reservation();
		if (ReservationOptional.isPresent()) {
			reservation = ReservationOptional.get();
		}
		return reservation;
	}

	public List<Reservation> getAll() {
		return reservationRespository.findAll();
	}

}
