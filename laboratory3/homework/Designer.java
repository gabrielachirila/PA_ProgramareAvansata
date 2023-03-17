import java.time.LocalDate;

public class Designer extends Person {
    private double yearsOfExperience;
    public Designer() {
    }
    public Designer(String name, LocalDate birthDate, double yearsOfExperience) {
        super(name, birthDate);
        this.yearsOfExperience = yearsOfExperience;
    }

    public double getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(double yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Designer{");
        sb.append("yearsOfExperience=").append(yearsOfExperience);
        sb.append(", name='").append(name).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", relationships=").append(relationships);
        sb.append('}');
        return sb.toString();
    }
}
