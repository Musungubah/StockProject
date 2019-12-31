package bmm.arsenal.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="stocks")
public class Stock {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double price;
	private String stocksymbol;
	private String stockname;
	private boolean dividend;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getStocksymbol() {
		return stocksymbol;
	}
	public void setStocksymbol(String stocksymbol) {
		this.stocksymbol = stocksymbol;
	}
	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public boolean isDividend() {
		return dividend;
	}
	public void setDividend(boolean dividend) {
		this.dividend = dividend;
	}

}
