package sist.com.jdbc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sist.com.dao.DemoDao;
import sist.com.model.EmpBean;

//1 EMP  2 STUDENT
public class JdbcProcessEx3 extends JFrame {

	private JScrollPane jsp;
	private JTable jtable;
	private JPanel jpn;
	private JtableModel jtablemodel=new JtableModel();
	private Object [][]data;
	private JLabel jlb;
	
	public void setEmp() {
		List<EmpBean>eb=DemoDao.selectEmp();
		data=new Object[eb.size()][jtablemodel.getColumnCount()];
		for (int i = 0; i < eb.size(); i++) {
			int j=0;
			EmpBean bean=eb.get(i);
			data[i][j++]=bean.getEmpno();
			data[i][j++]=bean.getEname();
			data[i][j++]=bean.getJob();
			data[i][j++]=bean.getMgr();
			data[i][j++]=bean.getHiredate();
			data[i][j++]=bean.getSal();
			data[i][j++]=bean.getComm();
			data[i][j++]=bean.getDeptno();
			
		}
		jtablemodel.setData(data);
	}
	public void initLayEx() {
		setEmp();
		jsp=new JScrollPane(jtable=new JTable(jtablemodel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add("Center",jsp);
		this.add("South", jlb=new JLabel(""));
		
		jtable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row=jtable.getSelectedRow();
				if(e.getClickCount()==2) {
					int empno=(int)jtablemodel.getValueAt(row, 0);
					EmpBean b=DemoDao.selectEmpInfo(empno);
					jlb.setText(b.getEmpno()+" "+b.getEname());
				}
			}
			
		});
	}
	
	public JdbcProcessEx3() {
		initLayEx();
		this.setBounds(100, 100, 600, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		new JdbcProcessEx3();
	}

}
