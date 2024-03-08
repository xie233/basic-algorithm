package org.jim.behavioral.observer.bus;




import org.jim.behavioral.observer.mockbus.AsyncEventBus;
import org.jim.behavioral.observer.mockbus.EventBus;

import java.util.concurrent.Executors;

public class EventBusFactory {

    //hold the instance of the event bus here
    //private static EventBus eventBus = new AsyncEventBus(Executors.newCachedThreadPool());
    private static final EventBus eventBus = new EventBus();
    public static EventBus getEventBus() {
        return eventBus;
    }

}
