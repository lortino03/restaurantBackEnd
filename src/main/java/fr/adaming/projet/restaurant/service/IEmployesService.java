package fr.adaming.projet.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Employes;

@Service
public interface IEmployesService {
	
	public Employes saveEmployes(Employes employes);

	public void deleteEmployes(long id);

	public boolean deleteEmployes1(long id);

	public Employes getOneEmployes(long id);

	public List<Employes> getAll();
	
	public boolean findByLogin(Employes employes);


}
