package com.ironhack.events.repositories;

import com.ironhack.events.model.Conference;
import com.ironhack.events.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e JOIN FETCH e.guestList WHERE s.id = :id")
    Optional<List<Conference>> getByIdWithGuestList(@Param("id") Long id);
}
