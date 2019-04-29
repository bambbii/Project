package team.project.reservation;

public class RoomInfomation {
	private int houseno;
	private int peoplecount;
	private int roomcount;
	private int bedcount;
	private String detailinfo;
	private String title;
	public int getHouseno() {
		return houseno;
	}
	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}
	public int getPeoplecount() {
		return peoplecount;
	}
	public void setPeoplecount(int peoplecount) {
		this.peoplecount = peoplecount;
	}
	public int getRoomcount() {
		return roomcount;
	}
	public void setRoomcount(int roomcount) {
		this.roomcount = roomcount;
	}
	public int getBedcount() {
		return bedcount;
	}
	public void setBedcount(int bedcount) {
		this.bedcount = bedcount;
	}
	public String getDetailinfo() {
		return detailinfo;
	}
	public void setDetailinfo(String detailinfo) {
		this.detailinfo = detailinfo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "roominfomation [houseno=" + houseno + ", peoplecount=" + peoplecount + ", roomcount=" + roomcount
				+ ", bedcount=" + bedcount + ", detailinfo=" + detailinfo + ", title=" + title + "]";
	}
	
	

}
