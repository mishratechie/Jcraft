package com.TestTwo;

//Cpoies file from Linux to Windows

import com.jcraft.jsch.*;

import java.io.IOException;

public class FetchFileFromLinux {

    public static void main(String[] args) throws IOException, JSchException, SftpException {

        Session session=JcraftSession.getJcraftSession();
        session.connect();
        Channel channel = session.openChannel("sftp");
        channel.connect();


        String copyFrom = "/local/home/test_qa/outputTeamTest.log";
        String copyTo = "./";

        ChannelSftp sftpChannel = (ChannelSftp) channel;
        sftpChannel.get(copyFrom, copyTo);
        sftpChannel.exit();

        session.disconnect();



    }
}
