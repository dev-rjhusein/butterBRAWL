package xyz.devrj.butterbrawl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)	//Disable white label error pages for dev
public class ButterBrawlApplication implements WebMvcConfigurer {

	public static void main(String[] args) {

		SpringApplication.run(ButterBrawlApplication.class, args);
	}

	//Define a bean for the ViewResolver
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
}

