package com.hotspice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class HotspiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HotspiceApplication.class, args);
	}
	
	/**
     * Used when run as WAR
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HotspiceApplication.class);
    }

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
