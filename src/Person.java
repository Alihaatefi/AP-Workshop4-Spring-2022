public class Person {
    private String firstName ;
    private String lastName;

    public Person(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    @Override
    public String toString(){
        return  "My Name is " + firstName +" And My Last Name is " + lastName;
    }
}
