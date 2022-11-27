package data;

public class Teacher extends User {
    private String disciplesTaught;

    public Teacher(String name, String birthday, String disciplesTaught) {
        super.setName(name);
        super.setBirthday(birthday);
        this.disciplesTaught = disciplesTaught;
    }


    public String getDisciplesTaught() {
        return disciplesTaught;
    }

    public void setDisciplesTaught(String disciplesTaught) {
        this.disciplesTaught = disciplesTaught;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Name=" + super.getName() + " " +
                "Birthday=" + super.getBirthday() + " " +
                "disciplesTaught='" + disciplesTaught + '\'' +
                '}';
    }
}
