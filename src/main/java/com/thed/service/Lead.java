package com.thed.service;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by Pravin on 4/19/17.
 * Copyright D Inc. 2017 , use it at own risk
 */
@JsonIgnoreProperties("self,key")
public class Lead {
	private String self;
	private String name;
	private String displayName;
	private Boolean active;
	private String key;
}
