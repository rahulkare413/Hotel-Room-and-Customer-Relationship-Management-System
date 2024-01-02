package Operation;

import SessionHelper.Connection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class UpdateData {
    private static Scanner sc = new Scanner(System.in);

    public void updateData(){
        SessionFactory sessionFactory = Connection.getConnection();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("ENTER ROOM ID TO UPDATE DATA ");
        int id = sc.nextInt();

        System.out.println("ENTER UPDATED CAPACITY OF ROOM ");
        int capacity = sc.nextInt();

        // Create a parameterized query with named parameters
        Query query = session.createQuery("update Room set capacity = :newCapacity where RoomId = :roomId");
        query.setParameter("newCapacity", capacity);
        query.setParameter("roomId", id);

        int updatedRows = query.executeUpdate();

        tx.commit();
        session.close();
        System.out.println("UPDATED DATA SUCCESSFULLY ");
    }
}
