package prj1;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
        (exclude = {
//                DataSourceAutoConfiguration.class ,
//                MongoAutoConfiguration.class
//                ,
//                MongoDataAutoConfiguration.class
        })
//@EnableMongoRepositories
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
