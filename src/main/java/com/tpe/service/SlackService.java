package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

@Component
//bu classın objelerini biz degil spring olusturacak(biz new ile olusturuyor idik paramiz yetmiyor) ve yoneticek ve objere Spring Bean denir
@Scope("prototype")
public class SlackService implements MsgService {


    @PostConstruct
    public void postConstruct() {
        System.out.println("------> Slack Service Objesi olustu!!!");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("------> Slack Service objesi imha edildi!!!");
    }

    @Autowired
    private Random rnd;

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız slack ile gönderiliyor ...." + message);
    }

    @Override
    public void saveMessage(Message message) {
        //Random rnd=new Random();//newleme yaptım ama burda newleme yapmama aslında gerek yok
        System.out.println(rnd.nextInt(100));
    }
}