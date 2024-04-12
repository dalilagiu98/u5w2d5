package dalilagiurgola9.U5W2D5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
//LOMBOK:
@Getter
@Setter
@NoArgsConstructor
//DB:
@Entity
public class Employee {
    //ATTRIBUTES LIST:
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String avatarImage;
    @OneToMany(mappedBy = "employee")
    private List<Device> assignedDevicesList;

    //CONSTRUCTOR:
    public Employee(String username, String firstName, String lastName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
