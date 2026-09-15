package com.arrangement.repository;

import com.arrangement.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByEventId(Long eventId);
    long countByEventIdAndStatus(Long eventId, String status);
}