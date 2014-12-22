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

public class MenuDoAlunoDAA extends MenuDoAluno {

    private DefaultHttpClient httpclient;

    MenuDoAlunoDAA() {
        httpclient = new DefaultHttpClient();
    }

    @Override
    public PaginaDeNotas consultaNotas(String anoConsulta) throws IOException {
        String notasHTML = getNotasHTML(anoConsulta);
        return new PaginaDeNotas(notasHTML);
    }

    public PaginaDeNotas logaSeNecessario(String numeroRA, String senha) throws IOException {

        if (isLogado())
            return new PaginaDeNotas("");

        HttpPost httppostLogin = getLoginPost(numeroRA, senha);
        HttpResponse response = httpclient.execute(httppostLogin);
        return new PaginaDeNotas(EntityUtils.toString(response.getEntity()));
    }

    private boolean isLogado() {
        HttpGet httpGet = new HttpGet("http://www.npd.uem.br/menuAluno/ValidaMenuAluno");
        PaginaDoMenu pagina;
        try {
            HttpResponse response = httpclient.execute(httpGet);
            String html = EntityUtils.toString(response.getEntity());
            pagina = new PaginaDoMenu(html);
        } catch (IOException e) {
            pagina = new PaginaDoMenu("");
            e.printStackTrace();
        }
        return pagina.isAcessoPermitido();
    }

    private HttpPost getLoginPost(String numeroRA, String senha) throws UnsupportedEncodingException {
        HttpPost httppostLogin = new HttpPost("http://www.npd.uem.br/menuAluno/ValidaMenuAluno");
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("usuario", numeroRA));
        nameValuePairs.add(new BasicNameValuePair("se_usuario", senha));
        httppostLogin.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        return httppostLogin;
    }

    private String getNotasHTML(String anoConsulta)
            throws IOException {
        HttpPost httppost = getNotasPost(anoConsulta);
        HttpResponse response = httpclient.execute(httppost);
        return EntityUtils.toString(response.getEntity());
    }

    private HttpPost getNotasPost(String anoConsulta) throws UnsupportedEncodingException {
        HttpPost httppost = new HttpPost("http://www.npd.uem.br/menuAluno/ConsultarNotas");
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
        nameValuePairs.add(new BasicNameValuePair("dt_ano_base", anoConsulta));
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        return httppost;
    }

    @Override
    public void sair() {
        httpclient.getCookieStore().clear();
    }
}
