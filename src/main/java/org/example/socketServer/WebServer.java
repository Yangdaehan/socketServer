package org.example.sibal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(80)
        ) {
            // 80번 포트로 서버 소켓 생성
            System.out.println("서버 시작. 80번 포트에서 대기 중...");

            while (true) {
                Socket clientSocket = serverSocket.accept(); // 클라이언트 연결 수락
                System.out.println("클라이언트 연결됨.");

                // 클라이언트를 처리할 새로운 스레드 생성
                Thread clientThread = new Thread(new Client(clientSocket));
                clientThread.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
