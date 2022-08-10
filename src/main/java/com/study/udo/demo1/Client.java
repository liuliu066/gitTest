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
         * 1、创建服务端，DatagramSocket类 +指定的发送端口
         * 2、准备数据，以字节数组的形式
         * 3、打包DatagramPacket客户端的地址和端口
         * 4、发送
         * 5、释放资源
         *
         */
        DatagramSocket datagramSocket = null;
        try {

            datagramSocket  = new DatagramSocket(6666);
            byte[] receiveByBites = new byte[2048];
            DatagramPacket datagramPacket = new DatagramPacket(receiveByBites,2048);
//            datagramSocket接受数据，并记录接受数据的长度
            System.out.println("客户端准备完毕，等待服务端发送数据：");
            datagramSocket.receive(datagramPacket);
            // 分析数据 组装字节数组
            String receiveStr = new String(receiveByBites,0,datagramPacket.getLength());
            System.out.println("接受的数组为"+receiveStr);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (datagramSocket != null){
                datagramSocket.close();
            }
        }
    }
}
