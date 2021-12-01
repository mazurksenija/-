import java.io.IOException;
import java.util.ArrayList;

public class Network {

    private Connect connect;

    public Network(Connect connect) {
        this.connect = connect;

    }

    public void sendInfo(String button, String id, String t, String i, String s, String end,String fk) {


        try {
            connect.writeLine(button);
            connect.writeLine(id);
            connect.writeLine(t);
            connect.writeLine(i);
            connect.writeLine(s);
            connect.writeLine(end);
            connect.writeLine(fk);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendUser(String button, String id, String name, String mat, String price) {


        try {
            connect.writeLine(button);
            connect.writeLine(id);
            connect.writeLine(name);
            connect.writeLine(mat);
            connect.writeLine(price);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//search//


    public User searchLogin(String button, String login, String pass) {

        User user = new User();
        try {
            connect.writeLine(button);
            connect.writeLine(login);
            connect.writeLine(pass);

            user.setIdUser(Integer.parseInt(connect.readLine()));
            user.setLogin(connect.readLine());
            user.setPassword(connect.readLine());
            user.setStatus(connect.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;

    }

    public ArrayList<Requirement> getArrayList(String button) throws IOException, ClassNotFoundException {
        connect.writeLine(button);
        return connect.readObjList();
    }
    public ArrayList<String> getArrayString(String button) throws IOException, ClassNotFoundException {
        connect.writeLine(button);
        return connect.readObjString();
    }

    public ArrayList<Colleague> getCol(String button,String pr) throws IOException, ClassNotFoundException {
        connect.writeLine(button);
        connect.writeLine(pr);
        return connect.readObjCol();
    }
    public ArrayList<Customer> getCust(String button,String pr) throws IOException, ClassNotFoundException {
        connect.writeLine(button);
        connect.writeLine(pr);
        return connect.readObjCust();
    }
    public ArrayList<Search_pr> getArrayListSearch(String button,String project) throws IOException, ClassNotFoundException {
        connect.writeLine(button);
        connect.writeLine(project);
        System.out.println(project);
        return connect.readObjSearch();
    }
    public ArrayList<User> getArrayUser(String button) throws IOException, ClassNotFoundException {
        connect.writeLine(button);
        return connect.readObjUser();
    }

    public String edit(String button, String oldName, String id, String Name, String mat, String price, String prod,String fk) {
        String flagEdit = new String("");
        try {
            connect.writeLine(button);
            connect.writeLine(oldName);

            connect.writeLine(id);
            connect.writeLine(Name);
            connect.writeLine(mat);
            connect.writeLine(price);
            connect.writeLine(prod);
            connect.writeLine(fk);

            flagEdit = connect.readLine();
        } catch (IOException e) {
        }
        return flagEdit;
    }

    public void close(){
        connect.close();
    }

    public String delete(String buttonDelete, String name) throws IOException {
        connect.writeLine(buttonDelete);
        connect.writeLine(name);
        return connect.readLine();
    }
    public String deleteUser(String buttonDelete, String name) throws IOException {
        connect.writeLine(buttonDelete);
        connect.writeLine(name);
        return connect.readLine();
    }

}
