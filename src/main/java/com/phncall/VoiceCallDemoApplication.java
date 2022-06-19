package com.phncall;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URI;

@SpringBootApplication
public class VoiceCallDemoApplication {
    private final static String SID_ACCOUNT = "<My Twilo Account SID>";
    private final static String AUTH_ID = "<My Twilo Account AuthID>";
    private final static String FROM_NUMBER = "<FROM NUMBER>";
    private final static String TO_NUMBER = "<To NUmber>";

    static {
        Twilio.init(SID_ACCOUNT, AUTH_ID);
    }

    public static void main(String[] args) {

        SpringApplication.run(VoiceCallDemoApplication.class, args);

    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
                    new URI("http://demo.twilio.com/docs/voice.xml")).create();
        };
    }

}
