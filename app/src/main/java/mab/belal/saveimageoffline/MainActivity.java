package mab.belal.saveimageoffline;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button saveBtn ;
    ImageView imgView;
    SQLiteDatabase db  ;
    SqliteHelper db_con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //db  = MainActivity.this.openOrCreateDatabase(SqliteHelper.DATABASE_NAME, 0, null);
         db_con = new SqliteHelper(getApplicationContext());
        db = db_con.getReadableDatabase();
        db = db_con.getWritableDatabase();


        imgView = findViewById(R.id.imageView_save);
        saveBtn = findViewById(R.id.button_save);




        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap bitmap = ((BitmapDrawable)imgView.getDrawable()).getBitmap();

              boolean saved =  db_con.insertImage("beli" , bitmap);

                if(saved)
                {
                    startActivity(new Intent(MainActivity.this , RetriveActivity.class));
                }
                else

                    {
                        Toast.makeText(MainActivity.this, "No Saved", Toast.LENGTH_SHORT).show();
                    }


            }
        });



    }





}
