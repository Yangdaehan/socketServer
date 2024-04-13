package org.example.socketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestHandler implements Runnable {

    private final Socket clientSocket;

    public RequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // 클라이언트로부터 요청 받기
            String requestLine = in.readLine();
            System.out.println("요청 받음: " + requestLine);

            // 요청 라인 파싱
            String[] requestParts = requestLine.split(" ");
            String method = requestParts[0];
            String path = requestParts[1];

            // 헤더 파싱
            String headerLine;
            while ((headerLine = in.readLine()) != null && !headerLine.isEmpty()) {
                System.out.println("헤더: " + headerLine);
            }

            // GET 요청 확인
            if (method.equals("GET")) {
                // 요청된 리소스 파싱
                String requestedResource = path.substring(1); // '/' 제거

                // 응답 준비
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/html");
                out.println();
                out.println("<html><body>");
                out.println("<h1>Hello, World!</h1>");
                out.println("<p>requested resource: " + requestedResource + "</p>");
                out.println("</body></html>");
            } else {
                // 지원하지 않는 HTTP 메서드
                out.println("HTTP/1.1 405 Method Not Allowed");
            }

            // 멀티 스레딩이 구현되었는지 확인
            Thread.sleep(10000);
            System.out.println("test!!!"); // 멀티스레딩이 안된다면 여러 창을 띄었을 때 10초 씩 텀을 두고 test가 print 되어야 함


            // 스트림과 소켓 닫기
            out.close();
            in.close();
            clientSocket.close();
            System.out.println("클라이언트 연결 종료.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
