package com.tpe.controller;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.InstaService;
import com.tpe.service.SlackService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageApplicationSpring {
    public static void main(String[] args) {
        Message message = new Message();
        message.setBody("Welcome Spring :)");

        //config classını okur ve componentscan ile componentlari(bizim olusturdugumuz classlarda) ve beanleri(bizim olusturmadigimiz classlarda) tarar
        //sadece 1 tane spring bean olusturur ve context atar ve hazır olarak bekletir
        //bean istendiginde gerekliyse icine bagimliginini enjekte ederek gonderir
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);


        // MsgService service=context.getBean(SlackService.class);//newlemedik,rica ettik :)
        // service.sendMessage(message);

        // MsgService service=context.getBean(MsgService.class);
        // service.sendMessage(message);//getBean olarak parent classı secersek otomatik olarak companent olan child class gelir

        //getBean methoduna parametre olarak parent verdik ancak birden fazla child(companent olan!!!) olsaydi ne yapardık?
         InstaService service=context.getBean("insta_service",InstaService.class);
         service.sendMessage(message);

        //kullanacıdan alma senoryosunda
        //System.out.println("1'e bastiginda insta");
        //System.out.println("2'e bastiginda slack");
        //int a=1;
        //String str;
        //if (a==1){
        //    str="insta_service";
        //}else {
        //    str="slack_service";
        //}
        //MsgService service=context.getBean(str,MsgService.class);
        //service.sendMessage(message);


        //Bağımlılık varsa ne olur?
        // InstaService service=context.getBean(InstaService.class);
        // DbRepository repository=context.getBean(DbRepository.class);
        //  InstaService service=context.getBean(InstaService.class);
        //  service.saveMessage(message);//insta_service'i newlemedik
        //service repoya bagımlı ama biz enjekte etmedik
        //spring SAĞOLSUN :)
        //DbRepository repository=context.getBean(DbRepository.class);
        //service.setRepo(repository);
        //service.saveMessage(message);


        //Random bir deger yazdiralim
        //Random rnd = new Random();
        //System.out.println(rnd.nextInt(100));

        //Random rnd = context.getBean(Random.class);
        //System.out.println(rnd.nextInt(100));
        //SlackService service=context.getBean(SlackService.class);
        //service.saveMessage(message);

        SlackService service1 = context.getBean(SlackService.class);
        SlackService service2 = context.getBean(SlackService.class);

        System.out.println(service1);
        System.out.println(service2);
        //Scope

        //default olarak singleton oluyor : bu classtan sadece bir tane bean uretiyor ve her seferinde bu beani cagiriyor!!!
        //bu olusturulan bean'in life cycle'ini Spring yonetir ve Spring Sorumludur!!!

        //prototype olarak degistirebiliriz : bu ise classtan her cagrildiginda farkli bir obje uretmeyi saglar!!!
        //Beanlerin imhasından Spring sorumlu degildir

        if (service1 == service2) {//== : hem referans hemde objenin degerini kontrol eder
            System.out.println("bu objeler aynidir!!!");
        } else {
            System.out.println("bu objeler ayni degildir!!!");
        }
//



    }
}