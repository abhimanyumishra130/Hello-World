package com.example.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements itemClickListener{

    private ArrayList<Employee> employeeList=new ArrayList<>();
    private RecyclerView recyclerView;
    private CardView mEditCardView;
    private EditText metName, metAge, metAddress;
    private Button mBtnDone;
    private EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        buildEmployeeList();
        setRecyclerView();
    }

    private void setRecyclerView() {
        employeeAdapter = new EmployeeAdapter(employeeList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(employeeAdapter);
    }

    private void buildEmployeeList() {
        for(int i=0; i<50; i++){
            Employee employee = new Employee("abhimanyu",20,"mumbai");
            employeeList.add(employee);
        }
    }

    private void initView() {
        recyclerView=findViewById(R.id.recyclerView);
        mEditCardView=findViewById(R.id.editCardView);
        metName=findViewById(R.id.etName);
        metAge=findViewById(R.id.etAge);
        metAddress=findViewById(R.id.etAddress);
        mBtnDone=findViewById(R.id.btnDone);
    }

    @Override
    public void onItemClicked(int position, Employee employee) {
        mEditCardView.setVisibility(View.VISIBLE);
        metName.setText(employee.getName());
        metAge.setText(employee.getAge()+"");
        metAddress.setText(employee.getAddress());
        mBtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditCardView.setVisibility(View.GONE);
                Employee employee1 = new Employee(metName.getText().toString(),Integer.parseInt(metAge.getText().toString()),metAddress.getText().toString());
                employeeList.set(position,employee1);
                employeeAdapter.notifyItemChanged(position);
            }
        });
    }
}