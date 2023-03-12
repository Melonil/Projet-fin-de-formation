package com.m2i.java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false,updatable=false)
	private Long id;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [id=").append(id).append("]");
		return builder.toString();
	}
	
}
