package webapp.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean isUserValid(String user, String password) {
		if(user.toLowerCase().equals("toheeb") && password.toLowerCase().equals("abc123")) {
			System.out.println("valid");
			return true;
			
		}
		System.out.println("invalid");
		return false;
	}
}
