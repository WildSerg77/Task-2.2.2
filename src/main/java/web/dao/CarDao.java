package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDao {
    private List<Car> cars;
    {
        cars = new ArrayList<>();
        cars.add(new Car("Skoda", "Kodiaq", 2020));
        cars.add(new Car("Hyundai", "Santa Fe", 2019));
        cars.add(new Car("Toyota", "Camry", 2018));
        cars.add(new Car("BMV", "X5", 2015));
        cars.add(new Car("Mazda", "CX9", 2017));
    }
    public List<Car> getCarsFullList() {
        return cars;
    }

    public List<Car> getCarsPartialList(int count) {
        return cars.stream().limit(count).toList();
    }
}
