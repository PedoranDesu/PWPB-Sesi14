package com.pedoran.pwpbsesi14.FirebaseExample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pedoran.pwpbsesi14.FirebaseExample.adapter.BookList;
import com.pedoran.pwpbsesi14.FirebaseExample.entity.Book;
import com.pedoran.pwpbsesi14.R;

import java.util.ArrayList;
import java.util.List;

public class FireBaseExample extends AppCompatActivity {
    EditText editTextName;
    Button btnAdd;
    Spinner spinnerDif;

    DatabaseReference dbBook;
    ListView lvBook;
    List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base_example);

        dbBook = FirebaseDatabase.getInstance().getReference("book");

        editTextName = findViewById(R.id.editTextName);
        btnAdd = findViewById(R.id.buttonAddBook);
        spinnerDif = findViewById(R.id.spinnerDifficulty);
        lvBook = findViewById(R.id.listViewBook);
        bookList = new ArrayList<>();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBook();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        dbBook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bookList.clear();
                //resultset -> dataSnapshot
                for (DataSnapshot bookSnap : dataSnapshot.getChildren()){
                    Book book = bookSnap.getValue(Book.class);
                    bookList.add(book);
                }

                BookList adapter = new BookList(FireBaseExample.this,bookList);
                lvBook.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void addBook(){
        String title = editTextName.getText().toString().trim();
        String diff = spinnerDif.getSelectedItem().toString();

        if(!TextUtils.isEmpty(title)){
            String id = dbBook.push().getKey();
            Book origamiBook = new Book(id,title,diff);

            dbBook.child(id).setValue(origamiBook);
            Toast.makeText(this, "Book Added!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Please Enter This Field First", Toast.LENGTH_SHORT).show();
        }
    }
}
