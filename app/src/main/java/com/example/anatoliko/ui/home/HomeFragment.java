package com.example.anatoliko.ui.home;

import android.content.Intent;
import android.icu.text.Edits;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.anatoliko.Announcement;
import com.example.anatoliko.PrivateActivity;
import com.example.anatoliko.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import static android.content.ContentValues.TAG;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    Button addAnnouncementBtn;
    Button refreshBtn;
    TextView multilineText;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_anakoinwseis, container, false);

        addAnnouncementBtn = root.findViewById(R.id.btn);
        addAnnouncementBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PrivateActivity.class);
                startActivity(i);
            }
        });


        refreshBtn = root.findViewById(R.id.refresh);
        multilineText = root.findViewById(R.id.dispAnnouncements);

        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference().child("Announcements");

        // Read from the database
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                mDatabaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
//                        Log.d(TAG, "User name: " + announcement.get_title() + ", email " + announcement.get_content());

                        String text = "";
                        if (dataSnapshot.exists()) {
                            int maxid = (int) dataSnapshot.getChildrenCount();
//                            int i=1;
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                                String title = snapshot.child("_title").getValue().toString();

//                                Log.d(TAG, snapshot.child("An010").getValue().toString());
                                String date = snapshot.child("_date").getValue().toString();
                                String content=snapshot.child("_content").getValue().toString();
                                text += title + "\t\t" + date + "\n" + content + "\n\n";
                                Log.d(TAG, "User  " + title);

//                                Log.d(TAG,"User2" + announcement.get_title());

                            }
                            multilineText.setText(text);
                        }
                    }


                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
            }
        });

        return root;
    }
}

// mDatabaseReference = mDatabase.getReference().child("Announcements");
//         mDatabaseReference.addValueEventListener(new ValueEventListener() {
//@Override
//public void onDataChange(@NonNull DataSnapshot snapshot) {
//        if (snapshot.exists()){
//        maxid = (snapshot.getChildrenCount());
//        Log.d(TAG,"maxid" + maxid);
//
//        }
//        }                               //PROSOXH!!     AN YPARXEI ANAKOINWSH ME ESTW KAI ENA KOINO STOIXEIO THA KANEI OVERWRITE
//
//@Override
//public void onCancelled(@NonNull DatabaseError error) {
//
//        }
//        });