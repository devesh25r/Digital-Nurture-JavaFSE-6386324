package com.cognizant.spring_learn;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

@SpringBootApplication
public class HandsOn2App {

    public static void main(String[] args) throws ParseException {
        displayDate();
    }

    public static void displayDate() throws ParseException {
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        Date parsedDate = format.parse("31/12/2018");
        System.out.println("Parsed Date: " + parsedDate);
    }
}

