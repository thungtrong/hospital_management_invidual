CREATE TABLE patient
(
id NUMBER(9),
name VARCHAR2(100) NOT NULL,
date_of_birth DATE,
gender BOOLEAN,
address NVARCHAR2,
phone_number VARCHAR2(15),
CONSTRAINTS patient_id_pk PRIMARY KEY(id)
);

CREATE TABLE admission_form
(
id NUMBER,
date_in DATE,
date_out DATE,
patient_id NUMBER(9),
CONSTRAINTS admission_form_id_pk PRIMARY KEY(id),
CONSTRAINTS admission_form_patient_id_fk FOREIGN KEY (patient_id) 
REFERENCES patient (id) ON DELETE CASCADE
);

-- test_form
CREATE TABLE test_form
(
id NUMBER,
patient_id NUMBER,
creation_date,
CONSTRAINTS test_form_id_pk PRIMARY KEY(id),
CONSTRAINTS test_form_patient_id_fk FOREIGN KEY (patient_id)
REFERENCES patient(id) ON DELETE SET NULL
);

-- doctor, department


-- health_record
CREATE TABLE health_record
(
id NUMBER,
creation_date DATE,
re_date DATE,
doctor_id NUMBER,
patient_id NUMBER(9),
CONSTRAINTS health_record_id_pk PRIMARY KEY(id),
CONSTRAINTS health_record_patient_id_fk FOREIGN KEY (patient_id) 
REFERENCES patient (id) ON DELETE CASCADE,
CONSTRAINTS health_record_doctor_id_fk FOREIGN KEY (doctor_id) 
REFERENCES doctor (id) ON DELETE SET NULL,
);


-- prescription





