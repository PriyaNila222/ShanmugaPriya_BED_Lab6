package com.greatlearning.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.entity.RegistrationList;
import com.greatlearning.repository.RegistrationListRepository;
import com.greatlearning.service.RegistrationListService;

@Service
public class RegistrationListServiceImpl implements RegistrationListService {

	@Autowired
	RegistrationListRepository registrationListrepository;

	@Override
	public List<RegistrationList> getAllRecords() {
		return registrationListrepository.findAll();
	}

	@Override
	public RegistrationList saveRecord(RegistrationList registrationList) {
		return registrationListrepository.save(registrationList);
	}

	@Override
	public RegistrationList getRecordById(long id) {
		return registrationListrepository.findById(id).get();
	}

	@Override
	public RegistrationList updateRecordById(long id, RegistrationList registrationList) {
		RegistrationList existingRecord = getRecordById(id);
		existingRecord.setStudentId(id);
		existingRecord.setFirstName(registrationList.getFirstName());
		existingRecord.setLastName(registrationList.getLastName());
		existingRecord.setCourse(registrationList.getCourse());
		existingRecord.setCountry(registrationList.getCountry());
		return saveRecord(existingRecord);
	}

	@Override
	public void deleteRecordById(long id) {
		registrationListrepository.deleteById(id);

	}

}
