package pl.obj.dynamodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.obj.dynamodb.entity.Car;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, String> {

    List<Car> findByName(@Param("name") String name);
}
