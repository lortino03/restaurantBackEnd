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
	private String numero;
	private long NbrePlace;
	private Employes employe;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="IdTable")
	public long getIdTable() {
		return idTable;
	}
	
	public void setIdTable(long idTable) {
		this.idTable = idTable;
	}
	
	@Column(name="Numero")
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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
	

	
// constructeurs
	public Tables(long idTable,String numero, long nbrePlace, Employes employe) {
		this.idTable = idTable;
		this.numero=numero;
		this.NbrePlace = nbrePlace;
		this.employe = employe;
	
	}
	
	public Tables() {
		super();
	}

	@Override
	public String toString() {
		return "Tables [numero=" + numero + ",NbrePlace=" + NbrePlace + ", employe=" + employe + "]";
	}
	

	

}
