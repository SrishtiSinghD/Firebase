package in.ac.firebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class write extends AppCompatActivity {
EditText username,password;
Button btnSubmit;
FirebaseFirestore db=FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        username=(EditText)findViewById(R.id.editTextUsername);
        password=(EditText)findViewById(R.id.editTextPassword);
        btnSubmit=(Button)findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String sUsername=username.getText().toString();
                String sPassword=password.getText().toString();
                Map<String,Object> user=new HashMap<>();
                user.put("id",sUsername);
                user.put("pass",sPassword);
               // Toast.makeText(write.this, "Hello", Toast.LENGTH_SHORT).show();


                db.collection("user")
                        .document(sUsername)
                        .set(user)
                        .addOnSuccessListener(new OnSuccessListener<Void>()
                        {
                    @Override
                    public void onSuccess(Void aVoid)
                    {
                        Toast.makeText(write.this, "Save",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                        .addOnFailureListener(new OnFailureListener()
                        {
                            @Override
                            public void onFailure(@NonNull Exception e)
                            {
                                Toast.makeText(write.this, e.toString(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        });
    }
}
