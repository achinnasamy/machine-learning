package com.dmac.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;

@WebServlet("/oauthAuthorize")
public class OAuthServerAuthorize extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response)
	throws ServletException, IOException 
	{
		  
		try {
			OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(request);
			
			OAuthIssuer oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
			String authorizationCode = oauthIssuerImpl.authorizationCode();
			
			OAuthResponse resp = OAuthASResponse
								.authorizationResponse(request, HttpServletResponse.SC_FOUND)
								.location("/MATH180")
								.buildQueryMessage();
	
			
			
		} catch (OAuthSystemException | OAuthProblemException e) {
			
			e.printStackTrace();
		}
	}

	
}
