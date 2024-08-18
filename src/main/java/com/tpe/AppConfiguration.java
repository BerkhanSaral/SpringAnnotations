package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Properties;
import java.util.Random;

@Configuration//bu class'ın bir konfigurasyon classı oldugunu belirtiyoruz
@ComponentScan("com.tpe")//bu pathdeki tüm companentlari tarar
//default path:AppConfiguration classinin icinde bulundugu path'i tarar
@PropertySource("classpath:application.properties")//application.properties isimli dosyanin bilgileri okur(bu bilgileri okuyabilmesi icin dosya yolunu yazariz)
public class AppConfiguration {
    //Spring tarafından olusturulan bir interface bu interface PropertySource aradigimiz dosyalarin okunmasini saglayan methodlari icerir

    @Autowired
    private Environment environment;

    @Bean
    //bean=kucuk java objeleri!!!
    public Random random(){
        return new Random();//tek bir new keywordu ile istedigim kadar obje olusturabilirim!!!
    }

    //@value anatasyonu ile yaptıgımız işlemleri enviroment ve properties isimli classlar ile yapalım
    @Bean
    public Properties properties(){
        Properties properties=new Properties();
        properties.put("mymail",environment.getProperty("eposta"));
        properties.put("myphone",environment.getProperty("phone"));
        return properties;

    }
}