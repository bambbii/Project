package team.project.reservation;

public class MemberSeller {
	
	private int houseno;
	private String sellerid;
	private String password;
	private String name;
	private String addr;
	private String tel;
	private String gender;
	private String visstate;
	private String buyerid;
	
	public int getHouseno() {
		return houseno;
	}
	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}
	public String getSellerid() {
		return sellerid;
	}
	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getVisstate() {
		return visstate;
	}
	public void setVisstate(String visstate) {
		this.visstate = visstate;
	}
	public String getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
	}
	@Override
	public String toString() {
		return "MemberSeller [houseno=" + houseno + ", sellerid=" + sellerid + ", password=" + password + ", name="
				+ name + ", addr=" + addr + ", tel=" + tel + ", gender=" + gender + ", visstate=" + visstate
				+ ", buyerid=" + buyerid + "]";
	}
	

}
