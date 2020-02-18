package fr.adaming.projet.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Tables;
import fr.adaming.projet.restaurant.repository.ITablesRepository;

@Service
public class TablesService implements ITablesService {
	@Autowired
	ITablesRepository tablesRepository;

	@Override
	public Tables saveTables(Tables tables) {

		return tablesRepository.save(tables);
	}

	@Override
	public void deleteTables(long id) {
		tablesRepository.deleteById(id);

	}

	@Override
	public boolean deleteTables1(long id) {
		try {
			tablesRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Tables getOneTables(long id) {
		Optional<Tables> TablesOptional = tablesRepository.findById(id);
		Tables tables = new Tables();
		if (TablesOptional.isPresent()) {
			tables = TablesOptional.get();
		}
		return tables;
	}

	@Override
	public List<Tables> getAll() {
		return tablesRepository.findAll();
	}

}
