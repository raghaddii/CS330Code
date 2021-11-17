// A Java program for a Server
import java.net.*;
import java.io.*;

public class Server
{
	//initialize socket and input stream
	private Socket		 socket = null;
	private ServerSocket server = null;
	private DataInputStream in	 = null;
	private DataOutputStream out = null;

	// constructor with port
	public Server(int port)
	{
		// starts server and waits for a connection
		try
		{
			server = new ServerSocket(port);
			System.out.println("Server started");

			System.out.println("Waiting for a client ...");

			socket = server.accept();
			System.out.println("Client accepted");

			// takes input from the client socket
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

			// sends output to the socket
			out = new DataOutputStream(socket.getOutputStream());

			String line = "";

			// reads message from client until "3" is sent
			while (true)
			{
				try
				{
					line = in.readUTF();

					if(line.equals("3"))
					break;

					if(line.startsWith("1")){
						line = line.substring(1)+ " arrived";
						
					}

					else {							//Since there's no other choise, go option 2
						line = line.substring(1);
						String d = Bob(line,3);
						System.out.println("Decrypted word:"+d);
						System.out.print("Encrypted word:");
						
					}
					
					
                     System.out.println(line);
					 out.writeUTF(line);							

				}
				catch(IOException i)
				{
					System.out.println(i);
				}
			}
			System.out.println("Closing connection");

			// close connection
			socket.close();
			in.close();
			out.close();
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}
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
		Server server = new Server(500);
	}
	
}

