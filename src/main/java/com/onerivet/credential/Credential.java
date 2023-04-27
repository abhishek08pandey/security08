package com.onerivet.credential;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Credential {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String userId;
	private String password;
	private String role;
}
