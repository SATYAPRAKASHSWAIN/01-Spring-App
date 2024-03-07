package com.ashokit.service;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.ashokit.util.EmailUtils;
import com.ashokit.util.ExcelGenerator;
import com.ashokit.util.PdfGenerator;
import com.lowagie.text.*;

import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ashokit.entity.CitiizenPlan;
import com.ashokit.repository.CitizenPlanRepo;
import com.ashokit.request.SearchRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepo planRepo;

	@Autowired
	private ExcelGenerator excelGenerator;

	@Autowired
	private PdfGenerator pdfgenerator;

	@Autowired
	private EmailUtils emailUtils;

	@Override
	public List<String> getPlanNames() {
		return planRepo.getPlanNames();

	}
	@Override
	public List<String> getPlanStatuses() {
		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitiizenPlan> search(SearchRequest request) {
		CitiizenPlan entity = new CitiizenPlan();

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			entity.setPlanStartDate(localDate);
		}
		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String endDate = request.getEndDate();
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDatee = LocalDate.parse(endDate, formater);
			entity.setPlanEndDate(localDatee);
		}

		return planRepo.findAll(Example.of(entity));
	}
	@Override
	public boolean exportExcel(HttpServletResponse response)throws Exception {
		File file = new File("Plans.xls");
		List<CitiizenPlan> plans = planRepo.findAll();
		excelGenerator.generator(response,plans,file);
		String subject="Text mail subject";
		String body="<h1> Text mail body</h1>";
		String to="ajitkumarjena824@gmail.com";


		emailUtils.sendEmail(subject,body,to,file);
		file.delete();
		return true;
	}
	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File f = new File("Plans.pdf");
		List<CitiizenPlan> plans = planRepo.findAll();

		pdfgenerator.pdfGenerator(response,plans,f);
		String subject="Text mail subject";
		String body="<h1> Text mail body</h1>";
		String to="ajitkumarjena824@gmail.com";
		emailUtils.sendEmail(subject,body,to,f);
		f.delete();
		return true;
	}


}
