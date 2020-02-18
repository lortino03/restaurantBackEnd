package fr.adaming.projet.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_employe")
public class Employes {

	private long idEmploye;
	private String nom;
	private String prenom;
	private String status;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
				@Column(name="idEmploye")
				public long getIdEmploye() {
					return idEmploye;
				}
			
			
				public void setIdEmploye(long idEmploye) {
					this.idEmploye = idEmploye;
				}
				@Column(name="noms")
				public String getNom() {
					return nom;
				}
			
			
				public void setNom(String nom) {
					this.nom = nom;
				}
				@Column(name="prenoms")
				public String getPrenom() {
					return prenom;
				}

				public void setPrenom(String prenom) {
					this.prenom = prenom;
				}
			
				@Column(name="status")
				public String getStatus() {
					return status;
				}
			
			
				public void setStatus(String status) {
					this.status = status;
				}



	public Employes(long idEmploye, String nom, String prenom, String status) {
		super();
		this.idEmploye = idEmploye;
		this.nom = nom;
		this.prenom = prenom;
		this.status = status;
	}

	public Employes() {
					super();
				}


	@Override
	public String toString() {
		return "Employes [nom=" + nom + ", prenom=" + prenom + ", status=" + status + "]";
	}
	
	
	
	
}
