package Service;

import Model.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAll();
    Ingredient findOne(Integer id);
    void saveOrUpdateIngredient(Ingredient user);
    void delete(Integer id);
    void incPriceOfEveryIngredient(String category);
}
