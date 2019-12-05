package com.stackroute.accountmanager.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.accountmanager.exception.UserAlreadyExistsException;
import com.stackroute.accountmanager.exception.UserIdAndPasswordMismatchException;
import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.exception.UserNullException;
import com.stackroute.accountmanager.model.AccountManagerModel;
import com.stackroute.accountmanager.service.AccountManagerService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/gifs")

public class AccountManagerController {
	private static final Logger logger = LoggerFactory.getLogger(AccountManagerController.class.getName());	
	static final long EXPIRATIONTIME = 3000000;
	Map<String, String> map = new HashMap<>();
	@Autowired
	AccountManagerService accountManagerService;
	public AccountManagerController(AccountManagerService accountManagerService ) {
		this.accountManagerService=accountManagerService;
		
	}
	
	//create User
	@PostMapping("/register")
	public ResponseEntity<String> registerUserToDB(@RequestBody AccountManagerModel accountManager) throws UserAlreadyExistsException {
    	logger.info("UserAuth registerUserToDB");
		try {
			accountManager.setUserAddedDate(new Date());
			this.accountManagerService.saveUser(accountManager);
			
		}
		
		catch(UserAlreadyExistsException ex) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);

	}
	
	//login validation
	@PostMapping("/login")
	ResponseEntity<?> login(@RequestBody AccountManagerModel accountManager) throws UserIdAndPasswordMismatchException{
		logger.info("login method called");
		String jwtToken = "";
		try {
			logger.info("If calling");
    		jwtToken = getToken(accountManager.getUserId(), accountManager.getUserPassword());
    		map.clear();
			map.put("message", "user successfully logged in");
			map.put("token", jwtToken);
    		
    	}catch(Exception ex) {
    		String exceptionMessage = ex.getMessage();
			map.clear();
			map.put("token", null);
			map.put("message", exceptionMessage);
			return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
    		
    	}
    	return new ResponseEntity<>(map, HttpStatus.OK);
		
	}
	
	 // Generate JWT token
    public String getToken(String username, String password) throws UserNullException, UserNotFoundException {
    	logger.info("User Name::"+username+" password::"+password);
		if (username == null || password == null) {
			throw new UserNullException("Please fill in username and password");
		}

		AccountManagerModel accountManager= accountManagerService.findByUserIdAndPassword(username, password);

		if (accountManager==null) {
			throw new UserNotFoundException("UserNotFoundException");
		}
		

		String jwtToken = Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

		
		
		return jwtToken;
    }


        


}
