package cart.service;

public interface UserRegisterService {
	//新增User
	void addUser(String username, String password, String email);
	
	//email驗證成功
	void emailConfirmOK(String username);
}
