package my.ddos.inventoryservice.repository;

import my.ddos.inventoryservice.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
