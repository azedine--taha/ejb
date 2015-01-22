package metier.session;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import metier.entities.Compte;
@Local
public interface IBanqLocal {
	
	public void AddCompte(Compte c);
	public List<Compte> getAll();
	public Compte getCompte(Long code);
	public void verser(double mnt,Long code);
	public void retirer(double mnt,Long code);
	public void virement(double mnt,Long cpte1,Long cpt2);
	public void updateCompte(Compte c);
	public void supprimerCompte(Long code);

}
