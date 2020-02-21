package fr.adaming.projet.restaurant.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tb_reservation")
public class Reservation {

	private long idReservation;
	private String nom;
	private String telephone;
	private long NbrePersonne;
	private Date dateDeResa;
	private String horaire;
	private Clients client;
	private Tables tables;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
			@Column(name="idResa")
			public long getIdReservation() {
				return idReservation;
			}
			public void setIdReservation(long idReservation) {
				this.idReservation = idReservation;
			}
		
			@Column(name="date_resa")
			@JsonFormat(pattern = "yyyy-MM-dd")
			public Date getDateDeResa() {
				return dateDeResa;
			}
			public void setDateDeResa(Date dateDeResa) {
				this.dateDeResa = dateDeResa;
			}
			@Column(name="noms")
			public String getNom() {
				return nom;
			}
			public void setNom(String nom) {
				this.nom = nom;
			}
			@Column(name="Phone")
			public String getTelephone() {
				return telephone;
			}
			public void setTelephone(String telephone) {
				this.telephone = telephone;
			}
			
			@Column(name="nbrePersonne")
			public long getNbrePersonne() {
				return NbrePersonne;
			}
			public void setNbrePersonne(long nbrePersonne) {
				NbrePersonne = nbrePersonne;
			}
			@Column(name="horaire")
			public String getHeure() {
				return horaire;
			}
			public void setHeure(String heure) {
				this.horaire = heure;
			}
			
			@ManyToOne
			@JoinColumn(name="id_client")
			public Clients getClient() {
				return client;
			}
			public void setClient(Clients client) {
				this.client = client;
			}
			@ManyToOne
			@JoinColumn(name="id_table")
			public Tables getTables() {
				return tables;
			}
			public void setTables(Tables tables) {
				this.tables = tables;
			}
			public Reservation(long idReservation, String nom,String telephone, long NbrePersonne, Date dateDeResa,String horaire,Clients client,Tables tables) {
				super();
				this.idReservation = idReservation;
				this.nom = nom;
				this.telephone = telephone;
				this.NbrePersonne=NbrePersonne;
				this.dateDeResa = dateDeResa;
				this.horaire=horaire;
				this.client=client;
				this.tables=tables;
			
			}
		
			
			public Reservation() {
				
			}
			
			@Override
			public String toString() {
				return "Reservation [nom=" + nom + ",telephone=" + telephone + ",NbrePersonne="+ NbrePersonne+", "
						+ "dateDeResa=" + dateDeResa + "]";
			}
	
			
	
			
}
