import java.io.Serializable;
import java.util.Objects;

public class Colleague implements Serializable {
    private int idColleague = 0;
    private String name;
    private String secondName;
    private String position;
    private String fk_id_project;



    public Colleague() {
    }
    public Colleague(int id, String name, String mat, String price, String prod,String fk) {
        this.idColleague = id;
        this.name = name;
        this.secondName = mat;
        this.position = price;
        this.fk_id_project=fk;
    }

    public int getIdColleague() {
        return this.idColleague;
    }

    public void setIdColleague(int idColleague) {
        this.idColleague = idColleague;
    }



    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public String getPosition() {
        return this.position;
    }

    public void setPosition(String name) {
        this.position = name;
    }
    public String getFk_id_project() {
        return this.fk_id_project;
    }

    public void setFk_id_project(String name) {
        this.fk_id_project = name;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Colleague that = (Colleague) o;
            return Objects.equals(this.idColleague, that.idColleague)  && Objects.equals(this.name, that.name)&& Objects.equals(this.secondName, that.secondName) && Objects.equals(this.position, that.position)&& Objects.equals(this.fk_id_project, that.fk_id_project) ;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.idColleague, this.name, this.secondName,this.position,this.fk_id_project);
    }

    public String toString() {
        return "Colleague{idColleague=" + this.idColleague +  ", name='" + this.name +  '\'' + ", secondName='" + this.secondName  +  '\'' + ", position='" + this.position  +  '\'' + ", fk_id_project='" + this.fk_id_project  +  '\'' +'}';
    }
}