package fr.humanbooster.ibm.fitness.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@Getter
@Setter
@SuperBuilder

public class Adherent extends Personne  implements Comparable<Adherent> {

    private LocalDate dateDeNaissance; 
    
    @Builder.Default
    private List<Course> courses = new ArrayList<>();

    public Adherent(String nom, String prenom, LocalDate dateDeNaissance) {
		super(nom, prenom);
		this.dateDeNaissance = dateDeNaissance;
	}


	@Override
	public String toString() {
		return "Adherent [dateDeNaissance=" + dateDeNaissance + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ "]";
	}

	@Override
	public int compareTo(Adherent autreAdherent) {
		return getId().compareTo(autreAdherent.getId());
	}

}