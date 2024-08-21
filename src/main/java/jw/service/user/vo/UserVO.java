package jw.service.user.vo;
// W D 

public class UserVO {

	// Field
	private String id;
	private String pwd;
	private boolean active;
	private int no;

	
	// Constructor
	public UserVO() {
	}
	
	public UserVO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}

	public UserVO(int no, String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.no = no;
	}
	

	// Method
	@Override
	public String toString() {
		return String.format("UserVO [id= %s, pwd= %s, active= %b, no= %d]", id, pwd, active, no);
	}
	
	
	// Getter Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

}
// class end
