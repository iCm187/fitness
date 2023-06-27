package fr.humanbooster.ibm.fitness.business;

import java.time.LocalDateTime;

public class Course {

	private Long id;
	private LocalDateTime dateHeureDebut;
	private int dureeEnMinutes;
	private int distanceEnMetres;

	private static Long compteur = 0L;

	private Tapis tapis;

	private Adherent adherent;

	private Entraineur entraineur;
	
	public Course() {
		id = ++compteur;
	}

	public Course(LocalDateTime dateHeureDebut, int dureeEnMinutes, int distanceEnMetres, Tapis tapis,
			Adherent adherent, Tapis tapis1) {
		this();
		this.dateHeureDebut = dateHeureDebut;
		this.dureeEnMinutes = dureeEnMinutes;
		this.distanceEnMetres = distanceEnMetres;
		this.tapis = tapis;
		this.adherent = adherent;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateHeureDebut() {
		return dateHeureDebut;
	}

	public void setDateHeureDebut(LocalDateTime dateHeureDebut) {
		this.dateHeureDebut = dateHeureDebut;
	}

	public int getDureeEnMinutes() {
		return dureeEnMinutes;
	}

	public void setDureeEnMinutes(int dureeEnMinutes) {
		this.dureeEnMinutes = dureeEnMinutes;
	}

	public int getDistanceEnMetres() {
		return distanceEnMetres;
	}

	public void setDistanceEnMetres(int distanceEnMetres) {
		this.distanceEnMetres = distanceEnMetres;
	}

	public Tapis getTapis() {
		return tapis;
	}

	public void setTapis(Tapis tapis) {
		this.tapis = tapis;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Entraineur getEntraineur() {
		return entraineur;
	}

	public void setEntraineur(Entraineur entraineur) {
		this.entraineur = entraineur;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", dateHeureDebut=" + dateHeureDebut + ", dureeEnMinutes=" + dureeEnMinutes
				+ ", distanceEnMetres=" + distanceEnMetres + ", tapis=" + tapis + ", adherent=" + adherent
				+ ", entraineur=" + entraineur + "]";
	}

}
