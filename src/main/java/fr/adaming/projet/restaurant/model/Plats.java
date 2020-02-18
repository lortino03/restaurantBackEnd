package fr.adaming.projet.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_plats")
public class Plats {
	
	private long idPlats;
	private String libelle;
	private long quantite;
	private float prix;
	private Commande Commande;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="plats")
	public long getIdPlats() {
		return idPlats;
	}

	public void setIdPlats(long idPlats) {
		this.idPlats = idPlats;
	}
	@Column(name="Libelle")
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Column(name="Quantite")
	public long getQuantite() {
		return quantite;
	}

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}
	@Column(name="Prix")
	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	@ManyToOne
	@JoinColumn(name="id_commande")
	public Commande getCommande() {
		return Commande;
	}

	public void setCommande(Commande commande) {
		this.Commande = commande;
	}
	
	
	public Plats(long idPlats, String libelle, long quantite, float prix, Commande Commande) {
		super();
		this.idPlats = idPlats;
		this.libelle = libelle;
		this.quantite = quantite;
		this.prix = prix;
		this.Commande = Commande;
	}

	public Plats() {
		super();
	}

	@Override
	public String toString() {
		return "Plats [libelle=" + libelle + ", quantite=" + quantite + ", prix=" + prix + ", idCommande=" + Commande
				+ "]";
	}



	

}
