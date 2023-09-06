package com.zulo.view;

import java.util.Scanner;

public class CabSystem {

	public static void main(String[] args) {
		System.out.println("    Welcome to ZULA!!");
		new CabSystem().start();
	}

	private void start() {
		Scanner inp = new Scanner(System.in);
		process(inp);
		System.out.println("  ~~~ Thank you! ~~~");
	}

	private void process(Scanner inp) {
		String choice = "";
		do {
			showInstruction();
			choice = inp.next();
			manage(choice);
		} while (!choice.equals("4"));
	}

	private void manage(String choice) {
		LoginManager manage = new LoginManager();
		switch (choice) {
		case "1":
			manage.makeLogin(2,"Driver");
			break;
		case "2":
			manage.makeLogin(0,"Customer");
			break;
		case "3":
			manage.makeLogin(1,"Admin");
			break;
		case "4":
			break;
		default:
			System.out.println("Invalid input");
		}
	}

	private void showInstruction() {
		System.out.println("--------------------------");
		System.out.println("""
				1 . Cab Driver Login
				2 . Customer Login
				3 . Administrator Login
				4 . Quit

				 Enter choice :
				""");
	}

}
