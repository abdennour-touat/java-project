package projet_poo;

public class CompteCourant extends CompteNonBloquee {
	private double seuilDecouvert;
	private static int pourcentageAgio = 5;
	
	public CompteCourant(double solde, Client client) {
		super(solde, client);
		
	}
	public CompteCourant(int seuilDecouvert) {
		super();
		this.seuilDecouvert = seuilDecouvert;
		// TODO Auto-generated constructor stub
	}

	public CompteCourant() {
		// TODO Auto-generated constructor stub
		super();
	}
	public CompteCourant(double solde, Client client, int seuilDecouvert) {
		super(solde, client);
		this.seuilDecouvert = seuilDecouvert;
		// TODO Auto-generated constructor stub
	}

	
	public static int getPourcentageAgio() {
		return pourcentageAgio;
	}
	public static void setPourcentageAgio(int prcnt) {
		pourcentageAgio = prcnt;
	}
	
	public double getSeuilDecouvert() {
		return seuilDecouvert;
	}
	public void setSeuilDecouvert(int seuilDecouvert) {
		this.seuilDecouvert = seuilDecouvert;
	}
	@Override
	public void retrait(double montant) throws Exception {
		if(montant > 0 && this.getSolde() -montant < seuilDecouvert) {
			
			this.setSolde(this.getSolde() - montant);
		}else {
			throw new Exception("operation non valide");
		}
		if(this.getSolde()<0) {
			this.actualiser();
		}
	}
	@Override
	public void actualiser() {
		System.out.println("le solde est negatif, des agios sera prelever");
		this.setSolde(getSolde() - (this.getSolde()*pourcentageAgio/100));
	}
	
	public void depot(double montant) throws Exception{
		super.depot(montant);
		
		if(this.getSolde()<0) {
			System.out.println("le solde est negatif, des agios sera prelever");
			this.actualiser();
		}
	}

}
