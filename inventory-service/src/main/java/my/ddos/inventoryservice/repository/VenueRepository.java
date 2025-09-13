package my.ddos.inventoryservice.repository;

import my.ddos.inventoryservice.model.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
