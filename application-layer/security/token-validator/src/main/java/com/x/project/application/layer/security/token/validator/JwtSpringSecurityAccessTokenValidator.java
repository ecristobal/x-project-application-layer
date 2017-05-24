package com.x.project.application.layer.security.token.validator;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.rs.security.oauth2.common.AccessTokenValidation;
import org.apache.cxf.rs.security.oauth2.filters.JwtAccessTokenValidator;

/**
 * Class that extends {@link JwtAccessTokenValidator} to delegate the validation
 * process into Spring Security.
 * 
 * @author Esteban Cristóbal
 * @see JwtAccessTokenValidator
 */
public class JwtSpringSecurityAccessTokenValidator extends JwtAccessTokenValidator {

    /*
     * (non-Javadoc)
     * @see org.apache.cxf.rs.security.oauth2.filters.JwtAccessTokenValidator#
     * validateAccessToken(org.apache.cxf.jaxrs.ext.MessageContext,
     * java.lang.String, java.lang.String, javax.ws.rs.core.MultivaluedMap)
     */
    @Override
    public AccessTokenValidation validateAccessToken(MessageContext mc, String authScheme, String authSchemeData,
            MultivaluedMap<String, String> extraProps) {
        final AccessTokenValidation accessTokenValidation = super.validateAccessToken(mc, authScheme, authSchemeData,
                extraProps);
        // TODO Add delegation into Spring Security to check authentication and
        // authorization
        return accessTokenValidation;
    }

}
