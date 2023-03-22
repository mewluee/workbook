package com.example.jwtsample;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.io.Decoders;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

//테스트 인스턴스란?
//설정된 테스트 단위로 테스트 객체를 만든다.
//
//테스트 인스턴스의 라이프 사이클을 설정할 때 사용한다.
//- PER_METHOD : test 함수 당 인스턴스가 생성된다. (이게 기본 설정인듯? > 테스트간 영향이 없다)
//- PER_CLASS : test 클래스 당 인스턴스가 생성된다.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JwtTokenizerTest {
    private static JwtTokenizer jwtTokenizer;
    private String secretKey;
    private String base64EncodedSecretKey;

    // (1)
    @BeforeAll
    public void init() {
        jwtTokenizer = new JwtTokenizer();
        secretKey = "kevin1234123412341234123412341234";  // encoded "a2V2aW4xMjM0MTIzNDEyMzQxMjM0MTIzNDEyMzQxMjM0"

        // secret key를 base64형식으로 인코딩
        base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(secretKey);
    }

    // (2) base64형식으로 인코딩이 정상적으로 수행이 되는지 테스트
    // decode시 원본이 일치하는지 확인하고 있다.
    @Test
    public void encodeBase64SecretKeyTest() {
        System.out.println(base64EncodedSecretKey);

        assertThat(secretKey, is(new String(Decoders.BASE64.decode(base64EncodedSecretKey))));
    }

    // (3) jwt tokenizer가 access token을 정상적으로 생성하는지 테스트
    // jwt는 생성할 때마다 값이 바뀌기 때문에, null이 아닌지만 확인한다.
    // 더 정확한 테스트는 jwt의 서명 검증에서 확인가능하다.
    @Test
    public void generateAccessTokenTest() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("memberId", 1);
        claims.put("roles", List.of("USER"));

        String subject = "test access token";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 10);
        Date expiration = calendar.getTime();

        String accessToken = jwtTokenizer.generateAccessToken(claims, subject, expiration, base64EncodedSecretKey);

        System.out.println(accessToken);

        assertThat(accessToken, notNullValue());
    }

    // (4) jwt tokenizer가 refresh token을 정상적으로 생성하는지 테스트
    // custom claims가 필요하지 않다는 것 외에 access token과 테스트 과정은 동일하다.
    @Test
    public void generateRefreshTokenTest() {
        String subject = "test refresh token";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 24);
        Date expiration = calendar.getTime();

        String refreshToken = jwtTokenizer.generateRefreshToken(subject, expiration, base64EncodedSecretKey);

        System.out.println(refreshToken);

        assertThat(refreshToken, notNullValue());
    }

    // (1)
    @DisplayName("does not throw any Exception when jws verify")
    @Test
    public void verifySignatureTest() {
        //밑에 선언한 메서드 호출
        String accessToken = getAccessToken(Calendar.MINUTE, 10);
        assertDoesNotThrow(() -> jwtTokenizer.verifySignature(accessToken, base64EncodedSecretKey));
        //예외가 발생하지 않는다면 signature에 대한 검증이 잘 수행된 것이라고 본다.
    }

    // (2)
    @DisplayName("throw ExpiredJwtException when jws verify")
    @Test
    public void verifyExpirationTest() throws InterruptedException {
        String accessToken = getAccessToken(Calendar.SECOND, 1);
        assertDoesNotThrow(() -> jwtTokenizer.verifySignature(accessToken, base64EncodedSecretKey));
        //이땐 검증 ok

        //시간 좀 주고
        TimeUnit.MILLISECONDS.sleep(1500);

        //이땐 제대로 만료됬을 경우 검증하면 ExpiredJwtException이란 예외가 발생하니까
        //예외가 발생할거라고 검증한다. > 예외가 잘 발생하면 JWT가 정상적으로 만료된다고 볼 수 있다.
        assertThrows(ExpiredJwtException.class, () -> jwtTokenizer.verifySignature(accessToken, base64EncodedSecretKey));
    }


    //JWT토큰 생성
    private String getAccessToken(int timeUnit, int timeAmount) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("memberId", 1);
        claims.put("roles", List.of("USER"));

        String subject = "test access token";
        Calendar calendar = Calendar.getInstance();
        calendar.add(timeUnit, timeAmount);
        Date expiration = calendar.getTime();
        String accessToken = jwtTokenizer.generateAccessToken(claims, subject, expiration, base64EncodedSecretKey);

        return accessToken;
    }
}
