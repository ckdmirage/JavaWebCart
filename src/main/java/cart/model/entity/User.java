package cart.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Integer id;
	private String username;
	private String hashPassword;
	private String hashSalt;
	private String email;
	private Boolean completed;
}
