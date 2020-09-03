package Manager;

import java.util.Scanner;

public class Shop {
	Scanner in = new Scanner(System.in);
	
	public Shop() {
		while(true) {
			SignIn();
			
			if(SignIn()==1) {
				menu();
				int k = in.nextInt();
				in.nextLine();
				
				switch(k) {
				case 1: purchase(); break;
				case 2: myCart(); break;
				case 3: break;
				default: System.out.println("Choose again"); break;
				}
			}
			
		}
		
		
	}
	
	public void menu() {
		System.out.println("++LogIn Success++");
		System.out.println();
		System.out.println("1. Purchase");
		System.out.println("2. MyCart");
		System.out.println("3. Exit");
		
	}
	
	public int SignIn() {
		
		return 1; //id,pw맞으면
		//return 0; //안맞으면 
	}
	
	public void purchase() {
		
	}
	
	public void myCart() {
		
	}
	
}
