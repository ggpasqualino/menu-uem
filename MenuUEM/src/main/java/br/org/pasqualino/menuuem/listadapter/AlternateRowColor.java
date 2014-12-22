package br.org.pasqualino.menuuem.listadapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class AlternateRowColor<T> extends ArrayAdapter<T> {

    private String corLinhaPar;
    private String corLinhaImpar;

    public AlternateRowColor(Context context, int resource, List<T> objetos) {
        super(context, resource, objetos);
        corLinhaPar = "#dfdfdf";
        corLinhaImpar = "#efefef";
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        if (position % 2 == 0)
            view.setBackgroundColor(Color.parseColor(corLinhaPar));
        else
            view.setBackgroundColor(Color.parseColor(corLinhaImpar));

        return view;
    }
}
