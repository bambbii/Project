package team.project.reservation;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/* DB_Table : MemberInfoSeller
 * 판매자 정보
 * - 집과 판매자를 식별하기 위한 houseno <number> _ 시퀀스 번호
 * - 판매자 아이디 : sellerid <String>
 * - 판매자 비밀번호 : password <String>
 * - 판매자 이름 : name <String>
 * - 판매자 주소 : Addr <String>
 * - 판매자 성별 : tel <String>
 * - 승인 버튼 : visstate <String>
 * - 구매자 아이디 : buyerid <String>
 */

/* DB_Table : roominfomation
 * 집 상세정보
 * - 집과 판매자를 식별하기 위한 houseno <number> _ 외래키
 * - 예약시 인원 : peoplecount <number>
 * - 예약 방수 : roomcount <number>
 * - 침대 갯수 : bedcount <number>
 * - 상세설명 : detailinfo <String>
 * - 제목 : title <String>
 */
public class MypageSeller extends JFrame implements ActionListener{
	private JPanel jpmain, jpinfo, jproominfo, jpreserv, jpreservBtn,jpanmw;
	private JPanel[] jpsun = new JPanel[6];
	private JPanel[] jpsun2 = new JPanel[7];
	private JButton tab1, tab2, tab3;
	private ImageIcon imgicon = new ImageIcon("LOGO.png");
	private ImageIcon btimage = new ImageIcon("btimage.png");
	private ImageIcon btimage2 = new ImageIcon("btimage2.PNG");
	private ImageIcon btimage3 = new ImageIcon("btimage3.PNG");
	private ImageIcon btimage4 = new ImageIcon("btimage4.PNG");
	private JLabel jlicon, jltitle, roominfosubject, jlbroomPeopleCount, jlbroomCount, jlbedcount, jldetailinfo,
			jlreservation, jlsellerid, jlsellerpass, jlname, jlAddr, jltel, jlgender, jlMyinfo, jlsearch, jlpcount,
			jlrcount, jlbcount, jlprice;
	private JTextField jtftitle, jtfsellerid, jtfname, jtfAddr,jtfaddr2, jtftel, jtfprice;
	private JTextArea jta;
	private JButton roominfoModify, roominfoCheck, jbinfomod, jbinfocomplete, jbman, jbwoman, jbpp, jbpm, jbrp, jbrm,
			jbbp, jbbm, jbsearchtrue, jbsearchfalse, jbpassmodify , jbaddr;
	private JScrollPane jsp;
	private JTable jTableReserve;
	private LineBorder lb = new LineBorder(new Color(235, 235, 235));
	private int pcount, rcount, bcount;
	private String sgender;
	private String vstate;
	// 판매자에 대한 id를 넘겨주는 것!!!
	private String id = "";
	private String passwordChange="";
	private int butbit=0;

	
	
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public JLabel getJlpcount() {
		return jlpcount;
	}

	public void setJlpcount(JLabel jlpcount) {
		this.jlpcount = jlpcount;
	}

	public JLabel getJlrcount() {
		return jlrcount;
	}

	public void setJlrcount(JLabel jlrcount) {
		this.jlrcount = jlrcount;
	}

	public JLabel getJlbcount() {
		return jlbcount;
	}

	public void setJlbcount(JLabel jlbcount) {
		this.jlbcount = jlbcount;
	}

	public JTextField getJtfprice() {
		return jtfprice;
	}

	public void setJtfprice(JTextField jtfprice) {
		this.jtfprice = jtfprice;
	}

	public JTextField getJtfaddr2() {
		return jtfaddr2;
	}

	public void setJtfaddr2(JTextField jtfaddr2) {
		this.jtfaddr2 = jtfaddr2;
	}

	public String getPasswordChange() {
		return passwordChange;
	}

	public void setPasswordChange(String passwordChange) {
		this.passwordChange = passwordChange;
	}

	public String getVstate() {
		return vstate;
	}

	public void setVstate(String vstate) {
		this.vstate = vstate;
	}

	public int getPcount() {
		return pcount;
	}

	public void setPcount(int pcount) {
		this.pcount = pcount;
	}

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public JTextField getJtftitle() {
		return jtftitle;
	}

	public void setJtftitle(JTextField jtftitle) {
		this.jtftitle = jtftitle;
	}

	public JTextArea getJta() {
		return jta;
	}

	public void setJta(JTextArea jta) {
		this.jta = jta;
	}

	public String getSgender() {
		return sgender;
	}

	public void setSgender(String sgender) {
		this.sgender = sgender;
	}

	public JTextField getJtfsellerid() {
		return jtfsellerid;
	}

	public void setJtfsellerid(JTextField jtfsellerid) {
		this.jtfsellerid = jtfsellerid;
	}

	public JTextField getJtfname() {
		return jtfname;
	}

	public void setJtfname(JTextField jtfname) {
		this.jtfname = jtfname;
	}

	public JTextField getJtfAddr() {
		return jtfAddr;
	}

	public void setJtfAddr(JTextField jtfAddr) {
		this.jtfAddr = jtfAddr;
	}

	public JTextField getJtftel() {
		return jtftel;
	}

	public void setJtftel(JTextField jtftel) {
		this.jtftel = jtftel;
	}

	public JTable getjTableReserve() {
		return jTableReserve;
	}

	public void setjTableReserve(JTable jTableReserve) {
		this.jTableReserve = jTableReserve;
	}

	public void myinfo() {// 내 정보 페이지(tab1)
		int y = 0;
		for (int i = 0; i < jpsun.length; i++) {
			jpsun[i] = new JPanel(null);
			jpsun[i].setBackground(new Color(235, 235, 235));
			jpsun[i].setBounds(10, 170 + y, 400, 2);
			jpinfo.add(jpsun[i]);
			y = y + 100;
		}
		jlMyinfo = new JLabel("판매자 상세 정보");
		jlMyinfo.setForeground(new Color(156, 156, 156));
		jlMyinfo.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jlMyinfo.setBounds(150, 20, 200, 30);
		jpinfo.add(jlMyinfo);

		jlsellerid = new JLabel("아이디");
		jlsellerid.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jlsellerid.setForeground(new Color(101, 101, 101));
		jlsellerid.setBounds(20, 90, 100, 25);
		jpinfo.add(jlsellerid);

		jtfsellerid = new JTextField();
		jtfsellerid.setEditable(false);
		jtfsellerid.setBorder(lb);
		jtfsellerid.setFont(new Font("나눔고딕", Font.BOLD, 20));
		jtfsellerid.setForeground(new Color(101, 101, 101));
		jtfsellerid.setBounds(20, 120, 200, 40);
		jpinfo.add(jtfsellerid);

		jlsellerpass = new JLabel("비밀번호");
		jlsellerpass.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jlsellerpass.setForeground(new Color(101, 101, 101));
		jlsellerpass.setBounds(20, 190, 100, 25);
		jpinfo.add(jlsellerpass);

		jbpassmodify = new JButton("비밀번호 수정");
		jbpassmodify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SellerPassModify(id,passwordChange);
			}
		});
		jbpassmodify.setBorder(null);
		jbpassmodify.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbpassmodify.setForeground(Color.WHITE);
		jbpassmodify.setBackground(new Color(255, 90, 95));
		jbpassmodify.setBounds(20, 220, 200, 40);
		jpinfo.add(jbpassmodify);

		jlname = new JLabel("이름");
		jlname.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jlname.setForeground(new Color(101, 101, 101));
		jlname.setBounds(20, 290, 100, 25);
		jpinfo.add(jlname);

		jtfname = new JTextField();
		jtfname.setEditable(false);
		jtfname.setBorder(lb);
		jtfname.setFont(new Font("나눔고딕", Font.BOLD, 20));
		jtfname.setForeground(new Color(101, 101, 101));
		jtfname.setBounds(20, 320, 200, 40);
		jpinfo.add(jtfname);

		jltel = new JLabel("전화번호");
		jltel.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jltel.setForeground(new Color(101, 101, 101));
		jltel.setBounds(20, 390, 100, 25);
		jpinfo.add(jltel);

		jtftel = new JTextField();
		jtftel.setEditable(false);
		jtftel.setBorder(lb);
		jtftel.setFont(new Font("나눔고딕", Font.BOLD, 20));
		jtftel.setForeground(new Color(101, 101, 101));
		jtftel.setBounds(20, 420, 200, 40);
		jpinfo.add(jtftel);

		jlgender = new JLabel("성별");
		jlgender.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jlgender.setForeground(new Color(101, 101, 101));
		jlgender.setBounds(20, 490, 100, 25);
		jpinfo.add(jlgender);

		jbman = new JButton("남자");
		jbman.setEnabled(false);
		jbman.setBorder(lb);
		jbman.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbman.setForeground(new Color(255, 90, 95));
		jbman.setBackground(Color.WHITE);
		jbman.setOpaque(true);
		jbman.setBounds(20, 520, 190, 40);
		jbman.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jbwoman.setForeground(new Color(255, 90, 95));
				jbwoman.setBackground(Color.WHITE);
				jbwoman.setBorder(lb);
				jbman.setForeground(Color.WHITE);
				jbman.setBackground(new Color(255, 90, 95));
				sgender="남";
			}
		});
		jbwoman = new JButton("여자");
		jbwoman.setEnabled(false);
		jbwoman.setBorder(null);
		jbwoman.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbwoman.setForeground(Color.WHITE);
		jbwoman.setBackground(new Color(255, 90, 95));
		jbwoman.setBounds(210, 520, 190, 40);
		jbwoman.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jbman.setForeground(new Color(255, 90, 95));
				jbman.setBackground(Color.WHITE);
				jbman.setBorder(lb);
				jbwoman.setForeground(Color.WHITE);
				jbwoman.setBackground(new Color(255, 90, 95));
				sgender="여";
			}
		});
		jpinfo.add(jbman);
		jpinfo.add(jbwoman);

		jlAddr = new JLabel("주소");
		jlAddr.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jlAddr.setForeground(new Color(101, 101, 101));
		jlAddr.setBounds(20, 590, 100, 25);
		jpinfo.add(jlAddr);

		jtfAddr = new JTextField();
		jtfAddr.setEditable(false);
		jtfAddr.setBorder(lb);
		jtfAddr.setFont(new Font("나눔고딕", Font.BOLD, 20));
		jtfAddr.setForeground(new Color(101, 101, 101));
		jtfAddr.setBounds(20, 620, 180, 40);
		jpinfo.add(jtfAddr);
		
		jtfaddr2 = new JTextField("상세주소 입력");
		jtfaddr2.setEditable(true);
		jtfaddr2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				jtfaddr2.setText("상세주소 입력");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				jtfaddr2.setText("");
			}
		});
		
		jtfaddr2.setBorder(lb);
		jtfaddr2.setFont(new Font("나눔고딕",Font.BOLD,20));
		jtfaddr2.setForeground(new Color(101,101,101));
		jtfaddr2.setBounds(210,620,180,40);
		jpinfo.add(jtfaddr2);

	
		jpinfo.add(jbinfomod);
	
		
		jbinfocomplete = new JButton("확인");
		jbinfocomplete.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbinfocomplete.setBackground(new Color(255, 90, 95));
		jbinfocomplete.setForeground(Color.WHITE);
		jbinfocomplete.setBorder(null);
		jbinfocomplete.setBounds(230, 700, 120, 40);
		jbinfocomplete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtfsellerid.setEditable(false);
				jtfname.setEditable(false);
				jtftel.setEditable(false);
				jtfAddr.setEditable(false);
				jtfaddr2.setEnabled(false);
				jbman.setEnabled(false);
				jbwoman.setEnabled(false);
				jbpassmodify.setEnabled(false);
				jbaddr.setEnabled(false);

				
				
				sellerModify();
				 /////////////////////////////////////////
				dispose();
			}
		});
		jpinfo.add(jbinfocomplete);
	}

	// 방정보
	// 방 제목
	// 상세설명
	/*
	 * DB_Table : roominfomation 집 상세정보 - 집과 판매자를 식별하기 위한 houseno <number> _ 외래키
	 * 
	 * - 예약시 인원 : peoplecount <number> - 예약 방수 : roomcount <number> - 침대 갯수 :
	 * bedcount <number> - 상세설명 : detailinfo <String> - 제목 : title <String>
	 */
	// 예약리스트
	public void sellerModify() {
		ReservationDao.getInstnace().sellerModify(this); 
	
	}
	
	
	
	
	public void myreserv() {// 예약현황 페이지(tab2)
		jlreservation = new JLabel("예약자 현황");
		jlreservation.setForeground(new Color(156, 156, 156));
		jlreservation.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jlreservation.setBounds(170, 20, 100, 30);
		jpreserv.add(jlreservation);

		// initLayout에서 생성될때 함께 생성되어 값을 주기 위함
		jsp = new JScrollPane(jTableReserve = new JTable());
		// 테이블에 있는 속성을 더블클릭 했을시에 메시지 박스가 뜨게 해주는 기능
		jTableReserve.addMouseListener(new MouseAdapter() {

			@Override
	         public void mouseClicked(MouseEvent e) {
	            // TODO Auto-generated method stub
	            // super.mouseClicked(e);
	            if(e.getClickCount()==2) {
	            int row = jTableReserve.getSelectedRow();
	            String id= (String)jTableReserve.getValueAt(row, 0);
	            int houseNo= Integer.parseInt((String) jTableReserve.getValueAt(row, 1));
	            
	            String state=jTableReserve.getValueAt(row,4).equals("승인대기중")?"승인완료":"승인대기중";
	            String ShowMessage=state.equals("승인완료")?"예약을 승인하시겠습니까?":"예약을 취소하시겠습니까?";
	            String temp=null;
	            System.out.println("state="+state);
	               int result = JOptionPane.showConfirmDialog(null, ShowMessage, "Confirm", JOptionPane.YES_NO_OPTION);
	               if (result == JOptionPane.CLOSED_OPTION) {
	               } else if (result == JOptionPane.YES_OPTION) {
	                  JOptionPane.showMessageDialog(jpinfo,ShowMessage.equals("예약을 승인하시겠습니까?")?"승인완료":"승인 취소");
	                  ReservationDao.getInstnace().updateReservation(id,houseNo,state);
	               } else {
	                  JOptionPane.showMessageDialog(jpinfo, "취소");
	                  
	               }
	               
	               ReservationDao.reservationList(jTableReserve);
	            
	         }
	         }});
		jsp.setBounds(30, 80, 360, 655);
		jpreserv.add(jsp);
	}

	public void roominfo() {// 숙소 정보 페이지(tab3)
		int y = 0;
		for (int i = 0; i < jpsun2.length; i++) {
			y = i == 5 ? y + 150 : y;
			y = i == 6 ? y - 20 : y;
			jpsun2[i] = new JPanel(null);
			jpsun2[i].setBackground(new Color(235, 235, 235));
			jpsun2[i].setBounds(10, 170 + y, 400, 2);
			jproominfo.add(jpsun2[i]);
			y = y + 80;
		}
		roominfosubject = new JLabel("숙소 상세 정보");
		roominfosubject.setForeground(new Color(156, 156, 156));
		roominfosubject.setFont(new Font("나눔고딕", Font.BOLD, 15));
		roominfosubject.setBounds(150, 20, 200, 30);
		jproominfo.add(roominfosubject);

		jltitle = new JLabel("타이틀");
		jltitle.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jltitle.setForeground(new Color(101, 101, 101));
		jltitle.setBounds(20, 90, 100, 25);
		jproominfo.add(jltitle);

		jtftitle = new JTextField();
		jtftitle.setEditable(false);
		jtftitle.setBorder(lb);
		jtftitle.setFont(new Font("나눔고딕", Font.BOLD, 20));
		jtftitle.setForeground(new Color(101, 101, 101));
		jtftitle.setBounds(20, 120, 380, 40);
		jproominfo.add(jtftitle);

		jlbroomPeopleCount = new JLabel("예약 인원");
		jlbroomPeopleCount.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jlbroomPeopleCount.setForeground(new Color(101, 101, 101));
		jlbroomPeopleCount.setBounds(20, 200, 100, 25);
		jproominfo.add(jlbroomPeopleCount);

		jbpp = new JButton();
		jbpp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(butbit==1) {
				jlpcount.setText(String.valueOf(++pcount));
				}
			}
		});
		jbpp.setIcon(btimage4);
		jbpp.setBackground(null);
		jbpp.setBorder(null);
		jbpp.setBounds(350, 190, 50, 50);
//		jbpp.setEnabled(false);
		jproominfo.add(jbpp);
		jlpcount = new JLabel(String.valueOf(pcount));
		jlpcount.setBounds(300, 190, 50, 50);
		jlpcount.setHorizontalAlignment(JLabel.CENTER);
		jproominfo.add(jlpcount);
		jbpm = new JButton();
		jbpm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(butbit==1) {
				if (pcount <= 0 ) {
				} else {
					jlpcount.setText(String.valueOf(--pcount));
				}
				}
			}
		});
		jbpm.setIcon(btimage2);
		jbpm.setBackground(null);
		jbpm.setBorder(null);
		jbpm.setBounds(250, 190, 50, 50);
		jproominfo.add(jbpm);

		jlbroomCount = new JLabel("방 갯수");
		jlbroomCount.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jlbroomCount.setForeground(new Color(101, 101, 101));
		jlbroomCount.setBounds(20, 280, 100, 25);
		jproominfo.add(jlbroomCount);

		jbrp = new JButton();
		jbrp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			if(butbit==1) {
				jlrcount.setText(String.valueOf(++rcount));
			}
			}
		});
		jbrp.setIcon(btimage4);
		jbrp.setBackground(null);
		jbrp.setBorder(null);
		jbrp.setBounds(350, 270, 50, 50);
		jproominfo.add(jbrp);
		jlrcount = new JLabel(String.valueOf(rcount));
		jlrcount.setBounds(300, 270, 50, 50);
		jlrcount.setHorizontalAlignment(JLabel.CENTER);
		jproominfo.add(jlrcount);
		jbrm = new JButton();
		jbrm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(butbit==1) {
				if (rcount <= 0 ) {
				} else {
					jlrcount.setText(String.valueOf(--rcount));
				}
				}
			}
		});
		jbrm.setIcon(btimage2);
		jbrm.setBackground(null);
		jbrm.setBorder(null);
		jbrm.setBounds(250, 270, 50, 50);
		jproominfo.add(jbrm);

		jlbedcount = new JLabel("침대 갯수");
		jlbedcount.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jlbedcount.setForeground(new Color(101, 101, 101));
		jlbedcount.setBounds(20, 360, 100, 25);
		jproominfo.add(jlbedcount);

		jbbp = new JButton();
		jbbp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(butbit==1) {
				jlbcount.setText(String.valueOf(++bcount));
				}
			}
		});
		jbbp.setIcon(btimage4);
		jbbp.setBackground(null);
		jbbp.setBorder(null);
		jbbp.setBounds(350, 350, 50, 50);
		jproominfo.add(jbbp);
		jlbcount = new JLabel(String.valueOf(bcount));
		jlbcount.setBounds(300, 350, 50, 50);
		jlbcount.setHorizontalAlignment(JLabel.CENTER);
		jproominfo.add(jlbcount);
		jbbm = new JButton();
		jbbm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(butbit==1) {
				if (bcount <= 0 ) {
				} else {
					jlbcount.setText(String.valueOf(--bcount));
				}
				}
			}
		});
		jbbm.setIcon(btimage2);
		jbbm.setBackground(null);
		jbbm.setBorder(null);
		jbbm.setBounds(250, 350, 50, 50);
		jproominfo.add(jbbm);

		jlprice = new JLabel("가격");
		jlprice.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jlprice.setForeground(new Color(101, 101, 101));
		jlprice.setBounds(20, 440, 100, 25);
		jproominfo.add(jlprice);
		jtfprice = new JTextField();
		jtfprice.setBorder(lb);
		jtfprice.setBounds(170, 430, 230, 40);
		jproominfo.add(jtfprice);

		jldetailinfo = new JLabel("방 상세정보");
		jldetailinfo.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jldetailinfo.setForeground(new Color(101, 101, 101));
		jldetailinfo.setBounds(20, 510, 100, 25);
		jproominfo.add(jldetailinfo);

		jta = new JTextArea();
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setBorder(lb);
		jta.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jta.setForeground(new Color(101, 101, 101));
		jta.setBounds(20, 550, 380, 150);
		jproominfo.add(jta);

		jlsearch = new JLabel("검색 허용");
		jlsearch.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jlsearch.setForeground(new Color(101, 101, 101));
		jlsearch.setBounds(20, 740, 100, 25);
		jproominfo.add(jlsearch);

		jbsearchtrue = new JButton("ON");
		jbsearchtrue.setEnabled(false);
		jbsearchtrue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jbsearchtrue.setBackground(new Color(255, 90, 95));
				jbsearchtrue.setForeground(Color.WHITE);
				jbsearchfalse.setBackground(new Color(235, 235, 235));
				jbsearchfalse.setForeground(new Color(101, 101, 101));
				vstate="가능";
				System.out.println(vstate);
			}
		});
		jbsearchtrue.setBackground(new Color(235, 235, 235));
		jbsearchtrue.setBorder(null);
		jbsearchtrue.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbsearchtrue.setForeground(new Color(101, 101, 101));
		jbsearchtrue.setBounds(300, 738, 50, 25);
		jproominfo.add(jbsearchtrue);
		jbsearchfalse = new JButton("OFF");
		jbsearchfalse.setEnabled(false);
		jbsearchfalse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jbsearchfalse.setBackground(new Color(255, 90, 95));
				jbsearchfalse.setForeground(Color.WHITE);
				jbsearchtrue.setBackground(new Color(235, 235, 235));
				jbsearchtrue.setForeground(new Color(101, 101, 101));
				vstate="불가능";
				System.out.println(vstate);
			}
		});
		jbsearchfalse.setBackground(new Color(255, 90, 95));
		jbsearchfalse.setBorder(null);
		jbsearchfalse.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbsearchfalse.setForeground(Color.WHITE);
		jbsearchfalse.setBounds(350, 738, 50, 25);
		jproominfo.add(jbsearchfalse);

		roominfoModify = new JButton("상세정보 수정");
		roominfoModify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jtftitle.setEditable(true);
				jbpp.setIcon(btimage);
				jbpm.setIcon(btimage3);
				jbrp.setIcon(btimage);
				jbrm.setIcon(btimage3);
				jbbp.setIcon(btimage);
				jbbm.setIcon(btimage3);
				jta.setEditable(true);
				jbsearchtrue.setEnabled(true);
				jbsearchfalse.setEnabled(true);
				butbit=1;
			}
		});
		roominfoModify.setFont(new Font("나눔고딕", Font.BOLD, 15));
		roominfoModify.setBackground(new Color(255, 90, 95));
		roominfoModify.setForeground(Color.WHITE);
		roominfoModify.setBorder(null);
		roominfoModify.setBounds(80, 800, 120, 40);
		jproominfo.add(roominfoModify);

		roominfoCheck = new JButton("확인");
		roominfoCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jtftitle.setEditable(false);
				jbpp.setIcon(btimage4);
				jbpm.setIcon(btimage2);
				jbrp.setIcon(btimage4);
				jbrm.setIcon(btimage2);
				jbbp.setIcon(btimage4);
				jbbm.setIcon(btimage2);
				jta.setEditable(false);
				jbsearchtrue.setEnabled(false);
				jbsearchfalse.setEnabled(false);
				butbit=0;
				detailModify();
		
			}
		});
		roominfoCheck.setFont(new Font("나눔고딕", Font.BOLD, 15));
		roominfoCheck.setBackground(new Color(255, 90, 95));
		roominfoCheck.setForeground(Color.WHITE);
		roominfoCheck.setBorder(null);
		roominfoCheck.setBounds(230, 800, 120, 40);
		jproominfo.add(roominfoCheck);

	}

	public void detailModify() {
		ReservationDao.getInstnace().buyerDetailModify(this);
		ReservationDao.getInstnace().buyerDetailModifyState(this);
		
	}
	public void initLayout() {
		jpmain = new JPanel(null);
		jpmain.setBackground(Color.WHITE);
		jlicon = new JLabel(imgicon);
		jlicon.setBounds(10, 0, 50, 50);
		jpmain.add(jlicon);

		jpinfo = new JPanel(null);// 내 정보 페이지(tab1을 누르면 보이는 화면)
		jpinfo.setBounds(70, 0, 450, 770);
		jpinfo.setBackground(Color.WHITE);
		jpreserv = new JPanel(null);// 예약현황 페이지(tab2을 누르면 보이는 화면)
		jpreserv.setBounds(70, 0, 450, 770);
		jpreserv.setBackground(Color.WHITE);
		jpreserv.setVisible(false);
		jproominfo = new JPanel(null); // 방 상세정보 페이지(tab3을 누르면 보이는 화면)
		jproominfo.setBounds(70, 0, 450, 1000);
		jproominfo.setBackground(Color.WHITE);
		jproominfo.setVisible(false);

		tab1 = new JButton("내 정보");
		tab1.setBorder(null);
		tab1.setFont(new Font("나눔고딕", Font.BOLD, 15));
		tab1.setForeground(Color.WHITE);
		tab1.setBackground(new Color(255, 90, 95));
		tab1.setBounds(0, 50, 70, 30);
		tab1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jpreserv.setVisible(false);
				jpinfo.setVisible(true);
				jproominfo.setVisible(false);
				tab1.setForeground(Color.WHITE);
				tab1.setBackground(new Color(255, 90, 95));
				tab2.setBackground(Color.WHITE);
				tab2.setForeground(new Color(255, 90, 95));
				tab3.setBackground(Color.WHITE);
				tab3.setForeground(new Color(255, 90, 95));
				MypageSeller.this.setBounds(100, 100, 500, 800);
			}
		});

		tab2 = new JButton("리스트");
		tab2.setBorder(null);
		tab2.setFont(new Font("나눔고딕", Font.BOLD, 15));
		tab2.setBackground(Color.WHITE);
		tab2.setForeground(new Color(255, 90, 95));
		tab2.setBounds(0, 80, 70, 30);
		tab2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jpreserv.setVisible(true);
				jpinfo.setVisible(false);
				jproominfo.setVisible(false);
				tab1.setBackground(Color.WHITE);
				tab1.setForeground(new Color(255, 90, 95));
				tab2.setForeground(Color.WHITE);
				tab2.setBackground(new Color(255, 90, 95));
				tab3.setForeground(new Color(255, 90, 95));
				tab3.setBackground(Color.WHITE);
				MypageSeller.this.setBounds(100, 100, 500, 800);
			}
		});

		tab3 = new JButton("상세정보");
		tab3.setBorder(null);
		tab3.setFont(new Font("나눔고딕", Font.BOLD, 15));
		tab3.setBackground(Color.WHITE);
		tab3.setForeground(new Color(255, 90, 95));
		tab3.setBounds(0, 110, 70, 30);
		tab3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jpreserv.setVisible(false);
				jpinfo.setVisible(false);
				jproominfo.setVisible(true);
				tab1.setForeground(new Color(255, 90, 95));
				tab1.setBackground(Color.WHITE);
				tab2.setForeground(new Color(255, 90, 95));
				tab2.setBackground(Color.WHITE);
				tab3.setForeground(Color.WHITE);
				tab3.setBackground(new Color(255, 90, 95));
				MypageSeller.this.setBounds(100, 100, 500, 900);
			}
		});
		jbaddr=new JButton("주소검색");
		jbaddr.setEnabled(false);
		jbaddr.setBorder(null);
		jbaddr.setFont(new Font("나눔고딕", Font.BOLD, 15));
		
		jbaddr.setForeground(Color.WHITE);
		jbaddr.setBackground(new Color(255, 90, 95));
		jbaddr.setBounds(210, 580, 190, 40);
		jbaddr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==jbaddr) {
					
					new addr(MypageSeller.this);
				}
				
			}
		});
		
		jbinfomod = new JButton("수정");
		jbinfomod.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbinfomod.setBackground(new Color(255, 90, 95));
		jbinfomod.setForeground(Color.WHITE);
		jbinfomod.setBorder(null);
		jbinfomod.setBounds(80, 700, 120, 40);
		jbinfomod.addActionListener(this);
		
		
		jpinfo.add(jbaddr);
		jpmain.add(tab1);
		jpmain.add(tab2);
		jpmain.add(tab3);
		jpmain.add(jpinfo);
		jpmain.add(jpreserv);
		jpmain.add(jproominfo);
		
		this.add(jpmain);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jbinfomod) {
			System.out.println("tt");
			jbaddr.setEnabled(true);
			jtfname.setEditable(true);
			jtftel.setEditable(true);
			jtfAddr.setEditable(false);
			jtfaddr2.setEnabled(true);
			jbman.setEnabled(true);
			jbwoman.setEnabled(true);
			jbpassmodify.setEnabled(true);
		}
	}

	public void setgender() {
		jbinfomod.doClick();
		if (sgender.equals("남")) {
			jbman.doClick();
		} else {
			jbwoman.doClick();
		}
//		jbinfocomplete.doClick();
		butbit=0;
		jtfsellerid.setEditable(false);
		jtfname.setEditable(false);
		jtftel.setEditable(false);
		jtfAddr.setEditable(false);
		jtfaddr2.setEnabled(false);
		jbman.setEnabled(false);
		jbwoman.setEnabled(false);
		jbpassmodify.setEnabled(false);
		jbaddr.setEnabled(false);
	}

	public void setstate() {
		roominfoModify.doClick();
		if (vstate.equals("y")) {
			jbsearchtrue.doClick();
		} else {
			jbsearchfalse.doClick();
		}
		roominfoCheck.doClick();
	}

	public void setcount() {
		jlpcount.setText(String.valueOf(pcount));
		jlrcount.setText(String.valueOf(rcount));
		jlbcount.setText(String.valueOf(bcount));
	}

	public MypageSeller(String id) {
		this.id=id;
		initLayout();
		myreserv();
		myinfo();
		roominfo();
		ReservationDao.getInstnace().MyPageSellerDao(id, this);
		ReservationDao.getInstnace().detaildata(id, this);
		setgender();
		setstate();
		setcount();
		this.setBounds(100, 100, 500, 900);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	

	

	public static void main(String[] args) {
		//new MypageSeller("ttt");
	}
}