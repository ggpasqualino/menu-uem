package br.org.pasqualino.menuuem.core;

import org.jsoup.nodes.Element;

import java.io.Serializable;
import java.util.ArrayList;

public class LinhaDeNotas implements Serializable {

    protected final ArrayList<String> avaliacoes;
    protected final ArrayList<String> notas;
    protected final ArrayList<String> faltas;
    protected String codigo;
    protected String nome;
    protected String situacao;

    public LinhaDeNotas() {
        avaliacoes = new ArrayList<String>();
        notas = new ArrayList<String>();
        faltas = new ArrayList<String>();
    }

    public void addCodigoDaDisciplina(String codigo) {
        if (this.codigo == null)
            this.codigo = codigo;
    }

    public void addDisciplina(String disciplina) {
        if (this.nome == null)
            this.nome = disciplina;
    }

    public void addAvaliacao(String avaliacao) {
        avaliacoes.add(getSegundoTecoSePossivel(avaliacao));
    }

    public void addNota(String nota) {
        notas.add(getSegundoTecoSePossivel(nota));
    }

    private String getSegundoTecoSePossivel(String notaFaltaAvaliacao){
        String[] tecos = notaFaltaAvaliacao.split(":");
        if(tecos.length > 1)
            return tecos[1].trim();
        return notaFaltaAvaliacao;
    }

    public void addFalta(String falta) {
        faltas.add(getSegundoTecoSePossivel(falta));
    }

    public void addSituacao(String situacao) {
        if(this.situacao == null)
            this.situacao = situacao;
    }

    public ArrayList<String> getAvaliacoes() {
        return avaliacoes;
    }

    public ArrayList<String> getNotas() {
        return notas;
    }

    public ArrayList<String> getFaltas() {
        return faltas;
    }

    public String getSituacao() {
        return situacao;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", codigo, nome);
    }

    void preenche(Element element) {
        addCodigoDaDisciplina(element.child(0).text());
        addDisciplina(element.child(1).text());
        addAvaliacao(element.child(2).text());
        addNota(element.child(3).text());
        addFalta(element.child(4).text());
        addSituacao(element.child(5).text());
    }
}
