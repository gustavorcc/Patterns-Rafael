package org.example;

public class NotificationFactory {
    Notification createNotification(String type){
        if(type.equalsIgnoreCase("email")){
            return new EmailNotification();
        } else if(type.equalsIgnoreCase("sms")){
            return new SMSNotification();
        } else if(type.equalsIgnoreCase("push")){
            return new PushNotification();
        } else {
            throw new IllegalArgumentException("Opção inválida tente de novo!");
    }
}