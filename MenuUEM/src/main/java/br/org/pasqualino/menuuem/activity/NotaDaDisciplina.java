package br.org.pasqualino.menuuem.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import br.org.pasqualino.menuuem.R;
import br.org.pasqualino.menuuem.core.LinhaDeNotas;
import br.org.pasqualino.menuuem.listadapter.NotaDaDisciplinaAdapter;

public class NotaDaDisciplina extends ActionBarActivity {

    private ListView notasLV;
    private TextView situacaoTV;
    private TextView disciplinaTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_da_disciplina);

        notasLV = (ListView) findViewById(R.id.notas_lv);
        situacaoTV = (TextView) findViewById(R.id.situacao_tv);
        disciplinaTV = (TextView) findViewById(R.id.disciplina_tv);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Bundle extras = getIntent().getExtras();
        if (extras == null)
            throw new AssertionError();

        LinhaDeNotas disciplina = (LinhaDeNotas) extras.get(NotasActivity.DISCIPLINA);

        disciplinaTV.setText(disciplina.toString());
        situacaoTV.setText(disciplina.getSituacao());

        NotaDaDisciplinaAdapter adapter = new NotaDaDisciplinaAdapter(this, disciplina);
        notasLV.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nota_da_disciplina, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
