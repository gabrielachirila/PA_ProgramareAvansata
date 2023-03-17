import java.time.LocalDate;
import java.util.Map;

public class Programmer extends Person {
    private String programmingLanguage;
    public Programmer() {
    }
    public Programmer(String name, LocalDate birthDate, String programmingLanguage) {
        super(name, birthDate);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Programmer{");
        sb.append("programmingLanguage='").append(programmingLanguage).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", relationships=").append(relationships);
        sb.append('}');
        return sb.toString();
    }
}
