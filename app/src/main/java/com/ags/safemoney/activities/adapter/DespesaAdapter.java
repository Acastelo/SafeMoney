package com.ags.safemoney.activities.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ags.safemoney.R;
import com.ags.safemoney.model.Despesa;

import java.util.List;

/**
 * Created by luiz.alexandre on 11/01/2017.
 */

public class DespesaAdapter extends RecyclerView.Adapter<DespesaAdapter.MyViewHolder> {
    private List<Despesa> despesas;
    private LayoutInflater mLayoutInflater;

    public DespesaAdapter(Context c, List<Despesa> l) {
        despesas = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = mLayoutInflater.inflate(R.layout.item_despesa, viewGroup, false);
        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtDescicao.setText( despesas.get(position).getDescricao() );
        holder.txtMes.setText( despesas.get(position).getMes() );

        holder.txtValor.setText(String.format("R$ %2f", despesas.get(position).getValor()));

    }

    @Override
    public int getItemCount() {
        return despesas.size();
    }

    public void addListItem(Despesa d, int position){
        despesas.add(d);
        notifyItemInserted(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView txtDescicao;
        public TextView txtMes;
        public TextView txtValor;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtDescicao = (TextView) itemView.findViewById(R.id.txt_descricao_despesa);
            txtMes = (TextView) itemView.findViewById(R.id.txt_mes_despesa);
            txtValor = (TextView) itemView.findViewById(R.id.txt_valor_despesa);
        }
    }
}
