import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientMain {
	private static final int PORT = 12345;
	public static void main(String[] args) throws ClassNotFoundException {
		Socket socket = null;
		ObjectOutputStream outputStream= null;
		ObjectInputStream inputStream= null;
		
		ArrayList<Integer> clientList = new ArrayList<>();
		Scanner Scan1 = new Scanner(System.in);
		String stringInteger = "";
		boolean x = true;
		
		while (x == true) {
		
			System.out.println("Enter an integer(" + (char)34 + "!" + (char)34 + " to send):");
			stringInteger = Scan1.next();
			if(stringInteger.equals("!")) {
				x = false;
			}
			else {
				int integer = Integer.parseInt(stringInteger);
				clientList.add(integer);
			}
			
			
			
			
		}
		Scan1.close();
		
		try {
			
			InetAddress address = InetAddress.getLocalHost();
			
			socket = new Socket(address,PORT);
			
			
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.flush();
			
			
			System.out.println("Send: " + clientList);
			outputStream.writeObject(clientList);
			outputStream.flush();
			
			inputStream = new ObjectInputStream(socket.getInputStream());
			ArrayList<Integer> clientInputList = (ArrayList<Integer>)inputStream.readObject();
			System.out.println("Received: " + clientInputList);
			
			
		
		} catch (IOException ex){
			
			ex.printStackTrace();
		}finally {
			
			try {
				if (socket != null) {
					socket.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		}
	
	
		

	}


