package br.org.pasqualino.menuuem.core;

import java.io.IOException;

public class MenuDoAlunoMock extends MenuDoAluno {

    @Override
    public PaginaDeNotas consultaNotas(String anoConsulta) {
        return paginadeNotasOk();
    }

    private PaginaDeNotas paginaNaoLogado() {
        return new PaginaDeNotas("<html><head><meta http-equiv=\"Content-Language\" content=\"pt-br\" /> <meta http-equiv=\"Content-Type\" content=\"text/html;charset=iso-8859-1\" /> <title> Universidade Estadual de Maringá - NPD/Desenvolvimento</title><link rel='stylesheet' href='css/janela.css' type='text/css' /></head><body><center><br/><img src=\"images/webDAA_banner.jpg\" /></center><SCRIPT language=JavaScript> \n" +
                "function valida_form() \n" +
                "{ \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "document.getElementById('BotaoSubmit').disabled = true \n" +
                "return true \n" +
                "} </script><script language=JavaScript type=text/javascript src='js/form.js'></script> <p><center><table class='form'><th>SIGAUEM - Erro no Sistema</th><tr><td><form name='ErroSistema' action='http://www.npd.uem.br/menuAluno' accept-charset=\"iso-8859-1,utf-8\" method=post onsubmit='return valida_form()'> <br><center><font size=2><b>Acesso negado! Reinicie a aplicação.</b></br></center></font><br><center><table> \n" +
                " <tr> \n" +
                "\n" +
                " <td><input type=submit value='Sair' id=BotaoSubmit></td> \n" +
                " <td></td> \n" +
                " </form>\n" +
                " <form name=ItemErroSistema action='' method=post> \n" +
                " <td></td></form>\n" +
                " <form name=Item2ErroSistema action='' method=post> \n" +
                " <td></td></form>\n" +
                " <form name=Item2ErroSistema action='' method=post> \n" +
                " <td></td></form>\n" +
                " <form name=Item2ErroSistema action='' method=post> \n" +
                " <td></td></form>\n" +
                " <form name=Item2ErroSistema action='' method=post> \n" +
                " <td></td></form><form name=AuxiliarErroSistema action='' method=post> \n" +
                "<td></td>\n" +
                "<td></td></form></tr></table></center><br>");
    }


    private PaginaDeNotas paginadeNotasOk() {
        return new PaginaDeNotas(
                "<html>\n" +
                        "<head>\n" +
                        "    <meta http-equiv=\"Content-Language\" content=\"pt-br\"/>\n" +
                        "    <meta http-equiv=\"Content-Type\" content=\"text/html;charset=iso-8859-1\"/>\n" +
                        "    <title> Universidade Estadual de Maringá - NPD/Desenvolvimento</title>\n" +
                        "    <link rel='stylesheet' href='css/janela.css' type='text/css'/>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<center><br/><img src=\"images/webDAA_banner.jpg\"/></center>\n" +
                        "<style type=\"text/css\">\n" +
                        "    table#alter {\n" +
                        "    border-collapse: collapse;\n" +
                        "    background: #FFFFF0;\n" +
                        "    font-size:10px}\n" +
                        "    table#alter td {\n" +
                        "    border: 1px solid #000000;\n" +
                        "    }\n" +
                        "    table#alter th {\n" +
                        "    border: 1px solid #000000;\n" +
                        "    border-bottom: 2px solid #000000;\n" +
                        "    background: #F0FFF0; }\n" +
                        "    table#alter th {background: #006633;}\n" +
                        "    table#alter tr td {background: #ffffff;}\n" +
                        "    table#alter tr.dif td {background: #ccffcc;}\n" +
                        "    }\n" +
                        "</style>\n" +
                        "<table id=alter width=775>\n" +
                        "    <th colspan=4>Dados do Aluno</th>\n" +
                        "\n" +
                        "    <tr>\n" +
                        "        <td><b>RA</b></td>\n" +
                        "        <td><b>Nome do aluno</b></td>\n" +
                        "        <td><b>Série</b></td>\n" +
                        "        <td><b>Situação Acadêmica</b></td>\n" +
                        "    </tr>\n" +
                        "    <tr class=\"dif\">\n" +
                        "        <td>53040</td>\n" +
                        "        <td>GUILHERME IRINEU ROSA DE ARAUJO</td>\n" +
                        "        <td>4</td>\n" +
                        "        <td>Matriculado(a)</td>\n" +
                        "    </tr>\n" +
                        "</table>\n" +
                        "\n" +
                        "<SCRIPT language=JavaScript> \n" +
                        "function valida_form() \n" +
                        "{ \n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "document.getElementById('BotaoSubmit').disabled = true \n" +
                        "return true \n" +
                        "}\n" +
                        "</script>\n" +
                        "<script language=JavaScript type=text/javascript src='js/form.js'></script>\n" +
                        "<p>\n" +
                        "<center>\n" +
                        "    <table class='form'>\n" +
                        "        <th>Consulta de Notas e Faltas</th>\n" +
                        "        <tr>\n" +
                        "            <td>\n" +
                        "                <form name='FrmConsultaNotas' action='ValidaMenuAluno'\n" +
                        "                      accept-charset=\"iso-8859-1,utf-8\" method=post onsubmit='return valida_form()'>\n" +
                        "                    <table width=100% border=0 cellpadding=0 cellspacing=0 align=center>\n" +
                        "                        <tr bgcolor=#000000>\n" +
                        "                            <td colspan=6><img src='images/blackdot.jpg'></td>\n" +
                        "                        </tr>\n" +
                        "                        <tr bgcolor=#a7f3c1>\n" +
                        "                            <td width=50> Cód. Disc.</td>\n" +
                        "                            <td width=270>Disciplina</td>\n" +
                        "                            <td></td>\n" +
                        "                            <td>Notas e Faltas\n" +
                        "                            <td></td>\n" +
                        "                            <td>Situação</td>\n" +
                        "                        </tr>\n" +
                        "                        <tr bgcolor=#000000>\n" +
                        "                            <td colspan=6><img src='images/blackdot.jpg'></td>\n" +
                        "                        </tr>\n" +
                        "                        <tr bgcolor=#ffffff>\n" +
                        "                            <td colspan=6><img src='images/dot.jpg'></td>\n" +
                        "                        </tr>\n" +
                        "                        <tr bgcolor=#dfdfdf>\n" +
                        "                            <td>1000</td>\n" +
                        "                            <td>Disciplina 1</td>\n" +
                        "                            <td></td>\n" +
                        "                            <td>Nota: 6.8</td>\n" +
                        "                            <td>Faltas: 4</td>\n" +
                        "                            </td>\n" +
                        "                            <td><b>Aprovado</b></td>\n" +
                        "                        <tr bgcolor=#efefef>\n" +
                        "                            <td>1001</td>\n" +
                        "                            <td>Disciplina 2</td>\n" +
                        "                            <td></td>\n" +
                        "                            <td>Nota: 8.9</td>\n" +
                        "                            <td>Faltas: 0</td>\n" +
                        "                            </td>\n" +
                        "                            <td><b>Aprovado</b></td>\n" +
                        "                        <tr bgcolor=#dfdfdf>\n" +
                        "                            <td>1002</td>\n" +
                        "                            <td>Disciplina 3</td>\n" +
                        "                            <td></td>\n" +
                        "                            <td>Nota: 7.7</td>\n" +
                        "                            <td>Faltas: 12</td>\n" +
                        "                            </td>\n" +
                        "                            <td><b>Aprovado</b></td>\n" +
                        "                        <tr bgcolor=#efefef>\n" +
                        "                            <td>1003</td>\n" +
                        "                            <td>Disciplina 4</td>\n" +
                        "                            <td></td>\n" +
                        "                            <td>Nota: 7.5</td>\n" +
                        "                            <td>Faltas: 21</td>\n" +
                        "                            </td>\n" +
                        "                            <td><b>Aprovado</b></td>\n" +
                        "                        <tr bgcolor=#dfdfdf>\n" +
                        "                            <td>1004</td>\n" +
                        "                            <td>Disciplina 5</td>\n" +
                        "                            <td></td>\n" +
                        "                            <td>Nota: 8.5</td>\n" +
                        "                            <td>Faltas: 11</td>\n" +
                        "                            </td>\n" +
                        "                            <td><b>Aprovado</b></td>\n" +
                        "                        <tr bgcolor=#efefef>\n" +
                        "                            <td>1005</td>\n" +
                        "                            <td>Disciplina 6</td>\n" +
                        "                            <td>Avaliação:1</td>\n" +
                        "                            <td>Nota: 8.1</td>\n" +
                        "                            <td>Faltas: 0</td>\n" +
                        "                            </td>\n" +
                        "                            <td><b>Matriculado</b></td>\n" +
                        "                        <tr bgcolor=#efefef>\n" +
                        "                            <td></td>\n" +
                        "                            <td></td>\n" +
                        "                            <td>Avaliação:2</td>\n" +
                        "                            <td>Nota: 7.2</td>\n" +
                        "                            <td>Faltas: 0</td>\n" +
                        "                            </td>\n" +
                        "                            <td></td>\n" +
                        "                        <tr bgcolor=#efefef>\n" +
                        "                            <td></td>\n" +
                        "                            <td></td>\n" +
                        "                            <td>Avaliação:3</td>\n" +
                        "                            <td>Nota: 0.0</td>\n" +
                        "                            <td>Faltas: 0</td>\n" +
                        "                            </td>\n" +
                        "                            <td></td>\n" +
                        "                        <tr bgcolor=#000000>\n" +
                        "                            <td colspan=6><img src='images/blackdot.jpg'></td>\n" +
                        "                        </tr>\n" +
                        "                    </table>\n" +
                        "                    <br>Emitido em 14/12/2013 14:38:53<br>\n" +
                        "                    <center>\n" +
                        "                        <table>\n" +
                        "                            <tr>\n" +
                        "\n" +
                        "                                <td><input type=submit value='Voltar para o Menu do Aluno'\n" +
                        "                                           id=BotaoSubmit></td>\n" +
                        "                                <td></td>\n" +
                        "                </form>\n" +
                        "                <form name=ItemFrmConsultaNotas action='' method=post>\n" +
                        "                    <td></td>\n" +
                        "                </form>\n" +
                        "                <form name=Item2FrmConsultaNotas action='' method=post>\n" +
                        "                    <td></td>\n" +
                        "                </form>\n" +
                        "                <form name=Item2FrmConsultaNotas action='' method=post>\n" +
                        "                    <td></td>\n" +
                        "                </form>\n" +
                        "                <form name=Item2FrmConsultaNotas action='' method=post>\n" +
                        "                    <td></td>\n" +
                        "                </form>\n" +
                        "                <form name=Item2FrmConsultaNotas action='' method=post>\n" +
                        "                    <td></td>\n" +
                        "                </form>\n" +
                        "                <form name=AuxiliarFrmConsultaNotas action='' method=post>\n" +
                        "                    <td></td>\n" +
                        "                    <td>\n" +
                        "                        <input type=button value='Imprimir' OnClick=javascript:window.print();></td>\n" +
                        "                </form>\n" +
                        "        </tr>\n" +
                        "    </table>\n" +
                        "</center>\n" +
                        "<br>\n"
        );
    }

    @Override
    public PaginaDoMenu logaSeNecessario(String usuario, String senha) throws IOException {
        return new PaginaDoMenu("");
    }

    @Override
    public void sair() {

    }
}
