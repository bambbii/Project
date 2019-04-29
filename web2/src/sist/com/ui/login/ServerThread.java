package sist.com.ui.login;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;


public class ServerThread extends Thread{
	private ServerChat serverchat;
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public ServerThread(ServerChat serverchat) {
		this.serverchat = serverchat;
	}
	
	public void userListAdd() {
		String temp="";
		for (int i = 0; i < serverchat.getUserList().size(); i++) {
			temp+=serverchat.getUserList().get(i)+"#";
		 }
		temp+=serverchat.getList().size();
		for(ServerThread st:serverchat.getList()) {
			try {
				st.oos.writeObject("[CONNECT]"+temp);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public void userListRemove(String removeUser) {
		String temp="";
		for (int i = 0; i < serverchat.getUserList().size(); i++) {
			temp+=serverchat.getUserList().get(i)+"#";
		 }
		temp=temp+removeUser+"#"+serverchat.getList().size();
		for(ServerThread st:serverchat.getList()) {
			try {
				st.oos.writeObject("[DISCONNECT]"+temp);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	
	public void broadMessage(String message) {
		for(ServerThread st:serverchat.getList()) {
			try {
				st.oos.writeObject(message);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		socket=serverchat.getSocket();

		try {
			//닉네임
			ois=new ObjectInputStream(socket.getInputStream());
			oos=new ObjectOutputStream(socket.getOutputStream());
			while(true) {
				String message=(String)ois.readObject();
				if(message.startsWith("[CONNECT]")) {					
					serverchat.getUserList().add(message.substring(message.indexOf("]")+1));
					userListAdd();
				}else if(message.startsWith("[MESSAGE]")) {
					broadMessage(message);
				}else if(message.startsWith("[DISCONNECT]")) {
					String temp=message.substring(message.indexOf("]")+1);
					serverchat.getUserList().remove(serverchat.getUserList().indexOf(temp));
					userListRemove(temp);
					
				}
				System.out.println("서버스레드 : "+serverchat.getUserList());
				
			}
		} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();

			
		}finally {
			try {
				if(ois!=null)ois.close();
				if(oos!=null)oos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
}
