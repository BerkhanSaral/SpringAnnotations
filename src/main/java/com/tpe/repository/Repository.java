package com.tpe.repository;

import com.tpe.domain.Message;

public interface Repository {

    //bu mesajlari db'e kaydetmek istiyorum
    void saveMessage(Message message);

}
