package com.stackroute.giphermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.stackroute.giphermanager.jwtfilter.JwtFilter;

import brave.sampler.Sampler;

//@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@SpringBootApplication
@EnableDiscoveryClient
//@RestController
//@EnableFeignClients
@ComponentScan("com.stackroute.*")
public class GipherManagerApplication {
	
	final static String API_KEY="QPayNCt8xoMomlYfVdySXOEGxAxXfiV2";
	
	
   
	
	
	public static void main(String[] args) {
		//RestTemplate restTemplate=new RestTemplate();
	//	DataModel dataModel=restTemplate.getForObject("http://api.giphy.com/v1/gifs/search?api_key=QPayNCt8xoMomlYfVdySXOEGxAxXfiV2&q=modi", DataModel.class);
		SpringApplication.run(GipherManagerApplication.class, args);
		//System.out.println("response::"+dataModel.toString());
	}
	@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
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
		registrationBean.addUrlPatterns("/gipher-manager/*");
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


}

