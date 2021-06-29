package projet_poo;

public abstract class Compte {
	protected double solde;
	protected final Client titulaire;
	protected int numero;
	protected static int ind = 0;
	
	public Compte(double solde, Client client) {
		this.solde = solde;
		this.titulaire= client;
		this.numero = ind;
		ind++;
	}

	public Compte() {
		this(0, null);
	}
	
	@Override
	public String toString() {
		return "Compte [solde=" + solde + ", titulaire=" + titulaire + ", numero=" + numero + "]";
	}

	public double getSolde() {
		return this.solde;
	}
	protected void setSolde(double solde) {
		this.solde = solde;
	}
	
	public int getNumero() {
		return numero;
	}


	public void depot (double montant)throws Exception {
		if(montant > 0) {
			this.solde = this.solde +montant;
			System.out.println("operation effectuee");
		}else throw new Exception("montant non valide");
	}
	
	
	
	public Client getTitulaire() {
		return titulaire;
	}

	public abstract void actualiser();
	
}
