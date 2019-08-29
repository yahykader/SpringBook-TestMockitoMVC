package org.Kader.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter

@Entity
public class Employe implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String dept;
	

}
