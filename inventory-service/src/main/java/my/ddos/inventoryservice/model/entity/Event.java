package my.ddos.inventoryservice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "total_capacity")
    private Integer totalCapacity;


    @Column(name = "left_capacity")
    private Integer leftCapacity;


    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;
}
