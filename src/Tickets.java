public class Tickets {
    private int row;
    private int seat;
    private double price;
    private Person person;

    public Tickets(int row,int seat,double price,Person person){
        this.row=row;
        this.seat=seat;
        this.price=price;
        this.person=person;

    }

    public int getRow() {return row;}

    public int getSeat() {return seat;}

    public double getPrice() {return price;}

    public Person getPerson() {return person;}

    public void print(){
        System.out.println("");
        System.out.println("-------------------------------------------------\n");
        System.out.println("Ticket Details\n");
        System.out.println("Name         : "+person.getName()+" "+person.getSurname());
        System.out.println("Email        : "+person.getEmail());
        System.out.println("Row Number   : "+this.row);
        System.out.println("Seat Number  : "+this.seat);
        System.out.println("Price        : "+this.price+" $");
        System.out.println("\n-------------------------------------------------");
        System.out.println("");

    }

}
