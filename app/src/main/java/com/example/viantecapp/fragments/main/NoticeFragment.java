package com.example.viantecapp.fragments.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.viantecapp.R;
import com.example.viantecapp.adapters.DataAdapter;
import com.example.viantecapp.adapters.SettingAdapter;
import com.example.viantecapp.models.ModelData;
import com.example.viantecapp.models.Setting;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NoticeFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public NoticeFragment() {
        // Required empty public constructor
    }


    public static NoticeFragment newInstance(String param1, String param2) {
        NoticeFragment fragment = new NoticeFragment();
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

    RecyclerView settingsView,dataView;

    //class Event
    List<Setting> settings;
    SettingAdapter mEventAdapter;

    //class ModelData
    List<ModelData> data;
    DataAdapter mDataAdapter;

    NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);

        navController = navHostFragment.getNavController();


        setHasOptionsMenu(true);

        return inflater.inflate(R.layout.fragment_notice, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       settingsView = view.findViewById(R.id.recycler_view_settings);
       getSettings();

    }

    @Override
    public void onResume() {
        super.onResume();
        /*getSettings();
        getData();*/
    }



    private List<Fragment> getFragments(){
        return Arrays.asList(
                new EventNoticeFragment(),
                new AlertNoticeFragment()
        );
    }
    private void getSettings(){
        settings = new ArrayList<>();
        settings.add(new Setting(
                "Точки доступа OPN",
                true,
                true,
                false
        ));
        settings.add(new Setting(
                "Поддельная точка доступа",
                true,
                true,
                false
        ));
        mEventAdapter = new SettingAdapter(settings,getContext());
        settingsView.setAdapter(mEventAdapter);
    }

    private void getData(){
        data = new ArrayList<>();
        data.add(new ModelData(
                LocalDateTime.parse("2022-05-27T16:16:15"),
                "00:9C:44:70:11:17",
                "Точки доступа OPN",
                "Фиксируется, ч:мин:0:1"
        ));
        mDataAdapter = new DataAdapter(data,getContext());
        dataView.setAdapter(mDataAdapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.notice_top_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_search:
                navController.navigate(R.id.action_notice_to_bottomSheetFragment);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}