import javax.management.loading.ClassLoaderRepository;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Theatre {

    // These variables store the number of tickets sold in each row
    public static int count1;
    public static int count2;
    public static int count3;


    public static void main(String[] args) {

        // Display the welcome message to the user
        System.out.println("\n\n----------------------------------------------------------------");
        System.out.println("*****************  Welcome to the New Theatre  *****************");
        System.out.println("----------------------------------------------------------------\n");


        // Create a Scanner object to read user input
        Scanner input=new Scanner(System.in);


        // Declare three arrays to represent the seating area for each row
        int[] row_1 = new int[12];
        int[] row_2 = new int[16];
        int[] row_3 = new int[20];


        // Declare an ArrayList to store information about tickets
        ArrayList array_list=new ArrayList();


        // Display the options menu to the user
        while (true){
            System.out.println("Please select an option:");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("     0) Quit");

            System.out.print("-------------------------------------------------\nEnter option:");

            try {
                int mark = input.nextInt();
                switch (mark) {
                    case 1:
                        //Call the buy_ticket method
                        System.out.println("-------------------------------------------------");
                        System.out.println("                 BUY A TICKET                    ");
                        System.out.println(" ");
                        buy_ticket(row_1, row_2, row_3, array_list);
                        System.out.println("-------------------------------------------------\n");
                        break;


                    case 2:
                        //call the print_seating_area method
                        System.out.println("-------------------------------------------------");
                        System.out.println("               PRINT SEATING AREA                 ");
                        print_seating_area(row_1, row_2, row_3);
                        break;


                    case 3:
                        //call the cancel_ticket method
                        System.out.println("-------------------------------------------------");
                        System.out.println("                CANCEL TICKET                    ");
                        System.out.println(" ");
                        cancel_ticket(row_1, row_2, row_3, array_list);
                        System.out.println("-------------------------------------------------\n");
                        break;


                    case 4:
                        //call the show_available method
                        System.out.println("-------------------------------------------------");
                        System.out.println("              LIST AVAILABLE SEATS               ");
                        System.out.println(" ");
                        show_available(row_1, row_2, row_3);
                        System.out.println("\n-------------------------------------------------\n");
                        break;


                    case 5:
                        //call the save method
                        System.out.println("-------------------------------------------------");
                        System.out.println("                   SAVE TO FILE                  ");
                        System.out.println(" ");
                        save(row_1, row_2, row_3);
                        break;


                    case 6:
                        //call the load method
                        System.out.println("-------------------------------------------------");
                        System.out.println("                 LOAD FROM FILE                  ");
                        System.out.println(" ");
                        load(row_1, row_2, row_3);
                        break;


                    case 7:
                        // Call the show_tickets_info method
                        System.out.println("-------------------------------------------------");
                        System.out.println("    PRINT TICKET INFORMATION AND TOTAL PRICE     ");
                        System.out.println(" ");
                        show_tickets_info(array_list);
                        break;


                    case 8:
                        // Call the sort_tickets method
                        System.out.println("-------------------------------------------------");
                        System.out.println("             SORT TICKETS BY PRICE               ");
                        System.out.println(" ");
                        sort_tickets(array_list);
                        System.out.println("-------------------------------------------------\n");
                        break;

                    case 0:
                        // Exit the program with a status of 0
                        System.out.println("You press the quit button");
                        System.exit(0);//https://www.geeksforgeeks.org/system-exit-in-java/

                        default:
                            // Display a message when the user has entered out of range number
                            System.out.println("Please enter an integer from 0 to 8 \n");
                }

            }catch (Exception e){
                System.out.println("You input is invalid. Please check it and try again\n");
                String junk= input.nextLine();

            }
        }
    }


    public static void  buy_ticket(int[] row_1,int[] row_2,int[] row_3,ArrayList array_list){


        // Create a Scanner object to read user input
        Scanner input=new Scanner(System.in);
        double ticket_price;


        //Get the nic,name,surname and email from the user
        System.out.print("Please Enter Your NIC Number :");
        String N_NIC=input.next();
        System.out.print("Please Enter Your Name       :");
        String N_name=input.next();
        System.out.print("Please Enter Your Surname    :");
        String N_surname=input.next();
        String N_email;

        while(true){
            System.out.print("Please Enter Your Email      :");
            N_email=input.next();
            if(N_email.contains("@") && N_email.contains(".")){
                break;
            }else {
                System.out.println("Invalid E-mail Address.Try Again\n");
            }
        }


        //Create a Person object
        Person person1=new Person(N_NIC,N_name,N_surname,N_email);

        while (true){

            try{

                //Get the row number and the seat number from the user
                System.out.println("\nEnter a Row Number and a Seat Number");
                System.out.print("Row Number      - ");
                int row_number=input.nextInt();
                System.out.print("Seat Number     - ");
                int seat_number=input.nextInt();


                // Check if the input for row_number and seat_number is valid
                if (!((row_number==1 && 0<seat_number && seat_number<=row_1.length) || (row_number==2 && 0<seat_number && seat_number<=row_2.length) || (row_number==3 && 0<seat_number && seat_number<=row_3.length))){
                    System.out.println("\nInvalid Input\nPlease check your Row Number and the Seat Number");
                    continue;
                }


                // Check if the seat in the first row is available
                if(row_number==1 && row_1[seat_number-1]==0){
                    row_1[seat_number-1]=1;
                    count1+=1;
                    ticket_price=10;
                    System.out.println("\nYour seat reservation is successful");// Print a message to confirm that the reservation is successful
                }

                // Check if the seat in the second row is available
                else if (row_number==2 && row_2[seat_number-1]==0) {
                    row_2[seat_number-1]=1;
                    count2+=1;
                    ticket_price=20;
                    System.out.println("\nYour seat reservation is successful");// Print a message to confirm that the reservation is successful
                }

                // Check if the seat in the third row is available
                else if (row_number==3 && row_3[seat_number-1]==0){
                    row_3[seat_number-1]=1;
                    count3+=1;
                    ticket_price=30;
                    System.out.println("\nYour seat reservation is successful");// Print a message to confirm that the reservation is successful
                }

                else {
                    System.out.println("Your seat is already booked.\nPlease Select another seat");
                    continue; // continue loop if seat is already booked
                }

                //Create a ticket object
                Tickets ticket_obj=new Tickets(row_number,seat_number,ticket_price,person1);
                ticket_obj.print();


                // Add the nic,name,surname,email,row number,seat number and the ticket price to the ArrayList
                array_list.add(ticket_obj.getPerson().getNic());
                array_list.add(ticket_obj.getPerson().getName());
                array_list.add(ticket_obj.getPerson().getSurname());
                array_list.add(ticket_obj.getPerson().getEmail());
                array_list.add(ticket_obj.getRow());
                array_list.add(ticket_obj.getSeat());
                array_list.add(ticket_obj.getPrice());



                System.out.print("Do you want to buy more Tickets ? ");
                String answer=input.next();
                answer=answer.toLowerCase();

                if(answer.equals("yes")){
                    continue;
                }

                else if (answer.equals("no")){
                    break;
                }

                else {
                    System.out.println("Invalid input");
                    break;
                }
            }catch (Exception e){
                System.out.println("Please enter an Integer as the row number and the seat number");
                String junk= input.nextLine();
            }
        }

        System.out.println(" ");
    }


    public static void  print_seating_area(int[] row_1,int[] row_2,int[] row_3){

        System.out.println(" ");
        System.out.format("%29s","***********\n");  //https://www.javatpoint.com/java-string-format
        System.out.format("%29s","*  STAGE  *\n");
        System.out.format("%29s","***********\n");

        // Print some whitespace to center
        System.out.format("%16s","");

        for (int i=0;i<row_1.length;i++){
            if (row_1[i]==1){
                System.out.print("X");
            }
            else{
                System.out.print("O");
            }

            if(i==(row_1.length/2)-1){
                System.out.print(" ");
            }
        }

        System.out.println(" ");

        // Print some whitespace to center
        System.out.format("%14s","");

        for (int i=0;i<row_2.length;i++){
            if (row_2[i]==1){
                System.out.print("X");
            }
            else{
                System.out.print("O");
            }

            if(i==(row_2.length/2)-1){
                System.out.print(" ");
            }
        }

        System.out.println(" ");

        // Print some whitespace to center
        System.out.format("%12s","");

        for (int i=0;i<row_3.length;i++){
            if (row_3[i]==1){
                System.out.print("X");
            }
            else{
                System.out.print("O");
            }

            if(i==(row_3.length/2)-1){
                System.out.print(" ");
            }
        }

        System.out.println("\n-------------------------------------------------\n");
    }


    public static void  cancel_ticket(int[] row_1,int[] row_2,int[] row_3,ArrayList array_list){

        // Create a Scanner object to read user input
        Scanner input=new Scanner(System.in);

        while (true) {

            try{

                //Get the relevant nic,row number and seat number from the user
                System.out.print("Enter your NIC Number - ");
                String nic=input.next();
                System.out.println(" ");

                System.out.println("Enter a Row Number and a Seat Number\n");
                System.out.print("Row Number   - ");
                int row_number = input.nextInt();
                System.out.print("Seat Number  - ");
                int seat_number = input.nextInt();


                // Check if the input for row_number and seat_number is valid
                if (!((row_number==1 && 0<seat_number && seat_number<=row_1.length) || (row_number==2 && 0<seat_number && seat_number<=row_2.length) || (row_number==3 && 0<seat_number && seat_number<=row_3.length))) {
                    System.out.println("Row Number or the Seat Number is out of range\nPlease check it and Try again\n");
                    continue;
                }

                int x=0;
                for(int i=0;i<array_list.size();i++){

                    // checks if the NIC in the array list matches the input NIC
                    // checks if the row and seat number in the array list match the input row and seat number
                    if(Objects.equals(array_list.get(i),nic) && Objects.equals(array_list.get(i+4),row_number) && Objects.equals(array_list.get(i+5),seat_number)){


                        for(int j=0;j<7;j++) {  //To remove the information from array list
                            array_list.remove(i);
                        }


                        if (row_number == 1) {
                            row_1[seat_number - 1] = 0;
                            count1--;  // decreases the number of tickets by one
                            x=1;  // sets the value of x to 1 to indicate that the seat cancellation was successful
                            System.out.println("\nYour seat cancellation is successful");
                            break;

                        } else if (row_number == 2) {
                            row_2[seat_number - 1] = 0;
                            count2--;  // decreases the number of tickets by one
                            x=1;  // sets the value of x to 1 to indicate that the seat cancellation was successful
                            System.out.println("\nYour seat cancellation is successful");
                            break;

                        } else {
                            row_3[seat_number - 1] = 0;
                            count3--;  // decreases the number of tickets by one
                            x=1;  // sets the value of x to 1 to indicate that the seat cancellation was successful
                            System.out.println("\nYour seat cancellation is successful");
                            break;
                        }


                    }
                    else if(x==0 && i==(array_list.size()-1)){
                        System.out.println("Sorry. You can't cancel your reservation.\nYour ID does not match the Row and Seat numbers you entered ");
                        break;
                    }

                }

            }catch (Exception e){
                System.out.println("Please enter an Integer as the row number and the seat number\n");
                String junk= input.nextLine();
                continue;
            }
        break;
        }
    }


    public static void show_available(int[] row_1,int[] row_2,int[] row_3){


        int comma1=0;

        System.out.print("Seats available in row 1 :: ");
        for(int i=0;i<row_1.length;i++){
            if(row_1[i]==0){

                if(i!=0 && comma1==1){  // add a comma and a space if this is not the first unoccupied seat in the row
                    System.out.print(", ");
                }

                System.out.print(i+1);
                comma1=1;  // set comma1 to 1 to indicate that an unoccupied seat has been printed


            }
        }

        System.out.println("\n");

        int comma2=0;

        System.out.print("Seats available in row 2 :: ");
        for(int i=0;i<row_2.length;i++){
            if(row_2[i]==0){

                if(i!=0 && comma2==1){  // add a comma and a space if this is not the first unoccupied seat in the row
                    System.out.print(", ");
                }

                System.out.print(i+1);
                comma2=1;  // set comma1 to 1 to indicate that an unoccupied seat has been printed

            }
        }

        System.out.println("\n");


        int comma3=0;

        System.out.print("Seats available in row 3 :: ");
        for(int i=0;i<row_3.length;i++){
            if(row_3[i]==0){

                if(i!=0 && comma3==1 ){  // add a comma and a space if this is not the first unoccupied seat in the row
                    System.out.print(", ");
                }

                System.out.print(i+1);
                comma3=1;  // set comma1 to 1 to indicate that an unoccupied seat has been printed

            }
        }
    }


    public static void save(int[] row_1,int[] row_2,int[] row_3){
        try{

            FileWriter save_file =new FileWriter("Text_file.txt");  // create a new File object


            for(int i=0;i<row_1.length;i++) {
                if (row_1[i] == 0) {
                    save_file.write("0");  //write a "0" to the file
                }
                else {
                    save_file.write("1");  //write a "1" to the file
                }
            }save_file.write("\n");  // write a newline character to the file after all the seats in row 1 have been processed


            for(int i=0;i<row_2.length;i++) {
                if (row_2[i] == 0) {
                    save_file.write("0");  //write a "0" to the file
                }
                else {
                    save_file.write("1");  //write a "1" to the file
                }
            }save_file.write("\n");  // write a newline character to the file after all the seats in row 2 have been processed


            for(int i=0;i<row_3.length;i++) {
                if (row_3[i] == 0) {
                    save_file.write("0");  //write a "0" to the file
                }
                else {
                    save_file.write("1");  //write a "1" to the file
                }
            }save_file.write("\n");  // write a newline character to the file after all the seats in row 3 have been processed

            System.out.println("File saved successfully");
            System.out.println("-------------------------------------------------\n");

            save_file.close();  // close the FileWriter object
        }catch (Exception e){
            System.out.println("Can not save the fail");
        }
    }


    public static void load(int[] row_1,int[] row_2,int[] row_3){
        try{

            int a=1;  //Use to move on to the next row
            File load_file=new File("Text_file.txt");  // create a new File object
            Scanner input=new Scanner(load_file);  // create a new Scanner object to read from the file
            while(input.hasNextLine()){
                String line=input.nextLine();

                if(a==1){

                    for(int i=0;i<row_1.length;i++) {
                        //https://www.tutorialspoint.com/java/lang/character_getnumericvalue.htm
                        row_1[i]=Character.getNumericValue(line.charAt(i));  // set the element of row_1 to the numeric value of the character in the current line of the input file
                    }
                }


                if(a==2){
                    for(int i=0;i<row_2.length;i++) {
                        row_2[i]=Character.getNumericValue(line.charAt(i));  // set the element of row_1 to the numeric value of the character in the current line of the input file
                    }
                }


                if(a==3){
                    for(int i=0;i<row_3.length;i++) {
                        row_3[i]=Character.getNumericValue(line.charAt(i));  // set the element of row_1 to the numeric value of the character in the current line of the input file
                    }
                }

                a++;  // increment the row counter to move on to the next row
            }

            System.out.println("File loaded successfully");
            System.out.println("-------------------------------------------------\n");

            input.close();


        }catch (Exception e){
            System.out.println("Can not load the fail");
        }
    }


    public static void show_tickets_info(ArrayList array_list){
        System.out.println("\nPrice of a First  Row Ticket is 10$");
        System.out.println("Price of a Second Row Ticket is 20$");
        System.out.println("Price of a Third  Row Ticket is 30$\n");
        System.out.println("\nYour Ordered Tickets");


        for (int j = 0; j < (array_list.size());) {  //Print the array list
            System.out.println(" ");
            System.out.println("Personal Id         : " + array_list.get(j));
            System.out.println("Person Name         : " + array_list.get(j + 1));
            System.out.println("Person Surname      : " + array_list.get(j + 2));
            System.out.println("Person Email        : " + array_list.get(j + 3));
            System.out.println("Row Number          : " + array_list.get(j + 4));
            System.out.println("Seat Number         : " + array_list.get(j + 5));
            System.out.println("Ticket Price        : " + array_list.get(j + 6)+" $");
            j+=7;
        }
        System.out.println("\n-------------------------------------------------");
        System.out.println("\nYour Total Price is  : "+(10*count1+20*count2+30*count3)+" $\n");  //Count the total price of all the tickets
        System.out.println("-------------------------------------------------\n");
    }


    public static void  sort_tickets(ArrayList array_list){


        String list[]=new String[array_list.size()/7];
        ArrayList sorted_array=new ArrayList();  // create a new ArrayList called sorted_array


        int j=0;  //counter variable to keep track of the index of the list array
        for(int i=6;i<array_list.size();i+=7){
                list[j]= Double.toString((Double) array_list.get(i));  // get the element from the array_list and convert it to a String using the toString method
                j+=1;
        }


        Arrays.sort(list);  // sort the list array using the Arrays.sort method
        //https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/


        double price=0;

        for(int k=0;k<list.length;k++){

            if(k!=0 && Objects.equals(list[k], Double.toString(price))){  // If the current price is the same as the previous price, skip to the next iteration
                continue;
            }

            for(int i=6;i<array_list.size();i+=7){


                // If the current price in the array list matches the current price in the sorted list,
                // add the corresponding reservation information to the sorted array list
                if(list[k].equals(Double.toString((Double) array_list.get(i)))){

                        price=((Double) array_list.get(i));

                        sorted_array.add(array_list.get(i-6));
                        sorted_array.add(array_list.get(i-5));
                        sorted_array.add(array_list.get(i-4));
                        sorted_array.add(array_list.get(i-3));
                        sorted_array.add(array_list.get(i-2));
                        sorted_array.add(array_list.get(i-1));
                        sorted_array.add(array_list.get(i));

                }
            }
        }

        System.out.println("\nYour Sorted Tickets\n");

        for (int i = 0; i < (sorted_array.size());) {  //Print the "sorted_array" array list

            System.out.println("Personal Id         : " + sorted_array.get(i));
            System.out.println("Person Name         : " + sorted_array.get(i + 1));
            System.out.println("Person Surname      : " + sorted_array.get(i + 2));
            System.out.println("Person Email        : " + sorted_array.get(i + 3));
            System.out.println("Row Number          : " + sorted_array.get(i + 4));
            System.out.println("Seat Number         : " + sorted_array.get(i + 5));
            System.out.println("Ticket Price        : " + sorted_array.get(i + 6)+" $");
            System.out.println(" ");
            i+=7;
        }
    }
}