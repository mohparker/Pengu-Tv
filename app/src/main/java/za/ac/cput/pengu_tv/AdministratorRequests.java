package za.ac.cput.pengu_tv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class AdministratorRequests extends AppCompatActivity {
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_requests);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        builder= new AlertDialog.Builder(this);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));
        setContentView(R.layout.activity_administrator_requests);
        ImageView myImageView3= findViewById(R.id.requestsIcon);
        myImageView3.setImageResource(R.drawable.ic_baseline_emoji_people_24);
        builder= new AlertDialog.Builder(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.navigation,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.icAnime:
                Toast.makeText(this, "Welcome to Anime page!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AdministratorRequests.this, AdministratorAnime.class);
                startActivity(intent);
                return true;
            case R.id.icUsers:
                Toast.makeText(this, "Welcome to the Users page!", Toast.LENGTH_SHORT).show();
                intent = new Intent(AdministratorRequests.this, AdministratorUsers.class);
                startActivity(intent);
                return true;
            case R.id.icReviews:
                Toast.makeText(this, "Welcome to Reviews page!", Toast.LENGTH_SHORT);
                intent = new Intent(AdministratorRequests.this, AdministratorReviews.class);
                startActivity(intent);
                return true;

            case R.id.icRequests:
                Toast.makeText(this, "Already on the Requests page!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.icLogout:

                builder.setTitle("Warning!");
                builder.setMessage("Do you wish to logout?");
                builder.setCancelable(true);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent =new Intent(AdministratorRequests.this,AdminLogin.class);
                        startActivity(intent);
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }}
}