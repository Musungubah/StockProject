package bmm.arsenal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bmm.arsenal.demo.model.Stock;
import bmm.arsenal.demo.service.StockService;

@RestController
public class StockController {
	
	@Autowired
	StockService stockService;
	
	@GetMapping("/stocklist")
	@ResponseBody
	public List<Stock> getAllStocks(){
		List<Stock> mylist = stockService.getAllStocks();
		
		return  mylist;
	}
	
	@PostMapping("/stocklist")
	public void createAStock(@RequestBody Stock stock) {
		stockService.createAStock(stock);
	}
	
	@GetMapping("/stocklist/{symbol}")
	public Stock returnStock(@PathVariable String symbol) {
		return stockService.findAStock(symbol);
	}
	
	@DeleteMapping("/stocklist/{symbol}")
	public void deleteStock(@PathVariable String symbol) {
		stockService.deleteAStock(symbol);
	}
	

}
