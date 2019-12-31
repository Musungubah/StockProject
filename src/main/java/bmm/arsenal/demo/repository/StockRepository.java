package bmm.arsenal.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bmm.arsenal.demo.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
	public Stock findBystocksymbol(String stocksymbol);
}
