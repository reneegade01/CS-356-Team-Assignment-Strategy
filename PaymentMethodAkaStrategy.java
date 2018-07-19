
public interface PaymentMethodAkaStrategy {
	
    boolean pay(int paymentAmount);
    void collectPaymentDetails();

}
