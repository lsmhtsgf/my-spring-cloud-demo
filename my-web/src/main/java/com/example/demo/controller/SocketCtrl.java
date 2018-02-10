package com.example.demo.controller;

import com.example.demo.Entity.SocketMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

@CrossOrigin // 注解方式
@RestController
public class SocketCtrl {

    @Autowired
    SocketMessage socketMessage;

    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins = "*")
    @RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
    public SocketMessage sendMsg(String ip, String port, String sendMsg) {
        socketMessage.setSendMsg(sendMsg);
        socketMessage.setIp(ip);
        socketMessage.setPort(port);
        //{"cardTermCode":"900491555410000","sOldRrn":"105351737696","sellCardRRN":"597939","transCode":"TA0010"}
        try {
            //1.创建客户端Socket，指定服务器地址和端口
            Socket socket = new Socket("124.126.12.68", 37511);
            //构建IO
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            String msg = String.format("%04d%s", sendMsg.length(), sendMsg);
            //向服务器端发送一条消息
            bw.write(msg);
            bw.flush();
            //读取服务器返回的消息
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            String mess = br.readLine();
            byte[] datalen = new byte[4];
            is.read(datalen);//读取前四个字节数据存放到datalen中
            int length = Integer.parseInt(new String(datalen));//将字节数组转换为int型
            byte[] data = new byte[length];
            is.read(data);
            String mess = new String(data,"GBK");//将获得数据转为字符串类型
            System.out.println("服务器："+mess);
            socketMessage.setRecvMsg(mess);
            //4.关闭资源
            bw.close();
            //br.close();
            is.close();
            os.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return socketMessage;
    }
}
