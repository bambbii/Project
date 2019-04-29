package sist.com.ui.login;

import java.util.Vector;

public class ChatThread extends Thread{

	private ChatWin chatwin;
	private Vector<String>userList;
	
	public ChatThread(ChatWin chatwin) {
		this.chatwin = chatwin;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
			
			try {
				while(true) {
					
					chatwin.getmEditor().setEditable(false);
					chatwin.getmEditor().setCaretPosition(chatwin.getmEditor().getDocument().getLength());
					
					String temp=(String)chatwin.getOis().readObject();
					System.out.println("Ŭ���̾�Ʈ������ : "+temp);
					if(temp.startsWith("[CONNECT]")) {
						userList=new Vector<String>();
						String []res=temp.substring(temp.indexOf("]")+1).split("#");
						for (int i = 0; i < res.length; i++) {
							if(i==res.length-1) {
								chatwin.getJlbList().setText("������ : "+res[i]+"��");
								break;
							}
							if(chatwin.getUserInfo().getNickname().equals(res[i])) {
								userList.add(res[i]+"(��)");
							}else {
								
								userList.add(res[i]);
							}
						}
						chatwin.insertText("======"+res[res.length-2]+"  ���� �����ϼ̽��ϴ�======\n", chatwin.RED);
						chatwin.getList().setListData(userList);
						
					}else if(temp.startsWith("[DISCONNECT]")){
						userList=new Vector<String>();
						String []res=temp.substring(temp.indexOf("]")+1).split("#");
						for(String a:res) {
							System.out.printf("%5s",a);
						}
						System.out.println();
						for (int i = 0; i < res.length; i++) {
							if(i==res.length-1) {
								chatwin.getJlbList().setText("������ : "+res[i]+"��");
								break;
							}	
							if(i==res.length-2)continue;
							if(chatwin.getUserInfo().getNickname().equals(res[i])) {
								userList.add(res[i]+"(��)");
							}else {
								
								userList.add(res[i]);
							}
							
						}
						chatwin.insertText("======"+res[res.length-2]+"  ���� �����ϼ̽��ϴ�======\n", chatwin.RED);
						chatwin.getList().setListData(userList);
						
						
						
						
						
					} 
					
					
					
					if(temp.startsWith("[MESSAGE]")) {
						String res[]=temp.split("#");//[message]#[���̷�2]#[�Ϲ�]#�޼���~
						String nick=res[1].substring(res[1].indexOf("[")+1,res[1].indexOf("]"));
						if(res[2].equals("[�Ϲ�]")) {
							String message=res[3];
							chatwin.insertText("\n["+nick+"] ���� ��\n  "+message+"\n", chatwin.GRAY);//�г���
						}else if(res[2].equals("[�ӼӸ�]")){//[message]#[���̷�2]#[�ӼӸ�]#[����г���]#�޼���~
														   //[MESSAGE]#[���]#[�ӼӸ�]#[���̷�]#��������
							String secret=res[3].substring(res[3].indexOf("[")+1,res[3].indexOf("]"));
							String message=res[4];
							System.out.println("chatwin.getUserInfo().getNickname().equals(secret) : "+chatwin.getUserInfo().getNickname().equals(secret));
							System.out.println("chatwin.getUserInfo().getNickname().equals(nick) : "+chatwin.getUserInfo().getNickname().equals(nick));
							System.out.println("nick : "+nick);
							System.out.println("chatwin.getUserInfo().getNickname() : "+chatwin.getUserInfo().getNickname());
							if(chatwin.getUserInfo().getNickname().equals(secret)||chatwin.getUserInfo().getNickname().equals(nick)) {
								chatwin.insertText("\n["+nick+"] ���� ��\n  [�ӼӸ�] "+message+"\n", chatwin.GRAY);
							}
						}
					}
					
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		
	}
	

	
	
	
	
}
