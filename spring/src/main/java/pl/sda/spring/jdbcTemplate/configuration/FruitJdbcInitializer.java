package pl.sda.spring.jdbcTemplate.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sda.spring.jpa.Fruit;

@Component
public class FruitJdbcInitializer implements CommandLineRunner {

    private final FruitJdbc fruitRepository;

    public FruitJdbcInitializer(final FruitJdbc fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        final Fruit fruitA = new Fruit("Pineapple", 40.0);
        final Fruit fruitB = new Fruit("Grapes", 5.0);
        fruitRepository.addFruit(fruitA); // (x)
        fruitRepository.addFruit(fruitB);
    }
}