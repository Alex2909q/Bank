package functions;

import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Account from;
    @ManyToOne
    private Account to;
    @Column(nullable = false)
    private Double amountFunds;

    public Transaction(Account from, Account to, Double amountFunds) {
        this.from = from;
        this.to = to;
        this.amountFunds = amountFunds;
    }

    public Transaction(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getFrom() {
        return from;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public Account getTo() {
        return to;
    }

    public void setTo(Account to) {
        this.to = to;
    }

    public Double getAmountFunds() {
        return amountFunds;
    }

    public void setAmountFunds(Double amountFunds) {
        this.amountFunds = amountFunds;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", amountFunds=" + amountFunds +
                '}';
    }
}
