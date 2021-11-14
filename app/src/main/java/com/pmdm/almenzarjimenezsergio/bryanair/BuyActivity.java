package com.pmdm.almenzarjimenezsergio.bryanair;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


public class BuyActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvNameBuy, tvDestinationBuy, tvDepartureBuy, tvPriceBuy, tvDateBuy;
    String departure, destination, name, price, date;
    Bundle bundle;
    Button btBuyBuy, btCancelBuy;
    boolean window, pet, firstClass, insurance, premium;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_activity);

        initialize();

    }

    private void initialize() {
        bundle = getIntent().getExtras();

        departure = bundle.getString("departure");
        destination = bundle.getString("destination");
        name = bundle.getString("name");
        price = Integer.toString(bundle.getInt("price"));
        date = bundle.getString("date");

        tvNameBuy = findViewById(R.id.tvNameBuy);
        tvDepartureBuy = findViewById(R.id.tvDepartureBuy);
        tvDestinationBuy = findViewById(R.id.tvDestinationBuy);
        tvPriceBuy = findViewById(R.id.tvPriceBuy);
        tvDateBuy = findViewById(R.id.tvDateBuy);

        btBuyBuy = findViewById(R.id.btBuyBuy);
        btCancelBuy = findViewById(R.id.btCancelBuy);

        tvNameBuy.append(name);
        tvDepartureBuy.append(departure);
        tvDestinationBuy.append(destination);
        tvPriceBuy.append(price + "€");
        tvDateBuy.append(date);

        window = bundle.getBoolean("window");
        pet = bundle.getBoolean("pet");
        firstClass = bundle.getBoolean("firstClass");
        insurance = bundle.getBoolean("insurance");
        premium = bundle.getBoolean("premium");

        btBuyBuy.setOnClickListener(this);
        btCancelBuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(btCancelBuy)){
            finish();
        }

        if (view.equals(btBuyBuy)){
            bundle.putString("price", price+"€");
            Alertadialogo alertadialogo = new Alertadialogo(bundle);
            FragmentManager fragmentManager = getSupportFragmentManager();
            alertadialogo.show(fragmentManager, "Confirmar compra");
        }
    }
}
