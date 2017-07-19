package com.cdk.oneonone.outlook;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.joda.time.DateTime;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VAlarm;
import biweekly.component.VEvent;
import biweekly.parameter.ParticipationLevel;
import biweekly.parameter.ParticipationStatus;
import biweekly.parameter.Related;
import biweekly.parameter.Role;
import biweekly.property.Action;
import biweekly.property.Attendee;
import biweekly.property.DateEnd;
import biweekly.property.DateStart;
import biweekly.property.Trigger;
import biweekly.util.Duration;

public class CalendarEvent2 {

private JavaMailSender javaMailSender;

public CalendarEvent2(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
}

public void createCal(String sender,String reciepnts, String reciepntsEmail,String startDate, String endDate, String meetingRoom,String subjectLine, String description) throws MessagingException, ParseException, IOException {

    ICalendar ical = new ICalendar();

    VEvent event = new VEvent();

    Attendee attendee = new Attendee(reciepnts, reciepntsEmail);
    attendee.setRsvp(true);
    attendee.setRole(Role.ATTENDEE);
    attendee.setParticipationStatus(ParticipationStatus.NEEDS_ACTION);
    attendee.setParticipationLevel(ParticipationLevel.REQUIRED);

    event.addAttendee(attendee);

    event.setSummary("hello");

    DateTime dt = new DateTime(2017, 8, 20, 12, 50);
    DateTime et = new DateTime(2017, 8, 20, 13, 30);
    Date starts = (Date) dt.toDate();
    Date ends = (Date) et.toDate();

    DateStart thisStart = new DateStart(starts, true);
    DateEnd dateEnd = new DateEnd(ends, true);

    event.setDateStart(thisStart);
    event.setDateEnd(dateEnd);

    Duration reminder = new Duration.Builder().minutes(15).build();
    Trigger trigger = new Trigger(reminder, Related.START);
    Action action = new Action("DISPLAY");
    VAlarm valarm = new VAlarm(action, trigger);
    event.addAlarm(valarm);

    Duration duration = new Duration.Builder().hours(1).build();
    event.setDuration(duration);

    event.setUid("cdk"+UUID.randomUUID());
    event.setOrganizer(sender);
    event.setLocation("Conference");

    ical.addEvent(event);
    ical.setMethod("REQUEST");

    String str = Biweekly.write(ical).go();

    MimeMessage message = javaMailSender.createMimeMessage();
    message.addHeaderLine("charset=UTF-8");
    message.addHeaderLine("component=VEVENT");
    message.addHeaderLine("method=REQUEST");

    message.setFrom(new InternetAddress(sender));
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(reciepntsEmail));
    message.setSubject("You're Invited to a Meeting");

    
   // SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HHmmssX");
    
   // String startDate = sdf.format(new Date());
     
    //java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2017-07-17 18:10:10.0");
     
   // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmssX");
   
//    StringBuffer sb = new StringBuffer();
//
//    StringBuffer buffer = sb.append(
//            "BEGIN:VCALENDAR\n"
//            + "PRODID:-//Microsoft Corporation//Outlook 10.0 MIMEDIR//EN\n"
//            + "VERSION:2.0\n"
//            + "METHOD:REQUEST\n"
//            + "BEGIN:VTIMEZONE\n"
//            + "TZID:Asia/Kolkata\n"
//            + "X-LIC-LOCATION:Asia/Kolkata\n"
//            + "BEGIN:STANDARD\n"
//            + "DTSTART:"+startDate+"\n"
//            + "DTEND:"+endDate+"\n"
//            + "TZOFFSETFROM:0530\n"
//            + "TZOFFSETTO:0530\n"
//            + "TZNAME:IST\n"
//            + "END:STANDARD\n"
//            + "BEGIN:DAYLIGHT\n"
//            + "DTSTART:"+startDate+"\n"
//            + "TZOFFSETFROM:0530\n"
//            + "TZOFFSETTO:0530\n"
//            + "TZNAME:EDT\n"
//            + "END:DAYLIGHT\n"
//            + "END:VTIMEZONE\n"
//            + "BEGIN:VEVENT\n"
//            + "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:" + Reciepnts + "\n"
//            + "ORGANIZER:MAILTO:"+sender+"\n"
//            + "DTSTART;TZID=Asia/Kolkata:" +startDate + "\n"
//            + "DTEND;TZID=Asia/Kolkata:" +endDate + "\n"
//            + "LOCATION:Conference room\n"
//            + "TRANSP:OPAQUE\n"
//            + "SEQUENCE:0\n"
//            + "UID:" + UUID.randomUUID() + "\n"
//            + "DTSTAMP:"+timestamp+"\n"
//            + "CATEGORIES:Meeting\n"
//            + "DESCRIPTION:" + Description + "\n"
//            + "SUMMARY:" + subjectLine + "\n"
//            + "PRIORITY:5\n"
//            + "CLASS:PUBLIC\n"
//            + "BEGIN:VALARM\n"
//            + "TRIGGER:PT1440M\n"
//            + "ACTION:DISPLAY\n"
//            + "DESCRIPTION:Reminder\n"
//            + "END:VALARM\n"
//            + "END:VEVENT\n"
//            + "END:VCALENDAR");
  // MimeMessage message = javaMailSender.createMimeMessage();
//    message.addHeaderLine("charset=UTF-8");
//    message.addHeaderLine("component=VEVENT");
//    message.addHeaderLine("method=REQUEST");

//    message.setFrom(invite.getUserID());
//    message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
//    message.setSubject(invite.getSubject());

    BodyPart messageBodyPart = new MimeBodyPart();

    messageBodyPart.setHeader("Content-Class", "urn:content-classes:calendarmessage");
    messageBodyPart.setHeader("Content-ID", "calendar_message");
  //  messageBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(buffer.toString(), "text/calendar")));

    messageBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(str, "text/calendar")));// very important    
    Multipart multipart = new MimeMultipart();

    multipart.addBodyPart(messageBodyPart);

    message.setContent(multipart);

    javaMailSender.send(message);

}

//
//public static void main(String[] args) {
//
//        String host = "dsxfe4he.ds.ad.adp.com";// hostname of the mail server
//        String port = "25";
//        String from = "vedprakash.gupta@cdk.com"; // from internet address
//        String to = "satish.rajput@cdk.com"; // to internet address
//        Properties prop = new Properties();
//        prop.put("mail.host", host);
//        prop.put("mail.port",port);
//        Session session = Session.getDefaultInstance(prop, null);
//        
//        
//        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//        javaMailSender.setHost(host);
//        
//        
//        CalendarEvent2  inEvent = new CalendarEvent2(javaMailSender);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HHmmssX");
//        //20150910T105742Z
//         String startDate = sdf.format(new Date());
//         String endDate = sdf.format(new Date());
//        try {
//        
//        	inEvent.createCal("Dipak.Suryavanshi@cdk.com","ved", "vedprakash.gupta@cdk.com", "20180301T080000", "20170801T090000", "Conference", "You're Invited to a Meeting", "This is Test Description");
//        	
//		} 
//        
//        catch(Exception e){
//        	System.out.println("error"+e.getMessage());
//        }
//        finally {
//			
//        }
//        System.out.println("completed");
//        
//        
//}
}