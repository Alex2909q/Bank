package functions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String accountNumber;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Client client;
    private Currency currency;
    private Double amount = 0.0;
    @OneToMany(mappedBy = "from",cascade = CascadeType.ALL)
    private List<Transaction> sentPayments = new ArrayList<>();
    @OneToMany(mappedBy = "to",cascade = CascadeType.ALL)
    private List<Transaction> resentPayments = new ArrayList<>();

    public Account(String accountNumber, Client client, Currency currency) {
        this.accountNumber = accountNumber;
        this.client = client;
        this.currency = currency;
    }
    public Account(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Transaction> getSentPayments() {
        return sentPayments;
    }

    public void setSentPayments(List<Transaction> sentPayments) {
        this.sentPayments = sentPayments;
    }

    public List<Transaction> getResentPayments() {
        return resentPayments;
    }

    public void setResentPayments(List<Transaction> resentPayments) {
        this.resentPayments = resentPayments;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", client=" + client +
                ", currency=" + currency +
                ", amount=" + amount +
                ", sentPayments=" + sentPayments +
                ", resentPayments=" + resentPayments +
                '}';
    }
}
