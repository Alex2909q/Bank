package functions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Client {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String clientName;
    @Column
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    public Client(String clientName) {
        this.clientName = clientName;
    }

    public Client(String clientName, List<Account> accounts) {
        this.clientName = clientName;
        this.accounts = accounts;
    }

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> bankAccounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
