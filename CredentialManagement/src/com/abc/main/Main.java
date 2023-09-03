package com.abc.main;

import java.util.Scanner;

import com.abc.interfaces.CredentialService;
import com.abc.model.Employee;
import com.abc.service.DefaultCredentialService;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter First Name : ");
		String firstName = sc.nextLine();

		System.out.println("Enter Last Name : ");
		String lastName = sc.nextLine();
		
		System.out.println("Choose department : ");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		
		int deptChpoice = sc.nextInt();
		
		String department = null;
		switch(deptChpoice) {
		case 1: {
			department = "tech";
			break;
		}
		case 2: {
			department = "admin";
			break;
		}
		case 3: {
			department = "hr";
			break;
		}
		case 4: {
			department = "legal";
			break;
		}
		default:{
			System.out.println("Invalid option");
			System.exit(0);
		}
		
		}
		
		if(department != null)
		{
			String company = "abc";
			Employee employee = new Employee(firstName, lastName);
			CredentialService credentialService = new DefaultCredentialService(employee);
			credentialService.showCredentials(department, company);
		}
		sc.close();
	}

}
