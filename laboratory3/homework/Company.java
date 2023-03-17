import java.util.*;
public class Company implements Comparable<Company>, Node {
    private String name;
    public Company() {
    }
    public Company(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Company otherCompany) {
        return this.name.compareTo(otherCompany.name);
    }

    public Integer getNodeImportance()
    {
        return 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Company{");
        sb.append("name='").append(name).append('\'');
        sb.append('}').append('\n');
        return sb.toString();
    }
}
