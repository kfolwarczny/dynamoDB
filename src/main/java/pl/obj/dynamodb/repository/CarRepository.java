package pl.obj.dynamodb.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.obj.dynamodb.entity.Car;


@EnableScan
public interface CarRepository extends CrudRepository<Car, String> {
  Car findByName(@Param("name") String name);
}
