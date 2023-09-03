package com.abc.interfaces;

public interface CredentialService {
	String generateEmailAddress(String department, String company);
	
	String generatePassword();
	
	void showCredentials(String department, String company);
}
