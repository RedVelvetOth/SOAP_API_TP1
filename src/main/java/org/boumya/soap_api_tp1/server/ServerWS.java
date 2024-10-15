package org.boumya.soap_api_tp1.server;


import jakarta.xml.ws.Endpoint;
import org.boumya.soap_api_tp1.SoapApiTp1Application;
import org.boumya.soap_api_tp1.webservice.ProductWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ServerWS {
    @Autowired
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SoapApiTp1Application.class, args);
        String url = "http://localhost/8088/";
        ProductWebService productWebService = context.getBean(ProductWebService.class);
        Endpoint.publish(url, productWebService);
        System.out.println(url + " deployed");
    }
}
