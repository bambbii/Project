package team.project.reservation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.awt.image.RescaleOp;
import java.util.Calendar;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;

public class Main extends JFrame implements MouseListener {

	private JScrollPane jsp;
	private JPanel jpn, search, searchTable;
	private String[] imageNAME = new String[11];
	private BufferedImage image;
	private BufferedImage copy;

	private JLabel welcome, destination, checkin, checkout, count, join, login, logout, mypage, jl;
	private JLabel backGround,backButton,jlbName;
	private JTextField destinationText, inText, outText, countText;
	private JButton jbsearch, checkinbutton, checkoutbutton,personP,personM;
	private ImageIcon calendar = new ImageIcon("C:\\Users\\sist\\Desktop\\jdbcProject\\c1.png");
	private ImageIcon pButton = new ImageIcon("C:\\Users\\sist\\Desktop\\jdbcProject\\pButton.png");
	private ImageIcon mButton = new ImageIcon("C:\\Users\\sist\\Desktop\\jdbcProject\\mButton.png");
	private ImageIcon icon=new ImageIcon("C:\\Users\\sist\\Desktop\\jdbcProject\\bnb.png");
	private JTable jtable;
	private JtableProcess jtp = new JtableProcess();
	private SearchBean bean=new SearchBean();
	
	
	private int checkInYear,checkInDay,pCount;
	static int checkInMonth;
	
	private CalendarPanel calendarPanel;
	
	private boolean loginCheck=false;
	private String id;
	private String memberState;//구매자 판매자 구분



	public String getMemberState() {
		return memberState;
	}

	public void setMemberState(String memberState) {
		this.memberState = memberState;
	}

	public JLabel getJlbName() {
		return jlbName;
	}

	public void setJlbName(JLabel jlbName) {
		this.jlbName = jlbName;
	}

    

	public boolean isLoginCheck() {
		return loginCheck;
	}

	public void setLoginCheck(boolean loginCheck) {
		this.loginCheck = loginCheck;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public JTextField getInText() {
		return inText;
	}

	public void setInText(JTextField inText) {
		this.inText = inText;
	}

	public JTextField getOutText() {
		return outText;
	}

	public void setOutText(JTextField outText) {
		this.outText = outText;
	}

	public JTextField getCountText() {
		return countText;
	}

	public void setCountText(JTextField countText) {
		this.countText = countText;
	}//내가추가 개터세터
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getComponent() == join) {
			new Join();
		}
		if (e.getComponent() == login) {
			new Login(this);
		
		}
		if (e.getComponent() == mypage) {
			
			// 로그인 시 아이디와 비밀번호를 확인하여 구매자 마이페이지 또는 판매자 마이페이지를 생성
			if(memberState.equals("판매자")) {
				new MypageSeller(id);
			}else if(memberState.equals("구매자")){
				new MypageBuyer(id);
			}else {
				System.out.println("hihi");
			}
		}
		if (e.getComponent() == jbsearch) {
			String d=destinationText.getText();
			String in=inText.getText();
			String out=outText.getText();
			int cnt=Integer.parseInt(countText.getText().substring(0, countText.getText().indexOf("명")));
			
			if(d.length()==0||in.length()==0||out.length()==0||cnt==0) {
				JOptionPane.showMessageDialog(this, "검색 데이터를 입력해주세요");
				clearField();
				return;
			}else if(!loginCheck){
				JOptionPane.showMessageDialog(this, "로그인 해주세요");
				clearField();
				return;
			}
			
			//검색
			bean=new SearchBean(d,in,out,cnt);
			jtable.setModel(ReservationDao.getInstnace().searchData(bean));
			
			search.setVisible(false);
			
			searchTable.setVisible(true);
			backButton.setVisible(true);
			
		}
		if(e.getComponent()==personP) {
			
			pCount++;
			countText.setText(pCount+"명");
		}
		if(e.getComponent()==personM) {
			if(pCount==0) {
				JOptionPane.showMessageDialog(this, "인원을 입력해주세요");
				return;
			}
			pCount--;
			countText.setText(pCount+"명");
		}
		if(e.getComponent()==jtable&&e.getClickCount()==2) {
			
			int row = Integer.parseInt((String) jtable.getValueAt(jtable.getSelectedRow(), 0));
			
			new RoomInfo(this,row);
			
		}
		if(e.getComponent()==logout) {
			loginCheck=false;
			id="";
			bean.setAddr("");
			bean.setCheckIn("");
			bean.setCheckOut("");
			bean.setCount(0);
			initmypageLogout();
			jlbName.setText("");
			jlbName.setVisible(false);
		}
	}

	public void initmypage() {
		join.setVisible(false);
		login.setVisible(false);
		logout.setVisible(true);
		mypage.setVisible(true);
	}
	public void initmypageLogout() {
		join.setVisible(true);
		login.setVisible(true);
		logout.setVisible(false);
		mypage.setVisible(false);
		clearField();
	}
	public void clearField() {
		destinationText.setText("");
		inText.setText("");
		outText.setText("");
		countText.setText("0명");
		pCount=0;
	}
	
	private void showCalendarDialog1(ActionEvent e) {//Checkin 달력
		JDialog dialog = new JDialog();
		Calendar calendar = Calendar.getInstance();
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH);
		calendarPanel = new CalendarPanel(y, m, ev -> dialog.setVisible(false));
		
		calendarPanel.setBorder(new LineBorder(Color.BLACK));
		
		dialog.add(calendarPanel);
		dialog.setUndecorated(true);
		dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		//dialog.setBounds(getX() + 88 + 20, getY() + 85 + 25, 200, 200);
		dialog.setBounds(138,395,200,200);
		dialog.setModal(true);
		dialog.setVisible(true);
		inText.setText(calendarPanel.getSelectedDate());
		checkInDay=calendarPanel.checkInday();
		checkInMonth=calendarPanel.checkInMonth();
		checkInYear=calendarPanel.checkInYear();
	}
	private void showCalendarDialog2(ActionEvent e) {//checkout 달력
		JDialog dialog = new JDialog();
		Calendar calendar = Calendar.getInstance();
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH);
		calendarPanel = new CalendarPanel(checkInYear,checkInMonth,checkInDay, ev -> dialog.setVisible(false));
		
		calendarPanel.setBorder(new LineBorder(Color.BLACK));
		
		dialog.add(calendarPanel);
		dialog.setUndecorated(true);
		dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		//dialog.setBounds(getX() + 88 + 20, getY() + 85 + 25, 200, 200);
		dialog.setBounds(320,395,200,200);
		dialog.setModal(true);
		dialog.setVisible(true);
		outText.setText(calendarPanel.getSelectedDate());
	}

	public void initLayEx() {
		jpn = new JPanel(null);

		search = new JPanel(null); // 검색창 Panel
		search.setBackground(Color.WHITE);
		welcome = new JLabel("<html><body>특색 있는 숙소와 트립을<br>예약해보세요</body></html>");
		welcome.setFont(new Font("나눔고딕", Font.BOLD, 25));
		welcome.setBounds(20, 20, 370, 55);
		search.add(welcome);
		destination = new JLabel("목적지");
		destination.setFont(new Font("나눔고딕", Font.BOLD, 15));
		destination.setBounds(20, 100, 100, 20);
		search.add(destination);
		destinationText = new JTextField();
		destinationText.setFont(new Font("나눔고딕", Font.BOLD, 25));
		destinationText.setBounds(20, 125, 365, 40);
		search.add(destinationText);

		checkin = new JLabel("체크인");
		checkin.setFont(new Font("나눔고딕", Font.BOLD, 15));
		checkin.setBounds(20, 170, 170, 40);
		search.add(checkin);
		checkout = new JLabel("체크아웃");
		checkout.setFont(new Font("나눔고딕", Font.BOLD, 15));
		checkout.setBounds(200, 170, 170, 40);
		search.add(checkout);
		inText = new JTextField();
		inText.setFont(new Font("나눔고딕", Font.BOLD, 15));
		inText.setBounds(20, 210, 140, 40);
		inText.setEnabled(false);
		search.add(inText);
		checkinbutton = new JButton(calendar);
		checkinbutton.addActionListener(this::showCalendarDialog1);
		checkinbutton.setBackground(Color.WHITE);
		checkinbutton.setBorder(null);
		checkinbutton.setBounds(160, 210, 40, 40);
		search.add(checkinbutton);
		outText = new JTextField();
		outText.setFont(new Font("나눔고딕", Font.BOLD, 15));
		outText.setBounds(205, 210, 140, 40);
		outText.setEnabled(false);
		search.add(outText);
		checkoutbutton = new JButton(calendar);
		checkoutbutton.setBackground(Color.WHITE);
		checkoutbutton.setBorder(null);
		checkoutbutton.setBounds(345, 210, 40, 40);
		checkoutbutton.addActionListener(this::showCalendarDialog2);
		search.add(checkoutbutton);
		count = new JLabel("인원");
		count.setFont(new Font("나눔고딕", Font.BOLD, 15));
		count.setBounds(20, 260, 170, 40);
		search.add(count);
		personM=new JButton(mButton);
		personM.setBounds(20, 300, 42, 40);
		personM.setBorder(null);
		personM.addMouseListener(this);
		countText = new JTextField(10);
		countText.setFont(new Font("나눔고딕", Font.BOLD, 15));
		countText.setBounds(65, 300, 280, 40);
		countText.setEditable(false);
		countText.setText("0명");
		countText.setForeground(Color.gray);
		personP=new JButton(pButton);
		personP.setBounds(345, 300, 42, 40);
		personP.setBorder(null);
		personP.addMouseListener(this);
		search.add(personP);
		search.add(personM);
		search.add(countText);
		jbsearch = new JButton("검색");
		jbsearch.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbsearch.setForeground(Color.WHITE);
		jbsearch.setBackground(new Color(255, 90, 95));
		jbsearch.setBounds(300, 360, 80, 50);
		jbsearch.setBorder(null);
		jbsearch.addMouseListener(this);
		search.add(jbsearch);

		login = new JLabel("로그인");
		login.addMouseListener(this);
		login.setForeground(Color.WHITE);
		login.setOpaque(false);
		login.setBounds(730, 20, 80, 50);
		login.setFont(new Font("나눔고딕", Font.BOLD, 20));
		jpn.add(login);
		join = new JLabel("회원가입");
		join.addMouseListener(this);
		join.setForeground(Color.WHITE);
		join.setOpaque(false);
		join.setBounds(820, 20, 80, 50);
		join.setFont(new Font("나눔고딕", Font.BOLD, 20));
		jpn.add(join);
		logout = new JLabel("로그아웃");
		logout.addMouseListener(this);
		logout.setForeground(Color.WHITE);
		logout.setOpaque(false);
		logout.setBounds(730, 20, 80, 50);
		logout.setFont(new Font("나눔고딕", Font.BOLD, 20));
		logout.setVisible(false);
		jpn.add(logout);
		mypage = new JLabel("마이페이지");
		mypage.addMouseListener(this);
		mypage.setForeground(Color.WHITE);
		mypage.setOpaque(false);
		mypage.setBounds(820, 20, 100, 50);
		mypage.setFont(new Font("나눔고딕", Font.BOLD, 20));
		mypage.setVisible(false);
		backButton=new JLabel("Back");
		backButton.addMouseListener(this);
		backButton.setForeground(Color.WHITE);
		backButton.setOpaque(false);
		backButton.setBounds(35,10,50,50);
		backButton.setFont(new Font("나눔고딕", Font.BOLD, 20));
		backButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				search.setVisible(true);
				searchTable.setVisible(false);
				backButton.setVisible(false);
				clearField();
			}
			
			
		});
		backButton.setVisible(false);
		jpn.add(backButton);
		
		jlbName=new JLabel(" 님, 환영합니다.",SwingConstants.RIGHT);
		jlbName.setOpaque(false);
		jlbName.setFont(new Font("나눔고딕", Font.BOLD, 19));
		jlbName.setBounds(320, 30, 600, 100);
		jlbName.setForeground(Color.WHITE);
		jlbName.setVisible(false);
		
		jpn.add(jlbName);
		
		jpn.add(mypage);

		search.setBounds(100, 100, 400, 430);
		jpn.add(search);
		search.setVisible(true);

		// ============Table==========
		searchTable = new JPanel(null);
		searchTable.setBounds(100, 100, 730, 430);
		searchTable.setBackground(Color.white);
		searchTable.add(jsp = new JScrollPane(jtable = new JTable()));
		jtable.addMouseListener(this);
		jpn.add(searchTable);
		jsp.setBounds(0, 0, 733, 670);
		
		searchTable.setVisible(false);

		for (int i = 0; i < imageNAME.length; i++) {//////////////////////////////////////////////////////////////
			imageNAME[i] = "C:\\Users\\Force\\eclipse-workspace-jdbc\\team.project.reservation\\backPic\\" + i + ".jpg";
		}
		PlanarImage pi = JAI.create("fileload", imageNAME[0]);
		image = pi.getAsBufferedImage();
		copy = pi.getAsBufferedImage();
		backGround = new JLabel(new ImageIcon(copy));
		backGround.setBounds(1, 1, 965, 670);

		new Thread(new Runnable() {
			float value = (float) 50.0;
			float scaleFactor = (float) 1.0;
			int checkBit = 0;
			int imagebit=0;

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(5000);
					while (true) {
						while ((scaleFactor > 0.15&&checkBit==0)||(scaleFactor < 1.0&&checkBit==1)) {
								Thread.sleep(50);
								scaleFactor = 2 * value / 100;
								RescaleOp op = new RescaleOp(scaleFactor, 0, null);
								copy = op.filter(image, copy);
								repaint();
								value=checkBit==0?value-1:value+1;
						}
						checkBit=checkBit==0?1:0;
						if(checkBit==0) {
							Thread.sleep(6000);
							}
						if(checkBit==1) {
							imagebit=imagebit==imageNAME.length-1?0:imagebit;
							PlanarImage pi=JAI.create("fileload", imageNAME[++imagebit]);
							image=pi.getAsBufferedImage();
							copy = pi.getAsBufferedImage();
							RescaleOp op = new RescaleOp(scaleFactor-1, 0, null);
							copy = op.filter(image, copy);
							backGround.setIcon(new ImageIcon(copy));
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}).start();//////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		jpn.add(backGround);
		jsp = new JScrollPane(jpn);
		jsp.setBounds(0, 0, 965, 670);
		this.add(jsp);
	}

	public Main() {
		super("리듬비앤비");
		this.setIconImage(icon.getImage());
		initLayEx();
		this.setResizable(true);
		this.setVisible(true);
		this.setBounds(10, 10, 965, 670);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new Main();
	}
}