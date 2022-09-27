package com.xoriant.enrollmentapplication.springJWT.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xoriant.enrollmentapplication.entities.User;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private int userId;

  private String emailId;

  @JsonIgnore
  private String password;

  public UserDetailsImpl(int userId, String emailId, String password) {
    this.userId = userId;
    this.emailId = emailId;
    this.password = password;
  }

  public static UserDetailsImpl build(User user) 
  {
    return new UserDetailsImpl(
        user.getUserId(), 
        user.getEmailId(),
        user.getUserPassword());
  }
 

  public String getEmailId() {
    return emailId;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return emailId;
}

@Override
public boolean equals(Object o) {
  if (this == o)
    return true;
  if (o == null || getClass() != o.getClass())
    return false;
  UserDetailsImpl user = (UserDetailsImpl) o;
  return Objects.equals(userId, user.userId);
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

}
