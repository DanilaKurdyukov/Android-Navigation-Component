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

public class WifiFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public WifiFragment() {
        // Required empty public constructor
    }


    public static WifiFragment newInstance(String param1, String param2) {
        WifiFragment fragment = new WifiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    RecyclerView headersView;
    HeaderAdapter mHeaderAdapter;
    List<Header> headers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wifi, container, false);

        headersView = rootView.findViewById(R.id.recycler_view_wifi_header_list);

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
                        new Header("Точки доступа"),
                        new Header("Зоны"),
                        new Header("Клиенты"),
                        new Header("История ТД"),
                        new Header("История К"),
                        new Header("Информер ТД и К"),
                        new Header("Информер связей"),
                        new Header("Атаки на WiFi"))
        );
    }
}