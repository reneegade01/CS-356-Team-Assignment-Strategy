import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class PaypalPaymentMethod implements PaymentMethodAkaStrategy {
	
	    private static final Map<String, String> DATA_BASE = new HashMap<>();
	    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
	    private String email;
	    private String password;
	    private boolean signedIn;

	    static {
	        DATA_BASE.put("securepassword", "sreller@cpp.edu");
	        DATA_BASE.put("qwerty", "no1@no1.net");
	    }

	    @Override
	    public void collectPaymentDetails() {
	        try {
	            while (!signedIn) {
	                System.out.print("Email: ");
	                email = READER.readLine();
	                System.out.print("Password: ");
	                password = READER.readLine();
	                if (verify()) {
	                    System.out.println("Verified.");
	                } else {
	                    System.out.println("Wrong password or email does not exist");
	                }
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }

	    private boolean verify() {
	        setSignedIn(email.equals(DATA_BASE.get(password)));
	        return signedIn;
	    }

	    @Override
	    public boolean pay(int paymentAmount) {
	        if (signedIn) {
	            System.out.println("Paying " + paymentAmount + " using PayPal.");
	            return true;
	        } else {
	            return false;
	        }
	    }

	    private void setSignedIn(boolean signedIn) {
	        this.signedIn = signedIn;
	    }
	}
