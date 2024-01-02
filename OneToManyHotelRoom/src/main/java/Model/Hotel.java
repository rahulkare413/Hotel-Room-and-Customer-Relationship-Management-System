package Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;
    private String hotelName;
    private String hotelAddress;
    private long phoneNumber;

    @OneToMany(mappedBy = "hotelRef",cascade = CascadeType.ALL)
    private List<Room> roomList;

    public void getRoomList(Room r){
        if (roomList==null){
            roomList=new LinkedList<>();

        }
        roomList.add(r);
        r.setHotelRef(this);

    }

}
