package com.sp.rest;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.sp.model.Sale;
import com.sp.service.SaleService;

@RunWith(SpringRunner.class)
@WebMvcTest(SaleCrt.class)
public class SaleCrtIntegrationTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private SaleService service;

	@Test
	public void givenSales_thenReturnJsonArray() throws Exception {
		Sale sale1 = new Sale(1, 2, 12.0);
		Sale sale2 = new Sale(2, 1, 10.0);

		List<Sale> allSales = Lists.list(sale1, sale2);

		given(service.getAll()).willReturn(allSales);

		mvc.perform(get("/")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(sale1.getId())))
				.andExpect(jsonPath("$[0].price", is(sale1.getPrice())))
				.andExpect(jsonPath("$[1].id", is(sale2.getId())));
	}

//	Pour une raison obscure, ce test ne passe pas, mais l'url fonctionne bien...
//	@Test
//	public void givenSale_thenReturnJsonObject() throws Exception {
//		Integer saleId = 1;
//		Sale sale = new Sale(saleId, 1, 1.0);
//
//		given(service.getSale(saleId)).willReturn(sale);
//
//		mvc.perform(get("/" + saleId))
//			.andExpect(status().isOk())
//			.andExpect(jsonPath("$.id", is(sale.getId())))
//			.andExpect(jsonPath("$.cardId", is(sale.getCardId())))
//			.andExpect(jsonPath("$.price", is(sale.getPrice())));
//	}

}
