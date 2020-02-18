package fr.adaming.projet.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.projet.restaurant.model.Commande;

public interface ICommandeRepository extends JpaRepository<Commande,Long>{

}
