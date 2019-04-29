package team.project.reservation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ButtonDiaolog extends JFrame {

	private JPanel contentPane;
	private JTextField date;
	private CalendarPanel calendarPanel;
	private ImageIcon button = new ImageIcon("d:\\skj\\달력이모티.jpg");
	


	/**
	 * Create the frame.
	 */
	public ButtonDiaolog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton();

		btnNewButton.addActionListener(this::showCalendarDialog);
		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton.setIcon(button);
		btnNewButton.setBorderPainted(false);

		btnNewButton.setBounds(80, 54, 29, 28);
		
		date = new JTextField();
		date.setBounds(10, 55, 70, 25);
		
		contentPane.add(date);
		contentPane.add(btnNewButton);
	}

	private void showCalendarDialog(ActionEvent e) {
		JDialog dialog = new JDialog();
		Calendar calendar = Calendar.getInstance();
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH);

		calendarPanel = new CalendarPanel(y, m, ev -> dialog.setVisible(false));
		
		calendarPanel.setBorder(new LineBorder(Color.BLACK));
		
		dialog.add(calendarPanel);
		dialog.setUndecorated(true);
		dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		dialog.setBounds(getX() + 88 + 20, getY() + 85 + 25, 200, 200);
		dialog.setModal(true);
		dialog.setVisible(true);

		date.setText(calendarPanel.getSelectedDate());
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ButtonDiaolog frame = new ButtonDiaolog();
		frame.setVisible(true);
	}
	
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ButtonDialog frame = new ButtonDialog();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
}