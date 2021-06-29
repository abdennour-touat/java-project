package projet_poo;

public class ComptePEL extends Compte {
	
	public static int pourcentageInterets = 3;
	//constructeurs
	public ComptePEL(double solde, Client client) {
		super(solde, client);
		// TODO Auto-generated constructor stub
	}

	public ComptePEL() {
		// TODO Auto-generated constructor stub
		super(0, null);
	}
	
	//methode actualiser pour ajouter les interets..
	@Override
	public void actualiser() {
		this.setSolde(getSolde() + (pourcentageInterets * this.getSolde())/100);
	}
	//getters et setters
	public static int getPourcentageInterets() {
		return pourcentageInterets;
	}
	public static void setPourcentageInterets(int pourcentage) {
		pourcentageInterets = pourcentage;
	}
	//to string
	@Override
	public String toString() {
		return "ComptePEL [solde=" + solde + ", titulaire=" + titulaire + ", numero=" + numero + "]";
	}

}
