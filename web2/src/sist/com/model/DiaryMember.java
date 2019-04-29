package sist.com.model;

public class DiaryMember {
	private int no;
	private String name;
	private String id;
	private String password;
	private String gender;
	
	
	
	public DiaryMember() {
		super();
	}
	public DiaryMember(int no, String name, String id, String password, String gender) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.password = password;
		this.gender = gender;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "DiaryMember [no=" + no + ", name=" + name + ", id=" + id + ", password=" + password + ", gender="
				+ gender + "]";
	}
	
	
	
	
}
