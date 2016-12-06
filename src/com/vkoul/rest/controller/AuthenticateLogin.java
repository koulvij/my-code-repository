package com.vkoul.rest.controller;
/*package com.cov.nagarro.rest.controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cov.nagarro.rest.util.TokenTransfer;

@RestController
public class AuthenticateLogin {
	
	
	@RequestMapping(value="authenticate",method = RequestMethod.POST)

	public TokenTransfer authenticate(@FormParam("username") String username, @FormParam("password") String password)
	{
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(username, password);
		Authentication authentication = this.authManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		
		 * Reload user as password of authentication principal will be null after authorization and
		 * password is needed for token generation
		 
		UserDetails userDetails = this.userService.loadUserByUsername(username);

		return new TokenTransfer(TokenUtils.createToken(userDetails));
	}

}
*/