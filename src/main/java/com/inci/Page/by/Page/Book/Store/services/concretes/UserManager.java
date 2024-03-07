package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.services.JwtService;
import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.entities.concretes.User;
import com.inci.Page.by.Page.Book.Store.repositories.UserRepository;
import com.inci.Page.by.Page.Book.Store.services.abstracts.UserService;
import com.inci.Page.by.Page.Book.Store.services.dtos.user.request.AddUserRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.user.request.LoginRequest;
import com.inci.Page.by.Page.Book.Store.services.rules.UserBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;
   // private final UserBusinessRule userBusinessRule;
    private final ModelMapperService modelMapperService;
    //private final MessageService messageService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public void register(AddUserRequest request) {

        //  Encoding password
        request.setPassword(passwordEncoder.encode(request.getPassword()));

        User user = modelMapperService.forRequest().map(request, User.class);
        userRepository.save(user);
    }

    @Override
    public String login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                (request.getUsername(),request.getPassword()));
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(request.getUsername());
        }
        throw new RuntimeException("Kullanıcı adı yada şifre yanlış!");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user found!"));
    }
}
