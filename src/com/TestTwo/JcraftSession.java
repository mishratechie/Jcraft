package com.TestTwo;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.IOException;
import java.util.Properties;


public class JcraftSession {

    public static Session getJcraftSession() throws JSchException, IOException {

        String usernameLinux=ConfigLoader.getUsername();
        String passwordLinux=ConfigLoader.getPassword();

        JSch conn = new JSch();
        String userName = usernameLinux;
        String password = passwordLinux;

        String host = "qaMachine";//IP will also work

        Session session = conn.getSession(userName,host, 22);
        session.setPassword(password);
        session.setTimeout(300000);
        Properties properties = new Properties();
        properties.put("StrictHostKeyChecking", "no");
        //session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
        session.setConfig(properties);

        return session;
    }

}
