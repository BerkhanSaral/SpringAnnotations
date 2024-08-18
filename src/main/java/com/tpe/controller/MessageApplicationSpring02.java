package com.tpe.controller;

import com.tpe.AppConfiguration;
import com.tpe.service.InstaService;
import com.tpe.service.PrintService;
import com.tpe.service.SlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Properties;

public class MessageApplicationSpring02 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);
        //  //singleton
        //  InstaService service1=context.getBean(InstaService.class);
        //  System.out.println("service1 isimli instaservice objesini getBean methodu ile cagirdim");
        //  InstaService service2=context.getBean(InstaService.class);
        //  System.out.println("service2 isimli instaservice objesini getBean methodu ile cagirdim");
        //  //----------------------------------------------------------------------------------------------

        //  //prototype
        //  SlackService service3=context.getBean(SlackService.class);
        //  System.out.println("service3 isimli slackservice objesini getBean methodu ile cagirdim");
        //  SlackService service4=context.getBean(SlackService.class);
        //  System.out.println("service4 isimli slackservice objesini getBean methodu ile cagirdim");
        System.out.println("---------------------------------------------------------------");
        PrintService service=context.getBean(PrintService.class);
        service.printContact();
        System.out.println("----------------------Properties ile---------------------------");
        System.out.println("---------------------------------------------------------------");
        service.getContact();
        System.out.println("---------------------------------------------------------------");



        context.close();
        //    InstaService service5=context.getBean(InstaService.class);
    }
}