package com.onerivet.credential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credential")
public class CredentialController {

	@Autowired
	private Credentialrepository credentialrepository;
	
	@PostMapping("/add")
	public String addCredential(@RequestBody Credential credential) {
		credentialrepository.save(credential);
		return "done";
	}
}
