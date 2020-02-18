package fr.adaming.projet.restaurant.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tb_commande")
public class Commande {
	private long idCommande;
	private Date dateDeCommande;
	private String plats;
	private float prix;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
				@Column(name="idCommande")
				public long getIdCommande() {
					return idCommande;
				}
			
			
				public void setIdCommande(long idCommande) {
					this.idCommande = idCommande;
				}
			
				@Column(name="date de commande")
				@JsonFormat(pattern = "yyyy-MM-dd")
				public Date getDateDeCommande() {
					return dateDeCommande;
				}
			
				public void setDateDeCommande(Date dateDeCommande) {
					this.dateDeCommande = dateDeCommande;
				}
			
				@Column(name="Plats")
				public String getPlats() {
					return plats;
				}
			
			
				public void setPlats(String plats) {
					this.plats = plats;
				}
			
				@Column(name="Prix")
				public float getPrix() {
					return prix;
				}
			
			
				public void setPrix(float prix) {
					this.prix = prix;
				}
				
	
	public Commande(long idCommande, Date dateDeCommande, String plats, float prix) {
		this.idCommande = idCommande;
		this.dateDeCommande = dateDeCommande;
		this.plats = plats;
		this.prix = prix;
	}


	public Commande() {
		super();
	}


	@Override
	public String toString() {
		return "Commande [dateDeCommande=" + dateDeCommande + ", plats=" + plats + ", prix=" + prix + "]";
	}
	
	

}