package com.medecineproject.project.service.impl;

import com.medecineproject.project.model.Meeting;
import com.medecineproject.project.repository.MeetingRepository;
import com.medecineproject.project.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    MeetingRepository rep;

    @Override
    public Meeting save(Meeting meeting) {
        return rep.save(meeting);
    }

    @Override
    public Optional<Meeting> findById(long id) {
        return rep.findById(id);
    }

    @Override
    public List<Meeting> findAll() {
        return rep.findAll();
    }

    @Override
    public Meeting update(Meeting meeting) {
        return rep.save(meeting);
    }

    @Override
    public void deleteById(long id) {
        rep.deleteById(id);
    }
}
