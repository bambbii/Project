package sist.com.ui.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ChatWin extends JFrame implements ActionListener{
	private JPanel back,jpnL,jpnR,jpn2,jpn3,jpn4;
	private ImageIcon upImg=new ImageIcon("C:\\Users\\sist\\Desktop\\backup\\Desktop\\chat_nick.png");
	private JLabel nickL,jlbList;
	private String nick="우리";
	private TextField jtf;
	private JTextArea jta;
	private JScrollPane jsp;
	private JButton send;
	private JComboBox<String> jcb;
	private String[] jcombo= {"일반","귓속말"};
	private JList list;
	private JTextPane mEditor = new JTextPane();
	static SimpleAttributeSet GRAY = new SimpleAttributeSet();
	static SimpleAttributeSet ORANGE = new SimpleAttributeSet();
	static SimpleAttributeSet RED = new SimpleAttributeSet();
	//String id, String pw, String name, String nickname, String email
	private UserData userInfo=new UserData();
	private static UserData userInfo2=new UserData("saehe12","qwerty123","밤비","bambbii@nate.com");
	private Vector userList=new Vector<>();
	private Socket socket;
	private int PORT=5000;
	private ObjectOutputStream oos;	
	private ObjectInputStream ois;
	private ArrayList<ChatThread>thList=new ArrayList<ChatThread>();
	private String secret="";
	
	public JLabel getJlbList() {
		return jlbList;
	}

	public void setJlbList(JLabel jlbList) {
		this.jlbList = jlbList;
	}

	public JComboBox<String> getJcb() {
		return jcb;
	}

	public void setJcb(JComboBox<String> jcb) {
		this.jcb = jcb;
	}

	public String[] getJcombo() {
		return jcombo;
	}

	public void setJcombo(String[] jcombo) {
		this.jcombo = jcombo;
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public UserData getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserData userInfo) {
		this.userInfo = userInfo;
	}

	public Vector getUserList() {
		return userList;
	}

	public void setUserList(Vector userList) {
		this.userList = userList;
	}

	public Socket getSocket() {
		return socket;
	}

	public ObjectInputStream getOis() {
		return ois;
	}
	
	public JScrollPane getJsp() {
		return jsp;
	}

	public void setJsp(JScrollPane jsp) {
		this.jsp = jsp;
	}

	public JTextPane getmEditor() {
		return mEditor;
	}

	public void setmEditor(JTextPane mEditor) {
		this.mEditor = mEditor;
	}


	static {	
		StyleConstants.setForeground(ORANGE, Color.ORANGE);
		StyleConstants.setForeground(GRAY, Color.GRAY);
		StyleConstants.setForeground(RED, new Color(239,41,62));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==send) {
			if(jcb.getSelectedItem().equals("귓속말")) {
				if(secret.equals(""))JOptionPane.showMessageDialog(this, "귓속말 하실 상대를 선택해주세요");
				try {
					oos.writeObject("[MESSAGE]#["+userInfo.getNickname()+"]#["+jcb.getSelectedItem()+"]#["+secret+"]#"+jtf.getText());
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}else {
				
				try {
					oos.writeObject("[MESSAGE]#["+userInfo.getNickname()+"]#["+jcb.getSelectedItem()+"]#"+jtf.getText());
				} catch (Exception e2) {
					// TODO: handle exception
				}		
				
				
			}
		}else{
			if(jcb.getSelectedItem().equals("귓속말")) {
				if(secret.equals(""))JOptionPane.showMessageDialog(this, "귓속말 하실 상대를 선택해주세요");
				try {
					oos.writeObject("[MESSAGE]#["+userInfo.getNickname()+"]#["+jcb.getSelectedItem()+"]#["+secret+"]#"+jtf.getText());
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}else {
				
				try {
					oos.writeObject("[MESSAGE]#["+userInfo.getNickname()+"]#["+jcb.getSelectedItem()+"]#"+jtf.getText());
				} catch (Exception e2) {
					// TODO: handle exception
				}		
				
				
			}
		}
		jtf.setText("");
	}
		
	
	public void initLayEx() {
		back=new JPanel();
		back.setBackground(new Color(172,218,128));
				
		jpnL=new JPanel(){
			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				g.drawImage(upImg.getImage(), 0, 0,350,62,null);
			}
			
		};//대화창
		jpn2=new JPanel() ;
		jpn2.add(nickL=new JLabel(nick+" 님과의 대화"));
		nickL.setFont(new Font("고딕", Font.BOLD, 11));
		jpn2.setBackground(Color.yellow);
		jpn2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		jpn3=new JPanel();
		jpn3.add(jsp=new JScrollPane(mEditor,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		mEditor.setPreferredSize(new Dimension(326, 400));
		
		jpn4=new JPanel();
		jpn4.add(jcb=new JComboBox<String>(jcombo));
		jcb.setFont(new Font("나눔고딕", Font.PLAIN, 9));
		jpn4.add(jtf=new TextField(22));
		jtf.addActionListener(this);
		jpn4.add(send=new JButton("send"));
		send.setFont(new Font("나눔고딕", Font.PLAIN, 9));
		send.addActionListener(this);
		
		jpnL.add("North",jpn2);
		jpnL.add("Center",jpn3);
		jpnL.add("South",jpn4);
	
		
		jpnR=new JPanel();//사용자 리스트
		jpnR=new JPanel(new BorderLayout());
		jpnR.setBorder(BorderFactory.createEmptyBorder(35,5,5,5));
		jpnR.add("North",jlbList=new JLabel("참가자 : 1명"));
		jlbList.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		jlbList.setFont(new Font("고딕", Font.BOLD, 11));
		jpnR.add("Center",list=new JList());
		list.setBorder(BorderFactory.createLineBorder(new Color(122,138,153), 1));
		list.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				secret=(String)list.getSelectedValue();
				System.out.println(secret);
			}
			
		});
		jpnR.setBackground(new Color(233,246,203));
		
		back.add("Center",jpnL);
		back.add("East",jpnR);
		back.setLayout(null);
		jpnL.setOpaque(false);
		jpn2.setOpaque(false);
		jpn3.setOpaque(false);
		jpn4.setOpaque(false);
		jpnL.setBounds(-9,0,360,550);
		jpn2.setBounds(0,0,360,62);
		jpn3.setBounds(0,0,345,300);
		jpnR.setBounds(342, 0,153,510);
		
		this.add(back);
	}
	protected void insertText(String text, AttributeSet set) {
		try {
			mEditor.getDocument().insertString( mEditor.getDocument().getLength(), text, set ); 
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	public ChatWin() {
		this(userInfo2);
	}

	public ChatWin(UserData userInfo) {
		super("세이클럽 채팅창");
		initLayEx();
		this.userInfo=userInfo;
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
				try {
					oos.writeObject("[DISCONNECT]"+userInfo.getNickname());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				System.exit(0);
				
			}
			
			
		});
		
		this.setBounds(100,100,508,550);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mEditor.setEditable(false);
		insertText("대화 중에 세이클럽 비밀번호를 절대로 알려주지 마세요\n",ORANGE);
		jtf.requestFocus();
		
		try {
			socket=new Socket("localhost", PORT);
			oos=new ObjectOutputStream(socket.getOutputStream());
			ois=new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject("[CONNECT]"+userInfo.getNickname());
			ChatThread ct=new ChatThread(this);
			thList.add(ct);
			ct.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		new ChatWin();
	}

}
