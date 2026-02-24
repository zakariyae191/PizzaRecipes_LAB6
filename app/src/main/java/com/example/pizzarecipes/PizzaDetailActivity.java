package com.example.pizzarecipes;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

public class PizzaDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_pizza_detail);

        ImageView img = findViewById(R.id.imgDetail);
        TextView tvNom = findViewById(R.id.tvNomDetail);
        TextView tvDesc = findViewById(R.id.tvDesc);
        TextView tvIng = findViewById(R.id.tvIngredients);
        TextView tvSteps = findViewById(R.id.tvSteps);

        long id = getIntent().getLongExtra("pizza_id", -1);
        Produit p = ProduitService.getInstance().findById(id);

        if (p != null) {
            img.setImageResource(p.getImageRes());
            tvNom.setText(p.getNom());
            tvDesc.setText(p.getDescription());
            tvIng.setText(p.getIngredients());
            tvSteps.setText(p.getEtapes());
        }
    }
}