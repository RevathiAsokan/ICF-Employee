package com.icf.employee.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

public class AuthenticationTokenFilter extends OncePerRequestFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationTokenFilter.class);

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private TokenUtil jwtTokenUtil;

	@Value("${jwt.header}")
	private String tokenHeader;

	@Value("${employee.app.url}")
	private String appUrl;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException,
			IOException {
		final String requestHeader = request.getHeader(this.tokenHeader);

		final String origin = request.getHeader("Origin");
		LOGGER.trace("Origin={}", origin);

		LOGGER.trace("appUrl={}", appUrl);
		LOGGER.trace("URI={}", request.getRequestURI());
		LOGGER.trace("PathInfo={}", request.getPathInfo());
		LOGGER.trace("ServletPath={}", request.getServletPath());

		if ( true ) {
			String email = null;

			String authToken = null;
			if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
				authToken = requestHeader.substring(7);
				try {
					email = jwtTokenUtil.getEmailFromToken(authToken);
				} catch (IllegalArgumentException e) {
					LOGGER.error("an error occured during getting username from token", e);
				} catch (ExpiredJwtException e) {
					LOGGER.warn("the token is expired and not valid anymore", e);
				}
			} else {
				logger.warn("couldn't find bearer string, will ignore the header");
			}

			LOGGER.debug("checking authentication for user {}", email);
			if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				// It is not compelling necessary to load the use details from the database. You
				// could also store the information in the token and read it from it. It's up to
				// you ;)
				UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);

				if (jwtTokenUtil.validateToken(authToken, userDetails)) {
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					LOGGER.info("authenticated user {}, setting security context", email);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}

			chain.doFilter(request, response);
		} else {
			LOGGER.error("Someone tried to bypass security");
			throw new SecurityException("Not Allowed! You are trying to bypass security");
		}
	}

}
