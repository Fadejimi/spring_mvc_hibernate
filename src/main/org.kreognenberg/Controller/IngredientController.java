package Controller;

import Service.IngredientService;
import Validator.IngredientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private IngredientValidator ingredientFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(ingredientFormValidator);
    }


}
