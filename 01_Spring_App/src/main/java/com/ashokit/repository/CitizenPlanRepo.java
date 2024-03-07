package com.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashokit.entity.CitiizenPlan;

public interface CitizenPlanRepo extends JpaRepository<CitiizenPlan, Integer> {

	@Query("select distinct(planName) from CitiizenPlan")
	public List<String> getPlanNames();
	
	
	@Query("select distinct(planStatus) from CitiizenPlan")
	public List<String> getPlanStatus();
}
