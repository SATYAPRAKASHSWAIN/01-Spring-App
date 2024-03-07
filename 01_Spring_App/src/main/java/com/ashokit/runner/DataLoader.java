package com.ashokit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ashokit.entity.CitiizenPlan;
import com.ashokit.repository.CitizenPlanRepo;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		repo.deleteAll();
		
		// Cash plan Data
		CitiizenPlan c1 = new CitiizenPlan();
		c1.setCitizenName("John");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmt(5000.00);

		// Cash plan Data
		CitiizenPlan c2 = new CitiizenPlan();
		c2.setCitizenName("Smith");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setPlanStartDate(LocalDate.now());
		c2.setPlanEndDate(LocalDate.now().plusMonths(6));
		c2.setDenialReason("Rental Income");

		// Cash plan Data
		CitiizenPlan c3 = new CitiizenPlan();
		c3.setCitizenName("Cathy");
		c3.setGender("FeMale");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenefitAmt(5000.00);
		c3.setTerminateDate(LocalDate.now());
		c3.setTerminationRsn("Employed");

		// Food plan Data
		CitiizenPlan c4 = new CitiizenPlan();
		c4.setCitizenName("David");
		c4.setGender("Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmt(4000.00);

		// Cash plan Data
		CitiizenPlan c5 = new CitiizenPlan();
		c5.setCitizenName("Robert");
		c5.setGender("Male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("Property Income");

		// Cash plan Data
		CitiizenPlan c6 = new CitiizenPlan();
		c6.setCitizenName("Orlen");
		c6.setGender("FeMale");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenefitAmt(5000.00);
		c6.setTerminateDate(LocalDate.now());
		c6.setTerminationRsn("Employed");

		// Medical plan Data
		CitiizenPlan c7 = new CitiizenPlan();
		c7.setCitizenName("Charles");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenefitAmt(4000.00);

		// Cash plan Data
		CitiizenPlan c8 = new CitiizenPlan();
		c8.setCitizenName("Buttler");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setDenialReason("Property Income");

		// Cash plan Data
		CitiizenPlan c9 = new CitiizenPlan();
		c9.setCitizenName("Neel");
		c9.setGender("FeMale");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenefitAmt(5000.00);
		c9.setTerminateDate(LocalDate.now());
		c9.setTerminationRsn("Govenment Job");

		// Employeement plan Data
		CitiizenPlan c10 = new CitiizenPlan();
		c10.setCitizenName("Steve");
		c10.setGender("Male");
		c10.setPlanName("Employement");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenefitAmt(4000.00);

		// Cash plan Data
		CitiizenPlan c11 = new CitiizenPlan();
		c11.setCitizenName("Moris");
		c11.setGender("Male");
		c11.setPlanName("Employement");
		c11.setPlanStatus("Denied");
		c11.setDenialReason("Property Income");

		// Cash plan Data
		CitiizenPlan c12 = new CitiizenPlan();
		c12.setCitizenName("Gibs");
		c12.setGender("FeMale");
		c12.setPlanName("Employement");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now().minusMonths(4));
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setBenefitAmt(5000.00);
		c12.setTerminateDate(LocalDate.now());
		c12.setTerminationRsn("Govenment Job");

		List<CitiizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		repo.saveAll(list);
	}

}
