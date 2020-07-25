package com.lwl.scart.service;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "paytm.account")
@Component
public class PaytmAccount {

	private String merchantKey;
	private String paytmUrl;
	private Map<String, String> details;
	
	
}
