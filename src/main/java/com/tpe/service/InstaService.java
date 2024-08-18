package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component("insta_service")
//@Scope("singleton")
public class InstaService implements MsgService{

    @PostConstruct//bu anatasyon methodumuzun , constructor calıstıktan hemen sonra calısmasını saglar
    public void postConstruct(){
        System.out.println("------> Insta Service Objesi olustu!!!");
    }

    @PreDestroy//bu anatasyon ise objenin imhasindan hemen once bu methodun calismasını saglar
    public void preDestroy(){
        System.out.println("------> Insta Service objesi imha edildi!!!");
    }




    //field injection
    //@Autowired//bağımlılık olduğu durumlarda gerektiğinde otomatik deger atamasinin yapılmasını saglıyor
    //@Qualifier("fileRepository")//birden fazla aynı data tipi varsa bunlardan istedigimizden bean olusturmayi saglar
    //private Repository repo;

    //field injection'da enjekte etme işlemini instaservice classında yapıyorum ve obje olusurken benim enjekte ettigim degerin degisme olasili yok!!!

    //---------------------------------------------------------------

    //setter injection //sonradan repo degistirmeyi saglar!!! güvenilir değil!!!
    // private Repository repo;
    // @Autowired
    // @Qualifier("fileRepository")
    // public void setRepo(Repository repo) {
    //     this.repo = repo;
    // }

    //-----------------------------------------------------------------------
    //constructor injection
    private Repository repo;
    @Autowired
    public InstaService(@Qualifier("fileRepository") Repository repo) {
        this.repo = repo;
    }
    //obje olusturulken istedigim repoyu secebilirim sonradan degistirme imkanim yok neden cunku setter methodu yok!!!
    //final olmus olur neden cunku degistirilemez
    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız insta ile gonderiliyor.... : "+message);
    }

    @Override
    public void saveMessage(Message message) {
        repo.saveMessage(message);
    }
}