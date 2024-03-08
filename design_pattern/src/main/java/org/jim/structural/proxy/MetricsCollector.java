package org.jim.structural.proxy;

public class MetricsCollector {

    public void recordRequest(RequestInfo requestInfo){
        System.out.println(requestInfo);
    }
}
