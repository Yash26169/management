package com.hospital.dao;

import java.util.List;

import com.hospital.model.Doctor;
import com.hospital.model.OtherStaff;
import com.hospital.model.Patient;

public interface DAO {
	
	

	public void saveNewDoctor(Doctor doctor);
	
	public Doctor getDoctorById(int id);
	
	public Doctor getDoctorBySpeciality(String speciality);
	
	public void updateDoctor(Doctor doctor);
	
	public void deleteDoctorById(int id);
	
	public List<Doctor> getAllDoctor();
	
	public void saveNewPatient(Patient patient);
	
	public Patient getPatientById(int pid);
	
	public void updatePatient(Patient patient);
	
	public void deletePatientById(int pid);
	
	public List<Patient> getAllPatient();

    public void saveNewOtherStaff(OtherStaff otherStaff);
	
	public OtherStaff getOtherStaffById(int sid);
	
	public void updateOtherStaff(OtherStaff otherStaff);
	
	public void deleteOtherStaffById(int sid);
	
	public List<OtherStaff> getAllOtherStaff();
	
	public int getCountDoctor();
	
	public int getCountPatient();
	
	public int getCountStaff();
}
