package com.f7dec8.iam.security;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    public CustomAuthenticationFailureHandler() {
        super();
        setDefaultFailureUrl("/");
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        log.debug("#### authentication failure exception: {}", exception);

        saveException(request, exception);

        String referer = request.getHeader(HttpHeaders.REFERER);

        RedirectStrategy strategy = getRedirectStrategy();
        strategy.sendRedirect(request, response, referer + "?error");
//        request.getRequestDispatcher("/login?error").forward(request, response);

//        super.onAuthenticationFailure(request, response, exception);
    }

}
