package com.medecineproject.project.controller;

import com.medecineproject.project.dto.MeetingDTO;
import com.medecineproject.project.model.Doctor;
import com.medecineproject.project.model.Meeting;
import com.medecineproject.project.model.User;
import com.medecineproject.project.service.DoctorService;
import com.medecineproject.project.service.MeetingService;
import com.medecineproject.project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Objects;

@Slf4j
@RestController
public class MeetingController {
    @Autowired
    private MeetingService service;

    @Autowired
    private DoctorService serviceDoc;

    @Autowired
    private UserService serviceUser;

    @PostMapping("/create-meeting")
    public int registerDoctor(@RequestBody MeetingDTO meetingDTO) {
        if (Objects.isNull(service.readByTime(meetingDTO.getTime()))) {
            Meeting meeting = new Meeting(meetingDTO.getTime(), meetingDTO.getDoctor(), meetingDTO.getUser());
            service.save(meeting);

            User user = meetingDTO.getUser();
            Doctor doc = meetingDTO.getDoctor();
            doc.setNumOfMeetingsWithPatients(doc.getNumOfMeetingsWithPatients()+1);

            serviceDoc.update(doc);
            serviceUser.update(user);
            log.info("Meeting {} was added", meeting);

            return 200;
        }

        return 500;
    }
}
