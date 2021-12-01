

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
    private int idCustomer = 0;
    private String cust_name;
private String fk_id_project;

    public Customer(int id,String name,String fk_id_project) {
        this.idCustomer=id;
        this.cust_name=name;
        this.fk_id_project = fk_id_project;
    }
public Customer(){}
    public int getIdCustomer() {
        return this.idCustomer;
    }

    public void setIdCustomer(int idProject) {
        this.idCustomer = idProject;
    }



    public String getCust_name() {
        return this.cust_name;
    }

    public void setCust_name(String idRequirement) {
        this.cust_name = idRequirement;
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
            Customer that = (Customer)o;
            return  Objects.equals(this.idCustomer, that.idCustomer) && Objects.equals(this.cust_name, that.cust_name) && Objects.equals(this.fk_id_project, that.fk_id_project) ;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.idCustomer, this.cust_name,fk_id_project);
    }

    public String toString() {
        return "Customer{idCustomer=" + this.idCustomer + ", cust_name='" + this.cust_name + '\''   + this.fk_id_project + '\''   +'}';
    }
}