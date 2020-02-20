package fr.adaming.projet.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.projet.restaurant.model.Employes;

public interface IEmployesRepository extends JpaRepository<Employes,Long>{
	public Employes findByLogin(String login);

}
