package projet_poo;

public class ComptePEL extends Compte {
	
	public static int pourcentageInterets = 3;

	public ComptePEL(double solde, Client client) {
		super(solde, client);
		// TODO Auto-generated constructor stub
	}

	public ComptePEL() {
		// TODO Auto-generated constructor stub
		super(0, null);
	}


	@Override
	public void actualiser() {
		this.setSolde(getSolde() + (pourcentageInterets * this.getSolde())/100);
	}
	
	public static int getPourcentageInterets() {
		return pourcentageInterets;
	}
	public static void setPourcentageInterets(int pourcentage) {
		pourcentageInterets = pourcentage;
	}

}
