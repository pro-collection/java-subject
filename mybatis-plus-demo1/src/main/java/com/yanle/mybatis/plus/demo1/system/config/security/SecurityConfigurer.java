package com.yanle.mybatis.plus.demo1.system.config.security;

import com.yanle.mybatis.plus.demo1.common.base.Constants;
import com.yanle.mybatis.plus.demo1.system.config.filter.ValidateCodeFilter;
import com.yanle.mybatis.plus.demo1.system.config.security.handler.AuthenticationFailureHandler;
import com.yanle.mybatis.plus.demo1.system.config.security.handler.AuthenticationSuccessHandler;
import com.yanle.mybatis.plus.demo1.system.config.security.handler.CustomLogoutSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    /**
     * 最大登录数
     */
    @Value("${security.max-session}")
    private Integer maxSession;

    /**
     * 超出最大登录数，是否阻止登录
     */
    @Value("${security.prevents-login}")
    private Boolean preventsLogin;

    private final UserDetailServiceImpl userDetailService;

    private final CustomAuthenticationProvider customAuthenticationProvider;

    // todo
    private final ValidateCodeFilter validateCodeFilter;

    private final CustomInvalidSessionStrategy customInvalidSessionStrategy;

    private final CustomExpiredSessionStrategy customExpiredSessionStrategy;

    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    private final AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private SessionRegistry sessionRegistry;

    @Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers()
                .frameOptions()
                .disable();

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/static/**", "/favicon.ico", "/actuator/**", "/code", "/invalid_session", "/expired", "/logout", "/403").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                // form 登录
                .formLogin()
                .loginProcessingUrl(Constants.LOGIN_URL)
                .loginPage(Constants.LOGIN_URL)
                .permitAll()
                .and()
                .csrf().disable()
                .cors()
                .and()
                // 登出
                .logout()
                .logoutUrl(Constants.LOGOUT_URL)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler()

    }
}
