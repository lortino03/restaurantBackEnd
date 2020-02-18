
package fr.adaming.projet.restaurant.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.adaming.projet.restaurant.model.Employes;
import fr.adaming.projet.restaurant.repository.IEmployesRepository;

@Service
public class EmployesService {
	
	@Autowired
	IEmployesRepository employeRespository;

	
	public Employes saveEmployes(Employes employes) {
		return employeRespository.save(employes);
	}

	
	public void deleteEmployes(long id) {
		employeRespository.deleteById(id);

	}

	
	public boolean deleteEmployes1(long id) {
		try {
			employeRespository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}


	public Employes getOneEmployes(long id) {
		Optional<Employes> EmployesOptional = employeRespository.findById(id);
		Employes employes = new Employes();
		if (EmployesOptional.isPresent()) {
			employes = EmployesOptional.get();
		}
		return employes;
	}

	
	public List<Employes> getAll() {
		return employeRespository.findAll();
	}

	
	public List<Employes> findALL() {
		return employeRespository.findAll();
	}


}
