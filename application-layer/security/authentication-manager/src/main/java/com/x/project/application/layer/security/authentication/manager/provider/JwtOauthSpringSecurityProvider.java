package com.x.project.application.layer.security.authentication.manager.provider;

import java.util.List;

import org.apache.cxf.rs.security.jose.jwt.JwtClaims;
import org.apache.cxf.rs.security.oauth2.common.Client;
import org.apache.cxf.rs.security.oauth2.common.ServerAccessToken;
import org.apache.cxf.rs.security.oauth2.common.UserSubject;
import org.apache.cxf.rs.security.oauth2.provider.AbstractOAuthDataProvider;
import org.apache.cxf.rs.security.oauth2.provider.JPAOAuthDataProvider;
import org.apache.cxf.rs.security.oauth2.provider.OAuthServiceException;
import org.apache.cxf.rs.security.oauth2.tokens.refresh.RefreshToken;

/**
 * Class that extends {@link JPAOAuthDataProvider} to add custom fields (called
 * <i>claims</i> on JWT standard) to the response token sent back.
 * 
 * @author Esteban Cristóbal
 * @see JPAOAuthDataProvider
 */
public class JwtOauthSpringSecurityProvider extends AbstractOAuthDataProvider {

    /*
     * (non-Javadoc)
     * @see
     * org.apache.cxf.rs.security.oauth2.provider.AbstractOAuthDataProvider#
     * createJwtAccessToken(org.apache.cxf.rs.
     * security.oauth2.common.ServerAccessToken)
     */
    @Override
    protected JwtClaims createJwtAccessToken(ServerAccessToken at) {
        final JwtClaims jwtClaims = super.createJwtAccessToken(at);
        // TODO Add custom claims to JWT token
        return jwtClaims;
    }

    /*
     * (non-Javadoc)
     * @see org.apache.cxf.rs.security.oauth2.provider.OAuthDataProvider#getAccessToken(java.lang.String)
     */
    @Override
    public ServerAccessToken getAccessToken(String accessToken) throws OAuthServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.apache.cxf.rs.security.oauth2.provider.OAuthDataProvider#getAccessTokens(org.apache.cxf.rs.security.oauth2.
     * common.Client, org.apache.cxf.rs.security.oauth2.common.UserSubject)
     */
    @Override
    public List<ServerAccessToken> getAccessTokens(Client client, UserSubject subject) throws OAuthServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.apache.cxf.rs.security.oauth2.provider.OAuthDataProvider#getRefreshTokens(org.apache.cxf.rs.security.oauth2.
     * common.Client, org.apache.cxf.rs.security.oauth2.common.UserSubject)
     */
    @Override
    public List<RefreshToken> getRefreshTokens(Client client, UserSubject subject) throws OAuthServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.apache.cxf.rs.security.oauth2.provider.ClientRegistrationProvider#setClient(org.apache.cxf.rs.security.oauth2
     * .common.Client)
     */
    @Override
    public void setClient(Client client) {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javadoc)
     * @see org.apache.cxf.rs.security.oauth2.provider.ClientRegistrationProvider#getClients(org.apache.cxf.rs.security.
     * oauth2.common.UserSubject)
     */
    @Override
    public List<Client> getClients(UserSubject resourceOwner) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.apache.cxf.rs.security.oauth2.provider.AbstractOAuthDataProvider#saveAccessToken(org.apache.cxf.rs.security.
     * oauth2.common.ServerAccessToken)
     */
    @Override
    protected void saveAccessToken(ServerAccessToken serverToken) {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javadoc)
     * @see
     * org.apache.cxf.rs.security.oauth2.provider.AbstractOAuthDataProvider#saveRefreshToken(org.apache.cxf.rs.security.
     * oauth2.tokens.refresh.RefreshToken)
     */
    @Override
    protected void saveRefreshToken(RefreshToken refreshToken) {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javadoc)
     * @see org.apache.cxf.rs.security.oauth2.provider.AbstractOAuthDataProvider#doRevokeAccessToken(org.apache.cxf.rs.
     * security.oauth2.common.ServerAccessToken)
     */
    @Override
    protected void doRevokeAccessToken(ServerAccessToken accessToken) {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javadoc)
     * @see org.apache.cxf.rs.security.oauth2.provider.AbstractOAuthDataProvider#doRevokeRefreshToken(org.apache.cxf.rs.
     * security.oauth2.tokens.refresh.RefreshToken)
     */
    @Override
    protected void doRevokeRefreshToken(RefreshToken refreshToken) {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javadoc)
     * @see org.apache.cxf.rs.security.oauth2.provider.AbstractOAuthDataProvider#getRefreshToken(java.lang.String)
     */
    @Override
    protected RefreshToken getRefreshToken(String refreshTokenKey) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see org.apache.cxf.rs.security.oauth2.provider.AbstractOAuthDataProvider#doGetClient(java.lang.String)
     */
    @Override
    protected Client doGetClient(String clientId) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.apache.cxf.rs.security.oauth2.provider.AbstractOAuthDataProvider#doRemoveClient(org.apache.cxf.rs.security.
     * oauth2.common.Client)
     */
    @Override
    protected void doRemoveClient(Client c) {
        // TODO Auto-generated method stub
    }

}
