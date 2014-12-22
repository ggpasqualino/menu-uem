package br.org.pasqualino.menuuem.core;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaginaDeNotas extends PaginaDoMenu {

    public PaginaDeNotas(String html) {
        super(html);
    }

    public ArrayList<LinhaDeNotas> getNotas() {
        ArrayList<LinhaDeNotas> notas = new ArrayList<LinhaDeNotas>();
        LinhaDeNotas linhaAtual = null;

        if(paginaVeioComFalha())
            return notas;

        for (Element linhaTabelaHtml : getNotasTableRows())
            linhaAtual = adicionaLinhaDeNotasSeNecessario(notas, linhaAtual, linhaTabelaHtml);

        return notas;
    }

    private boolean paginaVeioComFalha() {
        return document.select("script").last().html().contains("Falha na busca dos dados!");
    }

    private List<Element> getNotasTableRows() {
        int numeroLinhasCabecalho = 4;
        int numeroLinhasRodape = 2;
        Elements select = document.select("table.form table tr");
        if (select.size() > numeroLinhasCabecalho + numeroLinhasRodape)
            return select.subList(numeroLinhasCabecalho, select.size() - numeroLinhasRodape);
        return Collections.EMPTY_LIST;
    }

    private LinhaDeNotas adicionaLinhaDeNotasSeNecessario(ArrayList<LinhaDeNotas> notas, LinhaDeNotas linhaAtual, Element element) {
        if (elementoTemCodigo(element)) {
            linhaAtual = new LinhaDeNotas();
            notas.add(linhaAtual);
        }
        linhaAtual.preenche(element);
        return linhaAtual;
    }

    private boolean elementoTemCodigo(Element element) {
        return element.child(0).hasText();
    }

}
