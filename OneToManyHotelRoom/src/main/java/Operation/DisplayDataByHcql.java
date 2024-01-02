package Operation;

import Model.Customer;
import Model.Hotel;
import Model.Room;
import SessionHelper.Connection;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Scanner;

public class DisplayDataByHcql {
    private static Scanner sc = new Scanner(System.in);

    public void displayDataByRestrictions() {
        SessionFactory sessionFactory = Connection.getConnection();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("ENTER HOTEL PHONE NUMBER TO DISPLAY ALL DATA ");
        long pNumber = sc.nextLong();

        Criteria criteria = session.createCriteria(Hotel.class);
        criteria.add(Restrictions.eq("phoneNumber", pNumber));

        List<Hotel> hotelList = criteria.list();

        for (Hotel h : hotelList) {
            System.out.println("ENTER HOTEL ID " + h.getHotelId());
            System.out.println("ENTER HOTEL NAME " + h.getHotelName());
            System.out.println("HOTEL ADDRESS " + h.getHotelAddress());
            System.out.println("HOTEL PHONE NUMBER " + h.getPhoneNumber());
            System.out.println("---------------------------------------");

            List<Room> roomList = h.getRoomList();
            for (Room r : roomList) {
                System.out.println("ROOM ID " + r.getRoomId());
                System.out.println("ROOM NUMBER " + r.getRoomNumber());
                System.out.println("ROOM CAPACITY " + r.getCapacity());
                System.out.println("ROOM PRICE PER NIGHT " + r.getPricePerNight());
                System.out.println("---------------------------------------------------");

                List<Customer> customerList = r.getCustomerList();
                for (Customer c : customerList) {
                    System.out.println("CUSTOMER ID " + c.getId());
                    System.out.println("CUSTOMER FIRST NAME " + c.getFirstName());
                    System.out.println("CUSTOMER LAST NAME " + c.getLastName());
                    System.out.println("CUSTOMER EMAIL ID " + c.getEmail());
                    System.out.println("CUSTOMER PHONE NUMBER " + c.getPhoneNumber());
                    System.out.println("-------------------------------------------");
                }
            }
        }
    }

}
