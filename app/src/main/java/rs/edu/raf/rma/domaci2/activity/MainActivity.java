package rs.edu.raf.rma.domaci2.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import rs.edu.raf.rma.domaci2.R;
import rs.edu.raf.rma.domaci2.adapter.ContactAdapter;
import rs.edu.raf.rma.domaci2.model.Contact;
import rs.edu.raf.rma.domaci2.util.Util;
import rs.edu.raf.rma.domaci2.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private List<Contact> mContacts;

    private ContactAdapter mAdapter;
    private MainViewModel mViewModel;

    private EditText mSearchEt;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);  // hide the title
//        getSupportActionBar().hide();                   // hide the title bar

        init();
    }


    private void init() {
        mContacts = new ArrayList<>();
        initViews();
        initViewModels();
    }

    private void initViewModels() {
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getContacts().observe(this,
                new Observer<List<Contact>>() {
                    @Override
                    public void onChanged(List<Contact> contacts) {
                        mContacts = new ArrayList<>(contacts);
                        mAdapter.setData(mContacts);
                    }
                });
    }

    private void initViews() {
        mSearchEt = findViewById(R.id.et_search);
        addBtn = findViewById(R.id.btn_main_add);
        EditText addTxt = findViewById(R.id.et_main_add);

        mSearchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<Contact> filteredContacts = new ArrayList<>();
                for (Contact c : mContacts) {
                    if (c.getName().startsWith(s.toString())) {
                        filteredContacts.add(c);
                    }
                }
                mAdapter.setData(filteredContacts);

                if (s.length() > 0) {
                    addBtn.setEnabled(false);
                } else {
                    addBtn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String s = addTxt.getText().toString();
                mContacts.add(new Contact(Util.generateId(), s));
                mViewModel.setContacts(mContacts);
                addTxt.setText("");
            }
        });

        RecyclerView recycler = findViewById(R.id.rv_main_list);

        GridLayoutManager manager = new GridLayoutManager(this,2);
        recycler.setLayoutManager(manager);

        mAdapter = new ContactAdapter();
        recycler.setAdapter(mAdapter);
    }
}
