package com.x.project.application.layer.authentication.manager.provider;

import org.apache.cxf.rs.security.jose.jwt.JwtClaims;
import org.apache.cxf.rs.security.oauth2.common.ServerAccessToken;
import org.apache.cxf.rs.security.oauth2.provider.JPAOAuthDataProvider;

/**
 * Class that extends {@link JPAOAuthDataProvider} to add custom fields (called <i>claims</i> on JWT standard) to the
 * response token sent back.
 * 
 * @author Esteban Cristóbal
 * @see JPAOAuthDataProvider
 */
public class JwtOauthCustomProvider extends JPAOAuthDataProvider {

    /*
     * (non-Javadoc)
     * @see org.apache.cxf.rs.security.oauth2.provider.AbstractOAuthDataProvider#createJwtAccessToken(org.apache.cxf.rs.
     * security.oauth2.common.ServerAccessToken)
     */
    @Override
    protected JwtClaims createJwtAccessToken(ServerAccessToken at) {
        final JwtClaims jwtClaims = super.createJwtAccessToken(at);
        // TODO Add custom claims to JWT token
        return jwtClaims;
    }

}
