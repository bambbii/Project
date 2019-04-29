package team.project.reservation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CalendarPanel extends JPanel {
	private JPanel topPanel = new JPanel();
	private JPanel calendarPanel = new JPanel();
	private JLabel yearHeader;
	private ActionListener callBackAction;
	private JLabel label;
	private JLabel sender;
	
	private int year;
	private int month,monthText;
	private int day;

	public int checkInday() {
		if(day==0) {
			return 0;
		}
		return day;
	}
	public int checkInMonth() {
		if(month==0) {
			return 0;
		}
		return month;
	}
	public int checkInYear() {
		if(year==0) {
			return 0;
		}
		return year;
	}
	
	public CalendarPanel(int year, int month, ActionListener action) {//체크인
		setLayout(new BorderLayout());

		topPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
		topPanel.setLayout(new GridBagLayout() {
			{ this.columnWeights = new double[] { 1, 1, 5, 1, 1, Double.MIN_VALUE }; }
		});
		calendarPanel.setLayout(new GridLayout(7, 7));

		this.year = year;
		this.month = month;
		monthText=month;
		this.callBackAction = action;
		
		initTopHeader();
		initHeader();
		initContents();

		add(topPanel, BorderLayout.NORTH);
		add(calendarPanel, BorderLayout.CENTER);
	}
	public CalendarPanel(int year, int month,int day, ActionListener action) {//체크아웃
		setLayout(new BorderLayout());
		
		topPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
		topPanel.setLayout(new GridBagLayout() {
			{ this.columnWeights = new double[] { 1, 1, 5, 1, 1, Double.MIN_VALUE }; }
		});
		calendarPanel.setLayout(new GridLayout(7, 7));
		
		this.year = year;
		this.month = month;
		monthText=month;
		this.day=day;
		this.callBackAction = action;
		
		
		initTopHeader();
		initHeader();
		initContents();
		
		add(topPanel, BorderLayout.NORTH);
		add(calendarPanel, BorderLayout.CENTER);
	}

	private void setYearMonth(int year, int month) {
		calendarPanel.removeAll();

		this.year = year;
		this.month = month;

		refreshHeaderText();
		initHeader();
		initContents();
	}

	private void initTopHeader() {
		Cursor hand = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

		topPanel.add(createJLabel("<<", hand)).addMouseListener(yearMonthChangeAdapter);
		topPanel.add(createJLabel("<", hand)).addMouseListener(yearMonthChangeAdapter);

		yearHeader = createJLabel("");
		topPanel.add(yearHeader);

		topPanel.add(createJLabel(">", hand)).addMouseListener(yearMonthChangeAdapter);
		topPanel.add(createJLabel(">>", hand)).addMouseListener(yearMonthChangeAdapter);

		refreshHeaderText();
	}

	private void refreshHeaderText() {
		yearHeader.setText(String.format("%d / %2d", year, month + 1));
	}
	private void initContents() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, 1);
		int weekIndex = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		calendar.add(Calendar.DATE, -weekIndex);
		
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyymmdd");
		Calendar cal=Calendar.getInstance();
		String nowday=dateFormat.format(cal.getTime());
		cal.set(year,month,day);
		
		
		for (int s = 0; s < 42; s++) {
			int m = calendar.get(Calendar.MONTH);
			int d = calendar.get(Calendar.DATE);
			if (m == this.month) {
				
				if(m==monthText) {//예약한 달의 달력
					label = createJLabel(String.valueOf(d), Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					
					calendarPanel.add(label);
					
					if (d < day+1) {
						label.setEnabled(false);
					}
					
					
				}else{
					label = createJLabel(String.valueOf(d), Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					
					calendarPanel.add(label);
					label.setEnabled(false);
				}
				label.addMouseListener(dateMouseAdapter);
				
			}else {
				calendarPanel.add(createJLabel(""));
			}
			
			
			calendar.add(Calendar.DATE, 1);
		}
		
	}

	private JLabel lastClikedDate = null;

	private MouseAdapter dateMouseAdapter = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			 sender = (JLabel) e.getSource();

			if (lastClikedDate != null) {
				lastClikedDate.setBorder(null);
			}

			lastClikedDate = sender;
			sender.setBorder(new LineBorder(Color.BLACK));
			callBackAction.actionPerformed(new ActionEvent(sender, 0, ""));
		};
	};

	private MouseAdapter yearMonthChangeAdapter = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
		    sender = (JLabel) e.getSource();

			switch (sender.getText()) {
			case "<<":
				setYearMonth(year - 1, month);
				break;
			case "<":
				setYearMonth(year, month - 1);
				break;
			case ">":
				setYearMonth(year, month + 1);
				break;
			case ">>":
				setYearMonth(year + 1, month);
				break;
			}
		};
	};

	public String getSelectedDate() {

		if (lastClikedDate == null) {
			return null;
		}
		
		int date = Integer.parseInt(lastClikedDate.getText());
		day=date;
		return String.format("%04d-%02d-%02d", year, month + 1, date);
	}

	private void initHeader() {
		calendarPanel.add(createJLabel("일", Color.RED));
		calendarPanel.add(createJLabel("월"));
		calendarPanel.add(createJLabel("화"));
		calendarPanel.add(createJLabel("수"));
		calendarPanel.add(createJLabel("목"));
		calendarPanel.add(createJLabel("금"));
		calendarPanel.add(createJLabel("토", Color.BLUE));
	}

	private JLabel createJLabel(String text) {
		return createJLabel(text, Color.BLACK, Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

	private JLabel createJLabel(String text, Cursor cursor) {
		return createJLabel(text, Color.BLACK, cursor);
	}

	private JLabel createJLabel(String text, Color color) {
		return createJLabel(text, color, Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

	private JLabel createJLabel(String text, Color color, Cursor cursor) {
		 label = new JLabel(text, JLabel.CENTER);

		label.setCursor(cursor);
		label.setForeground(color);

		return label;
	}

}

