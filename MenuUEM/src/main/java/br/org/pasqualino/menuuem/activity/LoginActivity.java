package br.org.pasqualino.menuuem.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import br.org.pasqualino.menuuem.R;
import br.org.pasqualino.menuuem.core.MenuDoAluno;
import br.org.pasqualino.menuuem.core.PaginaDoMenu;

public class LoginActivity extends ActionBarActivity {

    private EditText raView;
    private EditText senhaView;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefs = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);

        raView = (EditText) findViewById(R.id.ra_et);
        senhaView = (EditText) findViewById(R.id.senha_et);

        findViewById(R.id.entrar_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GravadorDeDadosDoAluno().execute();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        boolean isLogado = prefs.getBoolean(getString(R.string.prefs_isLogado), false);
        if (isLogado)
            startNotasActivity();
    }

    private void startNotasActivity() {
        Intent intent = new Intent(this, NotasActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    class GravadorDeDadosDoAluno extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            if (!isCamposValidos())
                return false;

            String ra = raView.getText().toString();
            String senha = senhaView.getText().toString();

            try {
                PaginaDoMenu loginResult = MenuDoAluno.getMenu("SAV").logaSeNecessario(ra, senha);
                if (!loginResult.isAcessoPermitido())
                    return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(getString(R.string.prefs_ra), ra);
            editor.putString(getString(R.string.prefs_senha), senha);
            editor.putBoolean(getString(R.string.prefs_isLogado), true);
            editor.commit();
            return true;
        }

        private boolean isCamposValidos() {
            return !raView.getText().toString().trim().equals("") && !senhaView.getText().toString().trim().equals("");
        }

        @Override
        protected void onPostExecute(Boolean isCamposValidos) {
            super.onPostExecute(isCamposValidos);
            if (isCamposValidos)
                startNotasActivity();
            else
                Toast.makeText(LoginActivity.this, "Campos Inválidos", Toast.LENGTH_LONG).show();
        }

    }

}
