package com.example.demo.Entity;

import org.springframework.stereotype.Service;

@Service
public class SocketMessage {
    private String ip="10.0.255.131";
    private String port="37510";
    private String sendMsg;
    private String recvMsg;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSendMsg() {
        return sendMsg;
    }

    public void setSendMsg(String sendMsg) {
        this.sendMsg = sendMsg;
    }

    public String getRecvMsg() {
        return recvMsg;
    }

    public void setRecvMsg(String recvMsg) {
        this.recvMsg = recvMsg;
    }
}
