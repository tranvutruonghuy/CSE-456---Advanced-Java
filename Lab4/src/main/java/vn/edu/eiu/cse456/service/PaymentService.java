package vn.edu.eiu.cse456.service;

import vn.edu.eiu.cse456.data.PaymentMethod;

public class PaymentService {

    // Single Responsibility Principle:
    // This class is responsible only for coordinating payment processing logic.
    private PaymentMethod paymentMethod;

    // Constructor Dependency Injection
    public PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        paymentMethod.makePayment(amount);
    }
}