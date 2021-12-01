import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ServerController {

    private static int countClient = 0;

    private Connect connect;


    public ServerController(ServerSocket serverSocket) {
        this.connect = new Connect(serverSocket);
        countClient++;
    }

    public ServerController() {
    }

    public ServerController(Connect connect) {
        this.connect = connect;
        countClient++;
    }

    public synchronized void work(ServerSocket serverSocket) {
        this.connect = new Connect(serverSocket);
        mysqlconnect mysql = new mysqlconnect();

        System.out.println("Client connect --> " + ++countClient);

        try {
            while (true) {
                switch (connect.readLine()) {

                    case "add": {

                        mysql.add(readClientReq());
                    }

                        break;
                    case "add_user": {

                        mysql.adduser(readClientUser());
                    } break;
                   case "edit":
                       int old = Integer.parseInt(connect.readLine());
                       System.out.println( old);
                        ArrayList<Requirement> list1 = mysql.get();
                        Integer flag1 = 0;
                       for (Requirement value : list1) {
                           int st = value.getIdRequirement();
                           System.out.println( st);
                           if (old == st) {
                               flag1 = 1;
                               break;
                           }
                           flag1 = 2;
                       }
                        if (flag1.equals(2) || flag1.equals(0)) {
                            connect.writeLine("false");
                        } else {
                            mysql.editDB(old, readClientReq());
                            connect.writeLine("true");
                        }
                        break;
                    case "delete": {


                        int whatDelete = Integer.parseInt(connect.readLine());
                        ArrayList<Requirement> list2 = mysql.get();
                        Integer flag2 = 0;
                        for (Requirement requirement : list2) {
                            if (whatDelete==(requirement.getIdRequirement())) {
                                flag2 = 1;
                                break;
                            }
                            flag2 = 2;
                        }
                        if (flag2.equals(2) || flag2.equals(0)) {
                            connect.writeLine("false");
                        } else {
                            mysql.deleteDB(whatDelete);
                            connect.writeLine("true");
                        }
                        break;
                    }
                    case "deleteUser": {


                        int whatDelete = Integer.parseInt(connect.readLine());
                        ArrayList<User> list2 = mysql.getUserDB();
                        Integer flag2 = 0;
                        for (User requirement : list2) {
                            if (whatDelete==(requirement.getIdUser())) {
                                flag2 = 1;
                                break;
                            }
                            flag2 = 2;
                        }
                        if (flag2.equals(2) || flag2.equals(0)) {
                            connect.writeLine("false");
                        } else {
                            mysql.deleteUser(whatDelete);
                            connect.writeLine("true");
                        }
                        break;
                    }
                    case "view": {
                        connect.writeObjList(mysql.get());
                        break;
                    }
                    case "viewUser": {
                        connect.writeObjUser(mysql.getUserDB());
                        break;
                    }
                    case "get_col": {
                        String col = connect.readLine();
                        connect.writeObjCol(mysql.getcol(col));
                        break;
                    }
                    case "get_cust": {
                        String cust = connect.readLine();
                        connect.writeObjCust(mysql.getcust(cust));
                        break;
                    }
                    case "choice_pr": {
                        connect.writeObjString(mysql.get_choicebox());
                        break;
                    }

                    case "login": {

                        String login = connect.readLine();
                        String password=connect.readLine();
                        ArrayList<User> list = mysql.getUserDB();
                        Integer flag = 0;
                        for (User user : list) {

                            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                                connect.writeLine(String.valueOf(user.getIdUser()));
                                connect.writeLine(user.getLogin());
                                connect.writeLine(user.getPassword());
                                connect.writeLine(user.getStatus());

                                flag = 1;
                                break;
                            }
                            flag = 2;
                        }
                        if (flag.equals(2) || flag.equals(0)) {
                            connect.writeLine("0");
                            connect.writeLine("");
                            connect.writeLine("");
                            connect.writeLine("");


                        }
                        break;
                    }


                    default:
                        System.out.println("Ошибка выбора");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connect.close();
        }
    }

    private Requirement readClientReq() throws IOException {

        return new Requirement(Integer.parseInt(connect.readLine()), connect.readLine(), connect.readLine(), connect.readLine(), connect.readLine(),connect.readLine());
    }
    private User readClientUser() throws IOException {

        return new User(Integer.parseInt(connect.readLine()), connect.readLine(), connect.readLine(), connect.readLine());
    }

}
