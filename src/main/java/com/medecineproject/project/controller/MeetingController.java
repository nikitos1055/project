package com.medecineproject.project.controller;

import com.medecineproject.project.dto.MeetingDTO;
import com.medecineproject.project.model.Doctor;
import com.medecineproject.project.model.Meeting;
import com.medecineproject.project.service.DoctorService;
import com.medecineproject.project.service.MeetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class MeetingController {
    @Autowired
    private MeetingService service;

    @Autowired
    private DoctorService serviceDoc;

    @PostMapping("/create-meeting")
    public int createMeeting(@RequestBody MeetingDTO meetingDTO) {
        List<Meeting> list = service.findAllByDoctorId(meetingDTO.getDoctor().getId());

        if (!list.contains(service.readByTime(meetingDTO.getTime()))) {
            Meeting meeting = new Meeting(meetingDTO.getTime(), meetingDTO.getDoctor(), meetingDTO.getUser());
            Doctor doc = serviceDoc.readByLogin(meetingDTO.getDoctor().getLogin());
            doc.setNumOfMeetingsWithPatients(doc.getNumOfMeetingsWithPatients() + 1);
            serviceDoc.update(doc);

            service.save(meeting);
            log.info("Meeting {} was added", meeting);
            return 200;
        }

        return 500;
    }

    @DeleteMapping("/delete-meeting/{id}")
    public int deleteMeeting(@PathVariable int id) {
        if (!Objects.isNull(service.findById(id))) {
            Meeting meeting = service.readById(id);
            Doctor doctor = meeting.getDoctor();
            log.info("Doctor updated - " + doctor);
            doctor.setNumOfMeetingsWithPatients(doctor.getNumOfMeetingsWithPatients() - 1);
            serviceDoc.update(doctor);

            service.deleteById(id);
            return 200;
        }

        return 500;
    }
}
