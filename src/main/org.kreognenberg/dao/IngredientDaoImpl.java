package dao;

import Model.Ingredient;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IngredientDaoImpl implements IngredientDao {
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Ingredient findById(Integer id) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        String sql = "SELECT * FROM Ingredients WHERE id=:id";

        Ingredient result = namedParameterJdbcTemplate.queryForObject(
                sql,
                params,
                new IngredientDaoImpl.IngredientMapper());

        //new BeanPropertyRowMapper(Customer.class));

        return result;

    }

    public List<Ingredient> findAll() {

        Map<String, Object> params = new HashMap<String, Object>();

        String sql = "SELECT * FROM ingredient";

        List<Ingredient> result = namedParameterJdbcTemplate.query(sql, params, new IngredientDaoImpl.IngredientMapper());

        return result;

    }

    public void save(Ingredient Ingredient) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", Ingredient.getId());
        params.put("name", Ingredient.getName());
        params.put("category", Ingredient.getCategory());
        params.put("amount", Ingredient.getAmount());
        params.put("pricePerKilo", Ingredient.getPricePerKilo());

        String sql = "INSERT INTO ingredient(id, name, category, amount, pricePerKilo) values(:id, " +
                ":name, :category, :amount, :pricePerKilo, :gender, :interests)";

        namedParameterJdbcTemplate.update(sql, params);
    }

    public void update(Ingredient Ingredient) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", Ingredient.getName());
        params.put("category", Ingredient.getCategory());
        params.put("amount", Ingredient.getAmount());
        params.put("pricePerKilo", Ingredient.getPricePerKilo());
        params.put("id", Ingredient.getId());

        String sql = "UPDATE ingredient SET name = :name, category = :category, amount = :amount, pricePerKilo = :pricePerKilo" +
                " WHERE id = :id";

        namedParameterJdbcTemplate.update(sql, params);
    }

    public void delete(Integer id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        String sql = "DELETE FROM ingredient WHERE id = :id";

        namedParameterJdbcTemplate.update(sql, params);
    }



    private static final class IngredientMapper implements RowMapper<Ingredient> {

        public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
            Ingredient ingredient = new Ingredient();
            ingredient.setId(rs.getInt("id"));
            ingredient.setName(rs.getString("name"));
            ingredient.setCategory(rs.getString("category"));
            ingredient.setPricePerKilo(rs.getInt("pricePerKilo"));
            ingredient.setAmount(rs.getInt("amount"));
            return ingredient;
        }
    }
}
