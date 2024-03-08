package org.jim.behavioral.observer.bus;


import org.jim.behavioral.observer.mockbus.EventBus;

public class PaymentService {
    EventBus eventBus = EventBusFactory.getEventBus();

    public void onPaymentSuccessful (String payment) {
        PaymentEvent paymentEvent = new PaymentEvent();
        paymentEvent.setName(payment);
        //post the payment event, after this point,
        //all methods that subscribed to payment event are executed Asynchronously
        eventBus.post(paymentEvent);
    }

    public static void main(String[] args) {
        EventBusFactory.getEventBus().register(new RecieptSender());
        PaymentService paymentService = new PaymentService();
        paymentService.onPaymentSuccessful("pay me ");
    }
}
