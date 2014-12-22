package br.org.pasqualino.menuuem.core;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class PaginaDeNotasSAV extends PaginaDeNotas {

    public PaginaDeNotasSAV(String html) {
        super(html);
    }

    @Override
    public ArrayList<LinhaDeNotas> getNotas() {
        ArrayList<LinhaDeNotas> disciplinas = new ArrayList<LinhaDeNotas>();
        Elements disciplinasElements = document.select("table.masterDetail>tbody");

        for (Element disciplina : disciplinasElements)
            disciplinas.add(getDisciplina(disciplina));

        return disciplinas;
    }

    private LinhaDeNotas getDisciplina(Element disciplina) {
        return new DisciplinaSav(disciplina);
    }

    @Override
    public boolean isAcessoPermitido() {
        return document.getElementsByClass("message-error").isEmpty();
    }
}




