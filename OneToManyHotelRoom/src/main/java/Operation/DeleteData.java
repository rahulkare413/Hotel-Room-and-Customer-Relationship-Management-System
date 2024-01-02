package Operation;

import SessionHelper.Connection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Scanner;

public class DeleteData {
    private static Scanner sc = new Scanner(System.in);

    public void deleteData(){
        SessionFactory sessionFactory = Connection.getConnection();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("ENTER CUSTOMER ID TO DELETE DATA ");
        int dId = sc.nextInt();

        Query query = session.createQuery("delete from Customer where id = :dId");
        query.setParameter("dId", dId);
        int updatedRows = query.executeUpdate();

        tx.commit();
        session.close();
        System.out.println("DELETE DATA SUCCESSFULLY ");
    }
}
