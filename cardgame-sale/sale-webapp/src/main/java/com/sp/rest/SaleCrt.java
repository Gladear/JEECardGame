package com.sp.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Sale;
import com.sp.service.SaleService;
import com.sp.utils.RequestUtils;

@RestController
public class SaleCrt {
	@Autowired
	SaleService sService;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public Iterable<Sale> getSales() {
		return sService.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Sale getSale(@PathVariable String saleId) {
		return sService.getSale(Integer.valueOf(saleId));
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/")
	public void putSale(HttpServletRequest request, @RequestParam String cardId, @RequestParam String price) {
		Integer userId = RequestUtils.getUserID(request);
		sService.create(userId, Integer.valueOf(cardId), Double.valueOf(price));
	}

	@RequestMapping(method = RequestMethod.POST, value = "/buy")
	public void buySale(HttpServletRequest request, @RequestParam String saleId) {
		Integer userId = RequestUtils.getUserID(request);
		sService.buy(userId, Integer.valueOf(saleId));
	}
}
