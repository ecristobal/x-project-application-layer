package com.x.project.application.layer.security.authentication.manager.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.rs.security.oauth2.common.Client;
import org.apache.cxf.rs.security.oauth2.common.ServerAccessToken;
import org.apache.cxf.rs.security.oauth2.common.UserSubject;
import org.apache.cxf.rs.security.oauth2.provider.AbstractOAuthDataProvider;
import org.apache.cxf.rs.security.oauth2.provider.JPAOAuthDataProvider;
import org.apache.cxf.rs.security.oauth2.provider.OAuthServiceException;
import org.apache.cxf.rs.security.oauth2.tokens.bearer.BearerAccessToken;
import org.apache.cxf.rs.security.oauth2.tokens.refresh.RefreshToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * Class that extends {@link JPAOAuthDataProvider} to add custom fields (called
 * <i>claims</i> on JWT standard) to the response token sent back.
 * 
 * @author Esteban Cristóbal
 * @see AbstractOAuthDataProvider
 */
public class JwtOauthSpringSecurityProvider extends AbstractOAuthDataProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtOauthSpringSecurityProvider.class);

    private TokenStore tokenStore;

    private ClientDetailsService clientDetailsService;

    /*
     * (non-Javadoc)
     * @see org.apache.cxf.rs.security.oauth2.provider.OAuthDataProvider#getAccessToken(java.lang.String)
     */
    @Override
    public ServerAccessToken getAccessToken(String accessToken) throws OAuthServiceException {
        LOGGER.debug("Looking for access token details for {}", accessToken);
        final OAuth2AccessToken oAuth2AccessToken = this.tokenStore.readAccessToken(accessToken);
        final ClientDetails clientDetails = this.findClientDetails(accessToken);
        final ServerAccessToken serverAccessToken = this.build(oAuth2AccessToken, clientDetails);
        LOGGER.debug("Successfully read access token details for {}", accessToken);
        return serverAccessToken;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.apache.cxf.rs.security.oauth2.provider.OAuthDataProvider#getAccessTokens(org.apache.cxf.rs.security.oauth2.
     * common.Client, org.apache.cxf.rs.security.oauth2.common.UserSubject)
     */
    @Override
    public List<ServerAccessToken> getAccessTokens(Client client, UserSubject subject) throws OAuthServiceException {
        final String clientId = client.getClientId();
        LOGGER.debug("Looking for access tokens for client with id {}", clientId);
        final Collection<OAuth2AccessToken> accessTokens = this.tokenStore.findTokensByClientId(clientId);
        final ClientDetails clientDetails = this.clientDetailsService.loadClientByClientId(clientId);
        final List<ServerAccessToken> serverAccessTokens = new ArrayList<>(accessTokens.size());
        for (OAuth2AccessToken accessToken : accessTokens) {
            serverAccessTokens.add(this.build(accessToken, clientDetails));
        }
        LOGGER.debug("Successfully got access token list for client with id {}", clientId);
        return serverAccessTokens;
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
        throw new UnsupportedOperationException("Could not add new clients");
    }

    /*
     * (non-Javadoc)
     * @see org.apache.cxf.rs.security.oauth2.provider.ClientRegistrationProvider#getClients(org.apache.cxf.rs.security.
     * oauth2.common.UserSubject)
     */
    @Override
    public List<Client> getClients(UserSubject resourceOwner) {
        throw new UnsupportedOperationException("Could not generate clients list");
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
        LOGGER.debug("Looking for refresh token details for {}", refreshTokenKey);
        final OAuth2RefreshToken oAuth2RefreshToken = this.tokenStore.readRefreshToken(refreshTokenKey);
        final ClientDetails clientDetails = this.findClientDetails(refreshTokenKey);
        final RefreshToken refreshToken = this.build(oAuth2RefreshToken, clientDetails);
        LOGGER.debug("Successfully read refresh token details for {}", refreshTokenKey);
        return refreshToken;
    }

    /*
     * (non-Javadoc)
     * @see org.apache.cxf.rs.security.oauth2.provider.AbstractOAuthDataProvider#doGetClient(java.lang.String)
     */
    @Override
    protected Client doGetClient(String clientId) {
        LOGGER.debug("Looking for client with id {}", clientId);
        final ClientDetails clientDetails = this.clientDetailsService.loadClientByClientId(clientId);
        final Client client = this.build(clientDetails);
        LOGGER.debug("Found client with id {}", clientId);
        return client;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.apache.cxf.rs.security.oauth2.provider.AbstractOAuthDataProvider#doRemoveClient(org.apache.cxf.rs.security.
     * oauth2.common.Client)
     */
    @Override
    protected void doRemoveClient(Client c) {
        throw new UnsupportedOperationException("Could not remove clients");
    }

    /**
     * @param token
     *            token with client name
     * @return {@link ClientDetails} instance
     */
    private ClientDetails findClientDetails(final String token) {
        final OAuth2Authentication oAuth2Authentication = this.tokenStore.readAuthentication(token);
        return this.clientDetailsService.loadClientByClientId(oAuth2Authentication.getName());
    }

    /**
     * Builds a {@link ServerAccessToken} based on the information provided by {@link OAuth2AccessToken}.
     * 
     * @param accessToken
     *            Spring Security {@link OAuth2AccessToken}
     * @param clientDetails
     *            client details
     * @return {@link ServerAccessToken} properly filled
     */
    private ServerAccessToken build(final OAuth2AccessToken accessToken, final ClientDetails clientDetails) {
        final ServerAccessToken cxfAccessToken = new BearerAccessToken();
        // Set additional properties
        final Map<String, Object> additionalInformation = accessToken.getAdditionalInformation();
        final Map<String, String> properties = new HashMap<>(additionalInformation.size());
        for (Map.Entry<String, Object> entry : additionalInformation.entrySet()) {
            properties.put(entry.getKey(), (String) entry.getValue());
        }
        cxfAccessToken.setExtraProperties(properties);
        // Set expiry
        cxfAccessToken.setExpiresIn(accessToken.getExpiresIn());
        // Set refresh token
        cxfAccessToken.setRefreshToken(accessToken.getRefreshToken().getValue());
        // Set token type
        cxfAccessToken.setTokenType(accessToken.getTokenType());
        // Set audiences
        cxfAccessToken.setAudiences(new ArrayList<>(accessToken.getScope()));
        // Set token key
        cxfAccessToken.setTokenKey(accessToken.getValue());
        // Set client
        cxfAccessToken.setClient(this.build(clientDetails));
        return cxfAccessToken;
    }

    /**
     * Builds a {@link RefreshToken} based on the information provided by {@link OAuth2RefreshToken} and
     * {@link ClientDetails}.
     * 
     * @param refreshToken
     *            Spring Security {@link OAuth2RefreshToken}
     * @param clientDetails
     *            client details
     * @return {@link RefreshToken} properly filled
     */
    private RefreshToken build(final OAuth2RefreshToken refreshToken, final ClientDetails clientDetails) {
        final RefreshToken cxfRefreshToken = new RefreshToken();
        // TODO Implement build logic
        return cxfRefreshToken;
    }

    /**
     * Builds a {@link Client} instance based on the information provided by {@link ClientDetails} instance.
     * 
     * @param clientDetails
     *            source data
     * @return {@link Client} properly filled
     */
    private Client build(final ClientDetails clientDetails) {
        final Client client = new Client();
        // TODO Implement build logic
        return client;
    }

    /**
     * @param tokenServices
     *            the tokenServices to set
     */
    public void setTokenStore(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    /**
     * @param clientDetailsService
     *            the clientDetailsService to set
     */
    public void setClientDetailsService(ClientDetailsService clientDetailsService) {
        this.clientDetailsService = clientDetailsService;
    }

}
