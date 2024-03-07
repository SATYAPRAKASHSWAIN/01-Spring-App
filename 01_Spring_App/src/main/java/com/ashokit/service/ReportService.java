package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.CitiizenPlan;
import com.ashokit.request.SearchRequest;

import javax.servlet.http.HttpServletResponse;

public interface ReportService {
	//Plan nmae drop down values should come from database table
	//method to get plan-status drop down data
	public List<String> getPlanNames();
	
	
	//Plan status deom down values should from database table
	//method to handle search functionality
	public List<String> getPlanStatuses();
	
	//method to export data to excel file	
	public List<CitiizenPlan> search(SearchRequest request);	
	
	//method to export data to excel file
	public boolean exportExcel(HttpServletResponse response) throws  Exception;
	
	//method to export data to pdj file
	public boolean exportPdf(HttpServletResponse response) throws  Exception;
	
	

}
