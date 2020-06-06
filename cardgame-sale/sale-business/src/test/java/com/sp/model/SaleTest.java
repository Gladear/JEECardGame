package com.sp.model;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
public class SaleTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createSale() {
		Sale sale = new Sale(1, 1, 5.00);
		assertTrue(sale.getId() == 1);
		assertTrue(sale.getCardId() == 1);
		assertTrue(sale.getPrice() == 5.00);
	}

	public void changePriceSuccess() {
		Sale sale = new Sale(1, 1, 5.00);
		sale.setPrice(10.00);
		assertTrue(sale.getPrice() == 10.00);
	}

	public void changePriceException() {
		Sale sale = new Sale(1, 1, 5.00);
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Price can't be negative");
		sale.setPrice(-5.00);
	}
}
