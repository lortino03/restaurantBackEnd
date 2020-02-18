package fr.adaming.projet.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Commande;

@Service
public interface ICommandeService {
	
	public Commande saveCommande(Commande commande);
	public void deleteCommande(long id);
	public boolean deleteCommande1(long id);
	public Commande getOneCommande(long id);
	public List<Commande> getAll();

	
		
	

}
