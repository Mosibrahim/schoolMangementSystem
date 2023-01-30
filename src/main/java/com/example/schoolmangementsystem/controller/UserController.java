package com.example.schoolmangementsystem.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.schoolmangementsystem.model.User;
import com.example.schoolmangementsystem.model.UserRole;
import com.example.schoolmangementsystem.repositories.UserRepository;
import com.example.schoolmangementsystem.repositories.UserRoleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@Data
@RequestMapping("/user")
public class UserController
{
	final UserRepository userRepo;
	final UserRoleRepository roleRepo;

	@GetMapping("/findAllUsers")
	public List<User> findAllUsers()
	{
		return userRepo.findAllUser();
	}

	@PostMapping("/saveUser")
	public void saveUser(User user)
	{
		userRepo.save(user);
	}

	@PostMapping("/saveRole")
	public void saveRole(UserRole role)
	{
		roleRepo.save(role);
	}

	@PostMapping("/addRoleToUser")
	@Transactional
	public void addRoleToUser(UserRole role, User user)
	{
		if (user.getRoles() == null)
			user.setRoles(new ArrayList<>());
		user.getRoles().add(role);
	}

	void onLoginSuccessfully(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException
	{
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
		authentication.getPrincipal();
		Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
		String accessToken = JWT.create().withSubject(user.getUsername()).withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
				.withIssuer(request.getRequestURL().toString())
				.withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList())).sign(algorithm);
		String refreshToken = JWT.create().withSubject(user.getUsername()).withExpiresAt(new Date(System.currentTimeMillis() + 100 * 60 * 1000))
				.withIssuer(request.getRequestURL().toString())
				.withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList())).sign(algorithm);
		Map<String, String> tokens = new HashMap<>();
		tokens.putIfAbsent("ACCESS_TOKEN", accessToken);
		tokens.putIfAbsent("REFRESH_TOKEN", refreshToken);
		response.setContentType(APPLICATION_JSON_VALUE);
		new ObjectMapper().writeValue(response.getOutputStream(), tokens);

	}
}
