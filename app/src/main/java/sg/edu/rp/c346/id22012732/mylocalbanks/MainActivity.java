package sg.edu.rp.c346.id22012732.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView dbs;
    TextView ocbc;
    TextView uob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbs = findViewById(R.id.textViewBank1);
        ocbc = findViewById(R.id.textViewBank2);
        uob = findViewById(R.id.textViewBank3);
        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);

    }
    String bankChosen = "";
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the Bank");
        if(v == dbs) {
            bankChosen = "dbs";
        }
        else if(v == ocbc) {
            bankChosen = "ocbc";
        } else if(v == uob) {
            bankChosen = "uob";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (bankChosen.equals("dbs")) {
            // Handle options for DBS bank
            if (itemId == 0) {
                // Handle "Website" option for DBS bank
                String websiteUrl = "https://www.dbs.com/default.page?gad=1&gclid=CjwKCAjwscGjBhAXEiwAswQqNKZ4t4RfGh1O4wktBVmhKWygh8QyOqLYP4SUcdQdbRaiqTyNRkz14BoCxdgQAvD_BwE&gclsrc=aw.ds"; // Replace with the actual DBS bank website URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
                startActivity(intent);
                return true;
            } else if (itemId == 1) {
                String phoneNumber = "1800 111 1111";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(intentCall);
                return true;
            }
        } else if (bankChosen.equals("ocbc")) {
            // Handle options for OCBC bank
            if (itemId == 0) {
                // Handle "Website" option for OCBC bank
                String websiteUrl = "https://www.ocbc.com/group/gateway.page"; // Replace with the actual OCBC bank website URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
                startActivity(intent);
                return true;
            } else if (itemId == 1) {
                String phoneNumber = "1800 363 3333";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(intentCall);
                return true;
            }
        } else if (bankChosen.equals("uob")) {
            // Handle options for UOB bank
            if (itemId == 0) {
                // Handle "Website" option for UOB bank
                String websiteUrl = "https://www.uob.com.sg/wealthbanking/index.page"; // Replace with the actual UOB bank website URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
                startActivity(intent);
                return true;
            } else if (itemId == 1) {
                String phoneNumber = "1800 222 2121";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(intentCall);
                return true;
            }
        }

        return super.onContextItemSelected(item);
    }

}