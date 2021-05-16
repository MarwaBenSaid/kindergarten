package tn.esprit.spring.services;

import tn.esprit.spring.entities.SmsRequest;

public interface SmsSender {


    void sendSms(SmsRequest smsRequest);

    // or maybe void sendSms(String phoneNumber, String message);
}