package com.lwl.quizer.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PaymentServiceTest {

	@Test
	public void getBillAmount() {
		
		RestTemplate template = new RestTemplate();
		
		String url = "https://lwl-pay.herokuapp.com/api/8765678444";
		
		ResponseEntity<Integer> response = template.getForEntity(url, Integer.class);
		Integer billAmount = response.getBody();
		System.out.println("Bill amount :"+billAmount);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(billAmount).isGreaterThan(1000).isLessThan(2000);
		
	}
	
	@Test
	public void payAmount() {
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setAmount(1600);
		paymentDTO.setMobile("9036102111");
		String url = "https://lwl-pay.herokuapp.com/api/pay";
		HttpEntity<PaymentDTO> request =new HttpEntity<PaymentDTO>(paymentDTO);
		RestTemplate template = new RestTemplate();
		ResponseEntity<TransactionDetailsDTO> response = template.exchange(url, HttpMethod.POST, request, TransactionDetailsDTO.class);
		TransactionDetailsDTO transaction = response.getBody();
		System.out.println(transaction);
		
	}
	
}
