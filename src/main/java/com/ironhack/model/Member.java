package com.ironhack.model;

import com.ironhack.model.enums.Status;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Date renewalDate;
    @ManyToOne
    private Chapter chapter;

    public Member() {
    }

    public Member(String name, Status status, Date renewalDate) {
        this.name = name;
        this.status = status;
        this.renewalDate = renewalDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member member)) return false;

        if (getId() != null ? !getId().equals(member.getId()) : member.getId() != null) return false;
        if (getName() != null ? !getName().equals(member.getName()) : member.getName() != null) return false;
        if (getStatus() != member.getStatus()) return false;
        if (getRenewalDate() != null ? !getRenewalDate().equals(member.getRenewalDate()) : member.getRenewalDate() != null)
            return false;
        return Objects.equals(chapter, member.chapter);
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getRenewalDate() != null ? getRenewalDate().hashCode() : 0);
        result = 31 * result + (chapter != null ? chapter.hashCode() : 0);
        return result;
    }
}
