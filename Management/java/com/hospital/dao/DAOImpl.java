package com.hospital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hospital.model.Doctor;
import com.hospital.model.OtherStaff;
import com.hospital.model.Patient;
@Component
public class DAOImpl implements DAO {

	public void saveNewDoctor(Doctor doctor) {
		

		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/management";
			String uname = "root";
			String pass = "Yash2520@";
			String query= "insert into Doctor (id, name, email, phone, speciality ) values (?,?,?,?,?)";
			
			Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, doctor.getId());
			ps.setString(2, doctor.getName());
			ps.setString(3, doctor.getEmail());
			ps.setInt(4, doctor.getPhone());
			ps.setString(5, doctor.getSpeciality());
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Doctor saved with id="+doctor.getId());
			}
			else 
				System.out.println("Doctor save failed with id="+doctor.getId());
			ps.close();
			con.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			}
		
	}
	
	

	public Doctor getDoctorById(int id) {
		
		
		Doctor doc = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/management";
			String uname = "root";
			String pass = "Yash2520@";
			String query= "select name, email, phone, speciality from Doctor where id = ?";
			
			Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				doc = new Doctor();
				doc.setId(id);
				doc.setName(rs.getString("name"));
				doc.setEmail(rs.getString("email"));
				doc.setPhone(rs.getInt("phone"));
				doc.setSpeciality(rs.getString("speciality"));
				System.out.println("Doctor Found::"+doc);
			}
			else
			{
				System.out.println("No Doctor found with id="+id);
			}
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return doc;
	}

	
	
	
	public Doctor getDoctorBySpeciality(String speciality) {
		
			Doctor doc = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/management";
			String uname = "root";
			String pass = "Yash2520@";
			String query= "select id, name, email, phone from Doctor where speciality = ?";
			
			Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, speciality);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				doc = new Doctor();
				doc.setId(rs.getInt("id"));
				doc.setName(rs.getString("name"));
				doc.setEmail(rs.getString("email"));
				doc.setPhone(rs.getInt("phone"));
				doc.setSpeciality(speciality);
				System.out.println("Doctor Found::"+doc);
			}
			else
			{
				System.out.println("No Doctor found with speciality="+speciality);
			}
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return doc;
		
		}
	
	
	
	

	public void updateDoctor(Doctor doctor) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/management";
			String uname = "root";
			String pass = "Yash2520@";
			String query = "update Doctor set name=?, email=?, phone=?, speciality=? where id=?";
			Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, doctor.getName());
			ps.setString(2, doctor.getEmail());
			ps.setInt(3, doctor.getPhone());
			ps.setString(4, doctor.getSpeciality());
			ps.setInt(5, doctor.getId());
			
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Doctor updated with id="+doctor.getId());
			}
			else 
				System.out.println("No Doctor found with id="+doctor.getId());
			ps.close();
			con.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
	}
	
	
	

	public void deleteDoctorById(int id) {
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/management";
			String uname = "root";
			String pass = "Yash2520@";
			String query = "delete from Doctor where id=?";
			Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Doctor deleted with id="+id);
			}
			else
				System.out.println("No Doctor found with id="+id);
		
			ps.close();
		con.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

	
	
	
	
	
	public List<Doctor> getAllDoctor() {
				
		List<Doctor> list1=new ArrayList();
		
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
			
		String url = "jdbc:mysql://localhost:3306/management";
		String uname = "root";
		String pass = "Yash2520@";
		String query= "select * from Doctor";
		
		Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		String userData = "";
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			Doctor doc=new Doctor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			userData = rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " + rs.getInt(4) + " : " + rs.getString(5);
			System.out.println(userData);
			list1.add(doc);
		}
		st.close();
		con.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		return list1;
	}
	
	
	
	
	public void saveNewPatient(Patient patient) {
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/management";
			String uname = "root";
			String pass = "Yash2520@";
			String query= "insert into Patient (pid, pname, pphone, disease ) values (?,?,?,?)";
			
			Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, patient.getPid());
			ps.setString(2, patient.getPname());
			ps.setInt(3, patient.getPphone());
			ps.setString(4, patient.getDisease());
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Patient saved with id="+patient.getPid());
			}
			else 
				System.out.println("Patient save failed with id="+patient.getPid());
			ps.close();
			con.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			}
		
	}

	
	
	

public Patient getPatientById(int pid) {
	
	
	Patient pat = null;

	try{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/management";
		String uname = "root";
		String pass = "Yash2520@";
		String query= "select pname, pphone, disease from Patient where pid = ?";
		
		Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, pid);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			pat = new Patient();
			pat.setPid(pid);
			pat.setPname(rs.getString("pname"));
			pat.setPphone(rs.getInt("pphone"));
			pat.setDisease(rs.getString("disease"));
			
			System.out.println("Patient Found::"+pat);
		}
		else
		{
			System.out.println("No Patient found with pid="+pid);
		}
		rs.close();
		ps.close();
		con.close();
	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
	return pat;
}

	
	
public void updatePatient(Patient patient) {
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/management";
		String uname = "root";
		String pass = "Yash2520@";
		String query = "update Patient set pname=?, pphone=?, disease=? where pid=?";
		Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, patient.getPname());
		ps.setInt(2, patient.getPphone());
		ps.setString(3, patient.getDisease());
		ps.setInt(4, patient.getPid());
		
		int out = ps.executeUpdate();
		if(out !=0){
			System.out.println("Patient updated with pid="+patient.getPid());
		}
		else 
			System.out.println("No Patient found with id="+patient.getPid());
		ps.close();
		con.close();
	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
	
}

	
	

public void deletePatientById(int pid) {

	try{
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/management";
		String uname = "root";
		String pass = "Yash2520@";
		String query = "delete from Patient where pid=?";
		Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, pid);
		int out = ps.executeUpdate();
		if(out !=0){
			System.out.println("Patient deleted with id="+pid);
		}
		else
			System.out.println("No Patient found with id="+pid);
	
		ps.close();
	con.close();
	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
}


	

public List<Patient> getAllPatient() {
			
	List<Patient> list1=new ArrayList();
	
	try {
		
	Class.forName("com.mysql.jdbc.Driver");
		
	String url = "jdbc:mysql://localhost:3306/management";
	String uname = "root";
	String pass = "Yash2520@";
	String query= "select * from Patient";
	
	Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
	Statement st = con.createStatement();
	String userData = "";
	ResultSet rs = st.executeQuery(query);
	while(rs.next())
	{
		Patient pat=new Patient(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
		userData = rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getInt(3) + " : " + rs.getString(4);
		System.out.println(userData);
		list1.add(pat);
	}
	st.close();
	con.close();
	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
	
	return list1;
}





public void saveNewOtherStaff(OtherStaff otherStaff) {
	
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/management";
		String uname = "root";
		String pass = "Yash2520@";
		String query= "insert into OtherStaff (sid, sname, semail, sphone, designation, shift) values (?,?,?,?,?,?)";
		
		Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, otherStaff.getSid());
		ps.setString(2, otherStaff.getSname());
		ps.setString(3, otherStaff.getSemail());
		ps.setInt(4, otherStaff.getSphone());
		ps.setString(5, otherStaff.getDesignation());
		ps.setString(6, otherStaff.getShift());
		int out = ps.executeUpdate();
		if(out !=0){
			System.out.println("OtherStaff saved with id="+otherStaff.getSid());
		}
		else 
			System.out.println("OtherStaff save failed with id="+otherStaff.getSid());
		ps.close();
		con.close();
	}
	catch(Exception ex)
	{
		System.out.println(ex);
		}
	
}





public OtherStaff getOtherStaffById(int sid) {


	OtherStaff os = null;

try{
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/management";
	String uname = "root";
	String pass = "Yash2520@";
	String query= "select sname, semail, sphone, designation, shift from OtherStaff where sid = ?";
	
	Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
	PreparedStatement ps = con.prepareStatement(query);
	ps.setInt(1, sid);
	ResultSet rs = ps.executeQuery();
	if(rs.next()){
		os = new OtherStaff();
		os.setSid(sid);
		os.setSname(rs.getString("sname"));
		os.setSemail(rs.getString("semail"));
		os.setSphone(rs.getInt("sphone"));
		os.setDesignation(rs.getString("designation"));
		os.setShift(rs.getString("shift"));
		
		System.out.println("Patient Found::"+os);
	}
	else
	{
		System.out.println("No OtherStaff found with sid="+sid);
	}
	rs.close();
	ps.close();
	con.close();
}
catch(Exception ex)
{
	System.out.println(ex);
}
return os;
}



public void updateOtherStaff(OtherStaff otherStaff) {

try{
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/management";
	String uname = "root";
	String pass = "Yash2520@";
	String query = "update OtherStaff set sname=?,  semail=?, sphone=?, designation=?, shift=? where sid=?";
	Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
	PreparedStatement ps = con.prepareStatement(query);
	ps.setString(1, otherStaff.getSname());
	ps.setString(2, otherStaff.getSemail());
	ps.setInt(3, otherStaff.getSphone());
	ps.setString(4, otherStaff.getDesignation());
	ps.setString(5, otherStaff.getShift());
	ps.setInt(6, otherStaff.getSid());
	
	int out = ps.executeUpdate();
	if(out !=0){
		System.out.println("OtherStaff updated with sid="+otherStaff.getSid());
	}
	else 
		System.out.println("No OtherStaff found with sid="+otherStaff.getSid());
	ps.close();
	con.close();
}
catch(Exception ex)
{
	System.out.println(ex);
}

}




public void deleteOtherStaffById(int sid) {

try{
	Class.forName("com.mysql.jdbc.Driver");
	
	String url = "jdbc:mysql://localhost:3306/management";
	String uname = "root";
	String pass = "Yash2520@";
	String query = "delete from OtherStaff where sid=?";
	Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
	PreparedStatement ps = con.prepareStatement(query);
	ps.setInt(1, sid);
	int out = ps.executeUpdate();
	if(out !=0){
		System.out.println("OtherStaff deleted with sid="+sid);
	}
	else
		System.out.println("No OtherStaff found with sid="+sid);

	ps.close();
con.close();
}
catch(Exception ex)
{
	System.out.println(ex);
}
}




public List<OtherStaff> getAllOtherStaff() {
		
List<OtherStaff> list1=new ArrayList();

try {
	
Class.forName("com.mysql.jdbc.Driver");
	
String url = "jdbc:mysql://localhost:3306/management";
String uname = "root";
String pass = "Yash2520@";
String query= "select * from OtherStaff";

Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
Statement st = con.createStatement();
String userData = "";
ResultSet rs = st.executeQuery(query);
while(rs.next())
{
	OtherStaff os=new OtherStaff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
	userData = rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " + rs.getInt(4) + " : " + rs.getString(5) + " : " + rs.getString(6);
	System.out.println(userData);
	list1.add(os);
}
st.close();
con.close();
}
catch(Exception ex)
{
	System.out.println(ex);
}

return list1;
}

	
public int getCountDoctor() {
	int count=0;
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
			
		String url = "jdbc:mysql://localhost:3306/management";
		String uname = "root";
		String pass = "Yash2520@";
		String query= "select * from Doctor";
		
		Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		String userData = "";
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			userData = rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " + rs.getInt(4) + " : " + rs.getString(5);
			count++;;
		}
		st.close();
		con.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		return count;
	}



		public int getCountPatient() {
			 int count=0;
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
					
				String url = "jdbc:mysql://localhost:3306/management";
				String uname = "root";
				String pass = "Yash2520@";
				String query= "select * from Patient";
				
				Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
				Statement st = con.createStatement();
				String userData = "";
				ResultSet rs = st.executeQuery(query);
				while(rs.next())
				{
					userData = rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getInt(3) + " : " + rs.getString(4);
					count++;
				}
				st.close();
				con.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
				return count;
	
		}

		public int getCountStaff() {
			
			int count=0;
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
					
				String url = "jdbc:mysql://localhost:3306/management";
				String uname = "root";
				String pass = "Yash2520@";
				String query= "select * from OtherStaff";

				Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
				Statement st = con.createStatement();
				String userData = "";
				ResultSet rs = st.executeQuery(query);
				while(rs.next())
				{
					userData = rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " + rs.getInt(4) + " : " + rs.getString(5) + " : " + rs.getString(6);
					count++;
				}
				st.close();
				con.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}

				return count;
		}

}
