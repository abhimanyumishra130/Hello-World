package com.example.fragmentcommunicationiw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity  implements CommunicationListener{

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager =getSupportFragmentManager();

        StudentPersonalDetailsFragment studentPersonalDetailsFragment = new StudentPersonalDetailsFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        studentPersonalDetailsFragment.setCommunicationListener(this);
        transaction.add(R.id.Container,studentPersonalDetailsFragment,"personal");
        transaction.commit();

    }

    @Override
    public void communicationListener(Bundle bundle) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        StudentPerformanceDetailsFragment studentPerformanceDetailsFragment = new StudentPerformanceDetailsFragment();
        studentPerformanceDetailsFragment.setArguments(bundle);
        transaction.replace(R.id.Container,studentPerformanceDetailsFragment,"personalDetailFragment").commit();
    }
}