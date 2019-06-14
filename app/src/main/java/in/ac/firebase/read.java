package in.ac.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class read extends AppCompatActivity
{
ListView list;
ArrayList arrayList;
FirebaseFirestore db=FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);


        arrayList=new ArrayList();
        list=(ListView)findViewById(R.id.listViewList);
        db.collection("user")
               // .whereEqualTo("id","srishti")-->name from editText
                // .whereEqualTo("pass","12345")-->password from editText
                .addSnapshotListener(new EventListener<QuerySnapshot>()
        {
            @Override
            public void onEvent(QuerySnapshot value, FirebaseFirestoreException e)
            {
                for (QueryDocumentSnapshot doc: value)
                {
                    String id=doc.getString("id");
                    String pass=doc.getString("pass");
                    Log.d("arvind",id);
                    arrayList.add(id+"\n"+pass);
                }

                ArrayAdapter ad= new ArrayAdapter(read.this,
                        android.R.layout.simple_list_item_1,arrayList);
                list.setAdapter(ad);
            }
        });
    }
}
