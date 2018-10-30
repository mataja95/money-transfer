package transfer.bank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankTransferModel {

    @JsonProperty
    private Integer fromAccountId;
    @JsonProperty
    private Integer toAccountId;
    @JsonProperty
    private Float amount;

    public Integer getFromAccountId() {
        return fromAccountId;
    }

    public void Integer(Integer fromAccount) {
        this.fromAccountId = fromAccount;
    }

    public Integer getToAccountId() {
        return toAccountId;
    }

    public void setToAccount(Integer toAccount) {
        this.toAccountId = toAccount;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
