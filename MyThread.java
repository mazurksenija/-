import java.io.IOException;
import java.net.ServerSocket;

class MyThread extends Thread{

    ServerSocket serverSocket;

    public MyThread(ServerSocket serverSocket) throws IOException {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run(){
        ServerController serverController = new ServerController();
        serverController.work(serverSocket);

    }

}
