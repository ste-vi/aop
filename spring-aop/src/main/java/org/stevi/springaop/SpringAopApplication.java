package org.stevi.springaop;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.stevi.springaop.aspect.LoggingAspect;
import org.stevi.springaop.service.BookService;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringAopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringAopApplication.class, args);
        BookService bookService = applicationContext.getBean(BookService.class);

		AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(bookService);
		aspectJProxyFactory.addAspect(LoggingAspect.class);
		BookService proxy = aspectJProxyFactory.getProxy();

        Integer id = proxy.insertBook("Book");
        String book = proxy.getBook(id);
        proxy.removeBook(id);
    }

}
