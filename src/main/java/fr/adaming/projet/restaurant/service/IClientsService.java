package fr.adaming.projet.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Clients;

@Service
public interface IClientsService {

	public Clients saveClients(Clients clients);

	public void deleteClients(long id);

	public boolean deleteClients1(long id);

	public Clients getOneClients(long id);

	public List<Clients> getAll();

	List<Clients> findALL();

}
