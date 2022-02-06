package com.rhombusthere.codemotioncloudpath.proxyservice.service;

import com.rhombusthere.codemotioncloudpath.proxyservice.model.UserBasic;
import com.rhombusthere.codemotioncloudpath.proxyservice.props.AuthenticationProperties;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.*;

@Service
public class AuthenticationService {
    private static final String USERNAME_CLAIM = "username";
    private static Set<String> inMemoryJwt = new HashSet<>();
    private static Key secretKey;
    private static int expireAfterMinutes;

    private final AuthenticationProperties authenticationProperties;

    public AuthenticationService(AuthenticationProperties authenticationProperties) {
        this.authenticationProperties = authenticationProperties;
        secretKey = new SecretKeySpec(Base64.getDecoder()
                .decode(this.authenticationProperties.getSecret()),
                SignatureAlgorithm.HS256.getJcaName());
        expireAfterMinutes = this.authenticationProperties.getExpirationTimeInMinutes();
    }

    public static String getJwtToken( UserBasic userBasic) {
        String createdToken = createJwt(userBasic);
        inMemoryJwt.add(createdToken);
        return createdToken;
    }

    public static boolean isValid(String token) {
        if(!inMemoryJwt.contains(token)) {
            return false;
        }
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            inMemoryJwt.remove(token);
            return  false;
        }
    }

    private static String createJwt(UserBasic userBasic) {
        Date now = new Date();
        return Jwts.builder()
                .claim(USERNAME_CLAIM, userBasic.getUsername())
                .setSubject(userBasic.getUsername())
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(now)
                .setExpiration(DateUtils.addMinutes(now, expireAfterMinutes))
                .signWith(secretKey)
                .compact();
    }

}
