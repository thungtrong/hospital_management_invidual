import java.sql.Date;

public class Main {
	public static void main(String[] args) {

//		DoctorDAO doctorDao = new DoctorDAO();
//		List<Doctor> doctor = doctorDao.findAll();
//		System.out.println(doctor);
		
		DAOTestting test = new DAOTestting();
		test.testPatientDAO();
		
	}
	
}
