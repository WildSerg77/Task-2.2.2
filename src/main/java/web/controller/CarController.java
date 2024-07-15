package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;


@Controller
public class CarController {


    private CarDao carDao;

    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping("/cars")
    public String getCarList(Model model, @RequestParam(value = "count", defaultValue = "5") int count) {

        if (count < 1 || count > 4) {
        model.addAttribute("cars", carDao.getCarsFullList());
        } else {
        model.addAttribute("cars", carDao.getCarsPartialList(count));
        }
        return "/cars";
    }

}
