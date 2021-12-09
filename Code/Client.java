
//CS330 Sec.374
//Team Members:
// Areej Turky Alotaibi	  440023303
// Raghad Adel Alshabana  440021235
// Shoroog Saad Alarifi	  440022128
// Shoug Ali Alsuhaibani  440022732


// A Java program for a Client
import java.net.*;
import java.io.*;


public class Client{

	// initialize socket and input output streams
	private Socket         socket = null;
	private DataInputStream input = null;
	private DataInputStream    in = null;
	private DataOutputStream  out = null;



	// constructor to put ip address and port
	public Client(String address, int port)
	{

		// establish a connection
		try
		{
			socket = new Socket(address, port);
			System.out.println("Connected");

			// takes input from terminal
			input = new DataInputStream(System.in);

			// sends output to the socket
			out = new DataOutputStream(socket.getOutputStream());
			
			// takes input from the server socket
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

		}
		catch(UnknownHostException u)
		{
			System.out.println(u);
		}
		catch(IOException i)
		{
			System.out.println(i);
		}

		// string to read message from input
		String line = "";
		char mode   = '0'; 

		// keep reading/writing until "3" is input

		while (true){

			System.out.println("1 Open mode");
		    System.out.println("2 Secure mode");
		    System.out.println("3 Quit");

			try
            {
                line = input.readLine();
				mode = line.charAt(0);
				out.writeUTF(line);	                 //writing to Server

				if(line.equals("3"))
				break;

				System.out.println("Client Received: ");

				line = in.readUTF();                     // reading from Server

				if (mode == '2'){
					String Decrypted = Bob(line,3);  // decrypting the received word
					System.out.println("Encrypted word:" + line);
					System.out.print("Decrypted word:");
					line = Decrypted;  
				}
				
				System.out.println(line);
				System.out.println();	
				
			}
            catch(IOException i)
            {
                System.out.println(i);
            }
		}

		System.out.println("Closing connection");

		// close the connection
		try
		{
			input.close();
			in.close();
			out.close();
			socket.close();
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
			
				
	}
	// Decryption Function 
	public static String Bob(String word , int key)
	{
		char[] chars=word.toCharArray();

		for(int i=0 ; i< chars.length ; i++)
		{
			chars[i] -=key;
		}

		return String.valueOf(chars);
	}

	public static void main(String args[])
	{
		Client client = new Client("127.0.0.1", 500);
	}
}

