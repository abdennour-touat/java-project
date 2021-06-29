package projet_poo;

public abstract class CompteNonBloquee extends Compte {

	public CompteNonBloquee(double solde, Client client) {
		super(solde, client);
		// TODO Auto-generated constructor stub
	}
	public CompteNonBloquee() 
	{
		super(0, null);
	}
	
	public abstract void retrait(double montant) throws Exception;
	
	public void virement(Compte destinataire, double montant) throws Exception{
		if(montant >0) {
			destinataire.depot(montant);
			this.setSolde(this.getSolde() -montant);
		}
	}

	
}
