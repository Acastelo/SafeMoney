package com.ags.safemoney.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ags.safemoney.R;
import com.ags.safemoney.activities.fragment.ListaFragment;
import com.ags.safemoney.controler.Meses;
import com.ags.safemoney.model.Despesa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FragmentPagerAdapter adapterViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MeuAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);
    }

    public List<Despesa> listaDespesas(int qtd) {
        String[] descricoes = new String[]{"Colégio", "Compras do Mês", "Remédios do Júlio", "Passecard", "Alimentação do dia"};
        String[] meses = new String[]{"JANEIRO", "FEVEIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO"};
        Double[] valores = new Double[]{10.00, 58.00, 47.30, 25.00, 458.00};
        List<Despesa> listAux = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            Despesa d = new Despesa(descricoes[i % descricoes.length], meses[i % meses.length], valores[i % valores.length]);
            listAux.add(d);
        }
        return (listAux);
    }

    public static class MeuAdapter extends FragmentPagerAdapter {
        private static int NUM_ITENS = 4;

        public MeuAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return NUM_ITENS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return ListaFragment.newInstance(0, "JANEIRO");
                case 1:
                    return ListaFragment.newInstance(1, "FEVEREIRO");
                case 2:
                    return ListaFragment.newInstance(2, "MARÇO");
                case 3:
                    return ListaFragment.newInstance(3, "ABRIL");
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return Meses.JANEIRO.toString();
                case 1:
                    return Meses.FEVEREIRO.toString();
                case 2:
                    return Meses.MARCO.toString();
                case 3:
                    return Meses.ABRIL.toString();
                default:
                    return null;
            }

        }
    }
}
