package com.inci.Page.by.Page.Book.Store.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
//  JWT (a specific type of token that is encoded as a JSON object): JSON Web Tokens are an open, industry standard
//                                              RFC 7519 method for representing claims securely between two parties.
public class JwtService {
    private static final String SECRET_KEY = "7c159158fc76e8027682b14ce3efb9ff58101be626c1753e8f47aace3a83ed49";

    private Key getSignKey() {
        //  decodes a Base64-encoded string (SECRET_KEY) into a byte array (keyBytes)
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        //  hmacShaKeyFor: provides by a cryptographic library, and it takes a byte array (keyBytes) as input to generate the key
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extractAllClaims(String token) {
        return (Claims) Jwts                             //  JWT: Json Web Token
                .parserBuilder()                //   parse and verify JWTs
                .setSigningKey(getSignKey())    //  set the signing key for the JWT parser
                .build()                        //  complete the configuration and build the actual JwtParser instance
                .parse(token)                   //  parses the provided JWT token using the configured parser
                .getBody();                     //   result is an object of type Claims representing the payload of the JWT
    }

    //  Responsible for extracting a specific claim from the provided token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        //  claimResolver Method: responsible for extracting a specific piece of information from the Claims object
        return claimsResolver.apply(claims);
    }

    //  Declares to take a String parameter named token and returns a String.
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject); //reference to the getSubject method of the Claims class
    }

    //  Creates a JWT with specified claims
    public String generateToken(
            Map<String, Object> extractClaims,
            UserDetails userDetails
    ) {
        return Jwts                              //  JWT: Json Web Token
                .builder()                       //  starts building a JWT (JSON Web Token)
                .setClaims(extractClaims)        //  map contains additional claims that should be included in the token
                .setSubject(userDetails.getUsername())  // sets the subject of the JWT
                //  sets the "issued at" (iat) claim of the JWT to the current date and time
                .setIssuedAt(new Date(System.currentTimeMillis()))
                //  sets the expiration time of the JWT to 24 hours (1 day) from the current date and time
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)   //  signs the JWT using the HMAC-SHA256 algorithm
                .compact();                     //  generates the compact representation of the JWT
    }

    //  Method to call generateToken with UserDetail object
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    //  Checks the validity of a JWT token by comparing the username
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    //  A specific case of a more generic extractClaim method, focused on extracting the expiration date from a given JWT token
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    //  Checks if a given JWT token has expired by comparing its expiration date with the current date
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

}
