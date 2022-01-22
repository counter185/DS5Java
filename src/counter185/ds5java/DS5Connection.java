package counter185.ds5java;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class DS5Connection {
	
	public DatagramSocket dgramSock;
	public int port = -1;
	public InetAddress addr;
	
	public boolean connected = false;
	
	public boolean Connect() {
		
		File portFile = new File("C:\\Temp\\DualSenseX\\DualSenseX_PortNumber.txt");
		
		try {
			Scanner portScanner = new Scanner(portFile);
			if (portScanner.hasNextInt()) {
				port = portScanner.nextInt();
				portScanner.close();
			} else {
				portScanner.close();
				return false;
			}
			
		} catch (FileNotFoundException e1) {
			return false;
		}
		
		try {
			addr = InetAddress.getByName("localhost");
			dgramSock = new DatagramSocket();
			
		} catch (UnknownHostException e) {
			return false;
		} catch (SocketException e) {
			return false;
		}
		
		connected = true;
		return true;
	}
	
	public void Disconnect() {
		dgramSock.close();
		connected = false;
	}
	
	public boolean Send(DS5Packet e) {
		if (!connected) {
			return false;
		}
		
		/*if (dgramSock.isClosed() || !dgramSock.isConnected()) {
			System.out.println("Socket closed or not connected");
			connected = false;
			return false;
		}*/
		
		byte[] data = e.buildJSON().getBytes(Charset.forName("ASCII"));
		DatagramPacket toSend = new DatagramPacket(data, data.length, addr, port);
		try {
			dgramSock.send(toSend);
		} catch (IOException e1) {
			return false;
		}
		return true;
	}
}
