package com.example.pizzarecipes.service;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.dao.IDao;

import java.util.ArrayList;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    private static ProduitService INSTANCE;
    private final List<Produit> data = new ArrayList<>();

    private ProduitService() {
        seed();
    }

    public static ProduitService getInstance() {
        if (INSTANCE == null) INSTANCE = new ProduitService();
        return INSTANCE;
    }

    private void seed() {
        data.add(new Produit("BARBECUE CHICKEN PIZZA", 3.0, R.drawable.pizza1, "35 min",
                "- 2 boneless skinless chicken breast halves\n- 1 cup barbecue sauce\n- cheese, onion...",
                "Pizza au poulet barbecue simple et rapide.",
                "STEP 1: Griller le poulet.\nSTEP 2: Étaler la sauce.\nSTEP 3: Garnir et cuire."));

        data.add(new Produit("SPINACH PIZZA", 2.0, R.drawable.pizza2, "25 min",
                "- Sauce Alfredo\n- Épinards\n- Tomates\n- Fromage...",
                "Pizza crémeuse et légère aux légumes.",
                "STEP 1: Étaler la pâte.\nSTEP 2: Ajouter la garniture.\nSTEP 3: Cuire 12-15 min."));

        data.add(new Produit("DEEP-DISH SAUSAGE PIZZA", 8.0, R.drawable.pizza3, "45 min",
                "- Pâte épaisse\n- Saucisse\n- Sauce tomate\n- Mozzarella...",
                "Style Chicago, bien généreuse.",
                "STEP 1: Préparer la pâte.\nSTEP 2: Ajouter saucisse + fromage.\nSTEP 3: Cuire 30-35 min."));

        data.add(new Produit("HOMEMADE PIZZA", 4.0, R.drawable.pizza4, "50 min",
                "- Pâte maison\n- Sauce tomate\n- Fromage\n- Garniture au choix",
                "La pizza classique faite maison.",
                "STEP 1: Préparer la pâte.\nSTEP 2: Mettre sauce + fromage.\nSTEP 3: Cuire 15 min."));

        data.add(new Produit("PESTO CHICKEN PIZZA", 3.0, R.drawable.pizza5, "50 min",
                "- Pesto\n- Poulet\n- Mozzarella\n- Tomates cerise",
                "Parfum pesto + poulet, très savoureux.",
                "STEP 1: Étaler pesto.\nSTEP 2: Ajouter poulet + fromage.\nSTEP 3: Cuire 12-15 min."));

        data.add(new Produit("BRUSCHETTA PIZZA", 5.0, R.drawable.pizza6, "40 min",
                "- Tomates fraîches\n- Basilic\n- Ail\n- Huile d’olive",
                "Goût italien frais et léger.",
                "STEP 1: Préparer bruschetta.\nSTEP 2: Mettre sur pizza.\nSTEP 3: Cuire 12 min."));

        data.add(new Produit("MARGHERITA PIZZA", 2.5, R.drawable.pizza7, "20 min",
                "- Sauce tomate\n- Mozzarella\n- Basilic",
                "Simple, classique, efficace.",
                "STEP 1: Sauce tomate.\nSTEP 2: Mozzarella.\nSTEP 3: Basilic après cuisson."));

        data.add(new Produit("VEGGIE PIZZA", 3.5, R.drawable.pizza8, "30 min",
                "- Poivrons\n- Oignons\n- Champignons\n- Olives",
                "100% légumes, très bonne.",
                "STEP 1: Préparer légumes.\nSTEP 2: Garnir.\nSTEP 3: Cuire 15 min."));

        data.add(new Produit("MEAT LOVER PIZZA", 7.0, R.drawable.pizza9, "40 min",
                "- Pepperoni\n- Viande hachée\n- Saucisse\n- Fromage",
                "Pour les fans de viande.",
                "STEP 1: Cuire viande.\nSTEP 2: Garnir.\nSTEP 3: Cuire 15-18 min."));

        data.add(new Produit("HAWAIIAN PIZZA", 4.5, R.drawable.pizza10, "35 min",
                "- Jambon\n- Ananas\n- Fromage\n- Sauce tomate",
                "Sucré-salé, très connue.",
                "STEP 1: Sauce.\nSTEP 2: Jambon + ananas.\nSTEP 3: Cuire 14-16 min."));
    }

    @Override
    public Produit create(Produit p) {
        data.add(p);
        return p;
    }

    @Override
    public Produit update(Produit p) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == p.getId()) {
                data.set(i, p);
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        Produit p = findById(id);
        return p != null && data.remove(p);
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : data) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return data;
    }
}