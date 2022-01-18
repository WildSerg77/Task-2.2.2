package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    public static List<Car> setCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Skoda", "Kodiaq", 2020));
        cars.add(new Car("Hyundai", "Santa Fe", 2019));
        cars.add(new Car("Toyota", "Camry", 2018));
        cars.add(new Car("BMV", "X5", 2015));
        cars.add(new Car("Mazda", "CX9", 2017));
        return cars;
    }

    @GetMapping(value = "/cars")
    public static String getCarList(ModelMap model, @RequestParam(value = "count", defaultValue = "5") int count) {
        List<Car> cars = setCars();
        List<Car> result = new ArrayList<>();
        if (count > cars.size()) {
            count = cars.size();
        }
        for (int i = 0; i < count; i++) {
            result.add(cars.get(i));
        }
        model.addAttribute("cars", result);
        return "cars";
    }
}
