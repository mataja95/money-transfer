package transfer;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
@EntityListeners(AuditingEntityListener.class)
public class BankAccount {

    @Id
    private int id;
    private float amount;

    protected BankAccount() {
    }

    protected BankAccount(int id, float amount) {
        this.id = id;
        this.amount = amount;
    }

    protected int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "main.java.transfer.BankAccount{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
