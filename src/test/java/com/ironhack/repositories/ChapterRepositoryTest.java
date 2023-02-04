package com.ironhack.repositories;

import com.ironhack.model.Chapter;
import com.ironhack.model.District;
import com.ironhack.model.Member;
import com.ironhack.model.enums.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ChapterRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private ChapterRepository chapterRepository;

    private District district;
    private Chapter chapter;
    private Member member1, member2, president;
    @BeforeEach
    void setUp() {
        //create chapter
        chapter = new Chapter();
        district = new District("00000");
        chapter.setDistrict(district);
        //create members, president and assign to the chapter
        member1 = new Member("member1", Status.ACTIVE, new Date(2020-02-02));
        member2 = new Member("member2", Status.LAPSED, new Date(2015-05-05));
        president = new Member("president", Status.ACTIVE, new Date(2001-01-01));
        chapter.setPresident(president);
        chapter.setMembers(List.of(member1, member2));
        //first, other repositories save foreign data
        districtRepository.save(district);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(president);
        //then
        chapterRepository.save(chapter);


    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void JpaGoesBrrr(){
        Optional<Chapter> optionalChapter = chapterRepository.findById(chapter.getId());
        assertTrue(optionalChapter.isPresent());
        assertEquals(chapter.getDistrict(), optionalChapter.get().getDistrict());
    }

//    @Test
//    void oneToMany_ReceivesChapterId_ReturnsChapterAndMembers(){
//        Optional<Chapter> optionalChapter = chapterRepository.findByIdWithMembers(chapter.getId());
//        assertTrue(optionalChapter.isPresent());
//    }

}