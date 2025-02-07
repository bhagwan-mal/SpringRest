package in.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
