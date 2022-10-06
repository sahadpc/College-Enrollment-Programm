package com.xoriant.enrollmentapplication.springJWT.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.enrollmentapplication.Repository.UserDao;
import com.xoriant.enrollmentapplication.entities.User;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserDao userRepositoryDao;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepositoryDao.findByEmailId(username);
    return UserDetailsImpl.build(user);
  }
}
