package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

/**
 * @Data : Auto-generating getters and setters, constructor, toString
 *
 */
public @Data class ResponseDTO {

	private String message;
	private Object data;

	public ResponseDTO(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}

}
