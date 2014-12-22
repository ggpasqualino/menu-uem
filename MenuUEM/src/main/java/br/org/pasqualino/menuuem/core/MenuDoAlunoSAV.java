package br.org.pasqualino.menuuem.core;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MenuDoAlunoSAV extends MenuDoAluno {

    private final DefaultHttpClient httpclient;

    MenuDoAlunoSAV() {
        httpclient = new DefaultHttpClient();
    }

    @Override
    public PaginaDeNotas consultaNotas(String anoConsulta) throws IOException {
        String notasHTML = getNotasHTML(anoConsulta);
        return new PaginaDeNotasSAV(notasHTML);
    }

    private String getNotasHTML(String anoConsulta) throws IOException {
        HttpGet httpGet = getNotasRequest(anoConsulta);
        HttpResponse response = httpclient.execute(httpGet);
        return EntityUtils.toString(response.getEntity());
    }

    private HttpGet getNotasRequest(String anoConsulta) throws UnsupportedEncodingException {
        String notasUri = String.format("http://sisav.uem.br/sav/consultaNotas/notasAno?ano=%s", anoConsulta);
        return new HttpGet(notasUri);
    }

    @Override
    public PaginaDeNotasSAV logaSeNecessario(String usuario, String senha) throws IOException {
        HttpPost httppostLogin = getLoginPost(usuario, senha);
        HttpResponse response = httpclient.execute(httppostLogin);
        return new PaginaDeNotasSAV(EntityUtils.toString(response.getEntity()));
    }

    private HttpPost getLoginPost(String usuario, String senha) throws UnsupportedEncodingException {
        HttpPost httppostLogin = new HttpPost("http://sisav.uem.br/sav/auth/signIn");
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("username", String.format("ra%s", usuario)));
        nameValuePairs.add(new BasicNameValuePair("password", senha));
        httppostLogin.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        return httppostLogin;
    }

    @Override
    public void sair() {
        httpclient.getCookieStore().clear();
    }
}
