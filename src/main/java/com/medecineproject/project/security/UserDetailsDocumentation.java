//package com.medecineproject.project.security;
//
//import com.medecineproject.project.model.User;
//import com.medecineproject.project.service.UserService;
//import com.medecineproject.project.service.impl.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service("UserDetailServiceImpl")
//public class UserDetailsDocumentation implements UserDetailsService {
//    @Autowired
//    private final UserService service = new UserServiceImpl();
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        User user = service.readByLogin(login);
//        return SecurityUser.fromUser(user);
//    }
//}
