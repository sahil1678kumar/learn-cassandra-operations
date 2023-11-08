package cassandra.demo.learn.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LearnCassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnCassandraApplication.class, args);
	}

}
