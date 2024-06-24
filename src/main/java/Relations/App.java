package Relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class App {
    public static void mainV1(String[] args) {
        Laptop l = new Laptop();
        l.setName("Mac");
        Student s = new Student();
        s.setName("Veli Veliyev");
        s.setMarks(76);
        s.getLaptop().add(l);
        l.getStudentList().add(s);

        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sessionFactory = conf.buildSessionFactory(serviceRegistry);
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();

//        session1.persist(s);
//        session1.persist(l);

        Student s2 = session1.get(Student.class, 1);
        System.out.println(s2);
        session1.getTransaction().commit();
        session1.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();

        Student s3 = session2.get(Student.class, 1);
        System.out.println(s3);
        session2.getTransaction().commit();
        session2.close();

    }

    public static void main(String[] args) {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sessionFactory = conf.buildSessionFactory(serviceRegistry);
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();

        Query<Object[]> query = session1.createQuery("select id, name from Student where id=:studentID", Object[].class);
//        //List<Student> list = query.list();
        query.setParameter("studentID", 4);
        Object[] s = query.uniqueResult();
        for (Object o : s) {
            System.out.println(o);
        }

        NativeQuery<Object[]> sqlQuery = session1.createNativeQuery("select id,name from students", Object[].class);
        List<Object[]> studentList = sqlQuery.getResultList();
        for (Object[] student : studentList) {
            Integer id = (Integer) student[0];
            String name = (String) student[1];
            System.out.println("ID: " + id + ", Name: " + name);
        }
        session1.getTransaction().commit();
    }
}
