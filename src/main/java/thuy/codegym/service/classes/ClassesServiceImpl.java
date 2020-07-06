package thuy.codegym.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import thuy.codegym.models.Classes;
import thuy.codegym.repositorys.ClassRepository;

import java.util.List;

public class ClassesServiceImpl implements ClassService {
    @Autowired
    private ClassRepository classRepository;
    @Override
    public List<Classes> findAll() {
        return (List<Classes>) classRepository.findAll();
    }

    @Override
    public Classes findById(Long id) {
        return classRepository.findOne(id);
    }

    @Override
    public void save(Classes model) {
        classRepository.save(model);

    }

    @Override
    public void remove(Long id) {
        classRepository.delete(id);

    }
}