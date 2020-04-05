package pers.hyu.bookmanagement.entity;

import java.io.Serializable;

/**
 * User的Java Bean类
 * 
 * @author hyu
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	// 用户名, 密码
	private String userName;
	private String password;

	/**
	 * User的无参构造方法
	 */
	public User() {
		super();
	}

	/**
	 * User的带参构造方法
	 * 
	 * @param userName 用户名
	 * @param password 用户密码
	 */
	public User(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
	}

	// get 和 set 方法
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
}
