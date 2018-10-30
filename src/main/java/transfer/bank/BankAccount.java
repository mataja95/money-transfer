package transfer.bank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "account")
@EntityListeners(AuditingEntityListener.class)
public class BankAccount {

    public static class DbKeys {

        private static final String ID = "id";
        private static final String AMOUNT = "amount";
    }

    @Id
    @NotNull(message = "Please provide Account number.")
    @Column(name = DbKeys.ID)
    private Integer id;

    @Column(name = DbKeys.AMOUNT)
    private Float amount;

    protected BankAccount() {
    }

    public BankAccount(Integer id) {
        this.id = id;
        this.amount = (float) 0;
    }

    public BankAccount(Integer id, Float amount) {
        this.id = id;
        this.amount = amount;
    }

    protected Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "main.java.transfer.bank.BankAccount{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
