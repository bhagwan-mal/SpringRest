package in.nit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.Student;
import in.nit.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	private IStudentService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {

		ResponseEntity res = null;
		Integer id = service.saveStudent(student);
		String body = "Empolyee:-" + id + "is Inserted";

		return new ResponseEntity(body, HttpStatus.CREATED);

	}


	@GetMapping("/findAll")
	public ResponseEntity<?> geAlltStudents() {
		ResponseEntity<?> res = null;
		List<Student> list = service.getAllStudents();
		if (list != null && !list.isEmpty()) {
			list.sort((s1, s2) -> s1.getStdName().compareTo(s2.getStdName()));
			res = new ResponseEntity<List<Student>>(list, HttpStatus.OK);
		}else{
			res= new ResponseEntity<String>("No student Found" , HttpStatus.OK);
		}

		return res;
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneStudent(@PathVariable Integer id){
		
		ResponseEntity<?> resp=null;
		Optional<Student> opt= service.getOneStudent(id);
		if(opt.isPresent()) {
			resp=new ResponseEntity<Student>(opt.get(),HttpStatus.OK);
			
		}else {
			resp=new ResponseEntity<String>("Student Not Fount",HttpStatus.NOT_FOUND);
			
		}
		
		return resp;
		
	}
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeStudent(@PathVariable Integer id){
		
		ResponseEntity<String> resp=null;
		boolean exist= service.isStudentExist(id);
		
		if(exist) {
			 service.deleteStudent(id);
			resp=new  ResponseEntity<String>("Student:-"+id+"Deleted",HttpStatus.OK);
		}else {
			
			resp=new  ResponseEntity<String>("Student Id:-"+id+"-Not Found",HttpStatus.BAD_REQUEST);
			
		}
		
		return resp;
	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> upsateStudent(
			@PathVariable Integer id,
			@RequestBody Student student
			)
	        {
		
		ResponseEntity<String> resp=null;
		boolean exist= service.isStudentExist(id);
		
		if(exist) {
			service.updateStudent(student);

			resp=new  ResponseEntity<String>("Student:-"+id+"Updated Sucessfully",HttpStatus.CREATED);
		}else {
			resp=new  ResponseEntity<String>("Student"+id+"Not Found",HttpStatus.NOT_FOUND);
		}
		
		return  resp;
	}

}
