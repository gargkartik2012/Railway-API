/*
package org.springbootdemo.Railway.webtoken;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JwtService {

    private  static final String SECRET = "F19894020DFDD3DA637CBC0C93F1B2C0DABE38040D0B79F8F9E650BE52EDC875CDCDF3E2529B14C70C668E76B741468D494866DB63CC2941C036DE4790296955";
    private static final long VALIDITY = TimeUnit.MINUTES.toMillis(30);

    public String generateToken(UserDetails userDetails){
       return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusMillis(VALIDITY)))

    }
}
*/
