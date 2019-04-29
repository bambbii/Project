package team.project.reservation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Join extends JFrame implements ActionListener,FocusListener{
	private JPanel jp, jpbuyer, jpseller;
	private JLabel jl;
	private JTextField tfid, tfpass1, tfpass2, tfname, tfphone, tfaddr1, tfaddr2;
	private JButton jbbuyer, jbseller, jbaddr, jbman, jbwoman, jbok, jbback;
	private String gender="여자";//버튼 남녀 구분을 위해 string을 줌
	private boolean flag;
	//private JOptionPane jop;
	
	
	@Override
	public void focusGained(FocusEvent g) {
		// TODO Auto-generated method stub
		if(g.getComponent()==tfid) {///  회원가입 텍스트 필드에 포커스가 가면 필드 값을 공백으로 해줌
			tfid.setText("");
		}
		if(g.getComponent()==tfpass1) {
			tfpass1.setText("");
		}
		if(g.getComponent()==tfpass2) {
			tfpass2.setText("");
		}
		if(g.getComponent()==tfname) {
			tfname.setText("");
		}
		if(g.getComponent()==tfphone) {
			tfphone.setText("");
		}
		if(g.getComponent()==tfaddr2) {
			tfaddr2.setText("");
		}
	}



	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	public JTextField getTfaddr1() {///주소필드 텍스트 기본값을 반환해줌
		return tfaddr1;
	}



	public void setTfaddr1(JTextField tfaddr1) {
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jbback) {///처음으로 버튼을 눌렀을때 화면이 사라지게 해서 첫화면이 나오게해줌
			dispose();
			
		}
		if(e.getSource()==jbaddr) {///주소찾기 버튼을 눌렀을때 새로운 폼이 생성되면서 주소를 찾게 해줌
			new addr(this);
		}
		
	}
	


	public void initLayEx() {
		jp = new JPanel(null);
		jp.setBackground(Color.WHITE);
		jp.setBounds(0, 0, 500, 600);

		jbbuyer = new JButton("구매자");
		jbbuyer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jpbuyer.setVisible(true);
				jbbuyer.setForeground(Color.WHITE);
				jbbuyer.setBackground(new Color(255, 90, 95));
				jbseller.setForeground(new Color(255, 90, 95));
				jbseller.setBackground(Color.WHITE);
				tfaddr1.setVisible(false);
				tfaddr2.setVisible(false);
				jbaddr.setVisible(false);
				tfid.setText("ID");
				tfpass1.setText("PASS");
				tfpass2.setText("PASSCHECK");
				tfname.setText("NAME");
				tfphone.setText("PHONE");
			}
		});
		jbbuyer.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbbuyer.setBorder(null);
		jbbuyer.setForeground(Color.WHITE);
		jbbuyer.setBackground(new Color(255, 90, 95));
		jbbuyer.setBounds(7, 10, 240, 50);
		jbseller = new JButton("판매자");
		jbseller.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				jbbuyer.setForeground(new Color(255, 90, 95));
				jbbuyer.setBackground(Color.WHITE);
				jbseller.setForeground(Color.WHITE);
				jbseller.setBackground(new Color(255, 90, 95));
				tfaddr1.setVisible(true);
				tfaddr2.setVisible(true);
				jbaddr.setVisible(true);
				tfid.setText("ID");
				tfpass1.setText("PASS");
				tfpass2.setText("PASSCHECK");
				tfname.setText("NAME");
				tfphone.setText("PHONE");
				tfaddr2.setText("상세주소");
			
			}
		});
		jbseller.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbseller.setBorder(null);
		jbseller.setForeground(new Color(255, 90, 95));
		jbseller.setBackground(Color.WHITE);
		jbseller.setBounds(247, 10, 240, 50);

		jpbuyer = new JPanel(null);
		jpbuyer.setBounds(7, 57, 480, 500);
		jpbuyer.setBackground(Color.WHITE);
		jpseller = new JPanel(null);
		jpseller.setBounds(7, 57, 480, 500);
		jpseller.setBackground(Color.WHITE);

		jl = new JLabel("에어비앤비에 오신 것을 환영합니다");
		jl.setFont(new Font("나눔고딕", Font.BOLD, 20));
		jl.setHorizontalAlignment(JLabel.CENTER);
		jl.setBounds(7, 20, 470, 50);
		LineBorder lb = new LineBorder(new Color(235, 235, 235));
		
		//아이디 입력 텍스트 필드
		tfid = new JTextField("ID");
		tfid.setBorder(lb);
		tfid.setBounds(7, 70, 470, 50);
		/*tfid.setFont(new Font("나눔고딕",.BOLD, 15));*/
		tfid.addFocusListener(this);
		//비밀번호 입력 텍스트 필드
		tfpass1 = new JTextField("PASS");
		tfpass1.setBorder(lb);
		tfpass1.setBounds(7, 120, 470, 50);
		tfpass1.addActionListener(this);
		tfpass1.addFocusListener(this);
		tfpass2 = new JTextField("PASSCHECK");
		tfpass2.setBorder(lb);
		tfpass2.setBounds(7, 170, 470, 50);
		tfpass2.addActionListener(this);
		tfpass2.addFocusListener(this);
		//이름 입력 텍스트 필드
		tfname = new JTextField("NAME");
		tfname.setBorder(lb);
		tfname.setBounds(7, 220, 470, 50);
		tfname.addFocusListener(this);
		//전화번호 입력 텍스트 필드
		tfphone = new JTextField("PHONE");
		tfphone.setBorder(lb);
		tfphone.setBounds(7, 270, 470, 50);
		tfphone.addFocusListener(this);
		//성별 선택
		//남자 / 여자 따로 구분되어 이벤트 발생
		jbman = new JButton("남자"); //
		jbman.setBorder(lb);
		jbman.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbman.setForeground(new Color(255, 90, 95));
		jbman.setBackground(Color.WHITE);
		jbman.setOpaque(true);
		jbman.setBounds(7, 320, 235, 50);

		jbman.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stubf
				//테스트 코드
				System.out.println(e.getSource());
				//
				jbwoman.setForeground(new Color(255, 90, 95));
				jbwoman.setBackground(Color.WHITE);
				jbwoman.setBorder(lb);
				jbman.setForeground(Color.WHITE);
				jbman.setBackground(new Color(255, 90, 95));
				gender="남자";///남자버튼을 눌렀을때 값을 남자로 지정해줌
			}
		});
		jbwoman = new JButton("여자");
		jbwoman.setBorder(null);
		jbwoman.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbwoman.setForeground(Color.WHITE);
		jbwoman.setBackground(new Color(255, 90, 95));
		jbwoman.setBounds(242, 320, 235, 50);
		jbwoman.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//테스트 코드
				System.out.println(e.getSource());
				//
				// TODO Auto-generated method stub
				jbman.setForeground(new Color(255, 90, 95));
				jbman.setBackground(Color.WHITE);
				jbman.setBorder(lb);
				jbwoman.setForeground(Color.WHITE);
				jbwoman.setBackground(new Color(255, 90, 95));
				gender="여자";///여자버튼을 눌렀을떄 값을 여자로 지정해줌
			}
		});

		tfaddr1 = new JTextField("기본주소");
		tfaddr1.setBorder(lb);
		tfaddr1.setBounds(7, 370, 235, 50);
		tfaddr1.setVisible(false);
		tfaddr1.setEnabled(false);
		tfaddr2 = new JTextField("상세주소");
		tfaddr2.setBorder(lb);
		tfaddr2.setBounds(240, 370, 168, 50);
		tfaddr2.setVisible(false);
		tfaddr2.addFocusListener(this);
		jbaddr = new JButton("주소찾기");
		jbaddr.addActionListener(this);
		jbaddr.setBorder(lb);
		jbaddr.setBounds(407, 370, 70, 50);
		jbaddr.setVisible(false);
		jbaddr.setBorder(lb);
		jbaddr.setFont(new Font("나눔고딕", Font.BOLD, 13));
		jbaddr.setForeground(Color.WHITE);
		jbaddr.setBackground(new Color(255, 90, 95));

		jbback = new JButton("처음으로");
		jbback.addActionListener(this);
		jbback.setBorder(null);
		jbback.setForeground(Color.WHITE);
		jbback.setBackground(new Color(136, 136, 136));
		jbback.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbback.setBounds(107, 450, 125, 50);
		jbok = new JButton("확인");
		jbok.addActionListener(this);
		jbok.setBorder(null);
		jbok.setForeground(Color.WHITE);
		jbok.setBackground(new Color(255, 90, 95));
		jbok.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbok.setBounds(252, 450, 135, 50);
		jbok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if (jbbuyer.getBackground() == Color.white) {///비밀번호를 가 틀렸을떄 다시 비밀번호 필들로 돌아가서 다시적게함
					System.out.println("ttttt");
					if(!(tfpass1.getText().equals(tfpass2.getText()))) {
						JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요");
						tfpass1.setText("");
						tfpass2.setText("");
						tfpass1.requestFocus();
						}else if(!tfid.getText().equals("")) {
							flag=ReservationDao.getInstnace().sellerIdCheck(tfid.getText());
							if(flag==true) {
								JOptionPane.showMessageDialog(null,"이미 사용중인 아이디 입니다.");
								tfid.setText("");
								tfid.requestFocus();
							}else if(flag==false) {
								insertSeller();
								dispose();
							}
						}
				} else if (jbseller.getBackground() == Color.white) {
					//구매자가 회원 가입시 
					//확인 버튼을 누르면 발생되는 이벤트!!!
					System.out.println("hello~");
					if(!(tfpass1.getText().equals(tfpass2.getText()))) {
					JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요");
					tfpass1.setText("");
					tfpass2.setText("");
					tfpass1.requestFocus();
					
					}else if(!tfid.getText().equals("")) {
						flag=ReservationDao.getInstnace().buyerIdCheck(tfid.getText());
						if(flag==true) {
							
							JOptionPane.showMessageDialog(null,"이미 사용중인 아이디 입니다.");
							tfid.setText("");
							tfid.requestFocus();
						}else if(flag==false) { 
							insertBuyer();
							dispose();
						}
						
					}
				
					
				}
			}
		});

		jpbuyer.add(jl);
		jpbuyer.add(tfid);
		jpbuyer.add(tfpass1);
		jpbuyer.add(tfpass2);
		jpbuyer.add(tfname);
		jpbuyer.add(tfphone);
		jpbuyer.add(tfaddr1);
		jpbuyer.add(tfaddr2);
		jpbuyer.add(jbaddr);
		jpbuyer.add(jbman);
		jpbuyer.add(jbwoman);
		jpbuyer.add(jbback);
		jpbuyer.add(jbok);

		jp.add(jbbuyer);
		jp.add(jbseller);
		jp.add(jpbuyer);
		jp.add(jpseller);
		this.add(jp);
	}

	public Join() {
		super("회원가입");
		initLayEx();
		this.setBackground(Color.WHITE);
		this.setResizable(false);
		this.setBounds(250, 100, 500, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Join();
	}
	
	public void  insertBuyer() {///구매자 데이터베이스 정보입력
		joinBean buyerbean=new joinBean();
		buyerbean.setBuyerid(tfid.getText());
		buyerbean.setPassword(tfpass2.getText());
		buyerbean.setName(tfname.getText());
		buyerbean.setTel(tfphone.getText());
		buyerbean.setGender(gender);
		ReservationDao.getInstnace().insertBuyer(buyerbean);/////구매자 데이터 Insert
	}
	public void insertSeller() {///판매자 데이터베이스 정보입력
		JoinBean2 sellerbean=new JoinBean2();
		sellerbean.setBuyerid(tfid.getText());
		sellerbean.setPassword(tfpass2.getText());
		sellerbean.setName(tfname.getText());
		sellerbean.setTel(tfphone.getText());
		sellerbean.setGender(gender);
		sellerbean.setZipcode(tfaddr1.getText()+tfaddr2.getText());
		ReservationDao.getInstnace().insertSeller(sellerbean);/////판매자 데이터 Insert
	}
}