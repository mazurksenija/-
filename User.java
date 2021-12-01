import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private int idUser;
    private String login;
    private String password;
    private String status;


    public User() {
    }
    public User(int id, String login, String pass, String st) {
        this.idUser = id;
        this.login = login;
        this.password = pass;
        this.status = st;

    }

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            User that = (User)o;
            return Objects.equals(this.idUser, that.idUser) && Objects.equals(this.login, that.login) && Objects.equals(this.password, that.password) && Objects.equals(this.status, that.status) ;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(idUser, login, password, status);
    }

    public String toString() {
        return "User{iduser='" + idUser + ", login='" + login + '\'' + ", password='" + password + '\'' + ", status='" + status + '\'' +'}';
    }
}

