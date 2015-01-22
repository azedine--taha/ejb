package metier.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import metier.entities.Compte;

@Stateless(name="BK")
public class BanqueEJBImpl implements IBanqRemote,IBanqLocal {

	
    @PersistenceContext(name="UP_BANQUE")
	private EntityManager em;
	
	@Override
	public void AddCompte(Compte c) {
		em.persist(c);		
	}
	@Override
	public List<Compte> getAll() {
		Query req=em.createQuery("select c from Compte c where c.active=true");
		return req.getResultList();
	}
	@Override
	public Compte getCompte(Long code) {
		Compte c= em.find(Compte.class, code);
		if(c==null) throw new RuntimeException("Compte introuvable");
		return c;
	}
	@Override
	public void verser(double mnt, Long code) {
		Compte c =getCompte(code);
		c.setSolde(c.getSolde()+mnt);
		
	}
	@Override
	public void retirer(double mnt, Long code) {
		Compte c =getCompte(code);
		c.setSolde(c.getSolde()-mnt);		
	}
	@Override
	public void virement(double mnt, Long cpte1, Long cpte2) {
		retirer(mnt, cpte1);
		verser(mnt, cpte2);		
	}
	@Override
	public void updateCompte(Compte c) {
		em.merge(c);		
	}
	@Override
	public void supprimerCompte(Long code) {
		Compte c =getCompte(code);
		em.remove(c);
		
	}

}
