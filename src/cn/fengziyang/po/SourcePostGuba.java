package cn.fengziyang.po;

public class SourcePostGuba {
	private String stockbar_type;
	private String stockbar_code;
	private String stockbar_inner_code;
	private String stockbar_name;
	private String stockbar_market;
	private String stockbar_quote;
	private String stockbar_exchange;
	private String stockbar_external_code;
	
	public SourcePostGuba(String stockbar_type, String stockbar_code,
			String stockbar_inner_code, String stockbar_name,
			String stockbar_market, String stockbar_quote,
			String stockbar_exchange, String stockbar_external_code) {
		super();
		this.stockbar_type = stockbar_type;
		this.stockbar_code = stockbar_code;
		this.stockbar_inner_code = stockbar_inner_code;
		this.stockbar_name = stockbar_name;
		this.stockbar_market = stockbar_market;
		this.stockbar_quote = stockbar_quote;
		this.stockbar_exchange = stockbar_exchange;
		this.stockbar_external_code = stockbar_external_code;
	}

	public String getStockbar_type() {
		return stockbar_type;
	}

	public void setStockbar_type(String stockbar_type) {
		this.stockbar_type = stockbar_type;
	}

	public String getStockbar_code() {
		return stockbar_code;
	}

	public void setStockbar_code(String stockbar_code) {
		this.stockbar_code = stockbar_code;
	}

	public String getStockbar_inner_code() {
		return stockbar_inner_code;
	}

	public void setStockbar_inner_code(String stockbar_inner_code) {
		this.stockbar_inner_code = stockbar_inner_code;
	}

	public String getStockbar_name() {
		return stockbar_name;
	}

	public void setStockbar_name(String stockbar_name) {
		this.stockbar_name = stockbar_name;
	}

	public String getStockbar_market() {
		return stockbar_market;
	}

	public void setStockbar_market(String stockbar_market) {
		this.stockbar_market = stockbar_market;
	}

	public String getStockbar_quote() {
		return stockbar_quote;
	}

	public void setStockbar_quote(String stockbar_quote) {
		this.stockbar_quote = stockbar_quote;
	}

	public String getStockbar_exchange() {
		return stockbar_exchange;
	}

	public void setStockbar_exchange(String stockbar_exchange) {
		this.stockbar_exchange = stockbar_exchange;
	}

	public String getStockbar_external_code() {
		return stockbar_external_code;
	}

	public void setStockbar_external_code(String stockbar_external_code) {
		this.stockbar_external_code = stockbar_external_code;
	}
	
	
	
}
