package com.x.project.application.layer.application.service.mock;

import com.x.project.application.layer.domain.api.ApiComponent;

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
