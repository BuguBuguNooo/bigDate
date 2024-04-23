package com.gfj.yellodate;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class jwt {
    @Test
    public void testGen(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username", "阳咪咪");
        //生成jwt的代码
        String token = JWT.create()
                .withClaim("user", claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))//添加过期时间
                .sign(Algorithm.HMAC256("gfjxy520"));//指定算法，配置密钥

        System.out.println(token);
    }

    @Test
    public void testParse(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IumYs-WSquWSqiJ9LCJleHAiOjE3MDg5OTExNjJ9" +
                ".tR2aiOs96dFoZDQnADoYcdh4TKcTdbwI9LR8HilA3a4";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("gfjxy520")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);//验证token,生成一个解析后的JWT对象

        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));

    }
}
