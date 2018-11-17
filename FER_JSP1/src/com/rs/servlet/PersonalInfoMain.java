package com.rs.servlet;

import com.rs.bean.PersonalInfo;
import com.rs.service.FERService;
import com.rs.service.FERServiceImpl;

public class PersonalInfoMain {

	public static void main(String[] args) {
		FERService fer = new FERServiceImpl();

		PersonalInfo personalInfo = fer.getPersonalInfo("1");

		System.out.println(personalInfo.getUser().getFirstName());
		System.out.println(personalInfo.getUser().getMiddleName());
		System.out.println(personalInfo.getUser().getLastName());
		System.out.println(personalInfo.getUser().geteMail());
		System.out.println(personalInfo.getUser().getMobileNumber());
		System.out.println(personalInfo.getUser().getUserName());
		System.out.println(personalInfo.getUser().getPassword());
		System.out.println(personalInfo.getAddress().getAddressLine1());
		System.out.println(personalInfo.getAddress().getAddressLine2());
		System.out.println(personalInfo.getAddress().getCity());
		System.out.println(personalInfo.getAddress().getState());
		System.out.println(personalInfo.getAddress().getCountry());

	}
}
