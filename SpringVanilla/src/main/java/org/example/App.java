package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Configuration.class)) {
/*
            MyBean bean1 = ctx.getBean("A", MyBean.class);
            MyBean bean2 = ctx.getBean("B", MyBean.class);
            MyBean bean3 = ctx.getBean( "A",MyBean.class);
            System.out.println( bean1.getName());
            System.out.println( bean2.getName());
            System.out.println( bean3.getName());

            MyBean bean4 = new MyBean();
            System.out.println(bean4.getName());
*/

/*            Cat cat = ctx.getBean(Cat.class);*/
            /*            System.out.println(cat);*/
            Owner owner = ctx.getBean(Owner.class);
            System.out.println(owner);

        }
    }
}
