package sist.com.model;

public class ManageInputBean {
	private int no;
	private String name;
	private int value;
	private int code;
	private String indate;
	
	
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
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "ManageInputBean [no=" + no + ", name=" + name + ", value=" + value + ", code=" + code + ", indate="
				+ indate + "]";
	}

	
	
}
