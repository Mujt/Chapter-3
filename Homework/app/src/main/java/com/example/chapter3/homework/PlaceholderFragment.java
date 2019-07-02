package com.example.chapter3.homework;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;

public class PlaceholderFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        ListView listView = view.findViewById(R.id.detail);
        String[] items = new String[]{"item1","item2","item3","item4","item5","item6","item7"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_expandable_list_item_1,items);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final LottieAnimationView buffer = getView().findViewById(R.id.buffer_animation);;
        final ListView listView = getView().findViewById(R.id.detail);
        buffer.setAlpha(1f);
        listView.setAlpha(0);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                buffer.setAlpha(0f);
                listView.setAlpha(1f);
            }
        }, 5000);
    }
}
