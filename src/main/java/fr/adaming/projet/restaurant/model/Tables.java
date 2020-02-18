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
@Table(name="tb_tables")
public class Tables {
	
	private long idTable;
	private long NbrePlace;
	private Employes employe;
	private Commande commande;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="IdTable")
	public long getIdTable() {
		return idTable;
	}
	
	public void setIdTable(long idTable) {
		this.idTable = idTable;
	}
	@Column(name="Places")
	public long getNbrePlace() {
		return NbrePlace;
	}

	public void setNbrePlace(long nbrePlace) {
		NbrePlace = nbrePlace;
		}

	@ManyToOne
	@JoinColumn(name="id_employe")
	public Employes getEmployes() {
		return employe;
	}

	public void setEmployes(Employes employe) {
		this.employe = employe;
	}
	@ManyToOne
	@JoinColumn(name="id_commande")
	public Commande getCommande() {
		return commande;
	}

	
	public void setIdCommande(Commande commande) {
		this.commande = commande;
	}

// constructeurs
	public Tables(long idTable, long nbrePlace, Employes employe, Commande commande) {
		this.idTable = idTable;
		NbrePlace = nbrePlace;
		this.employe = employe;
		this.commande =commande;
	}
	public Tables() {
		super();
	}

	

}
