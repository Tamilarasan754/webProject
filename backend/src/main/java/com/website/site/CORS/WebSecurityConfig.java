// package com.website.site.CORS;

// import org.springframework.context.annotation.Bean;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import java.util.Arrays;

// @EnableWebSecurity
// public class WebSecurityConfig {

// 	//...

// 	@Bean
// 	CorsConfigurationSource corsConfigurationSource() {

// 		CorsConfiguration configuration = new CorsConfiguration();
// 		configuration.setAllowedOrigins(Arrays.asList("https://example.com"));
// 		configuration.setAllowedMethods(Arrays.asList("GET","POST"));
// 		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
// 		source.registerCorsConfiguration("/**", configuration);
// 		return source;
// 	}
// }
