package pers.hyu.bookmanagement.service.implement;

import java.util.List;

import pers.hyu.bookmanagement.entity.User;
import pers.hyu.bookmanagement.service.UserService;

/**
 * user登陆接口的实现类 返回user在userlist中的index， -1表示用户不存在
 * 
 * @author hyu
 */
public class UserServiceImpl implements UserService {

	@Override
	public int login(List<User> userList, User user) {
		int result = -1;
		for (User u : userList) {
			if (user.getUserName().equals(u.getUserName()) && user.getPassword().equals(u.getPassword())) {
				result = userList.indexOf(u);
				break;
			}
		}
		return result;
	}

}
