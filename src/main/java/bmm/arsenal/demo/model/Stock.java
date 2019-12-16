package bmm.arsenal.demo.model;

public abstract class Stock {
	private Double price;
	private String stocksymbol;
	private String stockname;
	private boolean dividend;
	
	
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
