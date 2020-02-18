package fr.adaming.projet.restaurant.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Clients;
import fr.adaming.projet.restaurant.repository.IClientsRepository;

@Service

public class ClientsService implements IClientsService {
	
	@Autowired
	IClientsRepository clientsRespository;

	@Override
	public Clients saveClients(Clients clients) {
		return clientsRespository.save(clients);
	}

	@Override
	public void deleteClients(long id) {
		clientsRespository.deleteById(id);

	}

	@Override
	public boolean deleteClients1(long id) {
		try {
			clientsRespository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Clients getOneClients(long id) {
		Optional<Clients> ClientsOptional = clientsRespository.findById(id);
		Clients clients = new Clients();
		if (ClientsOptional.isPresent()) {
			clients = ClientsOptional.get();
		}
		return clients;
	}

	@Override
	public List<Clients> getAll() {
		return clientsRespository.findAll();
	}
//
//	@Override
//	public List<Clients> findALL() {
//		return clientsRespository.findAll();
//	}

}
