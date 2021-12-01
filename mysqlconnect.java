import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JOptionPane;

class Const_req{
    public static final String req_TABLE = "requirement";

    public static final String req_id = "id_requirement";

    public static final String req_type = "type";
    public static final String req_info = "info";

    public static final String req_st = "start_time";

    public static final String req_end = "end_time";

    public static final String req_id_project = "fk_pr_name";

}

class Const_user{
    public static final String user_TABLE = "user";

    public static final String user_id = "iduser";

    public static final String user_login = "login";

    public static final String user_password = "password";

    public static final String user_status = "status";



}

public class mysqlconnect {

    Connection conn = null;
    public static Connection ConnectDb(){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kursach","root","mazur5irina");

            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public void add(Requirement fur) {

        String insert = "INSERT INTO " + Const_req.req_TABLE+ "(" +
                Const_req.req_id+ "," + Const_req.req_type + "," +
                Const_req.req_info+","+
                Const_req.req_st + "," + Const_req.req_end + "," +
                Const_req.req_id_project + ")" +
                "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = ConnectDb().prepareStatement(insert);
            prSt.setString(1,  String.valueOf(fur.getIdRequirement()));
            prSt.setString(2, fur.getType());
            prSt.setString(3, fur.getInfo());
            prSt.setString(4, fur.getStartTime());
            prSt.setString(5, fur.getEndTime());
            prSt.setString(6,fur.getFk_id_project());
            prSt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void adduser(User fur) {

        String insert = "INSERT INTO " + Const_user.user_TABLE+ "(" +
                Const_user.user_id+ "," + Const_user.user_login + "," +
                Const_user.user_password+","+
                Const_user.user_status +")" +
                "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = ConnectDb().prepareStatement(insert);
            prSt.setString(1,  String.valueOf(fur.getIdUser()));
            prSt.setString(2, fur.getLogin());
            prSt.setString(3, fur.getPassword());
            prSt.setString(4, fur.getStatus());

            prSt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }


    public ArrayList<User> getUserDB() {

        ArrayList<User> arrayList = new ArrayList<>();
        try {
            String select = "SELECT * FROM " + Const_user.user_TABLE;
            Statement statement = Objects.requireNonNull(ConnectDb()).createStatement();
            ResultSet resSet = statement.executeQuery(select);
            while (resSet.next()) {
               User user = new User();
                user.setIdUser(resSet.getInt(1));
                user.setLogin(resSet.getString(2));
                user.setPassword(resSet.getString(3));
                user.setStatus(resSet.getString(4));

                arrayList.add(user);
            }
        } catch (SQLException e) {

        }
        return arrayList;
    }
    public ArrayList<String> get_choicebox() {

        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String select = "SELECT pr_name FROM project";
            Statement statement = Objects.requireNonNull(ConnectDb()).createStatement();
            ResultSet resSet = statement.executeQuery(select);
            while (resSet.next()) {
                arrayList.add(resSet.getString("pr_name"));
            }
        } catch (SQLException e) {

        }
        return arrayList;
    }

    public ArrayList<Customer> getcust(String search) {

        ArrayList<Customer> arrayList = new ArrayList<>();
        try {

            String select="SELECT *"+
                    "\tFROM customer WHERE fk_cust_pr =?";
            PreparedStatement preparedStatement = Objects.requireNonNull(Objects.requireNonNull(ConnectDb())).prepareStatement(select);
            preparedStatement.setString(1, search);
            ResultSet resSet = preparedStatement.executeQuery();



            while (resSet.next()) {
              Customer     user = new Customer();

                user.setIdCustomer(resSet.getInt(1));
                user.setCust_name(resSet.getString(2));
                user.setFk_id_project(resSet.getString(3));

                arrayList.add(user);
            }
        } catch (SQLException e) {

        }
        return arrayList;
    }
    public ArrayList<Colleague> getcol(String search) {

        ArrayList<Colleague> arrayList = new ArrayList<>();
        try {

           String select="SELECT *\n" +
                   "\tFROM colleague " +
                   "   WHERE fk_id_pr =?";
            PreparedStatement preparedStatement = Objects.requireNonNull(Objects.requireNonNull(ConnectDb())).prepareStatement(select);
            preparedStatement.setString(1, search);
            ResultSet resSet = preparedStatement.executeQuery();



            while (resSet.next()) {
            Colleague   user = new Colleague();

                user.setIdColleague(resSet.getInt(1));
                user.setName(resSet.getString(2));
                user.setSecondName(resSet.getString(3));
                user.setPosition(resSet.getString(4));

                arrayList.add(user);
            }
        } catch (SQLException e) {

        }
        return arrayList;
    }
    public ArrayList<Requirement> get() {

        ArrayList<Requirement> arrayList = new ArrayList<>();
        try {
            String select = "SELECT * FROM " + Const_req.req_TABLE;
            Statement statement = Objects.requireNonNull(ConnectDb()).createStatement();
            ResultSet resSet = statement.executeQuery(select);
            while (resSet.next()) {
                Requirement fur = new Requirement();
                fur.setIdRequirement(resSet.getInt(1));
                fur.setType(resSet.getString(2));
                fur.setInfo(resSet.getString(3));
                fur.setStartTime(resSet.getString(4));
                fur.setEndTime(resSet.getString(5));
                fur.setFk_id_project(resSet.getString(6));
                arrayList.add(fur);
            }
        } catch (SQLException e) {

        }
        return arrayList;
    }

   public void deleteDB(int deleteValue) {
        try {
            String DELETE = "DELETE FROM " + Const_req.req_TABLE + " WHERE " + Const_req.req_id + "='" + deleteValue + "'; ";
            PreparedStatement preparedStatementDelete = ConnectDb().prepareStatement(DELETE);
            preparedStatementDelete.executeUpdate();
        } catch (SQLException e) {

        }
    }
    public void deleteUser(int deleteValue) {
        try {

            String DELETE = "DELETE FROM user WHERE iduser =?; ";
            PreparedStatement preparedStatement = ConnectDb().prepareStatement(DELETE);
            preparedStatement.setInt(1, deleteValue);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void editDB(int oldName, Requirement furnirure) {
        try {

            String update = "UPDATE  requirement\n" +
                    "   SET id_requirement=?, type =?,info=? ,\n" +
                    "   start_time =?, end_time=?,fk_pr_name=? WHERE \n" +
                    "   id_requirement=?";

            PreparedStatement preparedStatement = ConnectDb().prepareStatement(update);

            preparedStatement.setInt(1, furnirure.getIdRequirement());
            preparedStatement.setString(2, furnirure.getType());
            preparedStatement.setString(3, furnirure.getInfo());
            preparedStatement.setString(4, furnirure.getStartTime());
            preparedStatement.setString(5, furnirure.getEndTime());
            preparedStatement.setString(6, furnirure.getFk_id_project());
            preparedStatement.setInt (7, oldName);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {

        }
    }

}

