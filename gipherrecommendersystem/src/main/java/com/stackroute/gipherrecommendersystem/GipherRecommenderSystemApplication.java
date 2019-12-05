package com.stackroute.gipherrecommendersystem;

import java.io.IOException;
import java.util.List;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.gipherrecommendersystem.jwtfilter.JwtFilter;
import com.stackroute.gipherrecommendersystem.model.GipherRecommendation;
import com.stackroute.gipherrecommendersystem.service.GipherRecommendationService;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableBinding(Sink.class)
public class GipherRecommenderSystemApplication {
	
	@Autowired
	GipherRecommendationService gipherRecommendationService;
	
	

	public static void main(String[] args) {
		SpringApplication.run(GipherRecommenderSystemApplication.class, args);
	}
	
	/*
	 * Define the bean for Filter registration. Create a new FilterRegistrationBean
	 * object and use setFilter() method to set new instance of JwtFilter object.
	 * Also specifies the Url patterns for registration bean.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/gipher-recommandation/*");
		return registrationBean;
	}
	/*
	 * Define the bean for WebMvcConfigurer. Create a new WebMvcConfigurerAdapter object 
     * and add addCorsMappings(CorsRegistry registry) method to set addMapping and allowedOrigins
	 */
	@Bean
    public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter(){
		     @Override
		     public void addCorsMappings(CorsRegistry registry){
		    	 registry.addMapping("/*").allowedOrigins("*");
		     }
		     };
    }
	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}
	
	/*@RabbitListener(queues = "bookmarkRetrival")
	//@RabbitListener(queues = "${app1.queue.name}")
	public void processRegisterBookmark(String bookmark) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("bookmark Registered by Client " + bookmark);
		gipherRecommendationService.createRecommandation(bookmark);
		
	}*/
	
	//@StreamListener(target = Sink.INPUT)
	/*@RabbitListener(queues = "${app2.queue.name}")
	public void processDeletionBookmark(String dletedBookmark) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("bookmark deleted by Client " + dletedBookmark);
		gipherRecommendationService.deleteRecommandedGipher(dletedBookmark);
		/*Message messageData = new ObjectMapper().readValue(bookmark, Message.class);
		System.out.println("Dat recieved to add: " + messageData);*/
		//GipherRecommendation gipherRecommendation=prepareRecommendedGipherObject(messageData);
	//}



}

