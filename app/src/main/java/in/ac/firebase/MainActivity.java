package in.ac.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity
{
    Button readData,writeData;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readData=(Button)findViewById(R.id.btnReadData);
        writeData=(Button)findViewById(R.id.btnWriteData);
        readData.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
        writeData.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intentWrite=new Intent(MainActivity.this,write.class);
                startActivity(intentWrite);
            }
        });
    }
}
