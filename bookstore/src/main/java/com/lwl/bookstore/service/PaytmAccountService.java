package com.lwl.bookstore.service;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Service
@ConfigurationProperties(prefix = "paytm.account")
@Getter
@Setter
@ToString
public class PaytmAccountService {

	private String merchantKey;
	private String paytmUrl;
	private Map<String, String> details;
}
