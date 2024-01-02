package Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "roomIdGene")
    @SequenceGenerator(name = "roomIdGene",allocationSize = 1000,initialValue = 100)
    private int RoomId;
    private int roomNumber;
    private int capacity;
    private double pricePerNight;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.PERSIST})
    @JoinColumn(name = "hotel_Ref")
    private Hotel hotelRef;


    @OneToMany(mappedBy = "roomref",cascade = CascadeType.ALL)
    private List<Customer> customerList ;

    public void addCustomer(Customer c ){
        if (customerList==null){
            customerList=new LinkedList<>();
        }
        customerList.add(c);
        c.setRoomref(this);

    }
}
