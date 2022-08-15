import java.sql.Date;
import java.util.List;

import com.hospitalmanagement.dao.DepartmentDAO;
import com.hospitalmanagement.dao.PatientDAO;
import com.hospitalmanagement.model.Department;
import com.hospitalmanagement.model.Patient;

public class DAOTestting {

	public void testPatientDAO()
	{
		PatientDAO patientDAO = new PatientDAO();

		System.out.println("Test Department insert");
//		Integer id, String name, Date dateOfBirth, Character gender, String address, String phoneNumber
		Date date = new Date(new java.util.Date().getTime());
		
		Patient tmp = new Patient(1, "Test Patient DAO", date, 'f', "Test Patient DAO", "0999999999");
	
		patientDAO.insert(tmp);
		
		List<Patient> patientList = patientDAO.findAll();
		System.out.println(patientList);
		
		System.out.println("Test Patient DAO findById");
		System.out.println(patientDAO.findById(1));
		
		System.out.println("Test Patient DAO update");
		tmp.setName("Test Patient DAO update");
		patientDAO.update(tmp);
		patientList = patientDAO.findAll();
		System.out.println(patientList);

		System.out.println("Test Department delete");
		patientDAO.delete(tmp);
		patientList = patientDAO.findAll();
		System.out.println(patientList);
	}
	
	public void testDepartmentDAO()
	{
		DepartmentDAO departmentDAO = new DepartmentDAO();
		List<Department> departList = departmentDAO.findAll();
		System.out.println(departList);
		System.out.println(departmentDAO.findById(1));
		departList.get(2).setDescription("Test DAO");
		departmentDAO.update(departList.get(2));
		departList = departmentDAO.findAll();
		System.out.println(departList);
		System.out.println("Test Department insert");
		Department tmp = new Department(4, "Test DAO", "Test DAO");
		departmentDAO.insert(tmp);
		departList = departmentDAO.findAll();
		System.out.println(departList);
		System.out.println("Test Department delete");
		departmentDAO.delete(tmp);
		departList = departmentDAO.findAll();
		System.out.println(departList);
	}
}
