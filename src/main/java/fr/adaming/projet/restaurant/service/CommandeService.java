package fr.adaming.projet.restaurant.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.adaming.projet.restaurant.model.Commande;
import fr.adaming.projet.restaurant.repository.ICommandeRepository;

@Service
public class CommandeService implements ICommandeService{
	
	@Autowired
	ICommandeRepository commandeRespository;

	
	public Commande saveCommande(Commande commande) {
		return commandeRespository.save(commande);
	}

	
	public void deleteCommande(long id) {
		commandeRespository.deleteById(id);

	}

	
	public boolean deleteCommande1(long id) {
		try {
			commandeRespository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}


	public Commande getOneCommande(long id) {
		Optional<Commande> CommandeOptional = commandeRespository.findById(id);
		Commande commande = new Commande();
		if (CommandeOptional.isPresent()) {
			commande = CommandeOptional.get();
		}
		return commande;
	}

	
	public List<Commande> getAll() {
		return commandeRespository.findAll();
	}



}
