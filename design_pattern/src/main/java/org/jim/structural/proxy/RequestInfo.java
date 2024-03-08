package org.jim.structural.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RequestInfo {
    private String apiName;
    private long responseTime, startTimestamp;
}
