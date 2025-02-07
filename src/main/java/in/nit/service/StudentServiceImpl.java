package in.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.nit.Student;
import in.nit.repository.StudentRepository;

@Component
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository repo;
	
	@Override
	public Integer saveStudent(Student student) {
		student=repo.save(student);
		
		return student.getId();
	}

	@Override
	public List <Student> getAllStudents() {
		List<Student> all = repo.findAll();
		return all;
		
	}
	

	@Override
	public Optional<Student> getOneStudent(Integer stdId) {
		Optional<Student> byId = repo.findById(stdId);
		return byId;
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.deleteById(id);
		
		
	}

	@Override
	public boolean isStudentExist(Integer id) {
		
		return repo.existsById(id);
		
	}
	
	@Override
	public void updateStudent(Student s) {
		repo.save(s);
	}

	
	
	

}
