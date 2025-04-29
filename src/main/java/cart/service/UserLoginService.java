package cart.service;

import cart.model.dto.UserDTO;

public interface UserLoginService {
	UserDTO login(String username, String password, String authCode, String sessionAuthCode);
}
