package Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "custIdGene")
    @SequenceGenerator(name = "custIdGene",allocationSize = 100,initialValue = 10)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "room_ref")
    private Room roomref;
}
