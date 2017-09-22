package dao;

import Model.Ingredient;

import java.util.List;

public interface IngredientDao {
    Ingredient findById(Integer id);

    void save(Ingredient ingredient);

    void update(Ingredient ingredient);

    void delete(Integer id);

    List<Ingredient> findAll();


}
