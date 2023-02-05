package com.ironhack.events.repositories;

import com.ironhack.events.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    @Query("SELECT c FROM Conference c JOIN FETCH c.speakers WHERE c.id = :id")
    Optional<List<Conference>> getByIdWithSpeakers(@Param("id") Long id);
}
