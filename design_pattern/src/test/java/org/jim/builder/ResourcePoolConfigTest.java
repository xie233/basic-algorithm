package org.jim.builder;

import org.jim.creational.builder.ResourcePoolConfig;
import org.junit.jupiter.api.Test;

public class ResourcePoolConfigTest {

    @Test
    public void illegalArgumentExceptionTest(){
        // minIdle>maxIdle
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("db_connection_pool")
                .setMaxTotal(16)
                .setMaxIdle(10)
                .setMinIdle(12)
                .build();
    }

    @Test
    public void buildTest(){
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("db_connection_pool_2")
                .setMaxTotal(16)
                .setMaxIdle(12)
                .setMinIdle(12)
                .build();
    }
}
