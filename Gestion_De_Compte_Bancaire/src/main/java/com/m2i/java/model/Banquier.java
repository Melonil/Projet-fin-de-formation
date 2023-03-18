package com.m2i.java.model;


import com.m2i.java.ENUM.ROLE;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Entity
@Getter
@Data
public class Banquier extends UserAccount{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false,updatable=false)
	private Long id;
	
	@Column(unique = true,nullable=false,updatable=false)
	private String numEmploye;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="idAgence")
	private Agence agence;
	
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="idUserDetails")
	private UserDetails userDetails;
	
	public Banquier() {
		super();
	}
	
	@Builder
	public Banquier(Long id, String numEmploye, String login , String password, ROLE role, Agence agence, UserDetails userDetails) {
		super(login, password, role);
		this.id = id;
		this.numEmploye = numEmploye;
		this.agence = agence;
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Banquier [id=");
		builder.append(id);
		builder.append(", numEmploye=");
		builder.append(numEmploye);
		builder.append(", agence=");
		builder.append(agence);
		builder.append("]");
		return builder.toString();
	}


}
