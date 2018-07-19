public class CreditCard {
    private int amount;
    private String number;
    private String expiration;
    private String cvv;

    CreditCard(String number2, String expiration2, String cvv2) {
        this.amount = 100_000;
        this.number = number2;
        this.expiration = expiration2;
        this.cvv = cvv2;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
