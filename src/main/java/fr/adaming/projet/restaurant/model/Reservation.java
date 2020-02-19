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
	private Clients client;
	private Date dateDeResa;
	private Tables table;
	private long NbrePersonne;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
			@Column(name="idResa")
			public long getIdReservation() {
				return idReservation;
			}
			public void setIdReservation(long idReservation) {
				this.idReservation = idReservation;
			}
			@ManyToOne
			@JoinColumn(name="id_clients")
			public Clients getClients() {
				return client;
			}
			public void setClients(Clients client) {
				this.client = client;
			}
			@Column(name="date_resa")
			@JsonFormat(pattern = "yyyy-MM-dd")
			public Date getDateDeResa() {
				return dateDeResa;
			}
			public void setDateDeResa(Date dateDeResa) {
				this.dateDeResa = dateDeResa;
			}
			@ManyToOne
			@JoinColumn(name="id_table")
			public Tables getTables() {
				return table;
			}
			public void setTables(Tables table) {
				this.table = table;
			}
		
			@Column(name="nbrePersonne")
			public long getNbrePersonne() {
				return NbrePersonne;
			}
			public void setNbrePersonne(long nbrePersonne) {
				NbrePersonne = nbrePersonne;
			}
			public Reservation(long idReservation, Clients client, Date dateDeResa, Tables table, long NbrePersonne) {
				super();
				this.idReservation = idReservation;
				this.client = client;
				this.dateDeResa = dateDeResa;
				this.table = table;
				this.NbrePersonne=NbrePersonne;
			}
			public Reservation() {
				
			}
			
			@Override
			public String toString() {
				return "Reservation [client=" + client + ", dateDeResa=" + dateDeResa + ", table=" + table + ",NbrePersonne="+ NbrePersonne+"]";
			}
	
			
	
			
}
