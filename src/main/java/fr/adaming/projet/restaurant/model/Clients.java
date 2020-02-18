package fr.adaming.projet.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="td_clients")
public class Clients {
	
	private long idClients;
	private String nom;
	private String prenom;
	private String telephone;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
				@Column(name="IdClients")
				public long getIdClients() {
					return idClients;
				}
				public void setIdClients(long idClients) {
					this.idClients = idClients;
				}
				@Column(name="Noms")
				public String getNom() {
					return nom;
				}
				public void setNom(String nom) {
					this.nom = nom;
				}
				@Column(name="Prenoms")
				public String getPrenom() {
					return prenom;
				}
				public void setPrenom(String prenom) {
					this.prenom = prenom;
				}
				public String getTelephone() {
					return telephone;
				}
				public void setTelephone(String telephone) {
					this.telephone = telephone;
				}
				
				// constructeurs
				
				public Clients(long idClients, String nom, String prenom, String telephone) {
					super();
					this.idClients = idClients;
					this.nom = nom;
					this.prenom = prenom;
					this.telephone = telephone;
				}
				
				public Clients() {
					super();
				}
				
				@Override
				public String toString() {
					return "Clients [nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + "]";
				}
				




}
