
package fr.adaming.projet.restaurant.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import fr.adaming.projet.restaurant.model.Employes;
import fr.adaming.projet.restaurant.repository.IEmployesRepository;

@Service
public class EmployesService implements IEmployesService {

	@Autowired
	IEmployesRepository employesRespository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public Employes saveEmployes(Employes employes) {
		return employesRespository.save(employes);
	}

	public void deleteEmployes(long id) {
		employesRespository.deleteById(id);

	}

	public boolean deleteEmployes1(long id) {
		try {
			employesRespository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Employes getOneEmployes(long id) {
		Optional<Employes> EmployesOptional = employesRespository.findById(id);
		Employes employes = new Employes();
		if (EmployesOptional.isPresent()) {
			employes = EmployesOptional.get();
		}
		return employes;
	}

	public List<Employes> getAll() {
		return employesRespository.findAll();
	}

	@Override
	public boolean findByLogin(Employes employes) {
		Employes emplcripte = employesRespository.findByLogin(employes.getLogin());
		if (emplcripte == null)
			return false;
		if (bCryptPasswordEncoder.matches(employes.getPwd(), emplcripte.getPwd()))
			;
		return true;

	}
}
