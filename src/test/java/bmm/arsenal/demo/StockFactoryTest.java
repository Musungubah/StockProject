package bmm.arsenal.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasSize;

import bmm.arsenal.demo.controller.StockController;
import bmm.arsenal.demo.controller.UserController;
import bmm.arsenal.demo.model.Stock;
import bmm.arsenal.demo.service.StockService;
import bmm.arsenal.demo.service.UserService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StockController.class)
class StockFactoryTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private StockService stockService;

	@Test
	public void test() {

		Stock stock1 = new Stock(1L, 3.14, "BAC", "bank of america", true);
		Stock stock2 = new Stock(2L, 3.14, "BAC", "bank of america", true);
		List<Stock> allStocks = new ArrayList<Stock>();
		allStocks.add(stock1);
		allStocks.add(stock2);

		BDDMockito.given(stockService.getAllStocks()).willReturn(allStocks);

		String testSymbol = allStocks.get(0).getStocksymbol();

		try {

			mvc.perform(get("/stocklist").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
					.andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].stocksymbol", is(testSymbol)));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
