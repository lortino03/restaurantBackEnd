package fr.adaming.projet.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.projet.restaurant.model.Clients;

public interface IClientsRepository extends JpaRepository<Clients,Long>{

}
