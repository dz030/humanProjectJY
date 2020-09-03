package Manager;

import java.util.Scanner;

public class Shop {
	Scanner in = new Scanner(System.in);
	
	public Shop() {
		while(true) {
			menu();
			
			int k = in.nextInt();
			in.nextLine();
			
			switch(k) {
			case 1: SignIn(); break;
			case 2: purchase(); break;
			case 3: myCart(); break;
			case 4: break;
			default: System.out.println("Choose again"); break;
			}
		}
		
		
	}
	
	public void menu() {
		System.out.println("++Welcome to Festival Market++");
		System.out.println();
		System.out.println("1. SignIn ");
		System.out.println("2. Purchase");
		System.out.println("3. MyCart");
		System.out.println("4. Exit");
		
	}
	
	public void SignIn() {
		
	}
	
	public void purchase() {
		
	}
	
	public void myCart() {
		
	}
	
}
