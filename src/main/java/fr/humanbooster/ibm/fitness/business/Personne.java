package fr.humanbooster.ibm.fitness.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
@SuperBuilder

public abstract class Personne {

    protected Long id = 0L;
    protected String nom;
    protected String prenom;
    private static Long compteur = 0L;

    protected Personne() {
    	id = ++compteur;
	}

	protected Personne(String nom, String prenom) {
		this();
		this.nom = nom;
		this.prenom = prenom;
	}
}