package com.m2i.java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Client extends UserDetailsClient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false,updatable=false)
	private Long id;
	
	@Column(nullable=false,updatable=false)
	private String idClient;
	
	@Column(nullable=false,updatable=false)
	private String numClient;

	public String toString() {
		return "Client(super=" + super.toString() + ", id=" + id + ", idClient=" + idClient + ", numClient=" + numClient + ")";
	}
	
}
