package com.ironhack.events.repositories;

import com.ironhack.events.model.Conference;
import com.ironhack.events.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

    @Query("SELECT s FROM Speaker s JOIN FETCH s.conferences WHERE s.id = :id")
    Optional<List<Conference>> findByIdWithConferences(@Param("id") Long id);
}
