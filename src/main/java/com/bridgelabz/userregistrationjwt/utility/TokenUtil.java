package com.bridgelabz.userregistrationjwt.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.stereotype.Component;

/***********************************************************************************************************************
 * Class : Token Util Class.
 * @author : Mangesh
 * @since : 12-06-2022
 *
 **********************************************************************************************************************/
@Component
public class TokenUtil {
    private static final String TOKEN_SECRET = "Mangesh";

    public String createToken(int id) {
        try {
// To Set Algorithm
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            String token = JWT.create()
                    .withClaim("user_Id", id)
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
// Log Token Signing Failed
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param token
     * @return
     */
    public int decodeToken(String token) {
        int user_Id;
//For Verification Algorithm
        Verification verification = null;
        try {
            verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        JWTVerifier jwtverifier = verification.build();
//To Decode token
        DecodedJWT decodedjwt = jwtverifier.verify(token);
        Claim claim = decodedjwt.getClaim("user_Id");
        user_Id = claim.asInt();
        return user_Id;
    }
}
