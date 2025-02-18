package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "org.example")
public class Configuration {


/*    @Bean
    public Cat cat() {
        Cat cat = new Cat();
        cat.setName("Mitzi");
        return cat;
    }

    @Bean
    public Owner owner(Cat cat) {
        Owner owner = new Owner(cat());
        return owner;
    }*/

    @Bean
    @Qualifier("cat1")
    public Cat cat1() {
        Cat cat = new Cat();
        cat.setName("Mitzi");
        return cat;
    }

    @Bean
    @Qualifier("cat2")
    public Cat cat2() {
        Cat cat = new Cat();
        cat.setName("Leo");
        return cat;
    }


    @Bean("A")
    public MyBean myBean1() {
        MyBean myBean = new MyBean();
        myBean.setName("Bean1");
        return myBean;
    }

    @Bean("B")
    public MyBean myBean2() {
        MyBean myBean = new MyBean();
        myBean.setName("Bean2");
        return myBean;
    }
}
