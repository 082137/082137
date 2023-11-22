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
 * public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
 *  
 *    private final AuthenticationSuccessHandlerProperties properties;
 *  
 *    &#064;PostConstruct
 *    public void init() {
 *        setAlwaysUseDefaultTargetUrl(properties.isAlwaysUseDefaultTargetUrl());
 *        setDefaultTargetUrl(properties.getDefaultTargetUrl());
 *        setTargetUrlParameter(properties.getTargetUrlParameter());
 *        setUseReferer(properties.isUseReferer());
 *    }
 *  
 *    &#064;Override
 *    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
 *          Authentication authentication) {
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
@ConfigurationProperties(prefix = "spring.security.authentication.success-handler")
public class AuthenticationSuccessHandlerProperties {

    private boolean alwaysUseDefaultTargetUrl = false;
    private boolean useReferer = true;

    private String defaultTargetUrl = "/";
    private String targetUrlParameter = "redirectUrl";

}
