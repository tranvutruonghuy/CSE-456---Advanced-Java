package vn.edu.eiu.cse456.presentation;

import vn.edu.eiu.cse456.data.BankTransferPayment;
import vn.edu.eiu.cse456.data.CardPayment;
import vn.edu.eiu.cse456.data.EwalletPayment;
import vn.edu.eiu.cse456.data.PaymentMethod;
import vn.edu.eiu.cse456.service.PaymentService;
public class Main {
    public static void main(String[] args) {
        // Choose payment method dynamically
        PaymentMethod method1 = new CardPayment();
        PaymentMethod method2 = new EwalletPayment();
        PaymentMethod method3 = new BankTransferPayment();

        // Inject into service layer
        PaymentService service1 = new PaymentService(method1); // Service with card payment
        PaymentService service2 = new PaymentService(method2); // Service with ewallet payment
        PaymentMethod service3 = new BankTransferPayment(); // Service with bank transfer payment

        // Call business logic
        service1.processPayment(150.75);
        service2.processPayment(100.00);
        service3.makePayment(900.00);

    }
}