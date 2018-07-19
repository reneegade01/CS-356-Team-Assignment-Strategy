import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreditCardPaymentMethod implements PaymentMethodAkaStrategy {
	
	   private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
	   private CreditCard card;
	    
	    @Override
	    public void collectPaymentDetails() {
	        try {
	            System.out.print("Enter the card number: ");
	            String number = READER.readLine();
	            System.out.print("Enter the card expiration date 'mm/yy': ");
	            String expirationDate = READER.readLine();
	            System.out.print("Enter the CVV code: ");
	            String cvv = READER.readLine();
	            card = new CreditCard(number, expirationDate, cvv);


	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	   
	    @Override
	    public boolean pay(int paymentAmount) {
	        if (isCardPresent()) {
	            System.out.println("Paying " + paymentAmount + " using Credit Card.");
	            card.setAmount(card.getAmount() - paymentAmount);
	            return true;
	        } else {
	            return false;
	        }
	    }

	    private boolean isCardPresent() {
	        return card != null;
	    }

}
