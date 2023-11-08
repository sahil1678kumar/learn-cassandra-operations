package cassandra.demo.learn.cassandra.entities;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    
    @PrimaryKey
    private Integer id;
    private String carName;
    private String carNumber;
    private Double carAmount;
}
