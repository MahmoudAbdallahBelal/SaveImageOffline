package mab.belal.saveimageoffline;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RetriveActivity extends AppCompatActivity {


    ImageView imgShow;

    SqliteHelper db_con;
    SQLiteDatabase db ;
    Button getImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive);

        getImage = findViewById(R.id.button_get);
        imgShow = findViewById(R.id.imageView_get);
        db_con = new SqliteHelper(getApplicationContext());
        db = db_con.getReadableDatabase();
        db = db_con.getWritableDatabase();

        getImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imgShow.setImageBitmap( db_con.getImage("beli"));

            }
        });


    }
}
