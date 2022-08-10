package com.study.udo.demo1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @author lwh
 * @date 2022/7/29 14:39
 */
public class Server {

    /**
     * ��������
     * 1����������ˣ�DatagramSocket�� +ָ���ķ��Ͷ˿�
     * 2��׼�����ݣ����ֽ��������ʽ
     * 3�����DatagramPacket�ͻ��˵ĵ�ַ�Ͷ˿�
     * 4������
     * 5���ͷ���Դ
     *
     */
    public static void main(String[] args) {

        DatagramSocket datagramSocket = null;
        try {
            datagramSocket =new DatagramSocket();
            System.out.println("����˽��з���");
            String sendMsg = "�����޴�ѽ�����ǿͻ�����Ϣ���������ݷ��͡�";
            byte[] sendMsgBytes = sendMsg.getBytes(StandardCharsets.UTF_8);
            DatagramPacket datagramPacket = new DatagramPacket(sendMsgBytes,sendMsgBytes.length, InetAddress.getByName("localhost"),6666);
            datagramSocket.send(datagramPacket);
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            if (null != datagramSocket){
                datagramSocket.close();
            }
        }




    }
}
