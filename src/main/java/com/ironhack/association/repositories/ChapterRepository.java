package com.ironhack.association.repositories;

import com.ironhack.association.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    @Query("SELECT c FROM Chapter c JOIN FETCH c.members WHERE c.id = :id")
    Optional<Chapter> findByIdWithMembers(@Param("id") Long id);
}
