package fr.humanbooster.ibm.fitness.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder

public class Entraineur extends Personne{

	private String numeroDeTelephone;
	
    public Entraineur(String nom, String prenom, String numeroDeTelephone) {
		super(nom, prenom);
		this.numeroDeTelephone = numeroDeTelephone;
	}

	@Override
	public String toString() {
		return "Entraineur [numeroDeTelephone=" + numeroDeTelephone + ", id=" + id + ", nom=" + nom + ", prenom="
				+ prenom + "]";
	}

}
