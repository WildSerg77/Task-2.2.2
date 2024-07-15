package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarDao carDao;


    public List<Car> getCarsFullList() {
        return carDao.getCarsFullList();
    }

    public List<Car> getCarsPartialList(int count) {
        return carDao.getCarsPartialList(count);
    }
}
