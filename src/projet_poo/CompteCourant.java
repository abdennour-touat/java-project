package projet_poo;

public class CompteCourant extends CompteNonBloquee {
	private double seuilDecouvert;
	private static int pourcentageAgio = 5;
	
	//constructeurs
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

	//gettters and setters
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
	
	//methode retrait avec le test si le solde depasse le seuilDecouvert
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
	
	//methode actualiser si le solde est en decouvert
	@Override
	public void actualiser() {
		System.out.println("le solde est negatif, des agios sera prelever");
		this.setSolde(getSolde() - (this.getSolde()*pourcentageAgio/100));
	}
	
	//methode depot
	public void depot(double montant) throws Exception{
		super.depot(montant);
		
		if(this.getSolde()<0) {
			System.out.println("le solde est negatif, des agios sera prelever");
			this.actualiser();
		}
	}
	
	//methode to string
	@Override
	public String toString() {
		return "CompteCourant [seuilDecouvert=" + seuilDecouvert + ", solde=" + solde + ", titulaire=" + titulaire
				+ ", numero=" + numero + "]";
	}

}
