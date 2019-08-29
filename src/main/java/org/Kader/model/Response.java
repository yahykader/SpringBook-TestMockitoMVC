package org.Kader.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Response implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private boolean success;

}
