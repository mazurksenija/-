import java.io.Serializable;
import java.util.Objects;

public class Project implements Serializable {
    private String prname;
   private String lead;
   private String info;


    public Project() {
    }
    public Project( String name, String mat, String price) {

        this.prname = name;
        this.lead = mat;
        this.info = price;

    }
    public String getIdProject() {
        return this.prname;
    }

    public void setIdProject(String idProject) {
        this.prname = idProject;
    }
    public String getLead() {
        return this.lead;
    }

    public void setLead(String idProject) {
        this.lead = idProject;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String idProject) {
        this.info = idProject;
    }




    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Project that = (Project)o;
            return Objects.equals(this.prname, that.prname) && Objects.equals(this.lead, that.lead) && Objects.equals(this.info, that.info) ;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.prname, this.lead, this.info);
    }

    public String toString() {
        return "Project{prname=" + this.prname  + '\'' + ", lead='" + this.lead + '\'' + ", info='" + this.info + '\''+  '}';
    }
}

