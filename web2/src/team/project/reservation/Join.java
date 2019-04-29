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
	private String gender="����";//��ư ���� ������ ���� string�� ��
	private boolean flag;
	//private JOptionPane jop;
	
	
	@Override
	public void focusGained(FocusEvent g) {
		// TODO Auto-generated method stub
		if(g.getComponent()==tfid) {///  ȸ������ �ؽ�Ʈ �ʵ忡 ��Ŀ���� ���� �ʵ� ���� �������� ����
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



	public JTextField getTfaddr1() {///�ּ��ʵ� �ؽ�Ʈ �⺻���� ��ȯ����
		return tfaddr1;
	}



	public void setTfaddr1(JTextField tfaddr1) {
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jbback) {///ó������ ��ư�� �������� ȭ���� ������� �ؼ� ùȭ���� ����������
			dispose();
			
		}
		if(e.getSource()==jbaddr) {///�ּ�ã�� ��ư�� �������� ���ο� ���� �����Ǹ鼭 �ּҸ� ã�� ����
			new addr(this);
		}
		
	}
	


	public void initLayEx() {
		jp = new JPanel(null);
		jp.setBackground(Color.WHITE);
		jp.setBounds(0, 0, 500, 600);

		jbbuyer = new JButton("������");
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
		jbbuyer.setFont(new Font("�������", Font.BOLD, 15));
		jbbuyer.setBorder(null);
		jbbuyer.setForeground(Color.WHITE);
		jbbuyer.setBackground(new Color(255, 90, 95));
		jbbuyer.setBounds(7, 10, 240, 50);
		jbseller = new JButton("�Ǹ���");
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
				tfaddr2.setText("���ּ�");
			
			}
		});
		jbseller.setFont(new Font("�������", Font.BOLD, 15));
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

		jl = new JLabel("�����غ� ���� ���� ȯ���մϴ�");
		jl.setFont(new Font("�������", Font.BOLD, 20));
		jl.setHorizontalAlignment(JLabel.CENTER);
		jl.setBounds(7, 20, 470, 50);
		LineBorder lb = new LineBorder(new Color(235, 235, 235));
		
		//���̵� �Է� �ؽ�Ʈ �ʵ�
		tfid = new JTextField("ID");
		tfid.setBorder(lb);
		tfid.setBounds(7, 70, 470, 50);
		/*tfid.setFont(new Font("�������",.BOLD, 15));*/
		tfid.addFocusListener(this);
		//��й�ȣ �Է� �ؽ�Ʈ �ʵ�
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
		//�̸� �Է� �ؽ�Ʈ �ʵ�
		tfname = new JTextField("NAME");
		tfname.setBorder(lb);
		tfname.setBounds(7, 220, 470, 50);
		tfname.addFocusListener(this);
		//��ȭ��ȣ �Է� �ؽ�Ʈ �ʵ�
		tfphone = new JTextField("PHONE");
		tfphone.setBorder(lb);
		tfphone.setBounds(7, 270, 470, 50);
		tfphone.addFocusListener(this);
		//���� ����
		//���� / ���� ���� ���еǾ� �̺�Ʈ �߻�
		jbman = new JButton("����"); //
		jbman.setBorder(lb);
		jbman.setFont(new Font("�������", Font.BOLD, 15));
		jbman.setForeground(new Color(255, 90, 95));
		jbman.setBackground(Color.WHITE);
		jbman.setOpaque(true);
		jbman.setBounds(7, 320, 235, 50);

		jbman.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stubf
				//�׽�Ʈ �ڵ�
				System.out.println(e.getSource());
				//
				jbwoman.setForeground(new Color(255, 90, 95));
				jbwoman.setBackground(Color.WHITE);
				jbwoman.setBorder(lb);
				jbman.setForeground(Color.WHITE);
				jbman.setBackground(new Color(255, 90, 95));
				gender="����";///���ڹ�ư�� �������� ���� ���ڷ� ��������
			}
		});
		jbwoman = new JButton("����");
		jbwoman.setBorder(null);
		jbwoman.setFont(new Font("�������", Font.BOLD, 15));
		jbwoman.setForeground(Color.WHITE);
		jbwoman.setBackground(new Color(255, 90, 95));
		jbwoman.setBounds(242, 320, 235, 50);
		jbwoman.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//�׽�Ʈ �ڵ�
				System.out.println(e.getSource());
				//
				// TODO Auto-generated method stub
				jbman.setForeground(new Color(255, 90, 95));
				jbman.setBackground(Color.WHITE);
				jbman.setBorder(lb);
				jbwoman.setForeground(Color.WHITE);
				jbwoman.setBackground(new Color(255, 90, 95));
				gender="����";///���ڹ�ư�� �������� ���� ���ڷ� ��������
			}
		});

		tfaddr1 = new JTextField("�⺻�ּ�");
		tfaddr1.setBorder(lb);
		tfaddr1.setBounds(7, 370, 235, 50);
		tfaddr1.setVisible(false);
		tfaddr1.setEnabled(false);
		tfaddr2 = new JTextField("���ּ�");
		tfaddr2.setBorder(lb);
		tfaddr2.setBounds(240, 370, 168, 50);
		tfaddr2.setVisible(false);
		tfaddr2.addFocusListener(this);
		jbaddr = new JButton("�ּ�ã��");
		jbaddr.addActionListener(this);
		jbaddr.setBorder(lb);
		jbaddr.setBounds(407, 370, 70, 50);
		jbaddr.setVisible(false);
		jbaddr.setBorder(lb);
		jbaddr.setFont(new Font("�������", Font.BOLD, 13));
		jbaddr.setForeground(Color.WHITE);
		jbaddr.setBackground(new Color(255, 90, 95));

		jbback = new JButton("ó������");
		jbback.addActionListener(this);
		jbback.setBorder(null);
		jbback.setForeground(Color.WHITE);
		jbback.setBackground(new Color(136, 136, 136));
		jbback.setFont(new Font("�������", Font.BOLD, 15));
		jbback.setBounds(107, 450, 125, 50);
		jbok = new JButton("Ȯ��");
		jbok.addActionListener(this);
		jbok.setBorder(null);
		jbok.setForeground(Color.WHITE);
		jbok.setBackground(new Color(255, 90, 95));
		jbok.setFont(new Font("�������", Font.BOLD, 15));
		jbok.setBounds(252, 450, 135, 50);
		jbok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if (jbbuyer.getBackground() == Color.white) {///��й�ȣ�� �� Ʋ������ �ٽ� ��й�ȣ �ʵ�� ���ư��� �ٽ�������
					System.out.println("ttttt");
					if(!(tfpass1.getText().equals(tfpass2.getText()))) {
						JOptionPane.showMessageDialog(null, "��й�ȣ�� Ȯ�����ּ���");
						tfpass1.setText("");
						tfpass2.setText("");
						tfpass1.requestFocus();
						}else if(!tfid.getText().equals("")) {
							flag=ReservationDao.getInstnace().sellerIdCheck(tfid.getText());
							if(flag==true) {
								JOptionPane.showMessageDialog(null,"�̹� ������� ���̵� �Դϴ�.");
								tfid.setText("");
								tfid.requestFocus();
							}else if(flag==false) {
								insertSeller();
								dispose();
							}
						}
				} else if (jbseller.getBackground() == Color.white) {
					//�����ڰ� ȸ�� ���Խ� 
					//Ȯ�� ��ư�� ������ �߻��Ǵ� �̺�Ʈ!!!
					System.out.println("hello~");
					if(!(tfpass1.getText().equals(tfpass2.getText()))) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ȯ�����ּ���");
					tfpass1.setText("");
					tfpass2.setText("");
					tfpass1.requestFocus();
					
					}else if(!tfid.getText().equals("")) {
						flag=ReservationDao.getInstnace().buyerIdCheck(tfid.getText());
						if(flag==true) {
							
							JOptionPane.showMessageDialog(null,"�̹� ������� ���̵� �Դϴ�.");
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
		super("ȸ������");
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
	
	public void  insertBuyer() {///������ �����ͺ��̽� �����Է�
		joinBean buyerbean=new joinBean();
		buyerbean.setBuyerid(tfid.getText());
		buyerbean.setPassword(tfpass2.getText());
		buyerbean.setName(tfname.getText());
		buyerbean.setTel(tfphone.getText());
		buyerbean.setGender(gender);
		ReservationDao.getInstnace().insertBuyer(buyerbean);/////������ ������ Insert
	}
	public void insertSeller() {///�Ǹ��� �����ͺ��̽� �����Է�
		JoinBean2 sellerbean=new JoinBean2();
		sellerbean.setBuyerid(tfid.getText());
		sellerbean.setPassword(tfpass2.getText());
		sellerbean.setName(tfname.getText());
		sellerbean.setTel(tfphone.getText());
		sellerbean.setGender(gender);
		sellerbean.setZipcode(tfaddr1.getText()+tfaddr2.getText());
		ReservationDao.getInstnace().insertSeller(sellerbean);/////�Ǹ��� ������ Insert
	}
}