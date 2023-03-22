package com.example.jwtsample;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;


import java.security.Key;
import java.util.Date;


public class JwtTokenizer {

    // (1) secret key(plain text->base64형식의 문자열)
    //     단, 버전업되면서 plaintext 자체를 secret key로 사용하는 것을 권장하지 않는다.
    // 서명과정에서 HMAC 알고리즘을 직접 지정하지 않고 내부적으로 적절한 HMAC알고리즘을 지정한다.
    public String encodeBase64SecretKey(String secretKey) {
        return Encoders.BASE64.encode(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    // (2) 인증된 사용자에게 JWT를 최초로 발급해주기 위한 JWT 생성 메서드
    public String generateAccessToken(Map<String, Object> claims,
                                      String subject,
                                      Date expiration,
                                      String base64EncodedSecretKey) {
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey); // (2-1)java security key 객체를 얻는다.

        return Jwts.builder() //
                .setClaims(claims)          // (2-2) jwt에 포함시킬 custon claims(주로 인증된 사용자와 관련된 정보 추가)
                .setSubject(subject)        // (2-3) jwt에 대한 제목 ㄹ추가
                .setIssuedAt(Calendar.getInstance().getTime())   // (2-4) jwt발행 일자를 설정(파라미터 타입:java.util.Date)
                .setExpiration(expiration)  // (2-5) jwt 만료일시 지정(위와 동일한 파라미터 타입)
                .signWith(key)              // (2-6) signwith에 서명을 위한 키 객체 설정
                .compact();                 // (2-7) jwt를 생성하고 직렬화한다.
    }

    // (3) Access 토큰이 만료되었을 경우 재생성할 Refresh 토큰을 생성하는 메서드
    public String generateRefreshToken(String subject, Date expiration, String base64EncodedSecretKey) {
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(Calendar.getInstance().getTime())
                .setExpiration(expiration)
                .signWith(key)
                .compact();
    }


    // (4) jwt의 서명에 사용할 secret key를 생성한다.
    private Key getKeyFromBase64EncodedKey(String base64EncodedSecretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(base64EncodedSecretKey);  // (4-1) base64형식으로 인코딩된 secret key를 디코딩한 후 byte array를 반환한다.
        Key key = Keys.hmacShaKeyFor(keyBytes);    // (4-2) key byte array를 기반으로 적절한 HMAC 알고리즘을 적용한 key객체를 생성한다.

        return key;
    }

    //JWT검증을 위한 메서드
    //JWT에 포함된 Signature을 검증함으로써 JWT의 위/변조 여부를 확인할 수 있다.
    //무슨 예외를 던지는데..?
    public void verifySignature(String jws, String base64EncodedSecretKey) {
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

        Jwts.parserBuilder()
                .setSigningKey(key)     // (1) 서명에 사용된 secret key 설정한다.
                .build()
                .parseClaimsJws(jws);   // (2) jwt를 파싱해서 claims를 얻는다.
                //jws : signature가 포함된 jwt라는 의미
    }
}
