package com.xoriant.enrollmentapplication.springJWT.response;

public class JwtResponse 
{
	
	  private String token;
	  private String type = "Bearer";
	  private int userId;
	  private String emailId;


	  public JwtResponse(String accessToken, int userId, String emailId) {
	    this.token = accessToken;
	    this.userId = userId;
	    this.emailId = emailId;
	  }

	  public String getAccessToken() {
	    return token;
	  }

	  public void setAccessToken(String accessToken) {
	    this.token = accessToken;
	  }

	  public String getTokenType() {
	    return type;
	  }

	  public void setTokenType(String tokenType) {
	    this.type = tokenType;
	  }

	  public int getUserId() {
	    return userId;
	  }

	  public void setId(int userId) {
	    this.userId = userId;
	  }

	  public String getEmail() {
	    return emailId;
	  }

	  public void setEmail(String email) {
	    this.emailId = email;
	  }

}

