package com.tpe.controller;

import com.tpe.domain.Message;
import com.tpe.repository.FileRepository;
import com.tpe.repository.Repository;
import com.tpe.service.MsgService;
import com.tpe.service.WhatsappService;

public class MessageApplication {
    public static void main(String[] args) {
        Message message = new Message();
        message.setBody("Spring is COMING...");
        Repository repository = new FileRepository();
        MsgService service = new WhatsappService(repository);
        //olusturdugumuz mesajı mail ile gondermek istersem!!!
        //MailService mailService=new MailService();//guncellemek icin burayi sildim
        //mailService.sendMessage(message);

        //ayni mesaji mail ile degil whatsapp ile gonder!!!
        //WhatsappService whatsappService=new WhatsappService();//burayi tekrar baştan olusturdum
        //whatsappService.sendMessage(message);

        //ayni mesaji whatsapp yerine sms ile gonder deseydim!!!
        //SmsService smsService=new SmsService();
        //smsService.sendMessage(message);

        //------------------------------------------------------------
        service.sendMessage(message);//ne ile new'lersem ona gore degisiklik olur!!!

        //bu mesajlari db'e kaydetmek istiyorum
        //service.saveMessage(message);

        //ben bu mesaji db'e degilde birde dosyanin icerisine(file) kaydetmek istersem
        //service.saveMessage(message);

        //------------------------------------------------
        service.saveMessage(message);
    }
}