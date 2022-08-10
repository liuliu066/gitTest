package com.study.udo.demo2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author lwh
 * @date 2022/7/29 14:39
 */
public class Server {

    /**
     * 服务器端
     * 1、创建服务端，DatagramSocket类 +指定的发送端口
     * 2、准备数据，以字节数组的形式
     * 3、打包DatagramPacket客户端的地址和端口
     * 4、发送
     * 5、释放资源
     *
     */
    public static void main(String[] args) {

        DatagramSocket datagramSocket = null;
        try {

            datagramSocket =new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("请输入信息：");
                String sendMsg = scanner.next();
//                System.out.println("服务端进行发送");
//                String sendMsg = "我真愚蠢呀，我是客户端信息，测试数据发送。";
                byte[] sendMsgBytes = sendMsg.getBytes(StandardCharsets.UTF_8);
                DatagramPacket datagramPacket = new DatagramPacket(sendMsgBytes,sendMsgBytes.length, InetAddress.getByName("localhost"),6666);
                datagramSocket.send(datagramPacket);
                System.out.println("数据发送完毕。。。。");
            }




        }catch (Exception e){
            e.printStackTrace();
        }finally {

            if (null != datagramSocket){
                datagramSocket.close();
            }
        }


    }
}
