package Manager;

import java.util.Scanner;

import INF.ShopINF_Imp;

public class Shop {
	Scanner in = new Scanner(System.in);
	ShopINF_Imp shopINFimp = new ShopINF_Imp();
	
	public Shop() {
		signIn();
		while(true) {
			
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
	
	public void menu() {
		System.out.println();
		System.out.println("1. Purchase");
		System.out.println("2. MyCart");
		System.out.println("3. Exit");
		
	}
	
	public void signIn() {
		shopINFimp.signIn();
	}
	
	public void purchase() {
		shopINFimp.list();
		shopINFimp.purchase();
	}
	
	public void myCart() {
		shopINFimp.myCart();
	}
	
}
