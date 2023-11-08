package cassandra.demo.learn.cassandra.repositories.cassandra;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import cassandra.demo.learn.cassandra.entities.Car;

@Repository
public interface BaseCassandraRepository extends CassandraRepository<Car, Integer>{

    // @Autowired
    // public CassandraOperations cassandraTemplate;

    // // @AllowFiltering
    // // public List<Car> findByCarName(String name);

    // @Query(
    //     allowFiltering = true
    // )
    // public List<Car> getAllCars(){
    //     return cassandraTemplate.select("select * from Car" , Car.class);
    // }

    @AllowFiltering
    public List<Car> findByCarAmountGreaterThan(double price);

    @AllowFiltering
    public List<Car> findByCarAmount(double price);

    @AllowFiltering
    public List<Car> findByCarAmountIsIn(List<Double> price);


    @AllowFiltering
    public List<Car> findByCarNumberAndCarAmount(String carNumber, double carAmount);

    public void deleteById(Long id);

    public void deleteByIdAndCarAmount(int id, double carAmount);

    @AllowFiltering
    public List<Car> findByIdAndCarName(Integer id, String carName);

}
