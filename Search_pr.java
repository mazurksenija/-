import java.io.Serializable;
import java.util.Objects;

public class Search_pr implements Serializable {

    private String name;
    private String secondName;
    private String pos;



    public Search_pr() {
    }

    public Search_pr(String name, String mat, String price) {

        this.name = name;
        this.secondName = mat;
        this.pos = price;

    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return this.pos;
    }

    public void setPos(String name) {
        this.pos= name;
    }
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Search_pr that = (Search_pr) o;
            return   Objects.equals(this.name, that.name) && Objects.equals(this.secondName, that.secondName) && Objects.equals(this.pos, that.pos);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash( this.name, this.secondName,this.pos);
    }

    public String toString() {
        return "Search_pr{name=" + this.name +  '\''+  ", secondName='" + this.secondName +  '\'' + ", pos='" + this.pos  +  '\''  +'}';    }
}
