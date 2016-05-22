package com.TestOne;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class JcraftSession {

	public static Session getJcraftSession() throws JSchException, IOException {
		
		Properties prop=new Properties();
		prop.load(new FileInputStream("src\\main\\resources\\userConfig.properties"));
		
		String linuxHost=prop.getProperty("linuxHost");
		String usernameLinux=prop.getProperty("username");
		String passwordLinux=prop.getProperty("password");
		
		JSch conn = new JSch();
		String userName = usernameLinux;
		String password = passwordLinux;
		String host = linuxHost;
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

