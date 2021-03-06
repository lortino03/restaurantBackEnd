package fr.adaming.projet.restaurant.controller;

import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.adaming.projet.restaurant.model.Employes;
import fr.adaming.projet.restaurant.model.Token;
import fr.adaming.projet.restaurant.service.IEmployesService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@RestController
@RequestMapping("employes")
@CrossOrigin("http://localhost:4200")
public class EmployesController {
	Key keys = Keys.secretKeyFor(SignatureAlgorithm.HS256); // encodage de l'algorythm d'encodage
	
	@Autowired
	IEmployesService employesService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// WEBSERVICE POUR AJOUTER UN EMPLOYE
	@PostMapping
	public Employes addOne(@RequestBody Employes employes) {
		employes.setPwd(bCryptPasswordEncoder.encode(employes.getPwd()));
		return employesService.saveEmployes(employes);
	}
	
	// WEBSERVICE boolean POUR SUPPRIMER UN EMPLOYE
	@DeleteMapping("{id}")
	public boolean deleteEmployes(@PathVariable long id){
		try {
			employesService.deleteEmployes(id);
		} catch (Exception e) {
		return false;
		}
		return true;
	}

	//WEBSERVICE POUR AFFICHER UN EMPLOYE EN PARTICULIER 
	@GetMapping("{id}")
	public Employes getOneEmployes(@PathVariable long id) {
		return employesService.getOneEmployes(id);
	}

	// WEBSERVBICE POUR AVOIR TOUS LES EMPLOYE
	@GetMapping
	public List<Employes> getAll(){
		return employesService.getAll();
	}
	
	@PostMapping("/connexbool") // WebSERVICE POUR SE CONNECTER
	public Boolean AfficherEmployesParLogin(@RequestBody Employes employes) {
		return employesService.findByLogin(employes);
	}
	
	
	// WEBSERVICE POUR MODIFIER LES INFOS D'UN EMPLOYE
	@PutMapping("{id}")
	public Employes UpdateEmployes(@PathVariable long id, @RequestBody Employes employes) {
		Employes E1=new Employes();
		E1= employesService.getOneEmployes(id);
		E1.setNom(employes.getNom());
		E1.setPrenom(employes.getPrenom());
		E1.setLogin(employes.getLogin());
		E1.setPwd(employes.getPwd());
		E1.setStatus(employes.getStatus());
		return employesService.saveEmployes(E1);
		
	}
	
	@PostMapping("/token") // WEBSERVICE APOUR SE CONNECTER AVEC TOKEN
	public Token AfficherUtilisateurParLogin(@RequestBody Employes employes) {
		Employes util = new Employes();
		util = employesService.findByLogin1(employes);
		if (util != null) {
			if (bCryptPasswordEncoder.matches(employes.getPwd(), util.getPwd()))
				;
			{
				Map<String, Object> claims = new HashMap<String, Object>();
				claims.put("idEmploye", util.getIdEmploye());
				claims.put("nom", util.getNom());
				claims.put("prenom", util.getPrenom());
				claims.put("idLogin", util.getLogin());
				claims.put("idpwd", util.getPwd());
				claims.put("status", util.getStatus());
				String jws = Jwts.builder().addClaims(claims).signWith(keys).compact(); // specifier la clé d'encodage
				// jws contiendra la chaine de caratere du token						// et pour ca , on instancie
																						// cette clé en haut la, le . compact() ferme le token
 				Token t = new Token();				// crée pour l'envoyer sous forme de JSOn avec le webserv qu'on a cree
				t.setToken(jws);
				return t;

			}
		}
		return null;
	}

}
