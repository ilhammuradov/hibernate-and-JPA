package JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HypersistenceOptimizer");
        EntityManager em = emf.createEntityManager();

        AlienName alienName = new AlienName();
        alienName.setFirstName("Rigby");
        alienName.setLastName("Alien");
        Alien alien = new Alien();
        alien.setName(alienName);
        alien.setColour("brown");
        alien.setId(1);

        em.getTransaction().begin();
        //Alien alien =em.find(Alien.class,2);
        em.persist(alien);

        System.out.println(alien);
        em.getTransaction().commit();
    }
}

