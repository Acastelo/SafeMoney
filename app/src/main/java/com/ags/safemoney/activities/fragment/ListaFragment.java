package com.ags.safemoney.activities.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ags.safemoney.R;
import com.ags.safemoney.activities.MainActivity;
import com.ags.safemoney.activities.adapter.DespesaAdapter;
import com.ags.safemoney.model.Despesa;

import java.util.List;

/**
 * Created by luiz.alexandre on 09/01/2017.
 */

public class ListaFragment extends Fragment {
    private String title;
    private int page;
    private List<Despesa> despesaList;

    private RecyclerView rvDespesas;

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
        rvDespesas = (RecyclerView) view.findViewById(R.id.rc_despesas);
        rvDespesas.setOnScrollListener(new RecyclerView.OnScrollListener(){

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) rvDespesas.getLayoutManager();
                DespesaAdapter adapter = (DespesaAdapter) rvDespesas.getAdapter();

                if (despesaList.size() == llm.findLastVisibleItemPosition() + 1){
                    List<Despesa> listAux = ((MainActivity) getActivity()).listaDespesas(10);

                    for (int i = 0; i < listAux.size(); i++){
                        adapter.addListItem(listAux.get(i), despesaList.size());
                    }
                }
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvDespesas.setLayoutManager(llm);

        despesaList = ((MainActivity) getActivity()).listaDespesas(10);
        DespesaAdapter adapter = new DespesaAdapter(getActivity(), despesaList);
        rvDespesas.setAdapter( adapter );

        label.setText("Despesas de " + title);
        return view;
    }
}
