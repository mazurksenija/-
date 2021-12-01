import java.io.Serializable;
import java.util.Objects;

public class Requirement implements Serializable {
    private int idRequirement = 0;
    private String type;
    private String StartTime;
    private String EndTime;
    private String Info;
    private String fk_id_project;

    public Requirement() {
    }
    public Requirement(int id, String name, String mat, String price, String prod,String fk) {
        this.idRequirement = id;
        this.type = name;
        this.Info = mat;
        this.StartTime = price;
        this.EndTime = prod;
        this.fk_id_project=fk;
    }
    public int getIdRequirement() {
        return this.idRequirement;
    }

    public void setIdRequirement(int idRequirement) {
        this.idRequirement = idRequirement;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getStartTime() {
        return this.StartTime;
    }

    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }
    public String getEndTime() {
        return this.EndTime;
    }

    public void setEndTime(String DueTO) {
        this.EndTime = DueTO;
    }

    public String getInfo() {
        return this.Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }
    public String getFk_id_project() {
        return this.fk_id_project;
    }

    public void setFk_id_project(String idRequirement) {
        this.fk_id_project = idRequirement;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Requirement that = (Requirement) o;
            return Objects.equals(this.idRequirement, that.idRequirement) && Objects.equals(this.type, that.type) && Objects.equals(this.StartTime, that.StartTime) && Objects.equals(this.EndTime, that.EndTime)&& Objects.equals(this.Info, that.Info) && Objects.equals(this.EndTime, that.EndTime)&& Objects.equals(this.fk_id_project, that.fk_id_project);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.idRequirement, this.Info ,this.type, this.StartTime, this.EndTime,this.fk_id_project});
    }

    public String toString() {
        return "Requirement{idRequirement=" + this.idRequirement + ", type='" + this.type + '\'' +", info='" + this.Info + '\''+ ", Start_time='" + this.StartTime  + '\'' + ", End_time='"+this.EndTime  + '\''+ ", fk_id_project='"+this.fk_id_project + '\'' +'}';
    }
}
