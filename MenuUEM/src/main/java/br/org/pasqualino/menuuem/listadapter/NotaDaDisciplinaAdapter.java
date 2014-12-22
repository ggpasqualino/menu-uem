package br.org.pasqualino.menuuem.listadapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.org.pasqualino.menuuem.R;
import br.org.pasqualino.menuuem.core.LinhaDeNotas;

public class NotaDaDisciplinaAdapter extends BaseAdapter {

    private Context context;
    private LinhaDeNotas disciplina;
    private List<Linha> linhas;
    static private String corLinhaPar = "#dfdfdf";
    static private String corLinhaImpar = "#efefef";

    public NotaDaDisciplinaAdapter(Context context, LinhaDeNotas disciplina) {
        this.context = context;
        this.disciplina = disciplina;
        disciplinaToLinhas();
    }

    private void disciplinaToLinhas() {
        linhas = new ArrayList<Linha>();
        for (int i = 0; i < disciplina.getNotas().size(); i++) {
            linhas.add(new Linha(disciplina.getNotas().get(i),
                    disciplina.getFaltas().get(i),
                    disciplina.getAvaliacoes().get(i)));
        }
    }

    @Override
    public int getCount() {
        return linhas.size();
    }

    @Override
    public Object getItem(int i) {
        return linhas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_nota_disciplina, null);
            holder = new ViewHolder();
            holder.nota = (TextView) convertView.findViewById(R.id.nota_tv);
            holder.faltas = (TextView) convertView.findViewById(R.id.falta_tv);
            holder.avaliacao = (TextView) convertView.findViewById(R.id.avaliacao_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Linha linha = (Linha) getItem(position);
        holder.nota.setText(linha.nota);
        holder.faltas.setText(linha.faltas);
        holder.avaliacao.setText(linha.avaliacao);

        if (position % 2 == 0)
            convertView.setBackgroundColor(Color.parseColor(corLinhaPar));
        else
            convertView.setBackgroundColor(Color.parseColor(corLinhaImpar));

        return convertView;
    }

    private class Linha {

        String nota;
        String faltas;
        String avaliacao;

        public Linha(String nota, String faltas, String avaliacao) {
            this.nota = nota;
            this.faltas = faltas;
            this.avaliacao = avaliacao;
        }
    }

    private class ViewHolder {
        TextView nota;
        TextView faltas;
        TextView avaliacao;
    }
}
