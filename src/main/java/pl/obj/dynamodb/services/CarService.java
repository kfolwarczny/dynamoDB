package pl.obj.dynamodb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.obj.dynamodb.entity.Car;
import pl.obj.dynamodb.repository.CarRepository;


@Service
public class CarService {
  private final CarRepository carRepository;

  @Autowired
  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public Car createCar(Car car) {
    return carRepository.save(car);
  }

  public Car findCarByName(String carName) {
    return carRepository.findByName(carName);
  }
}
