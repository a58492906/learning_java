package io.github.ericmeng.gateway;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-05-23 18:33
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-05-23 18:14
 */
public class BackEndServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8089);
        while (true) {
            try {
                final Socket socket = serverSocket.accept();
                new Thread(() -> {
                    service(socket);
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void service(Socket socket) {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:test/html ;charset=utf-8");
            String body = "hello.nio2";
            printWriter.println("Content-length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
