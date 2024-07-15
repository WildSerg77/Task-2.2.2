package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;


@Controller
public class CarController {


    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCarList(Model model, @RequestParam(value = "count", defaultValue = "5") int count) {

        if (count < 1 || count > 4) {
        model.addAttribute("cars", carService.getCarsFullList());
        } else {
        model.addAttribute("cars", carService.getCarsPartialList(count));
        }
        return "/cars";
    }

}
