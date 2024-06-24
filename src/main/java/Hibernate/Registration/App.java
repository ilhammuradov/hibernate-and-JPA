package Hibernate.Registration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {

        Alien alien = new Alien();
        AlienName alienName = new AlienName();
        alienName.setFirstName("Bob");
        alienName.setLastName("Registration.Alien");
        alien.setName(alienName);
        alien.setId(2);
        alien.setColour("green");

        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        session.save(alien);
        //session.delete(alien);
        //Registration.Alien alien1=session.get(Registration.Alien.class, alien.getId());
        //System.out.println(alien1);
        tx.commit();
    }
}
