package fr.adaming.projet.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Clients;
import fr.adaming.projet.restaurant.model.Plats;

@Service
public interface IPlatsService {

	public Plats savePlats(Plats plats);

	public void deletePlats(long id);

	public boolean deletePlats1(long id);

	public Clients getOnePlats(long id);

	public List<Plats> getAll();

	List<Plats> findALL();

}
