package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.DbRepository;
import com.tpe.repository.FileRepository;
import com.tpe.repository.Repository;

public class SmsService implements MsgService{
    private Repository repository;//hangi repo belli degil

    public SmsService(Repository repository){//cons ile repository hangi repoya baglanıcak onu seciyorum
        this.repository=repository;
    }
    @Override
    public void sendMessage(Message message) {
        System.out.println("Sms ile Message gonderiliyor.... : "+message);

    }

    @Override
    public void saveMessage(Message message) {
        //DbRepository repository1=new DbRepository();//postgresql
        //FileRepository repository1=new FileRepository();//bilgisayar icerindeki a isimle olusturdugum not defteri
        //repository1.saveMessage(message);

        repository.saveMessage(message);
    }
}