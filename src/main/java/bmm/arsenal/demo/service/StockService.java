package bmm.arsenal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bmm.arsenal.demo.model.Stock;
import bmm.arsenal.demo.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired 
	StockRepository stockRepository;
	
	public List<Stock> getAllStocks(){
		return stockRepository.findAll();
	}
	
	public Stock findAStock(String stocksymbol) {
		return stockRepository.findBystocksymbol(stocksymbol);
	}
	
	public void deleteAStock(String stocksymbol) {
		
		stockRepository.deleteById(stockRepository.findBystocksymbol(stocksymbol).getId());
	}
	
	public void createAStock(Stock stock) {
		stockRepository.save(stock);
	}

}
