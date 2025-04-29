package cart.service.impl;

import cart.dao.UserLoginDAO;
import cart.dao.impl.UserLoginDaoImpl;
import cart.model.dto.UserDTO;
import cart.model.entity.User;
import cart.service.UserLoginService;
import util.HashUtil;

public class UserLoginServiceImpl implements UserLoginService{
	private UserLoginDAO userLoginDAO = new UserLoginDaoImpl();
	@Override
	public UserDTO login(String username, String password, String authCode, String sessionAuthCode) {
		if(!authCode.equals(sessionAuthCode)) {
			throw new RuntimeException("驗證碼不符");
		}
		User user = userLoginDAO.findUserByName(username);
		if(user==null) {
			throw new RuntimeException("用戶不存在");
		}
		boolean completed = user.getCompleted();
		if(!completed) {
			throw new RuntimeException("Emial尚未驗證");
		}
		try {
			String hashPassword = HashUtil.hashPassword(password, user.getHashSalt());
			boolean checkPassword = user.getHashPassword().equals(hashPassword);
			if(!checkPassword) {
				throw new RuntimeException("密碼錯誤");
			}
			
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setEmail(user.getEmail());
			userDTO.setCompleted(user.getCompleted());
			return userDTO;
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}

	}
}
