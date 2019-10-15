package top.yeonon.yclouddisk.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * @Author yeonon
 * @date 2019/10/14 0014 23:31
 **/
public class JwtUtil {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateToken(Map<String, Object> info) {

        return Jwts.builder()
                .signWith(key)
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .setClaims(info)
                .compact();
    }

    public static <T> T getValueFromToken(String token, String filedName, Class<T> tClass) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
        return claims.getBody().get(filedName, tClass);
    }
}
