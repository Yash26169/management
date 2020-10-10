package com.hospital.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hospital.dao.DAO;
import com.hospital.model.Doctor;
import com.hospital.model.OtherStaff;
import com.hospital.model.Patient;

@Controller
public class ManagementController {
	@Autowired
	DAO DAOImpl;
	
	@RequestMapping("/saveNewDoctor")
	public ModelAndView saveNewDoctor(@RequestParam("t1") int i, @RequestParam("t2") String j,
			@RequestParam("t3") String k, @RequestParam("t4") int l, @RequestParam("t5") String m) {
			ModelAndView mv = new ModelAndView();
		Doctor doctor = new Doctor(i, j, k, l, m);
		// System.out.println("kaha");
		DAOImpl.saveNewDoctor(doctor);
		// System.out.println("kab");
		mv.setViewName("saveNewDoctor.jsp");
		mv.addObject("doctor", doctor);
		return mv;
	}

	@RequestMapping("/getDoctorById")
	public ModelAndView getDoctorById(@RequestParam("t1") int i, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("getDoctorById.jsp");
		Doctor doctor = new Doctor();
		doctor = DAOImpl.getDoctorById(i);
		mv.addObject("doctor", doctor);
		return mv;
	}

	@RequestMapping("/getDoctorBySpeciality")
	public ModelAndView getDoctorBySpeciality(@RequestParam("t1") String i, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("getDoctorBySpeciality.jsp");
		Doctor doctor = new Doctor();
		doctor = DAOImpl.getDoctorBySpeciality(i);
		mv.addObject("doctor", doctor);
		return mv;
	}

	@RequestMapping("/updateDoctor")
	public ModelAndView updateDoctor(@RequestParam("t1") int i, @RequestParam("t2") String j,
			@RequestParam("t3") String k, @RequestParam("t4") int l, @RequestParam("t5") String m) {
		ModelAndView mv = new ModelAndView("updateDoctor.jsp");
		Doctor doctor = new Doctor(i, j, k, l, m);
		DAOImpl.updateDoctor(doctor);
		mv.addObject("doctor", doctor);
		return mv;
	}

	@RequestMapping("/deleteDoctorById")
	public ModelAndView deleteDoctorById(@RequestParam("t1") int i, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("deleteDoctorById.jsp");
		System.out.println("kaha");
		DAOImpl.deleteDoctorById(i);
		System.out.println("kab");
		mv.addObject("result", i);
		return mv;
	}

	@RequestMapping("/getAllDoctor")
	public ModelAndView getAllDoctor() {
		ModelAndView mv = new ModelAndView("getAllDoctor.jsp");
		List<Doctor> doctorList = DAOImpl.getAllDoctor();
		mv.addObject("doctorList", doctorList);
		return mv;
	}

	@RequestMapping("/saveNewPatient")
	public ModelAndView saveNewPatient(@RequestParam("t1") int i, @RequestParam("t2") String j,
			@RequestParam("t3") int k, @RequestParam("t4") String l) {
		ModelAndView mv = new ModelAndView();
		Patient patient = new Patient(i, j, k, l);
		DAOImpl.saveNewPatient(patient);
		mv.setViewName("saveNewPatient.jsp");
		mv.addObject("patient", patient);
		return mv;
	}

	@RequestMapping("/getPatientById")
	public ModelAndView getPatientById(@RequestParam("t1") int i, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("getPatientById.jsp");
		Patient patient = new Patient();
		patient = DAOImpl.getPatientById(i);
		mv.addObject("patient", patient);
		return mv;
	}

	@RequestMapping("/updatePatient")
	public ModelAndView updatePatient(@RequestParam("t1") int i, @RequestParam("t2") String j,
			@RequestParam("t3") int k, @RequestParam("t4") String l) {
		ModelAndView mv = new ModelAndView("updatePatient.jsp");
		Patient patient = new Patient(i, j, k, l);
		DAOImpl.updatePatient(patient);
		mv.addObject("patient", patient);
		return mv;
	}

	@RequestMapping("/deletePatientById")
	public ModelAndView deletePatientById(@RequestParam("t1") int i, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("deletePatientById.jsp");
		DAOImpl.deletePatientById(i);
		mv.addObject("result", i);
		return mv;
	}

	@RequestMapping("/getAllPatient")
	public ModelAndView getAllPatient() {
		ModelAndView mv = new ModelAndView("getAllPatient.jsp");
		List<Patient> patientList = DAOImpl.getAllPatient();
		mv.addObject("patientList", patientList);
		return mv;
	}

	@RequestMapping("/saveNewOtherStaff")
	public ModelAndView saveNewOtherStaff(@RequestParam("t1") int i, @RequestParam("t2") String j,
			@RequestParam("t3") String k, @RequestParam("t4") int l, @RequestParam("t5") String m,
			@RequestParam("t6") String n) {
		ModelAndView mv = new ModelAndView();
		OtherStaff otherStaff = new OtherStaff(i, j, k, l, m, n);
		// System.out.println("kaha");
		DAOImpl.saveNewOtherStaff(otherStaff);
		// System.out.println("kb");
		mv.setViewName("saveNewOtherStaff.jsp");
		mv.addObject("otherStaff", otherStaff);
		return mv;
	}

	@RequestMapping("/getOtherStaffById")
	public ModelAndView getOtherStaffById(@RequestParam("t1") int i, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("getOtherStaffById.jsp");
		OtherStaff otherStaff = new OtherStaff();
		otherStaff = DAOImpl.getOtherStaffById(i);
		mv.addObject("otherStaff", otherStaff);
		return mv;
	}

	@RequestMapping("/updateOtherStaff")
	public ModelAndView updateOtherStaff(@RequestParam("t1") int i, @RequestParam("t2") String j,
			@RequestParam("t3") String k, @RequestParam("t4") int l, @RequestParam("t5") String m,
			@RequestParam("t6") String n) {
		ModelAndView mv = new ModelAndView("updateOtherStaff.jsp");
		OtherStaff otherStaff = new OtherStaff(i, j, k, l, m, n);
		DAOImpl.updateOtherStaff(otherStaff);
		mv.addObject("otherStaff", otherStaff);
		return mv;
	}

	@RequestMapping("/deleteOtherStaffById")
	public ModelAndView deleteOtherStaffById(@RequestParam("t1") int i, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("deleteOtherStaffById.jsp");
		DAOImpl.deleteOtherStaffById(i);
		mv.addObject("result", i);
		return mv;
	}

	@RequestMapping("/getAllOtherStaff")
	public ModelAndView getAllOtherStaff() {
		ModelAndView mv = new ModelAndView("getAllOtherStaff.jsp");
		List<OtherStaff> otherStaffList = DAOImpl.getAllOtherStaff();
		mv.addObject("otherStaffList", otherStaffList);
		return mv;
	}
	
	@RequestMapping("/Details")
	public ModelAndView Details() {
		int total_beds=20;
		int count_doctor=DAOImpl.getCountDoctor();
		int count_patient=DAOImpl.getCountPatient();
		int count_staff=DAOImpl.getCountStaff();
		int available=total_beds-count_patient; 
		ModelAndView mv = new ModelAndView("Details.jsp");
		
		
		mv.addObject("count_doctor",count_doctor);
		mv.addObject("count_patient",count_patient);
		mv.addObject("count_staff",count_staff);
		mv.addObject("total_beds",total_beds);
		mv.addObject("Occupied",count_patient);
		mv.addObject("available",available);
		return mv;
	}
	
	
}
