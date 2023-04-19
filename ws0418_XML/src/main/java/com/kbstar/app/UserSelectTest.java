package com.kbstar.app;

import com.kbstar.dto.ProductDTO;
import com.kbstar.frame.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserSelectTest {
    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");

        MyService<String, ProductDTO> service =
                (MyService<String, ProductDTO>) factory.getBean("pservice");
        System.out.println(service.get("id01").toString());
    //System.out.println(service.get("id01").getName()); 게터세터가 있으므로 네임, 가격, 수량 하니씩 가져 올수있다

    }
}
