package com.example.mylistview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    private static final String FRAG2 = "2";
    private ListView currenciesList;
    private List<Currency> currencies;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);


        currencies = new ArrayList<>();
        currencies.add(new Currency("USD", 1.10));
        currencies.add(new Currency("EUR", 0.95));
        currencies.add(new Currency("GBP", 0.85));

        currenciesList = view.findViewById(R.id.currency_list);
        currenciesList.setAdapter(currenciesList.getAdapter());
        FragmentManager fm = getParentFragmentManager();
        currenciesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Currency selectedCurrency = currencies.get(position);
                if (fm.findFragmentByTag(FRAG2) != null) {
                    TextView selectedOpt = getActivity().findViewById(R.id.selectedopt);
                    selectedOpt.setText("Pénznem: " + selectedCurrency.getName() + ", Ár: " + selectedCurrency.getPrice());
                } else {
                    Intent intent = new Intent(getActivity().getApplicationContext(), ShowItemActivity.class);
                    intent.putExtra("currency_name", selectedCurrency.getName());
                    intent.putExtra("currency_price", selectedCurrency.getPrice());
                    startActivity(intent);
                }
            }
        });

        return view;
    }
}


