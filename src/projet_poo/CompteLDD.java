package projet_poo;

public class CompteLDD extends CompteNonBloquee {
	
	public static int pourcentageInterets = 2;
	public static double seuil = 1000;

	public CompteLDD(double solde, Client client) {
		super(solde, client);
		// TODO Auto-generated constructor stub
	}

	public CompteLDD() {
		// TODO Auto-generated constructor stub
		super(0, null);
	}

	@Override
	public void retrait(double montant) {
		// TODO Auto-generated method stub
		if(this.getSolde() - montant<0) {
			System.out.println("retrait intedit, montant superieur a le solde actuel");
		}else {
			if(montant > seuil) {
				System.out.println("retrait interdit, montant superieur a le seuil");
			}else {
				this.setSolde(getSolde() - montant);
			}
		}
	}

	@Override
	public void actualiser() {
		this.setSolde(getSolde() + (pourcentageInterets * this.getSolde())/100);
	}
	public void depot(double montant) throws Exception{
		super.depot(montant);
	}
	
	
	
	public static int getPourcentageInterets() {
		return pourcentageInterets;
	}

	public static void setPourcentageInterets(int pourcentageInterets) {
		CompteLDD.pourcentageInterets = pourcentageInterets;
	}

	public static double getSeuil() {
		return seuil;
	}

	public static void setSeuil(double seuil) {
		CompteLDD.seuil = seuil;
	}
	

}
