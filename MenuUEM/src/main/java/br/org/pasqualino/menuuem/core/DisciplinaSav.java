package br.org.pasqualino.menuuem.core;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DisciplinaSav extends LinhaDeNotas {
    private transient Element disciplina;

    public DisciplinaSav(Element disciplina) {
        super();
        this.disciplina = disciplina;

        addCabecalho();
        addAvaliacoes();
    }

    private void addCabecalho() {
        Elements campos = disciplina.select("tr.master td");
        codigo = getCampoIfExists(campos, 0);
        nome = getCampoIfExists(campos, 1);
        situacao = getCampoIfExists(campos, 2);
    }

    private String getCampoIfExists(Elements campos, int index) {
        try {
            return campos.get(index).text();
        } catch (IndexOutOfBoundsException e) {
            return "";
        }
    }

    private void addAvaliacoes() {
        for (Element avaliacao : disciplina.select("tr.detail tbody tr"))
            addLinhaDeAvaliacao(avaliacao);

    }

    private void addLinhaDeAvaliacao(Element avaliacao) {
        avaliacoes.add(getChildTextIfExists(avaliacao, 0));
        notas.add(getChildTextIfExists(avaliacao, 1));
        faltas.add(getChildTextIfExists(avaliacao, 2));
    }

    private String getChildTextIfExists(Element avaliacao, int childIndex) {
        try {
            return avaliacao.child(childIndex).text();
        } catch (IndexOutOfBoundsException e) {
            return "";
        }
    }
}
