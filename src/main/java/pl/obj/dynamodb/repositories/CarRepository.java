package pl.obj.dynamodb.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.obj.dynamodb.entity.Car;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, String> {

    List<Car> findByName(String name);
}
