package Users_CenterManagers;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jws.soap.SOAPBinding;

public class CenterManager {
	public static void main(String[] args) {
		//arguments: -Djava.security.manager . new SecurityManager()
		System.out.println("----------Welcome To Our System-----------");
		Boolean FlagID = true;
		do {
			checkManagerIDFormat();
			if (checkExistsServer(Configuration.managerID)) {
				showMenu(Configuration.managerID);
				FlagID = false;
			}else{
				System.err.println("The managerID does not exists in our system, please try again!\n");			
			}
		} while (FlagID);
		
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
//		if(managerID.equals("MTL10000")){
//			return true;
//		}else {
//			return false;
//		}
		DatagramSocket aSocket = null;
		int serverPort = 0;
		
		if (Configuration.managerID.substring(0, 3).equalsIgnoreCase("MTL")) {
			serverPort = Configuration.ServerPort_MTL;
		}else if(Configuration.managerID.substring(0, 3).equalsIgnoreCase("LVL")){
			serverPort = Configuration.ServerPort_LVL;
		}else if (Configuration.managerID.substring(0, 3).equalsIgnoreCase("DDO")) {
			serverPort = Configuration.ServerPort_DDO;
		}
		
		try {
			aSocket = new DatagramSocket();
			byte[] msg = managerID.getBytes();
			InetAddress aHost = InetAddress.getByName(Configuration.aHost);
			DatagramPacket request = new DatagramPacket(msg, msg.length, aHost, serverPort);
			aSocket.send(request);
			
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);
			System.out.println("Reply: "+ new String(reply.getData()));	
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private static void checkManagerIDFormat() {
		Boolean flag = true;
		do {
			System.out.println("-----Please input a valid manager ID------");
			Scanner sc = new Scanner(System.in);
			Configuration.managerID = sc.next();
			Pattern IDmanager = Pattern.compile("^(MTL|LVL|DDO)(\\d{5})$");
			Matcher matcherString = IDmanager.matcher(Configuration.managerID);
			if (matcherString.find()) {
				System.out.println("----------Now, check if the managerID exists in our system-----------\n");
				flag = false;
			}else {
				System.err.println("The ManagerID format should be MTL|LVL|DDO + 5 dight number. eg: MTL10000\n");	
			}
		} while (flag);
	}

}
