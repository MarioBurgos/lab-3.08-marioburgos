package com.ironhack.events.repositories;

import com.ironhack.events.model.Conference;
import com.ironhack.events.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    @Query("SELECT g FROM Guest g JOIN FETCH g.events WHERE g.id = :id")
    Optional<List<Conference>> getByIdWithEvents(@Param("id") Long id);

}
