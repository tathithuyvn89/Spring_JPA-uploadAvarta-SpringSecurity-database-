package thuy.codegym.service.student;

import thuy.codegym.models.Classes;
import thuy.codegym.models.Student;
import thuy.codegym.service.IService;

import java.util.List;

public interface StudentService extends IService<Student> {
    List<Student> getAllByClasses(Classes classes);

}
