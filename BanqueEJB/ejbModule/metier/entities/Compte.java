package metier.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="COMPTES")
public class Compte implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODE")
	private Long code;
	@Column(name="SOLDE")
	@NonNull
	private Double solde;
	@Temporal(TemporalType.TIMESTAMP)
	 @NonNull
	private Date dateCreation;
	 @NonNull
	private boolean active;	
	
//	public Compte() {
//		super();
//	}
//	public Compte(Double solde, Date dateCreation, boolean active) {
//		super();
//		this.solde = solde;
//		this.dateCreation = dateCreation;
//		this.active = active;
//	}
//	public Long getCode() {
//		return code;
//	}
//	public void setCode(Long code) {
//		this.code = code;
//	}
//	public Double getSolde() {
//		return solde;
//	}
//	public void setSolde(Double solde) {
//		this.solde = solde;
//	}
//	public Date getDateCreation() {
//		return dateCreation;
//	}
//	public void setDateCreation(Date dateCreation) {
//		this.dateCreation = dateCreation;
//	}
//	public boolean isActive() {
//		return active;
//	}
//	public void setActive(boolean active) {
//		this.active = active;
//	}
//	
//	

}
