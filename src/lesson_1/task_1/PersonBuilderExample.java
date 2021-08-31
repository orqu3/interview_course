package lesson_1.task_1;

public class PersonBuilderExample {

    public static void main(String[] args) {

        Person person1 = new Person.PersonBuilder("Rose", "Williams", "England", "123456789", 23)
                .middleName("Louise")
                .address("address")
                .gender("female")
                .build();

        System.out.println(person1);

        Person person2 = new Person.PersonBuilder("Tom", "Taylor", "USA", "123456789", 78)
                .middleName("Noah")
                .address("address")
                //no gender
                .build();

        System.out.println(person2);

        Person person3 = new Person.PersonBuilder("Lucas", "Miller", "Canada", "123456789", 54)
                //No middleName
                //No address
                //No gender
                .build();

        System.out.println(person3);
    }
}
