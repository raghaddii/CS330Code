// A Java program for a Client
import java.net.*;
import java.io.*;
import java.util.*;


public class Client{

	// initialize socket and input output streams
	private Socket socket		 = null;
	private DataInputStream input = null;
	private DataOutputStream out	 = null;



	// constructor to put ip address and port
	public Client(String address, int port) throws Exception
	{
		Scanner scanner = new Scanner(System.in);

		// establish a connection
		
		socket = new Socket(address, port);
		System.out.println("Connected");

			// takes input from terminal
		input = new DataInputStream(System.in);

			// sends output to the socket
		out = new DataOutputStream(socket.getOutputStream());

		// string to read message from input
		String line = "";
        int caseNum = 0;

		// keep reading until "Over" is input
		while (true){

			System.out.println("1 Open mode");
			System.out.println("2 Secure mode");
			System.out.println("3 Quit");
			caseNum = scanner.nextInt();

			if (caseNum == 3) {
				out.writeUTF("Q");
					break;
				}		//no need to take any data from the user, end the app (nested of while checking)

			else{
			System.out.println("Enter Word:");
			out.writeUTF("");			//default, TOBE checked later
			
			line = input.readLine();  

				//No need to consider caseNum == 1 since it's the default
				if(caseNum == 2)
				{	
					line="encyrpted data";		//it will be sent later
					//Encryprion will go here
				}
				else
				System.out.println("Enter number from the menu");

			
			//Send it once
			   	out.writeUTF(line);  
		
			}
		}							

		System.out.println("Closing connection");

		// close the connection

		input.close();
		out.close();
		socket.close();
	
	}

	public static void main(String args[])throws Exception
	{
		Client client = new Client("127.0.0.1", 5000);
	}
}

