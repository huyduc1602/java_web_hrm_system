package tsg.net.vn.hrmweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan({"tsg.net.vn.hrmweb.controller"})
@ComponentScan({"tsg.net.vn.hrmweb.service"})
public class HrmWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmWebApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
