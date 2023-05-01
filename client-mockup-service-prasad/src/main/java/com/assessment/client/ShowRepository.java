package com.assessment.client;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assesment.movie.entity.MovieReleaseMaster;
import com.assesment.movie.entity.ShowMaster;

public interface ShowRepository extends JpaRepository<ShowMaster, UUID> {
	List<ShowMaster> findByReleaseAndShowDate(MovieReleaseMaster release, Date date);
	List<ShowMaster> findByRelease(MovieReleaseMaster release);
	List<ShowMaster> findByRelease_releaseId(UUID releaseId);
	
}
