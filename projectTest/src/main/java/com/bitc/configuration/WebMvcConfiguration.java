package com.bitc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bitc.interceptor.LoginCheckInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setDefaultEncoding("UTF-8");
		commonsMultipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024);
		
		return commonsMultipartResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("file:///C:/img/");
		
	
		
		
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		로그인 체크를 위한 클래스가 자동 생성되어서 지정된 패턴의 페이지에 접속 시 controller 보다 먼저 실행되어 로그인을 체크한다.
//		addPathPatterns("패턴") : 인터셉터를 사용할 컨트롤러 선택
//		excludePathPatterns("주소") : 인터셉터를 미 적용할 컨트롤러 선택
		
		registry.addInterceptor(new LoginCheckInterceptor())
		.addPathPatterns("/login/**")
		.excludePathPatterns("/login/loginfail")
		.excludePathPatterns("/login/login")
		.excludePathPatterns("/login/check")
		.excludePathPatterns("/login/somethingwrong");
	}
}
