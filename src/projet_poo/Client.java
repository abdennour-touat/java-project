package projet_poo;

import java.util.*;
public class Client {
	private String nom , prenom;
	private Date dateNaissance;
	private String adresse;
	private ArrayList<Compte> comptes = new ArrayList<Compte>();
	
	
	
	public Client(String nom, String prenom, Date dateNaissance, String adresse) {
		super();
		this.nom = nom.toUpperCase();
		this.prenom = prenom.substring(0, 1).toUpperCase()+ prenom.substring(1).toLowerCase(); 
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}
	
	public String getNom() {
		return this.nom;
	}
	public String getAdresse() {
		return this.adresse;
	}
	
	public String toString() {
		return this.prenom + " "+this.nom + " ("+this.dateNaissance+")";
	}
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(!(o instanceof Client)) {
			return false;
		}
		Client cl = (Client)o;
		if(cl.nom == this.nom && cl.prenom == this.prenom && cl.dateNaissance == this.dateNaissance && cl.adresse == this.adresse ) {
			return true;
		}
		return false;
	}
	
	public void ajouterCompte(Compte cp) {
		if(cp instanceof CompteLDD || cp instanceof ComptePEL) {
			this.comptes.add(cp);
		}else if(cp instanceof CompteCourant) {
			boolean check = true;
			Iterator<Compte> it = this.comptes.iterator();
			while(check && it.hasNext()) {
				if(it.next() instanceof CompteCourant) check = false;
			}
			if (check) {
				this.comptes.add(cp);
			}else System.out.println("cette Client a un compte courant deja");
		}
	}

	public ArrayList<Compte> getComptes() {
		return comptes;
	}

	
	
	
}
