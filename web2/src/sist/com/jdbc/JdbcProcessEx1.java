package sist.com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import sist.service.util.ServiceUtil;

public class JdbcProcessEx1 {
	private Scanner scan=new Scanner(System.in);
	Connection connection=ServiceUtil.getConnection();
	
	
	public void createProcess() {
		try {
			StringBuffer sb=new StringBuffer();
			sb.append("CREATE TABLE EUNJUNG( ")
			.append("NO NUMBER(5), ")
			.append("MESSAGE VARCHAR2(20))");
			PreparedStatement preparedStatement=connection.prepareStatement(sb.toString());//����ϴ� ��
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void addProcess() {
		LoginMember loginMember=new LoginMember();
		System.out.println("ID : ");
		loginMember.setId(scan.next());
		System.out.println("Pass : ");
		loginMember.setPass(scan.next());
		System.out.println("NAME : ");
		loginMember.setName(scan.next());
		System.out.println("Addr : ");
		loginMember.setAddr(scan.next());
		System.out.println(loginMember);
		LoginMemberDao.getInstance().addMember(loginMember);
	}
	public void listMember() {
		for(LoginMember i:LoginMemberDao.getInstance().selectMember()) {
			System.out.println(i);
		}		
	}
	public void deleteMember() {
		System.out.println("Delete id : ");
		String id=scan.next().trim();
		int rs=LoginMemberDao.getInstance().memberDelete(id);
		System.out.println(rs>0?"Delete Success":"Not Found");
	}
	public void modifyMember() {
		LoginMember loginMember=new LoginMember();
		System.out.println("SearchId : ");
		loginMember.setId(scan.next());
		System.out.println("ModifyPass : ");
		loginMember.setPass(scan.next());
		System.out.println("ModifyNAME : ");
		loginMember.setName(scan.next());
		System.out.println("ModifyAddr : ");
		loginMember.setAddr(scan.next());
		System.out.println(loginMember);
		int rs=LoginMemberDao.getInstance().modifyMember(loginMember);
		System.out.println(rs>0?loginMember.getId()+"�� ����":"Not Found");
	}
	public void infoMember() {
		System.out.println("Info ID : ");
		String id=scan.next().trim();
		LoginMember m=LoginMemberDao.getInstance().infoMember(id);
		System.out.println(m==null?"NotFoundElement":m);
	}
/*	public void modifyMember() {
		System.out.println("���� �� �������� id : ");
		String id=scan.next();
		System.out.println("������ ��? 1.id 2.password 3.name 4.address");
		String change=null;
		switch (scan.nextInt()) {
		case 1:
			System.out.println("������ ID �� : ");
			change=scan.next();
			LoginMemberDao.getInstance().modifyMember(id,"id",change);
			break;
		case 2:
			System.out.println("������ PASSWORD �� : ");
			change=scan.next();
			LoginMemberDao.getInstance().modifyMember(id,"pass",change);
			break;
		case 3:
			System.out.println("������ name �� : ");
			change=scan.next();
			LoginMemberDao.getInstance().modifyMember(id,"name",change);
			break;

		default:
			break;
		}
		
	}
*/	
	/*public void login() {
		System.out.println("Login ID ? :");
		String id=scan.next().trim();
		System.out.println("Login Password ? :");
		String pw=scan.next().trim();
		
	}*/
	public void loginCheck() {
		String id,pass;
		System.out.println("login ID:");
		id=scan.next().trim();
		System.out.println("login PW: ");
		pass=scan.next().trim();
		
		HashMap<String,String>map=new HashMap<String,String>();
		map.put("id", id);
		map.put("pass",pass);
		System.out.println(LoginMemberDao.getInstance().loginMemberCheck(map)?"LoginSuccess":"LoginFail");
	}
	public void printDb() {
		while(true) {
			System.out.println("1.create table 2.add member 3.List 4.Delete 5.Modify 6.Info 7.Login");
			switch (scan.nextInt()) {
			case 1:
				createProcess();
				break;
			case 2:
				addProcess();
				break;
			case 3:
				listMember();
				break;
			case 4:
				deleteMember();
				break;
			case 5:
				modifyMember();
				break;
			case 6:
				infoMember();
				break;
			case 7:
				loginCheck();
				break;
			default:
				break;
			}
		}
	}
	public static void main(String[] args) {
		new JdbcProcessEx1().printDb();
	}
}
