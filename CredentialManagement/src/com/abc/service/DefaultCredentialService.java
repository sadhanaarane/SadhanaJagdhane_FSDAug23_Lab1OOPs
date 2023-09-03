package com.abc.service;

import java.util.Random;

import com.abc.interfaces.CredentialService;
import com.abc.model.Employee;

public class DefaultCredentialService implements CredentialService{
	private Employee employee;
	
	public DefaultCredentialService(Employee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public String generateEmailAddress(String department, String company) {
		// TODO Auto-generated method stub
		return employee.getFirstName().toLowerCase().trim() + 
				employee.getLastName().toLowerCase().trim() + "@" + 
		department.toLowerCase().trim() + "." + company.toLowerCase().trim() + ".com";
	}

	@Override
	public String generatePassword() {
		// TODO Auto-generated method stub
		String specialCharacters = "!@#$%^&*()_+";
		String digits = "0123456789";
		String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
		
		Random random = new Random();
		
		String password = "";
		
		//At least one character from each category
		password += digits.charAt(random.nextInt(digits.length()));
		password += uppercaseLetters.charAt(random.nextInt(uppercaseLetters.length()));
		password += lowercaseLetters.charAt(random.nextInt(lowercaseLetters.length()));
		password += specialCharacters.charAt(random.nextInt(specialCharacters.length()));
		
		String allCharacters = specialCharacters + digits + uppercaseLetters + lowercaseLetters;
		
		int remainingLength = 8 - password.length()  ;
		
		//Fill rest with random characters
		for(int i = 0; i < remainingLength; i++) {
			password += allCharacters.charAt(new Random().nextInt(allCharacters.length()));
		}
		
		//Shuffle password
		char[] characters= password.toCharArray();
		
		for(int i = characters.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			char temp = characters[i];
			characters[i] = characters[index];
			characters[index] = temp;
		}
		
		return new String(characters);
	}

	@Override
	public void showCredentials(String department, String company) {
		// TODO Auto-generated method stub
		String email = generateEmailAddress(department, company);
		String password = generatePassword();
		
		System.out.println("Dear " + employee.getFirstName().trim() + ", your generated credentials are as follows");
		System.out.println("Email    ---> " + email);
		System.out.println("Password ---> " + password);
	}

}
