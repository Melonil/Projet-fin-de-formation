package com.m2i.java.model;

import com.m2i.java.ENUM.ROLE;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserAccount {
	
	@Id
	@Column(nullable=false,updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String login;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private ROLE role;



	public UserAccount(String login, String password, ROLE role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("UserAccount{");
		sb.append("id=").append(id);
		sb.append(", login='").append(login).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", role=").append(role);
		sb.append('}');
		return sb.toString();
	}
}
