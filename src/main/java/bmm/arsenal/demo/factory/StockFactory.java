package bmm.arsenal.demo.factory;

import bmm.arsenal.demo.model.DividendStock;
import bmm.arsenal.demo.model.NonDividendStock;
import bmm.arsenal.demo.model.Stock;

public class StockFactory {

	public Stock getStock(String stockType) {

		if (stockType == null) {
			return null;
		}

		if (stockType.equalsIgnoreCase("NONDIVIDENDSTOCK")) {
			return new NonDividendStock();
		} else if (stockType.equalsIgnoreCase("DIVIDENDSTOCK")) {
			return new DividendStock();
		} else {
			return null;
		}
	}
}
