package bootcamp.controller;

import bootcamp.services.LookUpServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.Scanner;

@RestController
public class LookUpController {
    
	private LookUpServices service = new LookUpServices();
	
    @RequestMapping("/request")
    public Map<String, Double> sendRequest() throws ResourceAccessException {
    	Map<String, Double> response;
//    	String fakeTransactionUrl = "http://stubberserver/request";
    	String url = "http://192.168.88.81:8080/menu";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
//        StubbedServer restTemplate = new StubbedServer();
    	RestTemplate restTemplate = new RestTemplate();
        System.out.println("Sending request......");
        response = restTemplate.getForObject(builder.toUriString(), Map.class);
        System.out.println(response);
        return response;
    }

    @RequestMapping("/receipt")
    public String getReceipt() throws ResourceAccessException {
        String response;
        String url = "http://192.168.88.81:8080/receieptRequest";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Sending request......");
        response = restTemplate.getForObject(builder.toUriString(), String.class);
        System.out.println(response);
        return response;
    }

    @RequestMapping("/response")
    public Map<String, Double> sendResponse() {
        Scanner order_input = new Scanner(System.in);
        Map<String, Double> pizzaMenu = sendRequest();
        String cus_input;
        boolean send = false;

//        while(!send) {
//            print(pizzaMenu);
//            System.out.println("Enter the pizza you want to order");
//            cus_input = order_input.nextLine();
//            if(cus_input.equals("send")) {
//                System.out.println("Sent order!");
//                send = true;
//            }
//            else if(pizzaMenu.containsKey(cus_input)) {
//                System.out.println("Put " + cus_input + " in the order");
//                service.getLookupdao().putInOrder(cus_input, pizzaMenu.get(cus_input));
//            } else System.err.println("[ERROR]: No such pizza in the menu");
//        }

        service.getLookupdao().putInOrder("Cheese", pizzaMenu.get("Cheese"));
        service.getLookupdao().putInOrder("Cheese", pizzaMenu.get("Cheese"));
        service.getLookupdao().putInOrder("Sausage", pizzaMenu.get("Sausage"));
        service.getLookupdao().putInOrder("Sausage", pizzaMenu.get("Sausage"));
        service.getLookupdao().putInOrder("Cheese", pizzaMenu.get("Cheese"));
        service.getLookupdao().putInOrder("Pepperoni", pizzaMenu.get("Pepperoni"));


        return service.getLookupdao().getOrder();
    }

    public void print(Map<String, Double> menu) {
        System.out.println(menu.toString());
    }
    
    
//    private String makeCall() throws ResourceAccessException {
//        String transactionUrl = "http://localhost:8080/response";
//        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(transactionUrl);
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(builder.toUriString(), String.class);
//        return response;
//    }
}
