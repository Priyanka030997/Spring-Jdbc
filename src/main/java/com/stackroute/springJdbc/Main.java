package com.stackroute.springJdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

public class Main
{
   public static void main(String args[])
   {
       ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigurationBean.class);
       StudentDao studentDao=applicationContext.getBean("studentDao",StudentDao.class);
       Student student=new Student();
      // studentDao.createTable();
       studentDao.insertData();
       studentDao.updateDetails();
       studentDao.readData();
      // studentDao.deleteDetails();

   }
}