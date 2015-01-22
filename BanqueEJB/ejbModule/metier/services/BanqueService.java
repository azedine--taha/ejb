package metier.services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.entities.Compte;
import metier.session.IBanqLocal;

@WebService
@Stateless
public class BanqueService {

	@EJB
	private IBanqLocal metier;
	
	@WebMethod
	public void AjouterCompte(@WebParam(name="solde")double soldeInit){
		Compte c=new Compte(soldeInit, new Date(), true);
		metier.AddCompte(c);
	}
	@WebMethod
	public List<Compte> ListComptes(){
		return metier.getAll();
	}
	
	@WebMethod
	public Compte consulterCompte(@WebParam(name="code")Long code){
		return metier.getCompte(code);
	}
}
