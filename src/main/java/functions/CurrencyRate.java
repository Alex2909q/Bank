package functions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrencyRate {
    @Id
    @GeneratedValue
    private long id;
    private Currency currency;
    private Double exchangeRate;

    public CurrencyRate(Currency currency, Double exchangeRate) {
        this.currency = currency;
        this.exchangeRate = exchangeRate;
    }
    public CurrencyRate(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "CurrencyRate{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}