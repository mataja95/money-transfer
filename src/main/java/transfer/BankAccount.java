package transfer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount {

    @Id
    private int id;
    private float money;

    protected BankAccount(int id, float money) {
        this.id = id;
        this.money = money;
    }

    protected int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "main.java.transfer.BankAccount{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
