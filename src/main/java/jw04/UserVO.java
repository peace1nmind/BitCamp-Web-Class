package jw04;
// W D 

public class UserVO {

	// Field
	private String id;
	private String pwd;
	private boolean active;

	
	// Constructor
	public UserVO() {
	}
	
	public UserVO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}


	// Method
	@Override
	public String toString() {
		return String.format("UserVO [id=%s, pwd=%s, active=%b]", id, pwd, active);
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
	

}
// class end
