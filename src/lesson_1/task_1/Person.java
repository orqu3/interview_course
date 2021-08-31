package lesson_1.task_1;

public class Person {

    private final String firstName;  // required
    private final String lastName;  // required
    private final String middleName;  // optional
    private final String country; // required
    private final String address; // optional
    private final String phone;  // required
    private final int age; // required
    private final String gender; // optional

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Person(PersonBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.country = builder.country;
        this.address = builder.address;
        this.phone = builder.phone;
        this.age = builder.age;
        this.gender = builder.gender;
    }

    public static class PersonBuilder {

        private final String firstName;
        private final String lastName;
        private String middleName;
        private final String country;
        private String address;
        private final String phone;
        private final int age;
        private String gender;

        public PersonBuilder(String firstName, String lastName, String country, String phone, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.country = country;
            this.phone = phone;
            this.age = age;
        }

        public PersonBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public PersonBuilder address(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
