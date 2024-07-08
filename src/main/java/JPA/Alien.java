package JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity(name = "Space_Alien")
@Table(name = "Aliens")
public class Alien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private AlienName name;
    @Column(name = "alien_colour")
    private String colour;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AlienName getName() {
        return name;
    }

    public void setName(AlienName name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Alien{" + "id=" + id + ", name='" + name + '\'' + ", colour='" + colour + '\'' + '}';
    }
}
