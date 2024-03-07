package com.ashokit.util;


import java.io.File;
import java.io.FileOutputStream;
import java.sql.ClientInfoStatus;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ashokit.entity.CitiizenPlan;
import com.ashokit.repository.CitizenPlanRepo;
import com.ashokit.request.SearchRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;


@Component
public class PdfGenerator {

	public void pdfGenerator(HttpServletResponse response, List<CitiizenPlan> reconds,File f)throws  Exception {
		Document document = new Document(PageSize.A4);
	 PdfWriter.getInstance(document, response.getOutputStream());
	 PdfWriter.getInstance(document,new FileOutputStream(f));
		document.open();
		// Creating font
		// Setting font style and size
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);

		// Creating paragraph
		Paragraph p = new Paragraph("Citizen Plan Info", fontTiltle);

		// Aligning the paragraph in document
		p.setAlignment(Paragraph.ALIGN_CENTER);


		// Create Table Cells for table header
		PdfPCell cell = new PdfPCell();

		// Setting the background color and padding
		cell.setBackgroundColor(CMYKColor.BLUE);
		cell.setPadding(5);

		// Create Table Cells for table header
		PdfPCell cell1 = new PdfPCell();

		// Setting the background color and padding
		cell1.setBackgroundColor(CMYKColor.YELLOW);
		cell1.setPadding(5);

		//Table Header
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);

		//Table body
		Font font1 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font1.setColor(CMYKColor.MAGENTA);


		//Paragraph p =new Paragraph("Citizen Plan Info");
		document.add(p);
		PdfPTable table = new PdfPTable(6);
		table.setSpacingBefore(5);
		table.setWidthPercentage(100f);
		table.setWidths(new int[]{6, 6, 6, 6, 6, 6});

		cell.setPhrase(new Phrase("Id", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Citizen Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Plan Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Plan Status", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Start Date", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("End Date", font));
		table.addCell(cell);


//		table.addCell("Id");
//		table.addCell("Citizen Name");
//		table.addCell("Plan Name");
//		table.addCell("Plan Status");
//		table.addCell("Start Date");
//		table.addCell("End Date");

		//List<CitiizenPlan> plans = planRepo.findAll();
		for (CitiizenPlan plan : reconds) {
			cell1.setPhrase(new Phrase(String.valueOf(plan.getCitizenId()), font1));
			table.addCell(cell1);
			cell1.setPhrase(new Phrase(plan.getCitizenName(), font1));
			table.addCell(cell1);
			cell1.setPhrase(new Phrase(plan.getPlanName(), font1));
			table.addCell(cell1);
			cell1.setPhrase(new Phrase(plan.getPlanStatus(), font1));
			table.addCell(cell1);
			cell1.setPhrase(new Phrase(plan.getPlanStartDate() + "", font1));
			table.addCell(cell1);
			cell1.setPhrase(new Phrase(plan.getPlanEndDate() + "", font1));
			table.addCell(cell1);
			//table.addCell(String.valueOf(plan.getCitizenId()));
//			table.addCell(plan.getCitizenName());
//			table.addCell(plan.getPlanName());
//			table.addCell(plan.getPlanStatus());
//			table.addCell(plan.getPlanStartDate()+"");
//			table.addCell(plan.getPlanEndDate()+"");

		}
		document.add(table);
		document.close();

	}
}