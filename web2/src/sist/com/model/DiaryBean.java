package sist.com.model;


public class DiaryBean {
	private int no;
	private String title;
	private String contents;
	private String feeling;
	private String weather;
	private String fileName;
	private int memberno;
	private String datediary;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getFeeling() {
		return feeling;
	}
	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDatediary() {
		return datediary;
	}
	public void setDatediary(String datediary) {
		this.datediary = datediary;
	}
	
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	@Override
	public String toString() {
		return "DiaryBean [no=" + no + ", title=" + title + ", contents=" + contents + ", feeling=" + feeling
				+ ", weather=" + weather + ", fileName=" + fileName + ", memberno=" + memberno + ", datediary="
				+ datediary + "]";
	}
	
	
	
	
}
