package de.krombacher.ebenerWebshop.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Bean
	public ObjectMapper mapper() {
	    ObjectMapper mapper = new ObjectMapper();
	    return mapper;
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException{
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
		PrintWriter writer = response.getWriter();
		
		response.addHeader("content-type", "application/json");
		response.setCharacterEncoding("UTF-8");
		mapper().writeValue(writer, auth.getPrincipal());
		response.setStatus(HttpServletResponse.SC_OK);
	}
}
