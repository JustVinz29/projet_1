package fr.eni.bulletin;

import java.util.Scanner;

public class Bulletin {

	public static void main(String[] args) {
		
//Saisie Utilisateur
		String nom;
		String prenom;
		int statut;
		double heure;
		double txHoraire;
		int enfant;
		Scanner scanner = new Scanner(System.in);
// Variable calculs
		double salaireBute;
		double cotisationSalariales;
		double salaireNet;
		int primeFamille;
		double salaireTotal;
		double salHeureSup1;
		double salHeureSup2;
		double salaireBase;
//Statut
		final int STATUT_AS = 1;
		final int STATUT_EB = 2;
		final int STATU_C = 3;
//Cotisation
		final double COT_IMP = 0.0349d;
		final double COT_N_IMP = 0.0615d;
		final double ASS_MAL = 0.0095d;
		final double ASS_VIEL = 0.0844d;
		final double ASS_CHOM = 0.0305d;
		final double RET_COMP = 0.0381d;
		final double COT_AGFF = 0.0102d;
//Prime Famille
		final int ENFANT_1 = 20;
		final int ENFANT_2 = 50;
		final int ENFANT_3 = 70;
		final int ENFANT_SUP = 20;
//Heures SUP
		//final String PERCENT_HSUP_1 = "50%";
		//final String PERCENT_HSUP_2 = "60%";
		final double MAJ_HSUP_1 = 1.5d;
		final double MAJ_HSUP_2 = 1.6d;
		final double HSUP_1 = 169d;
		final double HSUP_2 = 180d;
		String test;
//Saisie Info
		System.out.println("Indiquez votre nom :");
		nom = scanner.nextLine();
		System.out.println("Indiquez votre prenom :");
		prenom = scanner.nextLine();
		System.out.println("Indiquez votre statut :");
		System.out.println(STATUT_AS + " - Agent de Service");
		System.out.println(STATUT_EB + " - Employé de Bureau");
		System.out.println(STATU_C + "- Cadre");
		statut = scanner.nextInt();
		System.out.println("Indiquez le nombre d'heures travaillées :");
		heure = scanner.nextInt();
		test = scanner.nextLine();
		System.out.println("Indiquez votre taux horaire :");
		txHoraire = scanner.nextDouble();
		System.out.println("Indiquez le nombre d'enfants :");
		enfant = scanner.nextInt();
		
//bulletin de paie
		System.out.println("Bulletin de " + prenom + " " + nom);
		switch (statut) {
			case 1: { 
				System.out.println("Statut : Agent de service");break;
			}
			case 2: {
				System.out.println("Statut : Employé de bureau");break;
			}
			case 3: {
				System.out.println("Statut : Cadre");break;
			}
			
		}
//salaire brute
		if (heure > HSUP_2) {
			salHeureSup2 = (heure - HSUP_2) * txHoraire * MAJ_HSUP_2;
			salHeureSup1 = ((heure - HSUP_1) - (heure - HSUP_2)) * txHoraire * MAJ_HSUP_1;
			salaireBase = HSUP_1 * txHoraire;	
			System.out.println("Salaire brute : " + (salHeureSup2 + salHeureSup1 + salaireBase) + " €");
			salaireBute = (salHeureSup2 + salHeureSup1 + salaireBase);
		}
		else if (heure <= HSUP_2 && heure > HSUP_1) {
			salHeureSup2 = 0;
			salHeureSup1 = (heure - HSUP_1) * txHoraire * MAJ_HSUP_1;
			salaireBase = HSUP_1 * txHoraire;
			System.out.println("Salaire brute : " + (salHeureSup2 + salHeureSup1 + salaireBase) + " €");
			salaireBute = (salHeureSup2 + salHeureSup1 + salaireBase);
		}
		else  {
			salHeureSup2 = 0;
			salHeureSup1 = 0;
			salaireBase = heure * txHoraire;
			System.out.println("Salaire brute : " + (salHeureSup2 + salHeureSup1 + salaireBase) + " €");
			salaireBute = (salHeureSup2 + salHeureSup1 + salaireBase);
		}
//cotisation
		cotisationSalariales = 0 ;
		System.out.println("Calcul des cotisations :");
		System.out.println("- Contribution ...");
		System.out.println(salaireBute + " € x 3.49% = " +salaireBute*COT_IMP+ " €");
		cotisationSalariales = cotisationSalariales+(salaireBute*COT_IMP);
		System.out.println("- Contribution ...");
		System.out.println(salaireBute + " € x 6.15% = " +salaireBute*COT_N_IMP+ " €");
		cotisationSalariales = cotisationSalariales+(salaireBute*COT_N_IMP);
		System.out.println("- Assurance ...");
		System.out.println(salaireBute + " € x 0.95% = " +salaireBute*ASS_MAL+ " €");
		cotisationSalariales = cotisationSalariales+(salaireBute*ASS_MAL);
		System.out.println("- Assurance ...");
		System.out.println(salaireBute + " € x 8.44% = " +salaireBute*ASS_VIEL+ " €");
		cotisationSalariales = cotisationSalariales+(salaireBute*ASS_VIEL);
		System.out.println("- Assurance ...");
		System.out.println(salaireBute + " € x 3.05% = " +salaireBute*ASS_CHOM+ " €");
		cotisationSalariales = cotisationSalariales+(salaireBute*ASS_CHOM);
		System.out.println("- Retraite ...");
		System.out.println(salaireBute + " € x3.81% = " +salaireBute*RET_COMP+ " €");
		cotisationSalariales = cotisationSalariales+(salaireBute*RET_COMP);
		System.out.println("- Contribution ...");
		System.out.println(salaireBute + " € x 1.02% = " +salaireBute*COT_AGFF+ " €");
		cotisationSalariales = cotisationSalariales+(salaireBute*COT_AGFF);
		System.out.println("- Total des cotisations salariales : ");
		System.out.println(cotisationSalariales + " €");
		System.out.println("- Salaire net : " + (salaireBute-cotisationSalariales) + " €");
		salaireNet = salaireBute-cotisationSalariales;
//prime famille
		switch (enfant) {
			case 1: {
				primeFamille = ENFANT_1;
			}
			case 2: {
				primeFamille = ENFANT_1 + ENFANT_2;
			}
			case 3: {
				primeFamille = ENFANT_1 + ENFANT_2 + ENFANT_3;
			}
		default:
			primeFamille = ENFANT_1 + ENFANT_2 + ENFANT_3 + (ENFANT_SUP*(enfant-3));
		}
		System.out.println("- Prime familiale :" + primeFamille + " €");
		
		salaireTotal = salaireNet + primeFamille;
		System.out.println("Salaire net à payer : " + salaireTotal + " €");
		scanner.close(); 
	}

}
