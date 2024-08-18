package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;

public class WhatsappService implements MsgService{
    private Repository repository;
    public WhatsappService(Repository repository){
        this.repository=repository;
    }
    @Override
    public void sendMessage(Message message){
        System.out.println("Mesajınız whatsapp üzerinden gönderiliyor.... : "+message);
    }

    @Override
    public void saveMessage(Message message) {
        repository.saveMessage(message);
    }

}