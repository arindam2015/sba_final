package com.stackroute.gipherrecommendersystem.jwtfilter;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;






public class JwtFilter extends GenericFilterBean {

	
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	final HttpServletRequest req = (HttpServletRequest) request;
		final HttpServletResponse res= (HttpServletResponse) response;
		final String authHeader ="Bearer "+req.getHeader("authorization");
		System.out.println("authHeader::"+authHeader);
		if ("OPTIONS".equals(req.getMethod())) {
			res.setStatus(HttpServletResponse.SC_OK);
			chain.doFilter(request, response);
		}else {
			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				throw new ServletException("Missing or invalid Authorization header");
			}
			final String token = authHeader.substring(7);
			System.out.println("token::"+token);
			final Claims claims = Jwts.parser()
					  .setSigningKey("secretkey")
					  .parseClaimsJws(token)
					  .getBody();

           request.setAttribute("claims", claims);
           chain.doFilter(request, response);
		} 


    }
}
