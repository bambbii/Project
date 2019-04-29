package team.project.reservation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/*
 * - MemberInfoBuyer
 * - ±¸¸ÅÀÚ µ¥ÀÌÅÍº£ÀÌ½º Å×ÀÌºí
 * 
 * - buyerid : ±¸¸ÅÀÚ ¾ÆÀÌµð <String>
 * - password : ºñ¹Ð¹øÈ£ <String>
 * - name : ÀÌ¸§ <String>
 * - tel : ÀüÈ­¹øÈ£ <String>
 * - gender : ¼ºº° <String>
 */
public class MypageBuyer extends JFrame {
	private JPanel jpmain, jpinfo, jpreserv;
	private JPanel[] jpsun = new JPanel[6];
	private JPanel[] jpsun2 = new JPanel[5];
	private JButton tab1, tab2;
	private ImageIcon imgicon = new ImageIcon("LOGO.png");
	private JTextField jtfbuyerid, jtfname, jtftel;
	private JLabel jlicon, jlsubject, jldate, jltitle, jlcheckin, jlcheckout, jlservno, jlcost, jlpeople, jlapprove,
			jlbuyerid, jlbuyerpass, jlname, jltel, jlgender, jlMyinfoTitle,jlapprove1,jlpeople1,jlcost1,jlservno1,
jlcheckout1,jlcheckin1;
	private JButton jbpay, jbcancel, jbinfomod, jbinfocomplete, jbman, jbwoman, jbpassmodify;
	private LineBorder lb = new LineBorder(new Color(235, 235, 235));
	private String sgender;
	private String id = "pink";
	private String passwordChange="";



	public JLabel getJlapprove1() {
		return jlapprove1;
	}

	public void setJlapprove1(JLabel jlapprove1) {
		this.jlapprove1 = jlapprove1;
	}

	public JLabel getJlpeople1() {
		return jlpeople1;
	}

	public void setJlpeople1(JLabel jlpeople1) {
		this.jlpeople1 = jlpeople1;
	}

	public JLabel getJlcost1() {
		return jlcost1;
	}

	public void setJlcost1(JLabel jlcost1) {
		this.jlcost1 = jlcost1;
	}

	public JLabel getJlservno1() {
		return jlservno1;
	}

	public void setJlservno1(JLabel jlservno1) {
		this.jlservno1 = jlservno1;
	}

	public JLabel getJlcheckout1() {
		return jlcheckout1;
	}

	public void setJlcheckout1(JLabel jlcheckout1) {
		this.jlcheckout1 = jlcheckout1;
	}

	public JLabel getJlcheckin1() {
		return jlcheckin1;
	}

	public void setJlcheckin1(JLabel jlcheckin1) {
		this.jlcheckin1 = jlcheckin1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswordChange() {
		return passwordChange;
	}

	public void setPasswordChange(String passwordChange) {
		this.passwordChange = passwordChange;
	}

	public JLabel getJlbuyerpass() {
		return jlbuyerpass;
	}

	public void setJlbuyerpass(JLabel jlbuyerpass) {
		this.jlbuyerpass = jlbuyerpass;
	}

	public String getSgender() {
		return sgender;
	}

	public void setSgender(String sgender) {
		this.sgender = sgender;
	}

	public JTextField getJtfbuyerid() {
		return jtfbuyerid;
	}

	public void setJtfbuyerid(JTextField jtfbuyerid) {
		this.jtfbuyerid = jtfbuyerid;
	}

	public JTextField getJtfname() {
		return jtfname;
	}

	public void setJtfname(JTextField jtfname) {
		this.jtfname = jtfname;
	}

	public JTextField getJtftel() {
		return jtftel;
	}

	public void setJtftel(JTextField jtftel) {
		this.jtftel = jtftel;
	}

	public void myinfo() {// ³» Á¤º¸ ÆäÀÌÁö(tab1)
		int y = 0;
		for (int i = 0; i < jpsun2.length; i++) {
			jpsun2[i] = new JPanel(null);
			jpsun2[i].setBackground(new Color(235, 235, 235));
			jpsun2[i].setBounds(10, 170 + y, 400, 2);
			jpinfo.add(jpsun2[i]);
			y = y + 100;
		}
		jlMyinfoTitle = new JLabel("±¸¸ÅÀÚ »ó¼¼ Á¤º¸");
		jlMyinfoTitle.setForeground(new Color(156, 156, 156));
		jlMyinfoTitle.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlMyinfoTitle.setBounds(150, 20, 200, 30);
		jpinfo.add(jlMyinfoTitle);

		jlbuyerid = new JLabel("¾ÆÀÌµð");
		jlbuyerid.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlbuyerid.setForeground(new Color(101, 101, 101));
		jlbuyerid.setBounds(20, 90, 100, 25);
		jpinfo.add(jlbuyerid);

		jtfbuyerid = new JTextField();
		jtfbuyerid.setEditable(false);
		jtfbuyerid.setBorder(lb);
		jtfbuyerid.setFont(new Font("³ª´®°íµñ", Font.BOLD, 20));
		jtfbuyerid.setForeground(new Color(101, 101, 101));
		jtfbuyerid.setBounds(20, 120, 200, 40);
		jpinfo.add(jtfbuyerid);

		jlbuyerpass = new JLabel("ºñ¹Ð¹øÈ£");
		jlbuyerpass.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlbuyerpass.setForeground(new Color(101, 101, 101));
		jlbuyerpass.setBounds(20, 190, 100, 25);
		jpinfo.add(jlbuyerpass);

		jbpassmodify = new JButton("ºñ¹Ð¹øÈ£ ¼öÁ¤");
		jbpassmodify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new BuyerPassModify(id, passwordChange);
			}
		});
		jbpassmodify.setBorder(null);
		jbpassmodify.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jbpassmodify.setForeground(Color.WHITE);
		jbpassmodify.setBackground(new Color(255, 90, 95));
		jbpassmodify.setBounds(20, 220, 200, 40);
		jpinfo.add(jbpassmodify);

		jlname = new JLabel("ÀÌ¸§");
		jlname.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlname.setForeground(new Color(101, 101, 101));
		jlname.setBounds(20, 290, 100, 25);
		jpinfo.add(jlname);

		jtfname = new JTextField();
		jtfname.setEditable(false);
		jtfname.setBorder(lb);
		jtfname.setFont(new Font("³ª´®°íµñ", Font.BOLD, 20));
		jtfname.setForeground(new Color(101, 101, 101));
		jtfname.setBounds(20, 320, 200, 40);
		jpinfo.add(jtfname);

		jltel = new JLabel("ÀüÈ­¹øÈ£");
		jltel.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jltel.setForeground(new Color(101, 101, 101));
		jltel.setBounds(20, 390, 100, 25);
		jpinfo.add(jltel);

		jtftel = new JTextField();
		jtftel.setEditable(false);
		jtftel.setBorder(lb);
		jtftel.setFont(new Font("³ª´®°íµñ", Font.BOLD, 20));
		jtftel.setForeground(new Color(101, 101, 101));
		jtftel.setBounds(20, 420, 200, 40);
		jpinfo.add(jtftel);

		jlgender = new JLabel("¼ºº°");
		jlgender.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlgender.setForeground(new Color(101, 101, 101));
		jlgender.setBounds(20, 490, 100, 25);
		jpinfo.add(jlgender);

		jbman = new JButton("³²ÀÚ");
		jbman.setEnabled(false);
		jbman.setBorder(lb);
		jbman.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
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
				sgender="³²";
			}
		});
		jbwoman = new JButton("¿©ÀÚ");
		jbwoman.setEnabled(false);
		jbwoman.setBorder(null);
		jbwoman.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
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
				sgender="¿©";
			}
		});
		jpinfo.add(jbman);
		jpinfo.add(jbwoman);

		jbinfomod = new JButton("¼öÁ¤");
		jbinfomod.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jbinfomod.setBackground(new Color(255, 90, 95));
		jbinfomod.setForeground(Color.WHITE);
		jbinfomod.setBorder(null);
		jbinfomod.setBounds(80, 600, 120, 40);
		jbinfomod.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtfbuyerid.setEditable(true);
				jtfname.setEditable(true);
				jtftel.setEditable(true);
				jbman.setEnabled(true);
				jbwoman.setEnabled(true);
				jbpassmodify.setEnabled(true);
			}
		});
		jpinfo.add(jbinfomod);
		jbinfocomplete = new JButton("È®ÀÎ");
		jbinfocomplete.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jbinfocomplete.setBackground(new Color(255, 90, 95));
		jbinfocomplete.setForeground(Color.WHITE);
		jbinfocomplete.setBorder(null);
		jbinfocomplete.setBounds(230, 600, 120, 40);
		jbinfocomplete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtfbuyerid.setEditable(false);
				jtfname.setEditable(false);
				jtftel.setEditable(false);
				jbman.setEnabled(false);
				jbwoman.setEnabled(false);
				jbpassmodify.setEnabled(false);
				
				buyerModify();
			}
		});
		jpinfo.add(jbinfocomplete);
	}

	public void buyerModify() {
		System.out.println("È÷Èý");
		ReservationDao.getInstnace().buyerModify(this);
	}
	public void myreserv() {// ¿¹¾àÇöÈ² ÆäÀÌÁö(tab2)
		int y = 0;
		for (int i = 0; i < jpsun.length; i++) {
			jpsun[i] = new JPanel(null);
			jpsun[i].setBackground(new Color(235, 235, 235));
			jpsun[i].setBounds(10, 170 + y, 400, 2);
			jpreserv.add(jpsun[i]);
			y = y + 100;
		}

		jlsubject = new JLabel("¿¹¾àÇöÈ²");
		jlsubject.setForeground(new Color(156, 156, 156));
		jlsubject.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlsubject.setBounds(180, 20, 100, 30);
		jpreserv.add(jlsubject);

		String date = "1¿ù 21ÀÏ(Åä) - 1¿ù 22ÀÏ(ÀÏ)";
		jldate = new JLabel(date);
		jldate.setFont(new Font("³ª´®°íµñ", Font.BOLD, 10));
		jldate.setForeground(new Color(101, 101, 101));
		jldate.setBounds(20, 60, 400, 20);
		jpreserv.add(jldate);
		String title = "<html><body>Ocean view,Sooya house in <br>Haeundae #01</body></html>";// ¶óº§ÀÇ µ¥ÀÌÅÍ¸¦ ¶óÀÎ½ºÅµÇÏ¿© Ãâ·ÂÇÏ´Â Äõ¸®
		jltitle = new JLabel(title);
		jltitle.setFont(new Font("³ª´®°íµñ", Font.BOLD, 30));
		jltitle.setForeground(new Color(101, 101, 101));
		jltitle.setBounds(20, 90, 400, 60);
		jpreserv.add(jltitle);
		jlcheckin = new JLabel("Ã¼Å©ÀÎ");
		jlcheckin.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlcheckin.setForeground(new Color(101, 101, 101));
		jlcheckin.setBounds(20, 190, 100, 25);
		
	jlcheckin1 = new JLabel("");///////////////////////////
		jlcheckin1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlcheckin1.setForeground(new Color(101, 101, 101));
		jlcheckin1.setBounds(20, 240, 100, 25);
		
		jpreserv.add(jlcheckin);
		jpreserv.add(jlcheckin1);

		jlcheckout = new JLabel("Ã¼Å©¾Æ¿ô");
		jlcheckout.setHorizontalAlignment(JLabel.RIGHT);
		jlcheckout.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlcheckout.setForeground(new Color(101, 101, 101));
		jlcheckout.setBounds(290, 190, 100, 25);
		
		 jlcheckout1 = new JLabel("");///////////////////////////////
		jlcheckout1.setHorizontalAlignment(JLabel.RIGHT);
		jlcheckout1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlcheckout1.setForeground(new Color(101, 101, 101));
		jlcheckout1.setBounds(290, 240, 100, 25);
		
		jpreserv.add(jlcheckout);
		jpreserv.add(jlcheckout1);

		jlservno = new JLabel("¿¹¾à¹øÈ£");
		jlservno.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlservno.setForeground(new Color(101, 101, 101));
		jlservno.setBounds(20, 290, 100, 25);
		 jlservno1 = new JLabel(""); /////////////////////////////
		jlservno1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlservno1.setForeground(new Color(101, 101, 101));
		jlservno1.setBounds(20, 340, 100, 25);
		jpreserv.add(jlservno);
		jpreserv.add(jlservno1);

		jlcost = new JLabel("ÃÑºñ¿ë");
		jlcost.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlcost.setForeground(new Color(101, 101, 101));
		jlcost.setBounds(20, 390, 100, 25);
		 jlcost1 = new JLabel("");//////////////////////
		jlcost1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlcost1.setForeground(new Color(101, 101, 101));
		jlcost1.setBounds(20, 440, 100, 25);
		
		jpreserv.add(jlcost);
		jpreserv.add(jlcost1);
		
		jlpeople = new JLabel("ÀÎ¿ø");
		jlpeople.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlpeople.setForeground(new Color(101, 101, 101));
		jlpeople.setBounds(20, 490, 100, 25);
		 jlpeople1 = new JLabel("");/////////////////////////////////////
		jlpeople1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlpeople1.setForeground(new Color(101, 101, 101));
		jlpeople1.setBounds(20, 540, 100, 25);
		
		jpreserv.add(jlpeople);
		jpreserv.add(jlpeople1);
		jlapprove = new JLabel("½ÂÀÎ¿©ºÎ");
		jlapprove.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlapprove.setForeground(new Color(101, 101, 101));
		jlapprove.setBounds(20, 590, 100, 25);
		jlapprove1 = new JLabel("");////////////////////////////////////
		jlapprove1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jlapprove1.setForeground(new Color(101, 101, 101));
		jlapprove1.setBounds(20, 640, 100, 25);
		jpreserv.add(jlapprove);
		jpreserv.add(jlapprove1);
		jbpay = new JButton("¿¹¾àÃë¼Ò");
		jbpay.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jbpay.setBackground(new Color(255, 90, 95));
		jbpay.setForeground(Color.WHITE);
		jbpay.setBorder(null);
		jbpay.setBounds(80, 700, 120, 40);
		jpreserv.add(jbpay);
		jbcancel = new JButton("°áÁ¦");
		jbcancel.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		jbcancel.setBackground(new Color(255, 90, 95));
		jbcancel.setForeground(Color.WHITE);
		jbcancel.setBorder(null);
		jbcancel.setBounds(230, 700, 120, 40);
		jpreserv.add(jbcancel);
	}

	public void initLayout() {
		jpmain = new JPanel(null);
		jpmain.setBackground(Color.WHITE);
		jlicon = new JLabel(imgicon);
		jlicon.setBounds(10, 0, 50, 50);
		jpmain.add(jlicon);

		jpinfo = new JPanel(null);// ³» Á¤º¸ ÆäÀÌÁö(tab1À» ´©¸£¸é º¸ÀÌ´Â È­¸é)
		jpinfo.setBounds(70, 0, 450, 770);
		jpinfo.setBackground(Color.WHITE);
		jpreserv = new JPanel(null);// ¿¹¾àÇöÈ² ÆäÀÌÁö(tab2À» ´©¸£¸é º¸ÀÌ´Â È­¸é)
		jpreserv.setBounds(70, 0, 450, 770);
		jpreserv.setBackground(Color.WHITE);
		jpreserv.setVisible(false);

		tab1 = new JButton("³» Á¤º¸");
		tab1.setBorder(null);
		tab1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		tab1.setBackground(new Color(255, 90, 95));
		tab1.setForeground(Color.WHITE);
		tab1.setBounds(0, 50, 70, 30);
		tab1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jpinfo.setVisible(true);
				jpreserv.setVisible(false);
				tab2.setBackground(Color.WHITE);
				tab2.setForeground(new Color(255, 90, 95));
				tab1.setBackground(new Color(255, 90, 95));
				tab1.setForeground(Color.WHITE);
				MypageBuyer.this.setBounds(100, 100, 500, 700);
			}
		});
		tab2 = new JButton("¿¹¾àÇöÈ²");
		tab2.setBorder(null);
		tab2.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		tab2.setBackground(Color.WHITE);
		tab2.setForeground(new Color(255, 90, 95));
		tab2.setBounds(0, 80, 70, 30);
		tab2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jpreserv.setVisible(true);
				jpinfo.setVisible(false);
				tab1.setBackground(Color.WHITE);
				tab1.setForeground(new Color(255, 90, 95));
				tab2.setBackground(new Color(255, 90, 95));
				tab2.setForeground(Color.WHITE);
				MypageBuyer.this.setBounds(100, 100, 500, 800);
			}
		});
		jpmain.add(tab1);
		jpmain.add(tab2);
		jpmain.add(jpinfo);
		jpmain.add(jpreserv);

		this.add(jpmain);
	}

	public void setgender() {
		jbinfomod.doClick();
		if (sgender.equals("³²")) {
			jbman.doClick();
		} else {
			jbwoman.doClick();
		}
		jbinfocomplete.doClick();
	}

	public MypageBuyer(String id) {
		this.id=id;
		initLayout();
		myreserv();
		myinfo();
		ReservationDao.getInstnace().MyPageBuyerDao(id, this);
		ReservationDao.getInstnace().myReservation(this);
		setgender();
		this.setResizable(false);
		this.setBounds(100, 100, 500, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		//new MypageBuyer();
	}
}