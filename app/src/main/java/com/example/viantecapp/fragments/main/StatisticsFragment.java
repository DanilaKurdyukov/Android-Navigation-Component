package com.example.viantecapp.fragments.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viantecapp.R;
import com.example.viantecapp.adapters.HeaderAdapter;
import com.example.viantecapp.models.Header;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StatisticsFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public StatisticsFragment() {
        // Required empty public constructor
    }


    public static StatisticsFragment newInstance(String param1, String param2) {
        StatisticsFragment fragment = new StatisticsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    RecyclerView headersView;
    HeaderAdapter mHeaderAdapter;
    List<Header> headers;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_statistics, container, false);

        headersView = rootView.findViewById(R.id.recycler_view_statistics_header_list);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        setHeaders();
        mHeaderAdapter = new HeaderAdapter(headers,getContext());
        headersView.setAdapter(mHeaderAdapter);
    }

    private void setHeaders(){
        headers = new ArrayList<>();
        headers.addAll(
                Arrays.asList(
                        new Header("?????????????? WiFi"),
                        new Header("?????????? ?????????????? WiFi"),
                        new Header("?????????????? ????????????????????"),
                        new Header("??????????????"))
        );
    }
}