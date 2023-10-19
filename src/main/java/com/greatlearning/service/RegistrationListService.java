package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.RegistrationList;

public interface RegistrationListService {
	List<RegistrationList> getAllRecords();

	RegistrationList saveRecord(RegistrationList registrationList);

	RegistrationList getRecordById(long id);

	RegistrationList updateRecordById(long id, RegistrationList registrationList);

	void deleteRecordById(long id);
}
