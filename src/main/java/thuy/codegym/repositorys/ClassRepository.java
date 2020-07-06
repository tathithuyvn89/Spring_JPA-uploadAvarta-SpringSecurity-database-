package thuy.codegym.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thuy.codegym.models.Classes;

@Repository
public interface ClassRepository extends CrudRepository<Classes, Long> {
}
