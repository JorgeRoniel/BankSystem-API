package me.shrk.BankAccountAplication.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.shrk.BankAccountAplication.repositories.UserRepository;

@Component
public class SecurityFilter extends OncePerRequestFilter{

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        var token = recoveryToken(request);
        if(token != null){
            var login = tokenService.validateToken(token);
            UserDetails user = userRepository.findByEmail(login);

            var authorization = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authorization);
        }
        filterChain.doFilter(request, response);
    }

    private String recoveryToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null){
            return null;
        }else{
            return authHeader.replace("Bearer ", "");
        }
    }
    
}
