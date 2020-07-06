package thuy.codegym.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import thuy.codegym.models.Classes;
import thuy.codegym.models.Student;
import thuy.codegym.repositorys.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public void save(Student model) {
        studentRepository.save(model);

    }

    @Override
    public void remove(Long id) {
        studentRepository.delete(id);

    }

    @Override
    public List<Student> getAllByClasses(Classes classes) {
        return studentRepository.getAllByClasses(classes);
    }
}