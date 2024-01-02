package SessionHelper;

import Model.Customer;
import Model.Hotel;
import Model.Room;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {

    public static SessionFactory getConnection(){
        Configuration cfg = new Configuration();
        cfg.configure().addAnnotatedClass(Hotel.class).addAnnotatedClass(Room.class).addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        return sessionFactory;
    }
}
