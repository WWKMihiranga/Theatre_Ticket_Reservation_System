public class Person {
    private String nic;
    private String name;
    private String surname;
    private String email;

    public Person(String nic,String name,String surname,String email){
        this.nic=nic;
        this.name=name;
        this.surname=surname;
        this.email=email;
    }

    public String getName() { return name; }

    public String getSurname() { return surname; }

    public String getEmail() { return email; }

    public String getNic() {return nic;}

}



