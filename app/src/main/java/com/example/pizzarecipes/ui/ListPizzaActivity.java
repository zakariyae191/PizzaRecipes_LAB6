package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.PizzaDetailActivity;
import com.example.pizzarecipes.R;
import com.example.pizzarecipes.adapter.PizzaAdapter;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

import java.util.List;

public class ListPizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_list_pizza);

        ListView lv = findViewById(R.id.lvPizzas);
        ImageView btnShare = findViewById(R.id.btnShare);

        List<Produit> pizzas = ProduitService.getInstance().findAll();
        lv.setAdapter(new PizzaAdapter(this, pizzas));

        lv.setOnItemClickListener((AdapterView<?> parent, android.view.View view, int pos, long id) -> {
            Intent it = new Intent(ListPizzaActivity.this, PizzaDetailActivity.class);
            it.putExtra("pizza_id", id);
            startActivity(it);
        });

        btnShare.setOnClickListener(v -> {
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_TEXT, "Pizza Recipes 🍕 - Mon app Android !");
            startActivity(Intent.createChooser(share, "Partager"));
        });
    }
}