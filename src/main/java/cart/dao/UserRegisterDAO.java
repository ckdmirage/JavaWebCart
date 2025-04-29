package cart.dao;

import cart.model.entity.User;

public interface UserRegisterDAO {
	//新增用戶
	int addUser(User user);
	
	//email驗證成功並修改 complete = true
	int emailConfirmOK(String username);
	
	//
	
	
	//
	
	
	
}
