package com.lwl.scart.web;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lwl.scart.domain.Product;
import com.lwl.scart.service.PaytmAccount;
import com.lwl.scart.service.ProductService;
import com.paytm.pg.merchant.CheckSumServiceHelper;

@Controller
public class ScartController {

	@Value("${paytm.email}")
	private String email;
	@Value("${paytm.mobile}")
	private String mobile;

	@Autowired
	private ProductService productService;

	@Autowired
	private PaytmAccount paytmAccount;

	@GetMapping("/")
	public String index(@ModelAttribute("model") ModelMap model) {
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);
		return "index";
	}

	@GetMapping("/order")
	public String requestOrder(@RequestParam("pid") String pid, @ModelAttribute("model") ModelMap model) {
		Product product = productService.getProductById(pid).get();
		model.addAttribute("product", product);
		return "order";

	}

	@PostMapping(value = "/paynow")
	public ModelAndView paynow(@RequestParam Map<String, String> paramMap) throws Exception {

		TreeMap<String, String> map = new TreeMap<>();
		map.putAll(paramMap);
		ModelAndView modelAndView = new ModelAndView("redirect:" + paytmAccount.getPaytmUrl());
		map.putAll(paytmAccount.getDetails());
		map.put("MOBILE_NO", mobile);
		map.put("ORDER_ID", "" + System.currentTimeMillis());
		map.put("EMAIL", email);
		String checksum = getCheckSum(map);
		map.put("CHECKSUMHASH", checksum);
		modelAndView.addAllObjects(map);
		return modelAndView;

	}

	@PostMapping(value = "/paymentresponse")
	public String getResponseRedirect(HttpServletRequest request, Model model) {

		Map<String, String[]> mapData = request.getParameterMap();
		TreeMap<String, String> parameters = new TreeMap<String, String>();
		mapData.forEach((key, val) -> parameters.put(key, val[0]));
		String paytmChecksum = "";
		if (mapData.containsKey("CHECKSUMHASH")) {
			paytmChecksum = mapData.get("CHECKSUMHASH")[0];
		}
		String result="";
		boolean isValideChecksum = false;
		try {
			isValideChecksum = validateCheckSum(parameters, paytmChecksum);
			if (isValideChecksum && parameters.containsKey("RESPCODE")) {
				if (parameters.get("RESPCODE").equals("01")) {
					result = "Payment Successful";
				} else {
					result = "Payment Failed";
				}
			} else {
				result = "Checksum mismatched";
			}
		} catch (Exception e) {
			result = e.toString();
		}
		parameters.remove("CHECKSUMHASH");
		model.addAttribute("result", "Success");
		model.addAttribute("orderid", "" + System.currentTimeMillis());
		model.addAttribute("parameters", parameters);
		return "response";
	}

	private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
		return CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(paytmAccount.getMerchantKey(),
				parameters, paytmChecksum);
	}

	private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		return CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(paytmAccount.getMerchantKey(),
				parameters);
	}
}
