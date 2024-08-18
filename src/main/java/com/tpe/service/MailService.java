package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.DbRepository;
import com.tpe.repository.FileRepository;
import com.tpe.repository.Repository;

public class MailService implements MsgService{
    Repository respository;

    public MailService(Repository repository){
        this.respository=repository;
    }
    @Override
    public void sendMessage(Message message){
        System.out.println("Mesajınız mail ile gonderiliyor.... : "+message);
    }

    @Override
    public void saveMessage(Message message) {
        //FileRepository respository=new FileRepository();
        respository.saveMessage(message);
    }
}