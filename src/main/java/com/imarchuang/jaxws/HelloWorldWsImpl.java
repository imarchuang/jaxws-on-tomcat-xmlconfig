package com.imarchuang.jaxws;

import javax.jws.WebService;

/**
 * Created by marchuang on 2017-07-21.
 */

@WebService(endpointInterface = "com.imarchuang.jaxws.HelloWorldWs")
public class HelloWorldWsImpl implements HelloWorldWs {
    public String getHelloWorldAsString(String name) {
        return name + ", Hello World JAX-WS";
    }
}
