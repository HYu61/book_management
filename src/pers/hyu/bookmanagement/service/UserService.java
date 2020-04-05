package pers.hyu.bookmanagement.service;

import java.util.List;
import pers.hyu.bookmanagement.entity.User;

public interface UserService {
	public int login(List<User> userList, User user);
}
