package br.org.pasqualino.menuuem.core;

import java.io.IOException;

public abstract class MenuDoAluno {

    public abstract PaginaDeNotas consultaNotas(String anoConsulta) throws IOException;

    public abstract PaginaDoMenu logaSeNecessario(String usuario, String senha) throws IOException;

    public abstract void sair();

    public static MenuDoAluno getMenu(String menu) {
        if (menu.equals("SAV"))
            return new MenuDoAlunoSAV();
        else
            return new MenuDoAlunoDAA();
    }

}
