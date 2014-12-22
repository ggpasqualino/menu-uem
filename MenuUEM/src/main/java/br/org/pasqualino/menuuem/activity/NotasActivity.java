package br.org.pasqualino.menuuem.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.org.pasqualino.menuuem.R;
import br.org.pasqualino.menuuem.core.LinhaDeNotas;
import br.org.pasqualino.menuuem.core.MenuDoAluno;
import br.org.pasqualino.menuuem.core.PaginaDeNotas;
import br.org.pasqualino.menuuem.listadapter.AlternateRowColor;

public class NotasActivity extends ActionBarActivity {

    private static final String TAG = NotasActivity.class.getSimpleName();
    public static final String DISCIPLINA = "disciplina";
    private ListView notasLV;
    private ProgressBar progressBar;
    private SharedPreferences sharedPref;
    private EditText anoET;
    private MenuDoAluno menuDoAluno;
    private Spinner menusSpinner;
    private Button atualiza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        menusSpinner = (Spinner) findViewById(R.id.menu_spinner);
        menusSpinner.setOnItemSelectedListener(getMenusSpinnerListener());

        anoET = (EditText) findViewById(R.id.ano_et);
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        anoET.setText(format.format(new Date()));

        atualiza = (Button) findViewById(R.id.atualiza_diciplinas_bt);
        atualiza.setOnClickListener(atualizaListener());

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        notasLV = (ListView) findViewById(R.id.notas_lv);
        notasLV.setOnItemClickListener(notasLVClickListener());

        sharedPref = PreferenceManager.getDefaultSharedPreferences(NotasActivity.this);

    }

    private AdapterView.OnItemSelectedListener getMenusSpinnerListener() {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                String menu = (String) adapterView.getItemAtPosition(pos);
                menuDoAluno = MenuDoAluno.getMenu(menu);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }

    private View.OnClickListener atualizaListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable ano = anoET.getText();
                String anoString = ano != null ? ano.toString() : "";
                if(!anoString.trim().equals("") && anoString.trim().length() == 4)
                    new GetPaginaDeNotasTask().execute();
                else
                    Toast.makeText(NotasActivity.this, "Ano inválido", Toast.LENGTH_LONG).show();
            }
        };
    }

    private AdapterView.OnItemClickListener notasLVClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                LinhaDeNotas disciplina = (LinhaDeNotas) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(NotasActivity.this, NotaDaDisciplina.class);
                intent.putExtra(DISCIPLINA, disciplina);
                startActivity(intent);
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case R.id.action_sair:
                menuDoAluno.sair();
                sharedPref.edit().putBoolean(getString(R.string.prefs_isLogado), false).commit();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class GetPaginaDeNotasTask extends AsyncTask<Void, Integer, ArrayList<LinhaDeNotas>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            menusSpinner.setEnabled(false);
            atualiza.setEnabled(false);
        }

        @Override
        protected ArrayList<LinhaDeNotas> doInBackground(Void... voids) {
            String usuario = sharedPref.getString(getString(R.string.prefs_ra), "");
            String senha = sharedPref.getString(getString(R.string.prefs_senha), "");
            String ano = anoET.getText().toString();
            publishProgress(1);

            Log.d(TAG, "buscando notas");

            try {
                menuDoAluno.logaSeNecessario(usuario, senha);
            } catch (IOException e) {
                Log.e(TAG, "problema na conexão", e);
            }
            publishProgress(2);

            PaginaDeNotas paginaDeNotas = null;
            try {
                paginaDeNotas = menuDoAluno.consultaNotas(ano);
            } catch (IOException e) {
                paginaDeNotas = new PaginaDeNotas("");
                Log.e(TAG, "problema na conexão", e);
            }
            publishProgress(3);

            ArrayList<LinhaDeNotas> notas = paginaDeNotas.getNotas();
            publishProgress(4);

            return notas;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(ArrayList<LinhaDeNotas> notas) {
            super.onPostExecute(notas);

            if (notas.isEmpty())
                Toast.makeText(NotasActivity.this, "Não foi possível carregar as disciplinas", Toast.LENGTH_LONG).show();
            else {
                ArrayAdapter adapter = new AlternateRowColor(NotasActivity.this, android.R.layout.simple_list_item_1, notas);
                notasLV.setAdapter(adapter);
            }

            atualiza.setEnabled(true);
            menusSpinner.setEnabled(true);
            progressBar.setProgress(0);
        }
    }
}
