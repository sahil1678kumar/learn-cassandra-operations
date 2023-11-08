package cassandra.demo.learn.cassandra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cassandra.demo.learn.cassandra.entities.Car;
import cassandra.demo.learn.cassandra.repositories.cassandra.BaseCassandraRepository;
import cassandra.demo.learn.cassandra.repositories.cassandra.CassandraRepoUsingOperations;

@RestController
public class CassandraControllers {

    @Autowired
    BaseCassandraRepository baseCassandraRepository;

    @Autowired
    CassandraRepoUsingOperations cassandraRepoUsingOperations;

    @PostMapping("/post")
    public void postCar(@RequestBody Car mycar){
        baseCassandraRepository.insert(mycar);
    }

    @GetMapping("/post")
    public List<Car> getCar(){
        return baseCassandraRepository.findAll();
    }

    // @GetMapping("/post/{car}")
    // public List<Car> getCarByName(@PathVariable("car") String carName){
    //     return baseCassandraRepository.findByCarName(carName);
    // }

    @GetMapping("/post/priceLessThan/{price}")
    public List<Car>  getCarsByPrice(@PathVariable("price") double price){
        return baseCassandraRepository.findByCarAmountGreaterThan(price);
    }

    @GetMapping("/post/price/{price}")
    public List<Car> getCarByPrice(@PathVariable("price") double price){
        return baseCassandraRepository.findByCarAmount(price);
    }

    @GetMapping("/post/prices/{prices}")
    public List<Car> getCarsByPrices(@PathVariable("prices") List<Double> price){
        return baseCassandraRepository.findByCarAmountIsIn(price);
    }

    @GetMapping("/post/{carNumber}/{carAmount}")
    public List<Car> getCarsByCarNumberAndCarPrice(@PathVariable("carNumber") String carNumber, @PathVariable("carAmount") double carAmount){
        return baseCassandraRepository.findByCarNumberAndCarAmount(carNumber, carAmount);
    }

    @GetMapping("/post/carsByOperation")
    public List<Car> getCars(){
        return cassandraRepoUsingOperations.getCarByOperation();
    }

    @GetMapping("/post/carsByOperation/{price}/{carNumber}")
    public List<Car> getAllCars(@PathVariable("price") double price, @PathVariable("carNumber") String carNumber){
        Pageable pageable = PageRequest.of(0,1);
        return cassandraRepoUsingOperations.getCarsByPrice(price, carNumber, pageable);
    }

    @DeleteMapping("/post/{id}")
    public void deleteById(@PathVariable("id") int id){
        baseCassandraRepository.deleteById(id);
    }

    @DeleteMapping("/post/{id}/{carAmount}")
    public void deleteByIdAndCarAmount(@PathVariable("id") int id, @PathVariable("carAmount") double carAmount){
        baseCassandraRepository.deleteByIdAndCarAmount(id, carAmount);
    }

    @GetMapping("/posts")
    public List<Car> getListOfCars(@RequestBody Car car){
        return baseCassandraRepository.findByIdAndCarName(car.getId(), car.getCarName());
    }
}
