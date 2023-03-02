package com.fastcampus.projectadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http

    ) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .formLogin(withDefaults())
                .logout(logout -> logout.logoutSuccessUrl("/"))
                .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(UserAccountService userAccountService) {
//        return username -> userAccountService
//                .searchUser(username)
//                .map(BoardPrincipal::from)
//                .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다 - username: " + username));
//    }
//
//    /**
//     * <p>
//     * OAuth 2.0 기술을 이용한 인증 정보를 처리한다.
//     * 카카오 인증 방식을 선택.
//     *
//     * <p>
//     * TODO: 카카오 도메인에 결합되어 있는 코드. 확장을 고려하면 별도 인증 처리 서비스 클래스로 분리하는 것이 좋지만, 현재 다른 OAuth 인증 플랫폼을 사용할 예정이 없어 이렇게 마무리한다.
//     *
//     * @param userAccountService  게시판 서비스의 사용자 계정을 다루는 서비스 로직
//     * @param passwordEncoder 패스워드 암호화 도구
//     * @return {@link OAuth2UserService} OAuth2 인증 사용자 정보를 읽어들이고 처리하는 서비스 인스턴스 반환
//     */
//    @Bean
//    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService(
//            UserAccountService userAccountService,
//            PasswordEncoder passwordEncoder
//    ) {
//        final DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
//
//        return userRequest -> {
//            OAuth2User oAuth2User = delegate.loadUser(userRequest);
//
//            KakaoOAuth2Response kakaoResponse = KakaoOAuth2Response.from(oAuth2User.getAttributes());
//            String registrationId = userRequest.getClientRegistration().getRegistrationId();
//            String providerId = String.valueOf(kakaoResponse.id());
//            String username = registrationId + "_" + providerId;
//            String dummyPassword = passwordEncoder.encode("{bcrypt}" + UUID.randomUUID());
//
//            return userAccountService.searchUser(username)
//                    .map(BoardPrincipal::from)
//                    .orElseGet(() ->
//                            BoardPrincipal.from(
//                                    userAccountService.saveUser(
//                                            username,
//                                            dummyPassword,
//                                            kakaoResponse.email(),
//                                            kakaoResponse.nickname(),
//                                            null
//                                    )
//                            )
//                    );
//        };
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }

}
