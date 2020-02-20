package fr.adaming.projet.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_plats")
public class Plats {
	
	private long idPlats;
	private String libelle;
	private long quantite;
	private float prix;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="Id_plats")
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

	
	public Plats(long idPlats, String libelle, long quantite, float prix) {
		super();
		this.idPlats = idPlats;
		this.libelle = libelle;
		this.quantite = quantite;
		this.prix = prix;
	}

	public Plats() {
		super();
	}

	@Override
	public String toString() {
		return "Plats [libelle=" + libelle + ", quantite=" + quantite + ", prix=" + prix + " ]";
	}



	

}
