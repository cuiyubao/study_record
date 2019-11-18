package com.study.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * socket客户端
 */
public class ThreadClient {
    public static void main(String[] args) throws IOException {
        //为了简单起见，所有的异常都直接往外抛
        //要连接的服务端IP地址
        String host = "172.168.50.127";
        /* 要连接的服务端对应的监听端口 */
        int port = 8899;
        //与服务端建立连接

        Socket client = new Socket(host, port);
        //建立连接后就可以往服务端写数据了
        Writer writer = new OutputStreamWriter(client.getOutputStream());

        try {
            for (int i = 0; i < 10000; i++) {
                writer.write("{\"traceid\":\"" + i + "\",\"duration\":\"958915\",\"requestInfoList\":[\"cs:134.192.110.212:58191:1106.告警监控列表-自动刷新查询告警:2019-08-20 20:51:01\",\"cr:134.192.110.212:58191:1106.告警监控列表-自动刷新查询告警:2019-08-20 20:51:02\"],\"name\":\"告警监控列表-自动刷新查询告警\",\"time\":\"2019-08-20 20:51:01\",\"id\":\"720ed4b7b0c949e89bc1306ae686d812\",\"binaryInfo\":[{\"area\":\"8450000\",\"sdomainname\":\"\",\"firstSystemName\":\"告警监控列表-自动刷新查询告警\",\"orderno\":\"1566305462009\",\"display\":\"1\",\"display_name\":\"显示\",\"scencecode\":\"11999999999\",\"logcode_name\":\"\",\"logtype\":\"0\",\"logcode\":\"0,1\",\"logtype_name\":\"正常业务埋点\",\"servno\":\"3\",\"id\":\"720ed4b7b0c949e89bc1306ae686d812\",\"resultcode\":\"0\",\"custorderstatus\":\"\",\"spanname\":\"告警监控列表-自动刷新查询告警\"}]}\n");
                writer.flush();
            }
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            writer.close();
            client.close();
        }
    }
}