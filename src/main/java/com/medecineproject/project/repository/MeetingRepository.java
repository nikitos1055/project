package com.medecineproject.project.repository;

import com.medecineproject.project.model.Meeting;
import com.medecineproject.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long>,
        CrudRepository<Meeting, Long> {

    Meeting readByTime(String time);
}
