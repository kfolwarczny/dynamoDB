package pl.obj.dynamodb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.obj.dynamodb.entity.Car;
import pl.obj.dynamodb.services.CarService;


@RestController
public class CarController {
  private final CarService carService;

  @Autowired
  public CarController(CarService carService) {
    this.carService = carService;
  }

  @RequestMapping(value = "/createCar", method = RequestMethod.POST)
  public String createCar(Car car) {
    carService.createCar(car);
    return "created";
  }

  @RequestMapping(value = "/getCar", method = RequestMethod.GET)
  public Car getCarByName(String name) {
    return carService.findCarByName(name);
  }
}
