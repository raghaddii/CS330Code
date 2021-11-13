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
			in = new DataInputStream(
				new BufferedInputStream(socket.getInputStream()));

			String line = "";

			// reads message from client until "Over" is sent
			while (!line.equals("3"))
			{
				try
				{
					line = in.readUTF();
					if(line.equals("3"))
					break;

					if(line.startsWith("1")){

						line = line.substring(1);
	
					}
					else if(line.startsWith("2")){
						line = line.substring(1);
						//decrytion code goes here
					}
					
                                         System.out.println(line);
										

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
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}

	public static void main(String args[])
	{
		Server server = new Server(500);
	}
}

