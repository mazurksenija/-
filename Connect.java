import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Connect implements Closeable {

    private Socket socket;

    private BufferedReader bufferedReader;

    private BufferedWriter bufferedWriter;

    private ObjectOutputStream oos;

    private ObjectInputStream ois;


    public Connect(String ip, int port) {
        try {
            this.socket = new Socket(ip, port);
            this.bufferedReader = createReader();
            this.bufferedWriter = createWrite();
            this.oos = createOOS();
            this.ois = createOIS();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connect(ServerSocket serverSocket) {
        try {
            this.socket = serverSocket.accept();
            this.bufferedReader = createReader();
            this.bufferedWriter = createWrite();
            this.oos = createOOS();
            this.ois = createOIS();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private BufferedReader createReader() throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private BufferedWriter createWrite() throws IOException {
        return new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    private ObjectOutputStream createOOS() throws IOException {
        return new ObjectOutputStream(socket.getOutputStream());
    }

    private ObjectInputStream createOIS() throws IOException {
        return new ObjectInputStream(socket.getInputStream());
    }

    public void writeLine(String message) throws IOException {
        bufferedWriter.write(message);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }

    public Requirement readObj() throws IOException, ClassNotFoundException {
        return (Requirement) ois.readObject();
    }

    public ArrayList<Requirement> readObjList() throws IOException, ClassNotFoundException {
        return (ArrayList<Requirement>) ois.readObject();
    }

    public ArrayList<Search_pr> readObjSearch() throws IOException, ClassNotFoundException {
        return (ArrayList<Search_pr>) ois.readObject();
    }
    public ArrayList<String> readObjString() throws IOException, ClassNotFoundException {
        return (ArrayList<String>) ois.readObject();
    }
    public ArrayList<Colleague> readObjCol() throws IOException, ClassNotFoundException {
        return (ArrayList<Colleague>) ois.readObject();
    }
    public ArrayList<Customer> readObjCust() throws IOException, ClassNotFoundException {
        return (ArrayList<Customer>) ois.readObject();
    }
    public ArrayList<User> readObjUser() throws IOException, ClassNotFoundException {
        return (ArrayList<User>) ois.readObject();
    }

    public void writeObj(Requirement fur) throws IOException {
        oos.writeObject(fur);
        oos.flush();
    }
    public void writeObjList(ArrayList<Requirement> fur) throws IOException {
        oos.writeObject(fur);
        oos.flush();
    }
    public void writeObjCol(ArrayList<Colleague> fur) throws IOException {
        oos.writeObject(fur);
        oos.flush();
    }
    public void writeObjCust(ArrayList<Customer> fur) throws IOException {
        oos.writeObject(fur);
        oos.flush();
    }
    public void writeObjString(ArrayList<String> fur) throws IOException {
        oos.writeObject(fur);
        oos.flush();
    }
    public void writeObjUser(ArrayList<User> fur) throws IOException {
        oos.writeObject(fur);
        oos.flush();
    }
    public void writeObjListSearch(ArrayList<Search_pr> fur) throws IOException {
        oos.writeObject(fur);
        oos.flush();
    }

    @Override
    public void close() {
        try {
            bufferedReader.close();
            bufferedWriter.close();
            oos.close();
            ois.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}