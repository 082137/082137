package com.f7dec8.shared.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

/**
 * 아래와 같이 {@link AuthenticationSuccessHanlder}를 등록한다.
 * 
 * <pre>
 * &#064;Primary
 * &#064;Component
 * &#064;@RequiredArgsConstructor
 * public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
 *  
 *    private final AuthenticationFailureHandlerProperties properties;
 *  
 *    &#064;PostConstruct
 *    public void init() {
 *        setUseForward(properties.isForwardToDestination());
 *        setAllowSessionCreation(properties.isAllowSessionCreation());
 *        setDefaultFailureUrl(properties.getDefaultFailureUrl());
 *    }
 *  
 *    &#064;Override
 *    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
 *          AuthenticationException exception) throws IOException, ServletException {
 *        
 *        // do something
 *        
 *        super.onAuthenticationSuccess(request, response, authentication);
 *    }
 *  
 * }
 * </pre>
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "spring.security.authentication.failure-handler")
public class AuthenticationFailureHandlerProperties {

    private boolean forwardToDestination = false;
    private boolean allowSessionCreation = true;

    private String defaultFailureUrl = "/";

}
