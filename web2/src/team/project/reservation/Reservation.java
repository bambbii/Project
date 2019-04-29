package team.project.reservation;

public class Reservation {
	
	private String buyerid;
	private int houseno;
	private String checkin;
	private String checkout;
	private String state;
	
	public String getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
	}
	public int getHouseno() {
		return houseno;
	}
	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "reservation [buyerid=" + buyerid + ", houseno=" + houseno + ", checkin=" + checkin + ", checkout="
				+ checkout + ", state=" + state + "]";
	}
	
	

}
