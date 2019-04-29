package team.project.reservation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class SellerPassModify extends JFrame {
	private ImageIcon imgicon = new ImageIcon("LOGO.png");
	private JLabel jlicon, jltop;
	private JPanel jp;
	private JTextField jtf1, jtf2, jtf3;
	private LineBorder lb = new LineBorder(new Color(235, 235, 235));
	private JButton jbmodify, jbcancel;

	private String passwordChange;
	private String id;

	public void initLay() {

		jp = new JPanel(null);
		jp.setBackground(Color.WHITE);
		jlicon = new JLabel(imgicon);
		jlicon.setBounds(20, 20, 50, 50);
		jp.add(jlicon);
		jltop = new JLabel("비밀번호 변경");
		jltop.setBounds(80, 20, 300, 50);
		jltop.setFont(new Font("나눔고딕", Font.BOLD, 25));
		jltop.setForeground(new Color(255, 90, 95));
		jp.add(jltop);

		jtf1 = new JTextField();
		jtf1.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (jtf1.getText().equals("")) {
					jtf1.setText("현재 비밀번호");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				jtf1.setText("");
			}
		});
		jtf1.setText("현재 비밀번호");
		jtf1.setBounds(20, 90, 340, 50);
		jtf1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		jtf1.setBorder(lb);
		jtf2 = new JTextField();
		jtf2.setText("수정할 비밀번호");
		jtf2.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (jtf2.getText().equals("")) {
					jtf2.setText("수정할 비밀번호");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				jtf2.setText("");
			}
		});
		jtf2.setBounds(20, 150, 340, 50);
		jtf2.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		jtf2.setBorder(lb);
		jtf3 = new JTextField();
		jtf3.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (jtf3.getText().equals("")) {
					jtf3.setText("수정할 비밀번호 확인");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				jtf3.setText("");
			}
		});
		jtf3.setText("수정할 비밀번호 확인");
		jtf3.setBounds(20, 210, 340, 50);
		jtf3.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		jtf3.setBorder(lb);

		jbmodify = new JButton("수정");
		jbmodify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (passwordChange.equals(jtf1.getText())) {
					if (jtf2.getText().equals(jtf3.getText())) {
						passwordChange = jtf3.getText();
						
						ReservationDao.sellerPassword(id, passwordChange);
					} else {
						JOptionPane.showMessageDialog(null, "새로운 비밀번호를 다시 확인하세요");
						jtf2.setText("");
						jtf3.setText("");
						return;
					}
					// PasswordModify.this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "현재 비밀번호를 다시 확인하세요");
					jtf1.setText("");
					jtf2.setText("");
					jtf3.setText("");
					return;
				}
				JOptionPane.showMessageDialog(SellerPassModify.this, "수정이 완료 되었습니다.");
			}
			
		});
		jbmodify.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbmodify.setBackground(new Color(255, 90, 95));
		jbmodify.setForeground(Color.WHITE);
		jbmodify.setBorder(null);
		jbmodify.setBounds(20, 280, 160, 50);
		jbcancel = new JButton("취소");
		jbcancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SellerPassModify.this.dispose();
			}
		});
		jbcancel.setFont(new Font("나눔고딕", Font.BOLD, 15));
		jbcancel.setBackground(new Color(255, 90, 95));
		jbcancel.setForeground(Color.WHITE);
		jbcancel.setBorder(null);
		jbcancel.setBounds(200, 280, 160, 50);

		jp.add(jtf1);
		jp.add(jtf2);
		jp.add(jtf3);
		jp.add(jbmodify);
		jp.add(jbcancel);

		this.add(jp);
	}

	public SellerPassModify(String id, String passwordChange) {
		initLay();
		
		this.passwordChange = passwordChange;
		this.id = id;
		
		this.setBounds(100, 100, 400, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	/*
	 * public static void main(String[] args) { new SellerPassModify(); }
	 */
}
