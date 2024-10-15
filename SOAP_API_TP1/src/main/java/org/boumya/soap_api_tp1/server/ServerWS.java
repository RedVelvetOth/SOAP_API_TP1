package org.boumya.soap_api_tp1.server;


import jakarta.xml.ws.Endpoint;
import org.boumya.soap_api_tp1.webservice.ProductWebService;

public class ServerWS {
    public static void main(String[] args) {
        String url = "http://localhost/8088/";
        Endpoint.publish(url, new ProductWebService());
        System.out.println(url + " deployed");
    }
}
