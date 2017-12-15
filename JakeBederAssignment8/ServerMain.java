import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMain {
	private static final int PORT = 12345;
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		ObjectOutputStream outputStream = null;
		ObjectInputStream inputStream = null;	
			
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server socket has been created");
			socket = serverSocket.accept();
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.flush();
			
			inputStream = new ObjectInputStream(socket.getInputStream());
			ArrayList<Integer> servList = (ArrayList<Integer>)inputStream.readObject();
			System.out.println("Server recieved: " + servList);
			
			ArrayList<Integer> finalServList = new ArrayList<Integer>();
			finalServList = primeChecker(servList);
			
			
			outputStream.writeObject(finalServList);
			outputStream.flush();
			
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}
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
		System.out.println("Server Done! Please Check the Client Console!");
		}
	
	public static ArrayList<Integer> primeChecker (ArrayList<Integer> ArrList){
		ArrayList<Integer> ArrListCopy = new ArrayList<Integer>();
		ArrayList<Integer> FinalArrList = new ArrayList<Integer>();
		for(int i = 0; i < ArrList.size(); i++) {
			ArrListCopy.add(ArrList.get(i));
		}
		for(int x = 0; x < ArrListCopy.size(); x++) {
			if(isPrime(ArrListCopy.get(x)) == true) {
				FinalArrList.add(ArrListCopy.get(x));
			}
		}
		return FinalArrList;
	}
	//The method isPrime is inspired by Mkyong.com "How to determine a prime number in Java"
	//https://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
	public static boolean isPrime (int x) {
		if (x==1) return false;
		if (x==2) return true;
		if (x%2 == 0) return false;
			for (int i = 3;i * i<=x;i +=2) {
				if(x%i ==0) {
					return false;
				}
		}
	
		return true;
	}
	
	}


