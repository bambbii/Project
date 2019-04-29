package sist.com.ui.login;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

public class ServerChat {
	private Socket socket;
	private ServerSocket serverSocket;
	private static final int PORT=5000;
	private ArrayList<ServerThread>list=new ArrayList<>();
	private Vector<String> userList=new Vector<String>();
	
	public Socket getSocket() {
		return socket;
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	public Vector<String> getUserList() {
		return userList;
	}
	
	public void setUserList(Vector<String> userList) {
		this.userList = userList;
	}
	public ArrayList<ServerThread> getList() {
		return list;
	}

	public void setList(ArrayList<ServerThread> list) {
		this.list = list;
	}

	
	public ServerChat() {
		System.out.println("Server is Ready");
		try {
			serverSocket=new ServerSocket(PORT);
			while(true) {
				socket=serverSocket.accept();
				
				//서버쓰레드
				ServerThread st=new ServerThread(this);
				list.add(st);				
				st.start();
				
				System.out.println("서버 : "+socket.getInetAddress().getHostName() + ":"+ socket.getInetAddress().getHostAddress());
			}

				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public static void main(String[] args) {
		new ServerChat();
	}


}
