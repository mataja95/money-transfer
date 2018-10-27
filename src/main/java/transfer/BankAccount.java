package transfer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount {

    @Id
    private int number;
    private float money;

    public BankAccount(int number, float money) {
        this.number = number;
        this.money = money;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
                "number=" + number +
                ", money=" + money +
                '}';
    }
}
