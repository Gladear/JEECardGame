package com.sp.repository;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sp.model.Sale;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SaleRepoTest {
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Test
	public void findSale() {
		Optional<Sale> optSale = saleRepository.findById(1);
		assertTrue(optSale.isPresent());
		assertTrue(optSale.get().getId().equals(1));
	}
//	@Test
//	public void createSale() {			
//			double price = 100;
//			Sale testSale = new Sale(46, 1, price);
//			saleRepository.save(testSale);		    
//			Optional<Sale> optSale = saleRepository.findById(46);
//			assertTrue(optSale.isPresent());
//			assertTrue(optSale.get().getId().equals(46));
//			assertTrue(optSale.get().getCardId().equals(1));
//			assertTrue(optSale.get().getPrice().equals(price));		
//	}
	
	@Test
	public void updateSale() {
		double price = 100;		
		Optional<Sale> optSale = saleRepository.findById(1);
		assertTrue(optSale.isPresent());
		assertTrue(optSale.get().getId().equals(1));
		assertTrue(optSale.get().getCardId().equals(1));
		assertTrue(optSale.get().getPrice().equals(price));	
		price = 200 ;
		Sale testSale=optSale.get();
		testSale.setPrice(price);
		saleRepository.save(testSale);
		optSale = saleRepository.findById(1);
		assertTrue(optSale.isPresent());
		assertTrue(optSale.get().getId().equals(1));
		assertTrue(optSale.get().getCardId().equals(1));
		assertTrue(optSale.get().getPrice().equals(price));	
		
	}
	
	@Test
	public void deleteSale() {
		double price = 100;		
		Optional<Sale> optSale = saleRepository.findById(1);
		assertTrue(optSale.isPresent());
		saleRepository.delete(optSale.get());
		optSale = saleRepository.findById(1);
		assertTrue(!optSale.isPresent());
	}
}
