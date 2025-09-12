package my.ddos.inventoryservice.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "venues")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Venue {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "total_capacity")
    private Integer totalCapacity;


    @OneToMany(mappedBy = "venue", orphanRemoval = true)
    private List<Event> events;


}
