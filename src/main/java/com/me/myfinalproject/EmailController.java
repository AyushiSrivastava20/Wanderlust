
package com.me.myfinalproject;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.me.myfinalproject.pojo.Booking;

public class EmailController {

     private final String user="wanderlustorg20@gmail.com";
        private final String password="ayushi20";
        private String recipient;
        
        public void sendEmail(){
            //String recipient = "";
            Properties props = new Properties();  
                props.put("mail.smtp.starttls.enable", "true"); 
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.user", user); // User name
                props.put("mail.smtp.password", password); // password
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true"); 
         
         Session session = Session.getDefaultInstance(props,  new javax.mail.Authenticator() {  
          protected PasswordAuthentication getPasswordAuthentication() {  
        return new PasswordAuthentication(user,password);  
          }  
        });  
      
       //Compose the message  
        try {  
         MimeMessage message = new MimeMessage(session);  
         message.setFrom(new InternetAddress(user));  
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient));  
         message.setSubject("Booking Confirmation- Wanderlust");  
         String b = "You have succesfully Booked your Stay with Wanderlust";
         message.setText(b);
        

         Transport.send(message);  
      
         System.out.println("message sent");  
       
         } catch (MessagingException e) {e.printStackTrace();}  
        
    }

        public String getRecipient() {
            return recipient;
        }

        public void setRecipient(String recipient) {
            this.recipient = recipient;
        }
        
}