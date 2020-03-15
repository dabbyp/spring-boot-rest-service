package com.agencyplatform.springboot.config.auth;

import com.agencyplatform.springboot.config.auth.dto.OAuthAttributes;
import com.agencyplatform.springboot.config.auth.dto.SessionUser;
import com.agencyplatform.springboot.domain.user.User;
import com.agencyplatform.springboot.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // oauth2 로그인 진행중인 서비스 구분용 (구글/네이버 등)
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        // oauth2 로그인 진행시 키가 되는 필드값을 의미 (구글:"sub")
        // 네이버,카카오 등은 지원하지 않음
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();
        // oauth2 로그인 성공 시, 사용자 정보를 담아온 클래스
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName,
                oAuth2User.getAttributes());
        // 특정속성(email 등)으로 사용자 정보를 업데이트 (구글 정보가 업데이트 되었을 경우, 동기화 목적)
        User user = saveOrUpdate(attributes);
        // 세션에 사용자 정보를 저장하기 위한 Dto 클래스 (세션에 담기위해 직렬화가 필요하기 때문에 별도의 SessionUser  클래스를 사용)
        httpSession.setAttribute("user", new SessionUser(user));

        return new DefaultOAuth2User(
                    Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                                    attributes.getAttributes(),
                                    attributes.getNameAttributeKey()
                );
    }

    private User saveOrUpdate(OAuthAttributes attributes) {
        User user = userRepository.findByEmail(attributes.getEmail())
                    .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
                    .orElse(attributes.toEntity());

        return userRepository.save(user);
    }
}
