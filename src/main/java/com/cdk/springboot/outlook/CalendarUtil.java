package com.cdk.springboot.outlook;

import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSenderImpl;

public class CalendarUtil {


    public  static JavaMailSenderImpl  getMailerService(){
        String host = "dsxfe4he.ds.ad.adp.com";// hostname of the mail server
        String port = "25";
//      String from = "vedprakash.gupta@cdk.com"; // from internet address
//      String to = "satish.rajput@cdk.com"; // to internet address
        Properties prop = new Properties();
        prop.put("mail.host", host);
        prop.put("mail.port",port);
        //   Session session = Session.getDefaultInstance(prop, null);


        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
//

        return javaMailSender;

    }
}