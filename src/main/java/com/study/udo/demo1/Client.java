package com.study.udo.demo1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author lwh
 * @date 2022/7/29 14:53
 */
public class Client {
    public static void main(String[] args) {
        /**
         * 1����������ˣ�DatagramSocket�� +ָ���ķ��Ͷ˿�
         * 2��׼�����ݣ����ֽ��������ʽ
         * 3�����DatagramPacket�ͻ��˵ĵ�ַ�Ͷ˿�
         * 4������
         * 5���ͷ���Դ
         *
         */
        DatagramSocket datagramSocket = null;
        try {

            datagramSocket  = new DatagramSocket(6666);
            byte[] receiveByBites = new byte[2048];
            DatagramPacket datagramPacket = new DatagramPacket(receiveByBites,2048);
//            datagramSocket�������ݣ�����¼�������ݵĳ���
            System.out.println("�ͻ���׼����ϣ��ȴ�����˷������ݣ�");
            datagramSocket.receive(datagramPacket);
            // �������� ��װ�ֽ�����
            String receiveStr = new String(receiveByBites,0,datagramPacket.getLength());
            System.out.println("���ܵ�����Ϊ"+receiveStr);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (datagramSocket != null){
                datagramSocket.close();
            }
        }
    }
}
