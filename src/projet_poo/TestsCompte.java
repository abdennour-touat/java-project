package projet_poo;

public class TestsCompte {

	public static void main(String[] args) {
		//le compte courant...
		CompteCourant cp1 = new CompteCourant(0, null, 1000);
		//tests depots..
		System.out.println("///////////////");
		System.out.println("compte courant:");

		System.out.println("ajout montant negatif:");
		try {
			cp1.depot(-500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("depot normale:");
		try {
			cp1.depot(500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//test retrait
		System.out.println("retrait montant negatif:");
		try {
			cp1.retrait(-500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("retrait normale:");
		try {
			cp1.retrait(200);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("depasser le seuil:");
		try {
			cp1.retrait(1200);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(cp1.toString());
		//test Compte PEL
		System.out.println("///////////////");
		System.out.println("compte PEL:");
		ComptePEL cpel = new ComptePEL(100, null);
		
		System.out.println("ajout montant negatif:");
		try {
			cpel.depot(-500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("depot normale:");
		try {
			cpel.depot(500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("solde avant actualisation:");
		System.out.println(cpel.toString());
		cpel.actualiser();
		cpel.actualiser();
		System.out.println("solde apres actualisation:");
		System.out.println(cpel.toString());
		
		//test compte LDD
		System.out.println("///////////////");
		System.out.println("compte LDD:");
		CompteLDD cpldd = new CompteLDD(200, null);
		System.out.println("ajout montant negatif:");
		try {
			cpldd.depot(-500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("depot normale:");
		try {
			cpldd.depot(500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("retrait solde negatif:");
		try {
			cpldd.retrait(-500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("retrait normale:");
		try {
			cpldd.retrait(500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("retrait montant superieur au solde:");
		try {
			cpldd.retrait(1600);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("depot normale:");
		try {
			cpldd.depot(1500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("solde avant actualisation:");
		System.out.println(cpldd.toString());
		cpldd.actualiser();
		cpldd.actualiser();
		System.out.println("solde apres actualisation:");
		System.out.println(cpldd.toString());
		
		
		
	}
	
	

}
