package vn.edu.eiu.cse456.data;

public class EwalletPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing eWallet payment of $" + amount);
    }
}