package Controller;

import Repository.StudentRepository;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public String Greeting(){
        return "Welcome to the spring boot";
    }

    @PostMapping("/addStudent")
    public List<Student> addStudent(@RequestBody Student student){
        studentRepository.save(student);
        return studentRepository.findAll();
    }

    @GetMapping("/listStudent")
    public List<Student> listStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Long id)
    {
        return studentRepository.findById(id).get();
    }
}
