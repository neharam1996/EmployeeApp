package com.tcs.springbootdemo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tcs.springbootdemo.model.Book;
import com.tcs.springbootdemo.model.Page;
import com.tcs.springbootdemo.model.Product;
import com.tcs.springbootdemo.repository.BookRepository;
import com.tcs.springbootdemo.repository.PageRepository;
import com.tcs.springbootdemo.service.ProductService;



@SpringBootApplication   
//it is a combination of 3 combinations @SpringbootConfiguration==(@Configuration),@EnableAutoConfiguration and @ComponentScan
//@EnableAutoConfiguration -it enables sping boot to auto=configure the applucation context
//it automatially creates and register beans based on both the included jar files in classpath and beans defined by us
//Spring mvc===>web jar(war) and tomcat server plugin
//when used spring web starter==>it includes the tomcat server mvc based on config
//exclude names autoconfig .we wan to skp specify that list tp @enableautoconfig
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SpringbootdemoApplication.class, args);
//		String [] beanNames=applicationContext.getBeanDefinitionNames();
//		Arrays.sort(beanNames);
//		for (String beanName:beanNames) {
//			System.out.println(beanName);
//		}	
//		
		
		
		
		
		System.out.println("after context creation");
		ProductService productService = context.getBean(ProductService.class);
		ProductService productService2 = context.getBean(ProductService.class);
		Product product = new Product(5, "laptop modified", "i5 10th gen", 123.0f, "mac laptop");
		String result = productService.createProduct(product);
		System.out.println(result);
		System.out.println(productService.equals(productService2));
		System.out.println(productService == productService2);
		
		Optional<List<Product>> optional = productService.getProductsByCategory("mac laptop");
		
		if(optional.isPresent()) {
			List<Product> products = optional.get();
			products.forEach(p->{
				System.out.println(p);
			});
		}
		else {
			System.out.println("problem");
		}
		
		BookRepository bookRepository=context.getBean(BookRepository.class);
		PageRepository pageRepository=context.getBean(PageRepository.class);
		
		Book book=new Book(0L,"Java","JamesG","java001",null);
		bookRepository.save(book);
		
		pageRepository.save(new Page(123,1,"Introduction","intro",book));
		pageRepository.save(new Page(111,1,"Introduction to java 8","intro to java 8",book));
		pageRepository.save(new Page(112,1,"Introduction to collection","intro to collection",book));
		
		System.out.println(pageRepository.findAll());
		
	
	}

}
