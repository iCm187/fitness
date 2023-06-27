package fr.humanbooster.ibm.fitness;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import fr.humanbooster.ibm.fitness.builder.CourseBuilder;
import fr.humanbooster.ibm.fitness.builder.impl.CourseBuilderImpl;
import fr.humanbooster.ibm.fitness.business.Adherent;
import fr.humanbooster.ibm.fitness.business.Course;
import fr.humanbooster.ibm.fitness.business.Entraineur;
import fr.humanbooster.ibm.fitness.business.Tapis;
import fr.humanbooster.ibm.fitness.util.ComparateurDAdherentsSurDistanceTotalParcourue;

public class App 
{
	// Attributs
	private static List<Entraineur> entraineurs = new ArrayList<>();
	private static List<Tapis> lesTapis = new ArrayList<>();
	private static List<Adherent> adherents = new ArrayList<>();
	private static List<Course> courses = new ArrayList<>();
	
	private static Scanner scanner = new Scanner(System.in);
    private static final String FORMAT_DATE = "yyyy-MM-dd";
    private static DateTimeFormatter dateTimeFormatterDate = DateTimeFormatter.ofPattern(FORMAT_DATE);
    private static final String FORMAT_HEURE = "HH:mm";
    private static DateTimeFormatter dateTimeFormatterHeure = DateTimeFormatter.ofPattern(FORMAT_HEURE);

    public static void main( String[] args )
    {
        ajouterDonneesInitiales();
        
        while (true) {
        	afficherMenuPrincipal();
        	int choix = demanderChoix("Entrez votre choix : ", 1, 5);
        	
        	switch (choix) {
			case 1:
				ajouterAdherent();
				break;
			case 2:
				afficherAdherents(1);
				break;
			case 3:
				ajouterCourse();
				break;
			case 4:
				afficherCourses();
				break;
			case 5:
				System.out.println("Au revoir");
				System.exit(0);
				break;
			default:
				break;
			}
        }
    }

	private static void afficherMenuPrincipal() {
		System.out.println("MENU PRINCIPAL");
		System.out.println("1 : ajouter un adherent");
		System.out.println("2 : voir les adherents tries sur leur distance totale parcourue (de la plus grande distance à la plus petite distance)");
		System.out.println("3 : ajouter une course");
		System.out.println("4 : voir toutes les courses");
		System.out.println("5 : quitter");
	}

	private static void afficherCourses() {
		for (Course course : courses) {
			System.out.println(course);
		}
	}

	private static Course ajouterCourse() {

		afficherAdherents(0);
		System.out.print("Entrez l'id de l'adherent : ");
		Adherent adherent = recupererAdherent(Long.parseLong(scanner.nextLine()));
		
        afficherTapis();
        System.out.print("Entrez l'id du tapis : ");
        Tapis tapis = recupererTapis(Long.parseLong(scanner.nextLine()));

        afficherEntraineurs();
        System.out.print("Entrez l'id de l'entraineur : ");
        Entraineur entraineur = recupererEntraineur(Long.parseLong(scanner.nextLine()));

        System.out.print("Entrez la date a laquelle la course a ete effectuee au format " + FORMAT_DATE + " : ");
        LocalDate dateSaisie = LocalDate.parse(scanner.nextLine(), dateTimeFormatterDate);

        System.out.print("Entrez l'heure a laquelle la course a debute : " + FORMAT_HEURE + " : ");
        LocalTime heureSaisie = LocalTime.parse(scanner.nextLine(), dateTimeFormatterHeure);

        System.out.print("Entrez la duree en minutes : ");
        int dureeEnMinutes = Integer.parseInt(scanner.nextLine());

        System.out.print("Entrez la distance en metres : ");
        int distanceEnMetres = Integer.parseInt(scanner.nextLine());

        // On aimerait utiliser un builder (patron de conception)
        // Le builder fournit une autre faÃ§on de constuire un
        // objet de type Course
        CourseBuilder courseBuilder = new CourseBuilderImpl();
        courseBuilder.definirTapis(tapis);
        courseBuilder.definirAdherent(adherent).definirEntraineur(entraineur);
        courseBuilder.definirDistanceEnMetres(distanceEnMetres);
        courseBuilder.definirDureeEnMinutes(dureeEnMinutes);
        courseBuilder.definirDateDebutCourse(dateSaisie);
        courseBuilder.definirHeureDebutCourse(heureSaisie);
        Course course = courseBuilder.build();
        
        courses.add(course);
        
		System.out.println("La course a bien ete ajoute, elle porte l'id " + course.getId() + ". "+ course);
		System.out.println();
		
        return course;
	}

    private static Adherent recupererAdherent(Long id) {
		for (Adherent adherent : adherents) {
			if (adherent.getId().equals(id)) {
				return adherent;
			}
		}
		return null;
	}

	private static Tapis recupererTapis(Long id) {
		for (Tapis tapis : lesTapis) {
			if (tapis.getId().equals(id)) {
				return tapis;
			}
		}
        return null;
    }

	private static Entraineur recupererEntraineur(Long id) {
		for (Entraineur entraineur : entraineurs) {
			if (entraineur.getId().equals(id)) {
				return entraineur;
			}
		}
        return null;
    }

	private static void afficherTapis() {
		System.out.println("Voici la liste exhaustive des tapis de course :");
		for (Tapis tapis : lesTapis) {
			System.out.println(tapis.getId() + " : " + tapis.getNom());
		}
	}

	private static void afficherAdherents(int tri) {
		if (tri==1) {
			Collections.sort(adherents, new ComparateurDAdherentsSurDistanceTotalParcourue());
		}
		else {
			Collections.sort(adherents);
		}
		
		System.out.println("Voici la liste exhaustive des adherents :");
		for (Adherent adherent : adherents) {
			System.out.println(adherent.getId() + " : " + adherent.getPrenom() + " " + adherent.getNom());
		}
	}

	private static void afficherEntraineurs() {
		System.out.println("Voici la liste exhaustive des entraineurs :");
		for (Entraineur entraineur : entraineurs) {
			System.out.println(entraineur.getId() + " : " + entraineur.getPrenom() + " " + entraineur.getNom());
		}
	}

	private static void ajouterAdherent() {
		String nom = "";
		String prenom = "";

		System.out.println("Ajout d'un adherent");
		System.out.print("Entrer le nom de l'adherent: ");
		nom = scanner.nextLine();
		System.out.print("Entrer le prenom de l'adherent: ");
		prenom = scanner.nextLine();
		System.out.print("Entrez la date de naissance au format " + FORMAT_DATE + " : ");
        LocalDate dateDeNaissance = LocalDate.parse(scanner.nextLine(), dateTimeFormatterDate);

        /*Adherent adherent = new Adherent(nom, prenom, dateDeNaissance);*/
        Adherent adherent = Adherent.builder()
                .nom(nom)
                .prenom(prenom)
                .dateDeNaissance(dateDeNaissance)
                .build();

		adherents.add(adherent);
		System.out.println("L'adherent a bien ete ajoute, il porte l'id " + adherent.getId());
		System.out.println();
	}

	private static void ajouterDonneesInitiales() {
		ajouterTapis();
		ajouterEntraineurs();
	}

	private static void ajouterEntraineurs() {
		Entraineur entraineur1 = new Entraineur("Arnold", "CRAMPE", "0622242628");
		Entraineur entraineur2 = new Entraineur("Carter", "COACH", "0622242630");
		entraineurs.add(entraineur1);
		entraineurs.add(entraineur2);
	}

	private static void ajouterTapis() {
		Tapis tapis0 = Tapis.builder().nom("STAR TRAC #0").build();
		Tapis tapis1 = Tapis.builder().nom("STAR TRAC #1").build();
		Tapis tapis2 = Tapis.builder().nom("STAR TRAC #2").build();
		lesTapis.add(tapis0);
		lesTapis.add(tapis1);
		lesTapis.add(tapis2);
	}
	
	private static int demanderChoix(String message, int borneMin, int borneMax) {
          int valeur = borneMin - 1;
          // Utilisation d'une boucle do while
          // Le code dans le do sera exécuté au moins une fois
          do {
                  System.out.print(message);
                  try {
                          String saisie = scanner.nextLine();
                          valeur = Integer.parseInt(saisie);
                          if (valeur<borneMin || valeur>borneMax)
                          {
                                  System.out.println("Merci de saisir un nombre compris entre " + borneMin + " et " + borneMax );
                          }
                  }
                  catch (NumberFormatException e)
                  {
                          System.out.println("Merci de saisir un nombre entier");
                  }

          }
          while (!(valeur>=borneMin && valeur<=borneMax));
          // équivalent à
          // while (choix<borneMin || choix>borneMax);
          // Loi de De Morgan
          return valeur;
  }

}