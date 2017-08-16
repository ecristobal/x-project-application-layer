/*******************************************************************************
 * Copyright (c) 2017 TecnoPYME. All rights reserved
 ******************************************************************************/
package com.tecnopyme.application.layer.business.delegate.discovery;

/**
 * Interface for the utility which looks for service URLs onto the service
 * registry.
 * 
 * @author Esteban Cristóbal
 */
@FunctionalInterface
public interface DiscoveryService {

	/**
	 * Gets the endpoint associated with the specified service name.
	 * 
	 * @param serviceName
	 *            service name
	 * @return service endpoint
	 */
	public String getEndpoint(final String serviceName);

}
