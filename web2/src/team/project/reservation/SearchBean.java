package team.project.reservation;

public class SearchBean {
	private String addr;
	private String checkIn;
	private String checkOut;
	private int count;
	
	
	
	public SearchBean() {
		super();
	}



	public SearchBean(String addr, String checkIn, String checkOut, int count) {
		super();
		this.addr = addr;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.count = count;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}



	public String getCheckIn() {
		return checkIn;
	}



	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}



	public String getCheckOut() {
		return checkOut;
	}



	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	@Override
	public String toString() {
		return "SearchBean [addr=" + addr + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", count=" + count
				+ "]";
	}
	
	
}
