package com.example.fragment_iitransactionmethodsiw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBntAddA, mBtnRemoveA;
    private Button mBtnRepalceAWithBWithBackStack, mBtnRepalceAWithBWithoutBackStack;
    private Button mBtnAddB, mBtnRemoveB, mBtnReplaceBWithA;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager=getSupportFragmentManager();
    }
    private void initViews() {
        mBntAddA=findViewById(R.id.btnAddA);
        mBtnRemoveA=findViewById(R.id.btnRemoveA);
        mBtnReplaceBWithA=findViewById(R.id.btnReplaceBWithA);
        mBtnRepalceAWithBWithBackStack=findViewById(R.id.btnReplaceAWithBWithBackstack);
        mBtnRepalceAWithBWithoutBackStack=findViewById(R.id.btnReplaceAWithBWithoutBackstack);
        mBtnAddB=findViewById(R.id.btnAddB);
        mBtnRemoveB=findViewById(R.id.btnRemoveB);
        mBntAddA.setOnClickListener(this);
        mBtnRemoveA.setOnClickListener(this);
        mBtnReplaceBWithA.setOnClickListener(this);
        mBtnRepalceAWithBWithoutBackStack.setOnClickListener(this);
        mBtnRepalceAWithBWithBackStack.setOnClickListener(this);
        mBtnRemoveB.setOnClickListener(this);
        mBtnAddB.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch(id){
            case R.id.btnAddA:
                addA();
                break;
            case R.id.btnAddB:
                addB();
                break;
            case R.id.btnRemoveA:
                removeA();
                break;
            case R.id.btnRemoveB:
                removeB();
                break;
            case R.id.btnReplaceAWithBWithBackstack:
                replaceAwithBwithoutBackstack();

                break;
            case R.id.btnReplaceAWithBWithoutBackstack:
                replaceAwithB();
                break;
            case R.id.btnReplaceBWithA:
                replaceBwithA();
                break;
        }
    }

    private void replaceAwithBwithoutBackstack() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.flContainer,fragmentB,"fragment B").addToBackStack("").commit();
    }

    private void replaceBwithA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.replace(R.id.flContainer,fragmentA,"fragment B").commit();
    }

    private void replaceAwithB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.flContainer,fragmentB,"fragment B").commit();

    }

    private void removeB() {
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("fragment B");
        if(fragmentB!=null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentB).commit();
        }else{
            Toast.makeText(this, "fragment B is not added", Toast.LENGTH_SHORT).show();

        }
    }

    private void removeA() {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("fragment A");
        if(fragmentA!=null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentA).commit();
        }else{
            Toast.makeText(this, "fragment A is not added", Toast.LENGTH_SHORT).show();

        }
    }

    private void addB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.add(R.id.flContainer,fragmentB,"fragment B").commit();
    }

    private void addA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.add(R.id.flContainer,fragmentA,"fragment A").commit();
    }
}