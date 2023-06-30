package tp.entity;

public class Devise {
	
	private String code; //ex: EUR , USD
	private String name; //ex: Euro, Dollar 
	private Double exchangeRate; //taux d'échange pour 1 euro

	
	@Override
	public String toString() {
		return "Devise [code=" + code + ", name=" + name + ", exchangeRate=" + exchangeRate + "]";
	}


	public Devise() {
		super();
	}


	public Devise(String code, String name, Double exchangeRate) {
		super();
		this.code = code;
		this.name = name;
		this.exchangeRate = exchangeRate;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Double getExchangeRate() {
		return exchangeRate;
	}


	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	

	
}
