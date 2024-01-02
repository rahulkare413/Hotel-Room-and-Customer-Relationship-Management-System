package Operation;

import Model.Customer;
import Model.Hotel;
import Model.Room;
import SessionHelper.Connection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class InsertData {
    private static Scanner sc = new Scanner(System.in);

    public Hotel addHotelData(){
        SessionFactory sessionFactory = Connection.getConnection();
        Session sessionn= sessionFactory.openSession();
        Transaction tx = sessionn.beginTransaction();

        System.out.println("ENTER HOTEL NAME ");
        String name = sc.next();
        sc.nextLine();
        System.out.println("ENTER HOTEL ADDRESS ");
        String address = sc.next();
        sc.nextLine();
        System.out.println("ENTER HOTEL PHONE NUMBER ");
        long number = sc.nextLong();

        Hotel h1 = new Hotel();
        h1.setHotelName(name);
        h1.setHotelAddress(address);
        h1.setPhoneNumber(number);

        System.out.println("HOW MANY ROOMS U WANT TO BE ADD ");
        int count = sc.nextInt();
        for (int i = 1 ; i<=count ; i++){
            Room r = addRoomData();
            h1.getRoomList(r);
        }

        sessionn.save(h1);
        tx.commit();
        sessionn.close();

        return h1;


    }

    public Room addRoomData(){
        SessionFactory sessionFactory = Connection.getConnection();
        Session sessionn= sessionFactory.openSession();
        Transaction tx = sessionn.beginTransaction();

        System.out.println("ENTER ROOM NUMBER ");
        int number = sc.nextInt();
        System.out.println("ENTER ROOM CAPACITY ");
        int capacity = sc.nextInt();
        System.out.println("ENTER PRICE PER NIGHT ");
        double price = sc.nextDouble();

        Room r1 = new Room();
        r1.setRoomNumber(number);
        r1.setCapacity(capacity);
        r1.setPricePerNight(price);

        System.out.println("HOW MANY CUSTOMER U WANT TO BE ADDED ");
        int count = sc.nextInt();
        for (int i = 1 ; i<=count ; i++){
            Customer c1 = addCustomerDetails();
           r1.addCustomer(c1);
        }

        sessionn.save(r1);
        tx.commit();
        sessionn.close();

        return r1;

    }
    public Customer addCustomerDetails(){
        SessionFactory sessionFactory = Connection.getConnection();
        Session sessionn= sessionFactory.openSession();
        Transaction tx = sessionn.beginTransaction();

        System.out.println("ENTER FIRST NAME ");
        String fName = sc.next();
        sc.nextLine();
        System.out.println("ENTER LAST NAME ");
        String lName = sc.next();
        sc.nextLine();
        System.out.println("ENTER EMAIL ID ");
        String email = sc.next();
        System.out.println("ENTER PHONE NUMBER ");
        long number = sc.nextLong();

        Customer c1 = new Customer();
        c1.setFirstName(fName);
        c1.setLastName(lName);
        c1.setEmail(email);
        c1.setPhoneNumber(number);

        sessionn.save(c1);
        tx.commit();
        sessionn.close();

        return c1;
    }
}
