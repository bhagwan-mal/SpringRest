package in.nit.service;

import java.util.List;
import java.util.Optional;

import in.nit.Student;

public interface IStudentService {
	
	Integer saveStudent(Student student);
   
   List<Student> getAllStudents();
   
   Optional<Student> getOneStudent(Integer id);
   
   void deleteStudent(Integer id);

   public boolean isStudentExist(Integer id);

    void updateStudent(Student s);
}
