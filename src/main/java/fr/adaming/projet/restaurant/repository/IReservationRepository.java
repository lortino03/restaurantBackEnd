package fr.adaming.projet.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.projet.restaurant.model.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation,Long>{

}
