package com.santosh.assessment.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.assessment.entity.MovieReleaseMaster;
import com.santosh.assessment.entity.ShowMaster;

public interface ShowRepository extends JpaRepository<ShowMaster, UUID> {
	List<ShowMaster> findByReleaseAndShowDate(MovieReleaseMaster release, Date date);
	List<ShowMaster> findByRelease(MovieReleaseMaster release);
	List<ShowMaster> findByRelease_releaseId(UUID releaseId);
	
}
