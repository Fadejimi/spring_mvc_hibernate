package dao;

import Model.Ingredient;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

public class IngredientDaoImpl extends HibernateDaoSupport implements IngredientDao {

    @Override
    public Ingredient findById(Integer id) {
        return (Ingredient) getHibernateTemplate().find("from Ingredient where id = ?", id).get(0);
    }

    @Override
    public void save(Ingredient ingredient) {
        getHibernateTemplate().save(ingredient);
    }

    @Override
    public void update(Ingredient ingredient) {
        getHibernateTemplate().update(ingredient);
    }

    @Override
    public void delete(Integer id) {
        getHibernateTemplate().delete(findById(id));
    }

    @Override
    public List<Ingredient> findAll() {
        return (List<Ingredient>) getHibernateTemplate().find("from Ingredient");
    }
}
