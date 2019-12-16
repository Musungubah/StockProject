package bmm.arsenal.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bmm.arsenal.demo.factory.StockFactory;
import bmm.arsenal.demo.model.DividendStock;
import bmm.arsenal.demo.model.NonDividendStock;
import bmm.arsenal.demo.model.Stock;

class StockFactoryTest {

	@Test
	void test() {
		StockFactory stockFactory = new StockFactory();
		
		assertNotNull(stockFactory);
		
		DividendStock divStock = (DividendStock) stockFactory.getStock("DIVIDENDSTOCK");
		
		assertThat(divStock).isInstanceOf(Stock.class);
		
	}
	
	@Test
	void testNondividendStock() {
StockFactory stockFactory = new StockFactory();
		
		assertNotNull(stockFactory);
		
		NonDividendStock NondivStock = (NonDividendStock) stockFactory.getStock("NONDIVIDENDSTOCK");
		
		assertThat(NondivStock).isInstanceOf(Stock.class);
		
	}

}
