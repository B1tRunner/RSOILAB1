package com.example.client;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import javax.xml.rpc.ServiceException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Application {
    public static void main(String[] args) throws IOException, ServiceException {
        String endpoint = "http://localhost:8080/axis/Phone.jws";
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new URL(endpoint));

        System.out.println("1. enter the phone");
        System.out.println("2. enter the name");
        System.out.println("3. exit");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        line = in.readLine();
        while (!(line.equals("3"))){
            if (line.equals("1")) {
                String phone = in.readLine();
                Object[] param1 = new Object[]{phone};
                String response = (String) call.invoke("phone_name", param1);
                System.out.println("phone: " + phone + "name: " + response);
            }
            if (line.equals("2")) {
                String name = in.readLine();
                Object[] param2 = new Object[]{name};
                String response = (String) call.invoke("name_phone", param2);
                System.out.println("phone: " + response + "name: " + name);
            }
            System.out.println("1. enter the phone");
            System.out.println("2. enter the name");
            System.out.println("3. exit");
            line = in.readLine();
        }

    }
}
