package sist.com.ui.login;

import java.io.Serializable;

public class UserData implements Serializable{
	private String id;
	private String pw;
	private String nickname;
	private String email;
	
	public UserData() {
		super();
	}

	public UserData(String id, String pw, String nickname, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserData [id=" + id + ", pw=" + pw + ", nickname=" + nickname + ", email=" + email
				+ "]";
	}

	
	
	
}
