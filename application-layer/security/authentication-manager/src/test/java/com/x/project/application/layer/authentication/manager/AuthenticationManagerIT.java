package com.x.project.application.layer.authentication.manager;

import java.util.Map;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.json.JacksonJsonParser;

public class AuthenticationManagerIT {

	private static final String AUTHENTICATION_URL = "http://localhost:8081/services/oauth";

	private TokenGenerator tokenGenerator;

	@Before
	public void setUp() {
		this.tokenGenerator = JAXRSClientFactory.create(AUTHENTICATION_URL, TokenGenerator.class, "test", "test", null);
	}

	@Test
	public void test() {
		final MultivaluedMap<String, String> params = new MultivaluedHashMap<String, String>(1);
		params.add("grant_type", "client_credentials");
		final Response response = this.tokenGenerator.getToken(params);
		Assert.assertEquals(200, response.getStatus());
		final String json = response.readEntity(String.class);
		final Map<String, Object> parsedJson = this.parseResponse(json);
		Assert.assertTrue(parsedJson.containsKey("access_token"));
		Assert.assertFalse(((String) parsedJson.get("access_token")).isEmpty());
		Assert.assertTrue(parsedJson.containsKey("token_type"));
		Assert.assertEquals("Bearer", parsedJson.get("token_type"));
		Assert.assertTrue(parsedJson.containsKey("expires_in"));
		Assert.assertEquals(300, parsedJson.get("expires_in"));
	}

	private Map<String, Object> parseResponse(final String json) {
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		return jsonParser.parseMap(json);
	}

}
