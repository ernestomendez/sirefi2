package mx.com.dxesoft.sirefi2;

import mx.com.dxesoft.sirefi2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@SpringBootApplication
public class Sirefi2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sirefi2Application.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository) throws Exception {
		builder.userDetailsService(username -> new CustomUserDetails(userRepository.findUserByEmail(username)));
	}
}
