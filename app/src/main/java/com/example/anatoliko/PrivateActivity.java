package com.example.anatoliko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

public class PrivateActivity extends AppCompatActivity {

    EditText txtTitle, txtContent;

    Button btnsave;
    Announcement announcement;
    long maxid;

    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabaseReference = mDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private);

        btnsave = (Button) findViewById(R.id.btnsave);
        txtTitle = (EditText) findViewById(R.id.et1);
        txtContent = (EditText) findViewById(R.id.et2);
        announcement = new Announcement();
        mDatabaseReference = mDatabase.getReference().child("Announcements");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    maxid = (snapshot.getChildrenCount());
                    Log.d(TAG,"maxid" + maxid);

                }
            }                               //PROSOXH!!     AN YPARXEI ANAKOINWSH ME ESTW KAI ENA KOINO STOIXEIO THA KANEI OVERWRITE

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Title = txtTitle.getText().toString();
                String Content = txtContent.getText().toString();

                if(Title.isEmpty() || Content.isEmpty()){
//                    Toast.makeText("ΚΑΠΟΙΟ ΠΕΔΙΟ ΔΕΝ ΣΥΜΠΛΗΡΩΘΗΚΕ", text, duration).show();
                    Toast.makeText(getApplicationContext(), "ΚΑΠΟΙΟ ΠΕΔΙΟ ΔΕΝ ΣΥΜΠΛΗΡΩΘΗΚΕ", Toast.LENGTH_SHORT).show();

                }
                else {
                    announcement.set_content(Content);
                    announcement.set_title(Title);
                    announcement.set_id((int) maxid + 1);
                    announcement.set_date();
                    announcement.set_time();

                    String name = "";
                    if (maxid >= 0 && maxid < 9) {
                        name = "An00" + String.valueOf(maxid + 1);
                    } else if (maxid >= 9 && maxid < 99) {
                        name = "An0" + String.valueOf(maxid + 1);
                    } else {
                        name = "An" + String.valueOf(maxid + 1);
                    }

                    mDatabaseReference.child(name).setValue(announcement);

                    txtTitle.setText("");
                    txtContent.getText().clear();
                }
            }
        });
    }
}