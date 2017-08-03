package com.tecnopyme.application.layer.application.service.mock;

import com.tecnopyme.application.layer.domain.api.ApiComponent;

public class MockApiComponent implements ApiComponent {

	private String field;

	public MockApiComponent(final String field) {
		this.field = field;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field
	 *            the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

}
