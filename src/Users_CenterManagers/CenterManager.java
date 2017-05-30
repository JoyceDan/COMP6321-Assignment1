package Users_CenterManagers;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jws.soap.SOAPBinding;

public class CenterManager {
	public static void main(String[] args) {
		//arguments: -Djava.security.manager . new SecurityManager()
		System.out.println("----------Welcome To Our System-----------");
		checkValidID();
		if(checkExistsServer(Configuration.managerID)){
			showMenu(Configuration.managerID);
			//create the log file for manager
		}else{
			System.err.println("The managerID does not exists in our system, please try again!\n");
			checkValidID();
		}
		
	}

	private static void showMenu(String managerID) {
		// TODO Auto-generated method stub
		System.out.println("\n------- Welcome our manager "+managerID+" to DCMS -------");
		System.out.println("---- Please choose a operation to move on ----");
		System.out.println("1. Create a teacher record");
		System.out.println("2. Create a student record");
		System.out.println("3. Get the number of your tatal records");
		System.out.println("4. Edit your record");
		
	}

	private static boolean checkExistsServer(String managerID) {
		// TODO Auto-generated method stub
		if(managerID.equals("MTL10000")){
			return true;
		}else {
			return false;
		}
	}

	private static void checkValidID() {
		// TODO Auto-generated method stub
		Boolean flag = true;
		while(flag) {
			do{
				System.out.println("-----Please input a valid manager ID------");
				Scanner sc = new Scanner(System.in);
				Configuration.managerID = sc.next();
			}while(!checkManagerIDexists(Configuration.managerID));
			flag = false;
		}
	}

	private static boolean checkManagerIDexists(String managerID) {
		// TODO Auto-generated method stub
		Pattern IDmanager = Pattern.compile("^(MTL|LVL|DDO)(\\d{5})$");
		Matcher matcherString = IDmanager.matcher(managerID);
		if (matcherString.find()) {
			System.out.println("----------Now, check if the managerID exists in our system-----------\n");
			return true;
		}else {
			System.err.println("The ManagerID format should be MTL|LVL|DDO + 5 dight number. eg: MTL10000\n");
			checkValidID();
			return false;
		}
	}


}
