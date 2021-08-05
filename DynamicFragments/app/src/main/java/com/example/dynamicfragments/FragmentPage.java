package com.example.dynamicfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentPage extends Fragment {

    private Button btn;
    private RecyclerView recyclerView;
    ArrayList<ResponseDTO> list = new ArrayList<>();
    private FragmentAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        btn = view.findViewById(R.id.apiCall);
        recyclerView = view.findViewById(R.id.recyclerView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildList();
                setRecyclerView();
            }
        });
    }

    private void setRecyclerView() {
        adapter = new FragmentAdapter(list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void buildList() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        Call<ArrayList<ResponseDTO>> user = apiService.getData("shivarajp",
                "2cbe00030c04472c9d8ad4b0ec112dbe",
                "raw", "c651391e428182f08d60d59e79073f3fcf79b858", "nobroker");
        user.enqueue(new Callback<ArrayList<ResponseDTO>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseDTO>> call, Response<ArrayList<ResponseDTO>> response) {
                if(response.body()!=null && response.code()==200){

                    list = response.body();
                    adapter.update(list);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseDTO>> call, Throwable t) {

            }
        });
    }
}