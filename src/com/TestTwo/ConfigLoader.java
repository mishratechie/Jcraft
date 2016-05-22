package com.TestTwo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class ConfigLoader {

    public static Properties userProp,dbProp;


    static {
        try {
            File fileUserProp = null;
            String pathUserProp = "";


            fileUserProp=new File("src/main/resources/userConfig.properties");
            pathUserProp=fileUserProp.getAbsolutePath();
            System.out.println("UserProp AbsolutePath : " +pathUserProp);
            userProp = new Properties();
            userProp.load(new FileInputStream(pathUserProp));



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//Get User Configuration


    public static String getUsername(){
        return userProp.getProperty("username");
    }

    public static String getPassword(){
        return userProp.getProperty("password");
    }

//Get Database Configuration

}
