package team.project.reservation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class RoomInfo extends JFrame implements ActionListener {

	private ImageIcon pButton = new ImageIcon("C:\\Users\\sehee\\Desktop\\jdbcProject\\pButton.png");
	private ImageIcon mButton = new ImageIcon("C:\\Users\\sehee\\Desktop\\jdbcProject\\mButton.png");

	private JLabel boonru, title, addr, peopleCount, bedCount, roomCount, restroomCount;
	private JPanel jpmain;
	private JPanel jpRoomInfo;
	//
	private JTextArea detailInfo;
	private JScrollPane rommInfoScroll;
	//
//	private JLabel Arrow;
	private JLabel price, date, selectpeopleCount, notice;
	private JTextField jtfPCount;
	private JButton jbreserve, jbplusm, jbminus;
	private RoomInfomation roomInfomation = new RoomInfomation();
	private int row;
	private Main main;
	private String Id;
	//
	private CalendarPanel calendarPanel;
	private int checkInYear, checkInDay;
	static int checkInMonth;
	private JTextField inText, outText;
	private ImageIcon calendar = new ImageIcon("C:\\Users\\sehee\\Desktop\\jdbcProject\\c1.png");
	private JButton checkinbutton, checkoutbutton;
	private int pcouunt;
	private int  total;

	// 달력
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public JLabel getPrice() {
		return price;
	}

	public void setPrice(JLabel price) {
		this.price = price;
	}

	public JTextField getJtfPCount() {
		return jtfPCount;
	}

	public void setJtfPCount(JTextField jtfPCount) {
		this.jtfPCount = jtfPCount;
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

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public JTextArea getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(JTextArea detailInfo) {
		this.detailInfo = detailInfo;
	}

	public JLabel gettitle() {
		return title;
	}

	public void settitle(JLabel title) {
		this.title = title;
	}

	public JLabel getAddr() {
		return addr;
	}

	public void setAddr(JLabel addr) {
		this.addr = addr;
	}

	public JLabel getpeopleCount() {
		return peopleCount;
	}

	public void setpeopleCount(JLabel peopleCount) {
		this.peopleCount = peopleCount;
	}

	public JLabel getBedCount() {
		return bedCount;
	}

	public void setBedCount(JLabel bedCount) {
		this.bedCount = bedCount;
	}

	public JLabel getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(JLabel roomCount) {
		this.roomCount = roomCount;
	}

	public JLabel getRestroomCount() {
		return restroomCount;
	}

	public void setRestroomCount(JLabel restroomCount) {
		this.restroomCount = restroomCount;
	}

	public RoomInfomation getRoomInfomation() {
		return roomInfomation;
	}

	public void setRoomInfomation(RoomInfomation roomInfomation) {
		this.roomInfomation = roomInfomation;
	}

	private void showCalendarDialog1(ActionEvent e) {// Checkin 달력
		JDialog dialog = new JDialog();
		Calendar calendar = Calendar.getInstance();
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH);
		calendarPanel = new CalendarPanel(y, m, ev -> dialog.setVisible(false));

		calendarPanel.setBorder(new LineBorder(Color.BLACK));

		dialog.add(calendarPanel);
		dialog.setUndecorated(true);
		dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		// dialog.setBounds(getX() + 88 + 20, getY() + 85 + 25, 200, 200);
		dialog.setBounds(650, 475, 200, 200);
		dialog.setModal(true);
		dialog.setVisible(true);
		inText.setText(calendarPanel.getSelectedDate());
		checkInDay = calendarPanel.checkInday();
		checkInMonth = calendarPanel.checkInMonth();
		checkInYear = calendarPanel.checkInYear();
	}

	private void showCalendarDialog2(ActionEvent e) {// checkout 달력
		JDialog dialog = new JDialog();
		Calendar calendar = Calendar.getInstance();
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH);
		System.out.println(
				"checkInYear: " + checkInYear + " checkinMonth : " + checkInMonth + " checkInday : " + checkInDay);
		calendarPanel = new CalendarPanel(checkInYear, checkInMonth, checkInDay, ev -> dialog.setVisible(false));

		calendarPanel.setBorder(new LineBorder(Color.BLACK));

		dialog.add(calendarPanel);
		dialog.setUndecorated(true);
		dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		// dialog.setBounds(getX() + 88 + 20, getY() + 85 + 25, 200, 200);
		dialog.setBounds(830, 475, 200, 200);
		dialog.setModal(true);
		dialog.setVisible(true);
		outText.setText(calendarPanel.getSelectedDate());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbreserve) {
			Id = main.getId();
			String cki = "";
			String cko = ""; // 예약현황 체크인 체크아웃
			String buyi = "";
			String buyo = "";
			if (JOptionPane.showConfirmDialog(this, "예약하시겠습니까?") == JOptionPane.OK_OPTION) {

				if (ReservationDao.getInstnace().searchReservation(row).getCheckin() == null
						&& ReservationDao.getInstnace().searchReservation(row).getCheckout() == null) {
					ReservationDao.getInstnace().insertReservation(this);// 바로예약
					JOptionPane.showMessageDialog(this, "예약이 완료되었습니다");
					ReservationDao.getInstnace().insertReservation(this);
					this.dispose();
				} else {

					String[] res1 = ReservationDao.getInstnace().searchReservation(row).getCheckin().split("-");
					String[] res2 = ReservationDao.getInstnace().searchReservation(row).getCheckout().split("-"); // 예약현황
																													// 체크인
																													// 체크아웃
					System.out.println(res1);
					String[] buyCkI = inText.getText().split("-");
					String[] buyCkO = inText.getText().split("-"); // 현재 예약 체크인 체크아웃 분리

					for (int i = 0; i < res1.length; i++) {
						cki += res1[i];
						cko += res2[i];
						buyi += buyCkI[i];
						buyo += buyCkO[i];
					}
					int ckii = Integer.parseInt(cki);
					int ckoo = Integer.parseInt(cko);
					int buyii = Integer.parseInt(buyi);
					int buyoo = Integer.parseInt(buyo);

					if (((ckii <= buyii && buyii <= ckoo) || (ckii <= buyoo && buyoo <= ckoo))
							|| ((buyii <= ckoo && ckoo >= buyoo) || (buyii <= ckii && ckii >= buyoo))) {
						JOptionPane.showMessageDialog(this, "이미 예약중인 방입니다.");
					} else {
						JOptionPane.showMessageDialog(this, "예약이 완료되었습니다");
						ReservationDao.getInstnace().insertReservation(this);
						this.dispose();

					} // 03/07/8:24추가

				} // 예약하시겠습니까 if문
			}
		}
	}

	public void initLayEx() {
		LineBorder lb = new LineBorder(new Color(235, 235, 235));

		rommInfoScroll = new JScrollPane(detailInfo = new JTextArea(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		rommInfoScroll.setBounds(26, 300, 600, 450);
		rommInfoScroll.setBorder(lb);
		detailInfo.setFont(new Font("나눔고딕", Font.BOLD, 15));
		detailInfo.setLineWrap(true);
		detailInfo.setEnabled(false);

		///////////////////////////////////////////////////////////////////////////
		jpmain = new JPanel(null);
		/* jpmain.add(boonru = new JLabel("타운하우스")); */
		jpmain.setBackground(Color.white);
		/*
		 * boonru.setBounds(10, 50, 100, 30); boonru.setFont(new Font("나눔고딕", Font.BOLD,
		 * 13)); boonru.setBackground(Color.white); boonru.setOpaque(true);
		 */

		jpmain.add(title = new JLabel());
		title.setBounds(10, 65, 400, 50);
		title.setFont(new Font("나눔고딕", Font.BOLD, 30));
		title.setBackground(Color.white);
		title.setOpaque(true);

		jpmain.add(addr = new JLabel());
		addr.setBounds(10, 135, 300, 30);
		addr.setFont(new Font("나눔고딕", Font.BOLD, 17));
		addr.setForeground(new Color(192, 192, 192));
		addr.setBackground(Color.white);
		addr.setOpaque(true);

		jpmain.add(peopleCount = new JLabel());
		peopleCount.setBounds(40, 184, 70, 30);
		peopleCount.setFont(new Font("나눔고딕", Font.BOLD, 17));
		peopleCount.setBackground(Color.white);
		peopleCount.setOpaque(true);

		jpmain.add(bedCount = new JLabel());
		bedCount.setBounds(200, 184, 70, 30);
		bedCount.setFont(new Font("나눔고딕", Font.BOLD, 17));
		bedCount.setBackground(Color.white);
		bedCount.setOpaque(true);

		jpmain.add(roomCount = new JLabel());
		roomCount.setBounds(40, 224, 70, 30);
		roomCount.setFont(new Font("나눔고딕", Font.BOLD, 17));
		roomCount.setBackground(Color.white);
		roomCount.setOpaque(true);

		jpmain.add(restroomCount = new JLabel());
		restroomCount.setBounds(200, 225, 70, 30);
		restroomCount.setFont(new Font("나눔고딕", Font.BOLD, 17));
		restroomCount.setBackground(Color.white);
		restroomCount.setOpaque(true);
////////////////////////////////////////////////////////////////////////////////////////		
		jpmain.add(jpRoomInfo = new JPanel(null));
		jpRoomInfo.setBounds(640, 300, 370, 350);
		jpRoomInfo.setBackground(Color.white);
		jpRoomInfo.setOpaque(true);
		jpRoomInfo.setBorder(lb);

		jpRoomInfo.add(price = new JLabel());
		price.setBounds(15, 5, 200, 50);
		price.setFont(new Font("나눔고딕", Font.BOLD, 17));
		price.setBackground(Color.white);
		price.setOpaque(true);

		jpRoomInfo.add(date = new JLabel("날짜"));
		date.setBounds(15, 50, 200, 40);
		date.setFont(new Font("나눔고딕", Font.BOLD, 14));
		date.setBackground(Color.white);
		date.setOpaque(true);

		jpRoomInfo.add(inText = new JTextField(main.getInText().getText()));
		inText.setFont(new Font("나눔고딕", Font.BOLD, 15));
		inText.setBounds(15, 90, 130, 40);
		inText.setEnabled(false);
		inText.setBorder(lb);

//	    checkIn.setBackground(Color.white);

//		jpRoomInfo.add(Arrow = new JLabel("▶"));
//		Arrow.setForeground(new Color(101, 101, 101));
//		Arrow.setBounds(172, 90, 35, 40);
//		Arrow.setFont(new Font("나눔고딕", Font.BOLD, 14));
//	    checkIn.setBackground(Color.black);		

		checkinbutton = new JButton(calendar);
		checkinbutton.addActionListener(this::showCalendarDialog1);
		checkinbutton.setBackground(Color.WHITE);
		checkinbutton.setBorder(null);
		checkinbutton.setBounds(145, 90, 40, 40);
		checkinbutton.setOpaque(false);
		jpRoomInfo.add(checkinbutton);

		jpRoomInfo.add(outText = new JTextField(main.getOutText().getText()));
		outText.setFont(new Font("나눔고딕", Font.BOLD, 15));
		outText.setBorder(lb);
		outText.setBounds(190, 90, 130, 40);
		outText.setBackground(Color.white);
		outText.setEnabled(false);

		checkoutbutton = new JButton(calendar);
		checkoutbutton.setBackground(Color.WHITE);
		checkoutbutton.setBorder(null);
		checkoutbutton.setBounds(320, 90, 40, 40);
		checkoutbutton.addActionListener(this::showCalendarDialog2);
		jpRoomInfo.add(checkoutbutton);

		jpRoomInfo.add(selectpeopleCount = new JLabel("인원"));
		selectpeopleCount.setBounds(15, 130, 140, 40);
		selectpeopleCount.setFont(new Font("나눔고딕", Font.BOLD, 14));
		selectpeopleCount.setBackground(Color.white);
		selectpeopleCount.setOpaque(true);

		jbminus = new JButton(mButton);
		jbminus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pcouunt <= 1) {
					++pcouunt;
					JOptionPane.showMessageDialog(null, "인원수를 1명 이상 선택하세요");
					
				}
				jtfPCount.setText(String.valueOf(--pcouunt<1?1:pcouunt)+"명");
				
/*				price.setText(String.valueOf(
						Integer.parseInt(price.getText().split("원")[0]) *));*/
				price.setText(String.valueOf(total * (pcouunt)+"원"));
				System.out.println(pcouunt);
			}
		});
		jbminus.setBorder(null);
		jbminus.setBounds(15, 170, 40, 40);
		jpRoomInfo.add(jbminus);
		jbplusm = new JButton(pButton);
		jbplusm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtfPCount.setText(String.valueOf(++pcouunt)+"명");
/*				price.setText(String.valueOf(
						Integer.parseInt(price.getText().split("원")[0]) * pcouunt/pcouunt-1));*/
				price.setText(String.valueOf(total * pcouunt)+"원");
				System.out.println(pcouunt);
			}
		});
		jbplusm.setBorder(null);
		jbplusm.setBounds(310, 170, 40, 40);
		jpRoomInfo.add(jbplusm);
		pcouunt = Integer.parseInt(main.getCountText().getText().substring(0, 1));
		jtfPCount = new JTextField();
		jtfPCount.setFont(new Font("나눔고딕", Font.BOLD, 20));
		jtfPCount.setHorizontalAlignment(JTextField.RIGHT);
		jtfPCount.setText(String.valueOf(pcouunt)+"명");
		jpRoomInfo.add(jtfPCount);
		jtfPCount.setBorder(lb);
		jtfPCount.setBounds(55, 170, 250, 40);

		jpRoomInfo.add(notice = new JLabel("예약 확정 전에는 요금이 청구되지 않습니다."));
		notice.setOpaque(true);
		notice.setBounds(60, 220, 270, 40);
		notice.setFont(new Font("나눔고딕", Font.BOLD, 14));
		notice.setBackground(Color.white);

		jpRoomInfo.add(jbreserve = new JButton("예약 요청"));
		jbreserve.addActionListener(this);
		jbreserve.setBounds(15, 270, 340, 50);
		jbreserve.setBackground(new Color(255, 90, 95));
		jbreserve.setFont(new Font("나눔고딕", Font.BOLD, 17));
		jbreserve.setForeground(Color.white);
		jbreserve.setOpaque(true);
		jbreserve.setBorder(null);
		jpmain.add(rommInfoScroll);
		/// 달력시작

		this.add(jpmain);
		ReservationDao.getInstnace().searchRoomInfo(this, row);
		total=Integer.parseInt(price.getText().split("원")[0]);

	}

	public RoomInfo() {
		initLayEx();
		this.setVisible(true);
		this.setBounds(10, 10, 1050, 870);
	}

	public RoomInfo(Main main, int row) {
		this.main = main;
		this.row = row;
		initLayEx();
		this.setVisible(true);
		this.setBounds(10, 10, 1050, 870);

	}

	public static void main(String[] args) {
		new RoomInfo();
	}

}
