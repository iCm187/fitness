package fr.humanbooster.ibm.fitness.builder.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import fr.humanbooster.ibm.fitness.builder.CourseBuilder;
import fr.humanbooster.ibm.fitness.business.Adherent;
import fr.humanbooster.ibm.fitness.business.Course;
import fr.humanbooster.ibm.fitness.business.Entraineur;
import fr.humanbooster.ibm.fitness.business.Tapis;

public class CourseBuilderImpl implements CourseBuilder{

	 	private Course course;
	    private LocalDate dateSaisie;
	    private LocalTime heureSaisie;

	    public CourseBuilderImpl() {
			course = new Course();
	    }
	    
	@Override
	public CourseBuilder definirTapis(Tapis tapis) {
		course.setTapis(tapis);
		return this;
	}

	@Override
	public CourseBuilder definirAdherent(Adherent adherent) {
		course.setAdherent(adherent);
		return this;
	}

	@Override
	public CourseBuilder definirEntraineur(Entraineur entraineur) {
		course.setEntraineur(entraineur);
		return this;
	}

	@Override
	public CourseBuilder definirDistanceEnMetres(int distanceEnMetres) {
		course.setDistanceEnMetres(distanceEnMetres);
		return this;
	}

	@Override
	public CourseBuilder definirDureeEnMinutes(int dureeEnMinutes) {
		course.setDureeEnMinutes(dureeEnMinutes);
		return this;
	}

	@Override
	public CourseBuilder definirDateDebutCourse(LocalDate dateSaisie) {
		this.dateSaisie = dateSaisie;
		return this;
	}

	@Override
	public CourseBuilder definirHeureDebutCourse(LocalTime heureSaisie) {
		this.heureSaisie = heureSaisie;
		return this;
	}

	@Override
	public Course build() {
        LocalDateTime tempsEtHeure = LocalDateTime.of(dateSaisie, heureSaisie);
        course.setDateHeureDebut(tempsEtHeure);
        return course;
    }
}
