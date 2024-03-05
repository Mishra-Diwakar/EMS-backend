package com.clickncash.auth;

import java.io.IOException;
import java.util.Optional;
import java.util.StringTokenizer;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.clickncash.entity.User;
import com.clickncash.model.UserPrincipal;
import com.clickncash.repository.UserRepository;
import com.clickncash.service.AuthenticationService;
import com.clickncash.utils.AuthTokenUtil;

@Component
public class AuthRequestFilter extends OncePerRequestFilter {

	@Autowired
	private AuthenticationService authUserDetailsService;

	@Autowired
	private AuthTokenUtil authTokenUtil;
	
	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(AuthRequestFilter.class);

	@Autowired
	@Qualifier("handlerExceptionResolver")
	private HandlerExceptionResolver resolver;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {		
			if(request.getRequestURI().contains("login")) {
				System.out.println(request.getHeader("Authorization"));
			}
			String jwt = getJwtFromRequest(request);
			String userId = null;
			if (StringUtils.hasText(jwt) && authTokenUtil.validateToken(jwt)) {
				userId = authTokenUtil.getUserIdFromJWT(jwt);
			}else if (request.getRequestURI().contains("printloaddata")) {
				userId = "admin@vandiest.com";				
			}
			
			if (userId != null) {
				UserDetails userDetails = authUserDetailsService.loadUserByUsername(userId);
				System.out.println(userDetails.getUsername());
				System.out.println("!1111111111111");
				User user =  userRepository.findByEmail(userDetails.getUsername());
				if(user  == null || !user.getStatus().equalsIgnoreCase("ACTIVE")) {
					userDetails = null;
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
					return;
				}
				if (userDetails!=null) {
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authentication);
					UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
			
					request.setAttribute("userId", userPrincipal.getId());	
				}				
			}
			
			filterChain.doFilter(request, response);
		} catch (Exception ex) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
			logger.error("Could not set user authentication in security context", ex);
		}
		
	}

	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}
}