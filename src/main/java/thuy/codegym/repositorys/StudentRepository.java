package thuy.codegym.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thuy.codegym.models.Classes;
import thuy.codegym.models.Student;

import java.util.List;

@Repository
public interface StudentRepository  extends CrudRepository<Student,Long> {
    List<Student> getAllByClasses(Classes classes);
}
