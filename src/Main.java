import java.util.List;

import com.hospitalmanagement.dao.DoctorDAO;
import com.hospitalmanagement.model.Department;
import com.hospitalmanagement.model.Doctor;

public class Main {
	public static void main(String[] args) {
		System.out.println("Running");
		DoctorDAO doctorDao = new DoctorDAO();
		List<Doctor> doctors = doctorDao.findAll();
		System.out.println(doctors);
//		
//		Doctor doctor = doctors.get(0);
//		doctor.setDepartment(new Department(1));
//		doctorDao.update(doctor);
//		
//		doctors = doctorDao.findAll();
//		System.out.println(doctors);
		
		
//		DAOTestting test = new DAOTestting();
//		test.testDepartmentDAO();
//		
	}
	
}
