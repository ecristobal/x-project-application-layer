package com.x.project.application.layer.domain.api;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class to be implemented by API classes to simplify parameter extraction
 * in a generic way.
 * This interface is intended to be part of a
 * <a href="https://en.wikipedia.org/wiki/Composite_pattern">Composite</a>
 * design pattern implementation, being this interface the <i>Component</i>.
 * Because of what is said, all classes which intends to be part of the service
 * API should extend this class, being the <i>Composite</i> elements of the
 * design pattern.
 * 
 * @author Esteban Cristóbal
 */
public interface ApiComponent {

	/**
	 * @return {@link Map} representation of fields contained on API
	 */
	@SuppressWarnings("unchecked")
	@JsonIgnore
	public default Map<String, Object> getParameterMap() {
		final ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(this, Map.class);
	}

}