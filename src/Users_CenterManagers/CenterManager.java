package Users_CenterManagers;

import java.util.Scanner;

public class CenterManager {
	public static void main(String[] args) {
		//arguments: -Djava.security.manager . new SecurityManager()
		checkValidID();
		
		
	}

	private static void checkValidID() {
		// TODO Auto-generated method stub
		Boolean flag = true;
		while(flag) {
			System.out.println("----------Welcome To Our System-----------");
			do{
				System.out.println("-----Please input a valid manager ID------");
				Configuration.managerID = new Scanner(System.in).next();
			}while(!checkManagerIDexists(Configuration.managerID));
			flag = false;
		}
	}

	private static boolean checkManagerIDexists(String managerID) {
		// TODO Auto-generated method stub
		return false;
	}


}
