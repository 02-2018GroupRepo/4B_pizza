package bootcamp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import bootcamp.model.Location;
import bootcamp.services.LookUpServices;
import stub.server.StubbedServer;

@RestController
public class LookUpController {
    
	private LookUpServices service = new LookUpServices();
	
    @RequestMapping("/request")
    public String sendRequest() throws ResourceAccessException {
    	String response = "";
//    	String fakeTransactionUrl = "http://stubberserver/request";
    	String url = "http://192.168.88.66:8080/menu";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
//        StubbedServer restTemplate = new StubbedServer();
    	RestTemplate restTemplate = new RestTemplate();
        System.out.println("Sending request......");
        response = restTemplate.getForObject(builder.toUriString(), String.class);
        System.out.println(response);
        return response;
    }

    @RequestMapping("/response")
    public String sendResponse(@RequestParam(value="name", defaultValue="Atlanta") String name) {
        return service.getLocationByName(name).getLocation();
    }
    
    
//    private String makeCall() throws ResourceAccessException {
//        String transactionUrl = "http://localhost:8080/response";
//        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(transactionUrl);
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(builder.toUriString(), String.class);
//        return response;
//    }
}
