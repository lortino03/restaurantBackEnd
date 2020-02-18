package fr.adaming.projet.restaurant.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.adaming.projet.restaurant.model.Plats;
import fr.adaming.projet.restaurant.repository.IPlatsRepository;

@Service
public class PlatsService implements IPlatsService{
	@Autowired
	IPlatsRepository platsRespository;

	public Plats savePlats(Plats plats) {
		return platsRespository.save(plats);
	}

	public void deletePlats(long id) {
		platsRespository.deleteById(id);

	}

	public boolean deletePlats1(long id) {
		try {
			platsRespository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Plats getOnePlats(long id) {
		Optional<Plats> PlatsOptional = platsRespository.findById(id);
		Plats plats = new Plats();
		if (PlatsOptional.isPresent()) {
			plats = PlatsOptional.get();
		}
		return plats;
	}

	public List<Plats> getAll() {
		return platsRespository.findAll();
	}

}
