package fr.humanbooster.ibm.fitness.builder;

import java.time.LocalDate;
import java.time.LocalTime;

import fr.humanbooster.ibm.fitness.business.Adherent;
import fr.humanbooster.ibm.fitness.business.Course;
import fr.humanbooster.ibm.fitness.business.Entraineur;
import fr.humanbooster.ibm.fitness.business.Tapis;

public interface CourseBuilder {

	CourseBuilder definirTapis(Tapis tapis);

	CourseBuilder definirAdherent(Adherent adherent);

	CourseBuilder definirEntraineur(Entraineur entraineur);

	CourseBuilder definirDistanceEnMetres(int distanceEnMetres);

	CourseBuilder definirDureeEnMinutes(int dureeEnMinutes);

	CourseBuilder definirDateDebutCourse(LocalDate dateSaisie);

	CourseBuilder definirHeureDebutCourse(LocalTime heureSaisie);

	Course build();
}
