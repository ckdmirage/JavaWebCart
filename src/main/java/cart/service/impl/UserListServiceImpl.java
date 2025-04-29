package cart.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import cart.dao.UserListDAO;
import cart.dao.impl.UserListDaoImpl;
import cart.model.dto.UserDTO;
import cart.model.entity.User;
import cart.service.UserListService;

public class UserListServiceImpl implements UserListService{
	private UserListDAO userListDao = new UserListDaoImpl();
	
	public List<UserDTO> findAllUsers(){
		List<User> users = userListDao.findAllUsers();
		List<UserDTO> userDtos = users.stream()
				.map(user->new UserDTO(user.getId(),user.getUsername(),user.getEmail(),user.getCompleted()))
				.collect(Collectors.toList());
				
		return userDtos;
	}
}
