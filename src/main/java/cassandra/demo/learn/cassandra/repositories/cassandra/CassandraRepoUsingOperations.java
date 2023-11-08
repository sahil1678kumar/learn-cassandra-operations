package cassandra.demo.learn.cassandra.repositories.cassandra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.data.domain.Pageable;

import static org.springframework.data.cassandra.core.query.Query.query;
import static org.springframework.data.cassandra.core.query.Criteria.where;
import org.springframework.stereotype.Repository;

import cassandra.demo.learn.cassandra.entities.Car;


@Repository
public class CassandraRepoUsingOperations {
    @Autowired
    CassandraOperations cassandraOperations;

    public List<Car> getCarByOperation(){
        return cassandraOperations.select("select * from Car", Car.class);
    }

    public List<Car> getCarsByPrice(double price, String carNumber, Pageable pageable) {
        // String query = "select * from Car where carAmount = " + price + " allow filtering";
        Query query = query(where("carAmount").is(price)).and(where("carNumber").is(carNumber)).pageRequest(pageable).withAllowFiltering();
        return cassandraOperations.select(query, Car.class);
    }

}
