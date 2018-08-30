package com.example.jemee.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitOrder(View view) {
        displayPrice();
    }
    private void displayPrice() {
        int price=quantity*5;
        EditText name=(EditText)findViewById(R.id.editText);
        String nam=name.getText().toString();
        CheckBox wheepdcream=(CheckBox)findViewById(R.id.checkBox);
        boolean haswheepcream=wheepdcream.isChecked();
        CheckBox chocolate=(CheckBox)findViewById(R.id.checkBox1);
        boolean ch=chocolate.isChecked();
        String jemo="NO";
        String jeo="NO";
        if(haswheepcream){
            jemo="YES";
            price+=(quantity);
        }
        if(ch){
            jeo="YES";
            price+=(2*quantity);
        }
        String display="Name: "+nam+"\nWhipped cream : " +jemo+"\nChocolate : " +jeo+ "\nQuantity: "+quantity+"\nTotal Price: "+price+" ₹\nThank You !";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just JAVA App order for "+nam);
        intent.putExtra(Intent.EXTRA_TEXT, display);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void increment(View view)
    {
        TextView t=(TextView)findViewById(R.id.quantity_text_view);
        quantity=Integer.parseInt(t.getText().toString());
        quantity++;
        if(quantity > 100)
        {
            quantity=100;
            Toast.makeText(this, "quantity can not be more than 100", Toast.LENGTH_SHORT).show();
        }
        t.setText(Integer.toString(quantity));
    }
    public void decrement(View view)
    {

        TextView t=(TextView)findViewById(R.id.quantity_text_view);
        quantity=Integer.parseInt(t.getText().toString());
        quantity--;
        if(quantity < 0)
        {
            quantity=0;
            Toast.makeText(this, "quantity can not be less than 0", Toast.LENGTH_SHORT).show();
        }
        t.setText(Integer.toString(quantity));
    }
}
