package com.imarchuang.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by marchuang on 2017-07-21.
 */
//Service Endpoint Interface
@WebService
//@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWorldWs {

    @WebMethod
    String getHelloWorldAsString(String name);

}
