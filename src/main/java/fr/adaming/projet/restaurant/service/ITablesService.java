package fr.adaming.projet.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Tables;

@Service
public interface ITablesService {
	
	public Tables saveTables(Tables tables);

	public void deleteTables(long id);

	public boolean deleteTables1(long id);

	public Tables getOneTables(long id);

	public List<Tables> getAll();

	List<Tables> findALL();


}
