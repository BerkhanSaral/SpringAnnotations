package com.tpe.domain;

//Mesaj atmak icin bir app olusturalım
public class Message {//pojo ürün
    private String body;

    public String getBody() {
        return body;
    }


    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Mesaj : " +
                "body='" + body + '\'' +
                '}';
    }
}
