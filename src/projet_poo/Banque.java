package projet_poo;
import java.util.ArrayList;
import java.util.Date;
public class Banque {
	//les tableau contenent les clients et les comptes..
	
	private ArrayList<Client> clients = new ArrayList<Client>();
	private ArrayList<Compte> comptes = new ArrayList<Compte>();
	
	public Banque(ArrayList<Client> clients, ArrayList<Compte> comptes) {
		this.comptes = comptes;
		this.clients = clients;
	}
	
	public void ajoutClient(Client client) {
		if(client != null)
			this.clients.add(client);
	}
	public void newCompte(Compte cp) {
		if (cp != null)
			this.comptes.add(cp);
	}
	public void crediterCompte(int numero, double montant) throws Exception {
		for(Compte cp : this.comptes) {
			if (cp.numero == numero) {
				cp.depot(montant);
			}
		}
	}

	public void retraitCompte(int numero, double montant)throws Exception {
		for(Compte cp : this.comptes) {
			if (cp.numero == numero) {
				if(cp instanceof Compte || cp instanceof ComptePEL) {
					System.out.println("compte non compatible avec l'operation de retrait");
				}else if (cp instanceof CompteCourant){
					((CompteCourant)cp).retrait(montant);
					}else if(cp instanceof CompteLDD) {
						((CompteLDD)cp).retrait(montant);
					}
				}
			}
			
	}
	
	public void afficherCompte(int numero) {
		for(Compte cp : this.comptes) {
			if (cp.numero == numero) {
				System.out.println("nom titulaire : "+cp.getTitulaire() + " solde:"+ cp.getSolde());
			}
		}

	}
	
	public Compte chercherCompte (int numero) {
		
		for(Compte cp : this.comptes) {
			if (cp.numero == numero) {
				return cp;			}
		}
		return null;
		
	}
	
	public void afficherDecouvert() {
		for(Compte cp : this.comptes) {
			if(cp.getSolde() < 0) {
				System.out.println(cp.numero);
			}
		}
	}
	
	@Override
	public String toString() {
		return "Banque [clients=" + clients + ", banques=" + comptes + "]";
	}
	
	public static void main(String[] args){
		Client cl1 = new Client("djelloul", "Ahmed",new Date(), "boufatiss oran");
		Client cl2 = new Client("djilali", "Mohamed",new Date(), "labyad sidi chikh elbyd");
		ArrayList<Compte> cps = new ArrayList<Compte>();
		ArrayList<Client> cls = new ArrayList<Client>();
		
		
		
		
		
		CompteCourant cc = new CompteCourant(-500, cl1);
		cl1.ajouterCompte(cc);
		
		try {
			((CompteCourant)cl1.getComptes().get(0)).depot(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			((CompteCourant)cl1.getComptes().get(0)).retrait(100);;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			((CompteCourant)cl1.getComptes().get(0)).retrait(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ComptePEL cpel = new ComptePEL(0, cl1);
		try {
			cpel.depot(200);
		}catch(Exception e) {
			e.printStackTrace();
		}
		cl1.ajouterCompte(cpel);
		
		
		CompteCourant cc2 = new CompteCourant(0, cl1);
		
		cl1.ajouterCompte(cc2);
		
		
		cps.addAll(cl1.getComptes());
		cps.addAll(cl2.getComptes());
		
		cls.add(cl2);
		cls.add(cl1);

		Banque b = new Banque(cls, cps);
		
		for(Client cl : b.clients) {
			System.out.println(cl.toString());
		}
		for(Compte cp : b.comptes) {
			System.out.println(cp.toString());
		}
		
	}

}
