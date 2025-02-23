package pl.sda.spring.jdbcTemplate.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.sda.spring.jpa.Fruit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FruitJdbc {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addFruit(Fruit fruit) {
        String sql ="INSERT INTO fruit values (NULL, ?, ?)";
        jdbcTemplate.update(sql, fruit.getName(), fruit.getWeight());
    }

    public List<Fruit> getFruits() {
        String sql ="SELECT * from fruit";

        return jdbcTemplate.query(sql, new RowMapper<Fruit>() {
            @Override
            public Fruit mapRow(ResultSet rs, int rowNum) throws SQLException {
                Fruit f = new Fruit();
                f.setName(rs.getString("name"));
                f.setWeight(rs.getDouble("weight"));
                return f;
            }
        });
    }
}
