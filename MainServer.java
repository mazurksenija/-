import java.io.*;
import java.net.ServerSocket;

public class MainServer {

    private static int port = 1025;

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Thread.sleep(1000);
            MyThread myThread = new MyThread(serverSocket);
            myThread.start();
            myThread.join();
        }
    }
}

