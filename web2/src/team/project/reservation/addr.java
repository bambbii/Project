package team.project.reservation;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



public class addr extends JFrame implements ActionListener {///주소에대한 처리값들
	private JButton jbtn,jbtn1;
	private JTable jta;
	private JTextField jtf,jtf1;
	private JPanel jpal;
	private JLabel jla,jla1;
	private JOptionPane jop;
	private Join join;
	private MypageSeller mypageSeller;
	
	
	
	
	
	public addr() throws HeadlessException {
		super();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("검색")) {
			if(jtf.getText().trim().length()==0){
				JOptionPane.showMessageDialog(this,"존재하지 않는 동입니다. 다시 입력해주세요");
				return;
			}else
			ReservationDao.getInstnace().selectZip(jtf.getText().trim(),jta);
		}
		if(e.getActionCommand().equals("확인")) {
			if(join!=null) {
			int row = jta.getSelectedRow();
			addrBean bean=(ReservationDao.getInstnace().selectBean(ReservationDao.getInstnace().getSbean(row)));
			join.getTfaddr1().setText(bean.getSido()+bean.getGugun()+bean.getDong()+bean.getBunji());
			addr.this.dispose();
			}else {
				int row = jta.getSelectedRow();
				addrBean bean=(ReservationDao.getInstnace().selectBean(ReservationDao.getInstnace().getSbean(row)));
				mypageSeller.getJtfAddr().setText(bean.getSido()+bean.getGugun()+bean.getDong()+bean.getBunji());
				addr.this.dispose();
					
			}
		}
	}


	public void initlay() {
		this.setLayout(new BorderLayout());
		
		jpal  = new JPanel();
		
		
		jpal.add(jla=new JLabel("동을 입력해 주세요"));
		jpal.add(jtf=new JTextField(20));
		jpal.add(jbtn=new JButton("검색"));
		jpal.add(jbtn1=new JButton("확인"));
		jbtn.addActionListener(this);
		jbtn1.addActionListener(this);
		
		
		
		this.add("North",jpal);
		this.add(new JScrollPane(jta=new JTable(),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
		
	}
	
	
	public addr(Join join) {
		this.join=join;
		initlay();
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


	public addr(MypageSeller mypageSeller) {
		// TODO Auto-generated constructor stub
		this.mypageSeller=mypageSeller;
		initlay();
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
}
