package team.project.reservation;

public class MemberInfoBuyer {
	private String buyerid;
	private String password;
	private String name;
	private String tel;
	private String gender;
	public String getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
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
	@Override
	public String toString() {
		return "MemberInfoBuyer [buyerid=" + buyerid + ", password=" + password + ", name=" + name + ", tel=" + tel
				+ ", gender=" + gender + "]";
	}
	
	
}
