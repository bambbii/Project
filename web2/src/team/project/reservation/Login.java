package team.project.reservation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Login extends JFrame implements ActionListener {
	private Main main;
	private JPanel jp;
	private JLabel jlid, jlpass;
	private JTextField tfid, tfpass;
	private JButton jbok, jbback,jbbuyer,jbseller;
	private boolean a;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jbbuyer) {///������ ��ư�� �������� ���������� ���ϸ鼭 �Ǹ��ڹ�ư�� �ٽ� �ʱ������ ���ư��� ���ش�.
			System.out.println("a");
			a=true;
			jbseller.setForeground(new Color(255, 90, 95));
			jbseller.setBackground(Color.WHITE);
			jbbuyer.setForeground(Color.WHITE);
			jbbuyer.setBackground(new Color(255, 90, 95));
		}
		if(e.getSource()==jbseller) {///�Ǹ��� ��ư�� �������� ���������� ���ϸ鼭 �Ǹ��ڹ�ư�� �ٽ� �ʱ������ ���ư��� ���ش�.
			System.out.println("b");
			a=false;
			jbbuyer.setForeground(new Color(255, 90, 95));
			jbbuyer.setBackground(Color.WHITE);
			jbseller.setForeground(Color.WHITE);
			jbseller.setBackground(new Color(255, 90, 95));
		}
	}

	public void initLayEx() {
		jp = new JPanel(null);
		jp.setBackground(Color.WHITE);
		jp.setBounds(0, 0, 300, 200);

		jlid = new JLabel("ID");
		jlid.setFont(new Font("�������", Font.BOLD, 15));
		jlid.setForeground(new Color(192, 192, 192));
		jlid.setBounds(20, 10, 30, 45);
		jlpass = new JLabel("PW");
		jlpass.setFont(new Font("�������", Font.BOLD, 15));
		jlpass.setForeground(new Color(192, 192, 192));
		jlpass.setBounds(20, 60, 30, 45);

		LineBorder lb = new LineBorder(new Color(235, 235, 235));
		tfid = new JTextField();
		tfpass = new JTextField();
		tfid.setBorder(lb);
		tfpass.setBorder(lb);
		tfid.setBounds(60, 10, 315, 45);
		tfpass.setBounds(60, 60, 315, 45);

		jbok = new JButton("�α���");
		jbok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String state="";
				String name="";
				if (a==true && ReservationDao.getInstnace().buyeridserch(tfid.getText(),String.valueOf(tfpass.getText())).equals(tfid.getText())) {/// DB�� �ִ� ID�� PASS�� ���ؼ� ��ġ�ϸ� �α���
					main.initmypage();
					Login.this.dispose();
					main.setId(tfid.getText());
					main.setLoginCheck(true);//�����ڴ�
					state="������";
					name=ReservationDao.getInstnace().selectNameBuyer(tfid.getText());
				}else if(a==false && ReservationDao.getInstnace().selleridserch(tfid.getText(),String.valueOf(tfpass.getText())).equals(tfid.getText())) {/// DB�� �ִ� ID�� PASS�� ���ؼ� ��ġ�ϸ� �α���
					main.initmypage();
					Login.this.dispose();
					System.out.println("�Ǹ��ڷα��� Ȯ��");
					main.setId(tfid.getText());
					main.setLoginCheck(true);//seller
					state="�Ǹ���";
					name=ReservationDao.getInstnace().selectNameSeller(tfid.getText());
				}else {
					JOptionPane.showMessageDialog(Login.this, "���̵�,��й�ȣ�� ���� �ʽ��ϴ�.");
					return;
				}
				
				main.getJlbName().setText(state+" "+name+" �� ȯ���մϴ�.");
				main.setMemberState(state);
				main.getJlbName().setVisible(true);
			}
		});

		jbok.setFont(new Font("�������", Font.BOLD, 15));
		jbok.setBounds(20, 190, 355, 45);
		jbok.setBorder(null);
		jbok.setForeground(Color.WHITE);
		jbok.setBackground(new Color(255, 90, 95));
		
		jbbuyer = new JButton("������"); ///�������� ��ư ����
		jbbuyer.setBorder(lb);
		jbbuyer.setFont(new Font("�������", Font.BOLD, 15));
		jbbuyer.setForeground(new Color(255, 90, 95));
		jbbuyer.setBackground(Color.WHITE);
		jbbuyer.setOpaque(true);
		jbbuyer.setBounds(20,120, 170, 50);
		jbbuyer.addActionListener(this);
		
		jbseller = new JButton("�Ǹ���");///�Ǹ����� ��ư ����
		jbseller.setBorder(lb);
		jbseller.setFont(new Font("�������", Font.BOLD, 15));
		jbseller.setForeground(new Color(255, 90, 95));
		jbseller.setBackground(Color.WHITE);
		jbseller.setOpaque(true);
		jbseller.setBounds(200, 120, 170, 50);
		jbseller.addActionListener(this);
		
		
		this.add(jlid);
		this.add(jlpass);
		this.add(tfid);
		this.add(tfpass);
		this.add(jbok);
		this.add(jbbuyer);
		this.add(jbseller);
		this.add(jp);
	}

	public Login(Main main) {
		super("�α���");
		this.main = main;
		initLayEx();
		this.setBackground(Color.WHITE);
		this.setResizable(false);
		this.setBounds(350, 200, 400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Login(new Main());
	}

}