package com.ags.safemoney.activities.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ags.safemoney.R;

/**
 * Created by luiz.alexandre on 09/01/2017.
 */

public class ListaFragment extends Fragment {
    private String title;
    private int page;

    public static ListaFragment newInstance(int page, String title){
        ListaFragment listaFragment = new ListaFragment();
        Bundle args = new Bundle();
        args.putInt("pagina", page);
        args.putString("titulo", title);
        listaFragment.setArguments(args);

        return listaFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("pagina", 0);
        title = getArguments().getString("titulo");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_fragment, container, false);
        TextView label = (TextView) view.findViewById(R.id.tv_label);
        label.setText(page + " -- " + title);
        return view;
    }
}
