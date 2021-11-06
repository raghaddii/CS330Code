// A Java program for a Server
import java.net.*;
import java.io.*;

public class Server
{
	//initialize socket and input stream
	private Socket		 socket = null;
	private ServerSocket server = null;
	private DataInputStream in	 = null;

	// constructor with port
	public Server(int port)throws Exception
	{
		// starts server and waits for a connection
	
			server = new ServerSocket(port);
			System.out.println("Server started");

			System.out.println("Waiting for a client ...");

			socket = server.accept();
			System.out.println("Client accepted");

			// takes input from the client socket
			in = new DataInputStream(
				new BufferedInputStream(socket.getInputStream()));

			String line = "";
			// reads message from client until "Over" is sent
			while (true)
			{
					if (in.readUTF() == "Q") break;			//here and only here breaking the loop before receiving the word
					line = in.readUTF();
					System.out.println(line);
	
			}
			System.out.println("Closing connection");

			// close connection
			socket.close();
			in.close();
		}
		
	

	public static void main(String args[])throws Exception
	{
		Server server = new Server(5000);
	}
}

