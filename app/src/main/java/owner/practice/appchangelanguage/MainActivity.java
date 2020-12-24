package owner.practice.appchangelanguage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import io.paperdb.Paper;
import owner.practice.appchangelanguage.helper.LocaleHelper;

public class MainActivity extends AppCompatActivity {

    TextView txtHello,txtHome,txtCategory,txtProfile,txtMore;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHello = findViewById(R.id.txtHello);
        txtHome = findViewById(R.id.txtHome);
        txtCategory = findViewById(R.id.txtCategory);
        txtProfile = findViewById(R.id.txtProfile);
        txtMore = findViewById(R.id.txtMore);
        Paper.init(this);

        String language = Paper.book().read("language");
        System.out.println("language==>"+language);
        if (language==null)
            Paper.book().write("language","en");

        updateView((String) Paper.book().read("language"));
    }

    private void updateView(String launguage) {
        Context context = LocaleHelper.setLocale(this,launguage);
        Resources resources = context.getResources();

        txtHello.setText(resources.getString(R.string.hello));
        txtHome.setText(resources.getString(R.string.home));
        txtCategory.setText(resources.getString(R.string.category));
        txtProfile.setText(resources.getString(R.string.profile));
        txtMore.setText(resources.getString(R.string.more));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.lang_en){
            Paper.book().write("language","en");
            updateView((String) Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.lang_hi){
            Paper.book().write("language","hi");
            updateView((String) Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.lang_ko){
            Paper.book().write("language","ko");
            updateView((String) Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.lang_jn){
            Paper.book().write("language","ja");
            updateView((String) Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.lang_vi){
            Paper.book().write("language","vi");
            updateView((String) Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.lang_ch){
            Paper.book().write("language","zh");
            updateView((String) Paper.book().read("language"));
        }
        return super.onOptionsItemSelected(item);
    }
}