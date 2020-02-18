package fr.adaming.projet.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.projet.restaurant.model.Tables;
import fr.adaming.projet.restaurant.service.ITablesService;

@RestController
@RequestMapping("tables")
@CrossOrigin("http://localhost:4200")
public class TablesController {
	@Autowired
	ITablesService tablesService;
	
	// WEBSERVICE POUR AJOUTER UNE TABLE
	@PostMapping
	public Tables addOne(@RequestBody Tables tables) {
		return tablesService.saveTables(tables);
	}
	
	// WEBSERVICE boolean POUR SUPPRIMER UNE TABLE 
	@DeleteMapping("{id}")
	public boolean deleteTables(@PathVariable long id){
		try {
			tablesService.deleteTables(id);
		} catch (Exception e) {
		return false;
		}
		return true;
	}

	//WEBSERVICE POUR AFFICHER UNE TABLE EN PARTICULIER 
	@GetMapping("{id}")
	public Tables getOneTables(@PathVariable long id) {
		return tablesService.getOneTables(id);
	}

	// WEBSERVBICE POUR AVOIR TOUTES LES  TABLE
	@GetMapping
	public List<Tables> getAll(){
		return tablesService.getAll();
	}
	
	// WEBSERVICE POUR MODIFIER LES INFOS D  UNE TABLE
	@PutMapping("{id}")
	public Tables UpdateTables(@PathVariable long id, @RequestBody Tables tables) {
		Tables t1=new Tables();
		t1= tablesService.getOneTables(id);
		return tablesService.saveTables(t1);
		
	}

	

}
