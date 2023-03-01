package com.demo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.WebhookEndpoint;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DemoApi {
  public static void main(String[] args) throws StripeException {
	//  Response response=RestAssured.get("https://webhook.site/5b9496cb-f6ed-4952-b130-c4723bc98350/v0.5/users/auth/on-init");
	  
	  Stripe.apiKey = "sk_test_51Lpqu6SADBeOiBfbVdK3j2PnlC0VqTYv510GG44U2rELMG3kmet2giG5mDWDOniv2WbyYYTIY0CBwH7YQvpyaQp500ltRtixH1";
	  
	  List<Object> events=new ArrayList<Object>();
	     events.add("change.succeeded");
	     events.add("change.failed");
	     
	     Map<String, Object>  map=new HashMap<String, Object>();
	     map.put("enabled_events", events);
	     map.put("url", "https://webhook.site/5b9496cb-f6ed-4952-b130-c4723bc98350");
	     
	     WebhookEndpoint updatedWebhookEndpoint = WebhookEndpoint.create(map);
	   
	  //System.out.println("hii11122444457==="+updatedWebhookEndpoint);
}
}
