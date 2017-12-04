import java.util.Calendar;
import java.util.List;

public class Customer {

    private String name;
    private String surname;
    private int birthyear;
    private String gender;
    private List<Sale> sales;

    public Customer(){}

    public Customer(String name, String surname, int birthyear, String gender) {
        this.name = name;
        this.surname = surname;
        this.birthyear = birthyear;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.trim().equals("")) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(surname.trim().equals("")) throw new IllegalArgumentException("Surname cannot be empty");
        this.surname = surname;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if(birthyear < 1900 || birthyear > currentYear) throw new IllegalArgumentException("Wrong year");
        this.birthyear = birthyear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(!gender.equals("Male") && !gender.equals("Female")) throw new IllegalArgumentException("Wrong gender");
        this.gender = gender;
    }

    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int age = currentYear - birthyear;

        return age;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
