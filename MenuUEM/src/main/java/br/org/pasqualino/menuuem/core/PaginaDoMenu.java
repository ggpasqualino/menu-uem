package br.org.pasqualino.menuuem.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PaginaDoMenu {
    protected String html;
    protected Document document;

    public PaginaDoMenu(String html) {
        this.html = html;
        document = Jsoup.parse(html);
    }

    public boolean isAcessoPermitido(){
        return document.getElementsByAttributeValueContaining("name", "ErroSistema").isEmpty();
    }

    @Override
    public String toString() {
        return html;
    }
}
