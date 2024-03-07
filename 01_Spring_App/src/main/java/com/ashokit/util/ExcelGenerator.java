package com.ashokit.util;

import com.ashokit.entity.CitiizenPlan;
import com.ashokit.repository.CitizenPlanRepo;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.pdf.CMYKColor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Component
public class ExcelGenerator {


    public void generator(HttpServletResponse response,List<CitiizenPlan> records,File file)throws  Exception{
        HSSFWorkbook wordSheet = new HSSFWorkbook();
        Sheet sheet = wordSheet.createSheet("plans-data");
        Row headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Citizen Name");
        headerRow.createCell(2).setCellValue("Plan Name");
        headerRow.createCell(3).setCellValue("Plan Status");
        headerRow.createCell(4).setCellValue("Plan Start Date");
        headerRow.createCell(5).setCellValue("Plan End Date");
        headerRow.createCell(6).setCellValue("Benefit Amount");

      //  List<CitiizenPlan> records=planRepo.findAll();

        int dataRowIndex=1;

        for (CitiizenPlan plan : records) {
            Row dateRow = sheet.createRow(dataRowIndex);
            dateRow.createCell(0).setCellValue(plan.getCitizenId());
            dateRow.createCell(1).setCellValue(plan.getCitizenName());
            dateRow.createCell(2).setCellValue(plan.getPlanName());
            dateRow.createCell(3).setCellValue(plan.getPlanStatus());
            if(null != plan.getPlanStartDate()){
                dateRow.createCell(4).setCellValue(plan.getPlanStartDate()+"");
            }else{
                dateRow.createCell(4).setCellValue("N/A");
            }
            if(null != plan.getPlanEndDate()){
                dateRow.createCell(5).setCellValue(plan.getPlanEndDate()+"");
            }else{
                dateRow.createCell(5).setCellValue("N/A");
            }
            if(null != plan.getBenefitAmt()){
                dateRow.createCell(6).setCellValue(plan.getBenefitAmt());
            }else{
                dateRow.createCell(6).setCellValue("N/A");
            }
            dataRowIndex++;
        }

        FileOutputStream fos=    new FileOutputStream(file);
        wordSheet.write(fos);
        fos.close();

        ServletOutputStream outputStream = response.getOutputStream();
        wordSheet.write(outputStream);
        wordSheet.close();

    }


}
