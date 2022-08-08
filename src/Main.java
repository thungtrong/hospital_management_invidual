import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hospitalmanagement.dao.DoctorDAO;
import com.hospitalmanagement.model.Doctor;
import com.hospitalmanagement.util.DBConnection;

public class Main {
	public static void main(String[] args) {

		DoctorDAO doctorDao = new DoctorDAO();
		List<Doctor> doctor = doctorDao.findAll();
		System.out.println(doctor);

	}
}
