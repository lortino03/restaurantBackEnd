package fr.adaming.projet.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.projet.restaurant.model.Plats;

public interface IPlatsRepository extends JpaRepository<Plats,Long>{

}
