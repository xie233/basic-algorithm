package org.jim.behavioral.observer.bus;


import org.jim.behavioral.observer.mockbus.Subscribe;

public class RecieptSender {

    @Subscribe
    public  void sendRecieptToCustomer(PaymentEvent paymentSuccessfulEvent){
        // Simulate sending reciept
        System.out.println("Reciept sent to Customer");
    }

    @Subscribe
    public  void sendRecieptToSeller(PaymentEvent paymentSuccessfulEvent){
        // Simulate sending reciept
        System.out.println("Reciept sent to Seller");
    }
}
