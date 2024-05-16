package TabelaHash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MapearLexemas {
    
    // Criando um HashMap que mapeia nomes para simbolos
    private HashMap<String, Simbolo> mapaLexemas;

    public MapearLexemas(String path){
        this.mapaLexemas = new HashMap<>();
        this.PopularMapa(path);
    }

    /*  Adicionando elementos ao HashMap PopularMapa,abre um arquivo especificado pelo caminho path, lê-o linha por linha, 
    e para cada linha chama um método analisarLinha que  processa a linha e atualiza a tabela de símbolos reservados 
    (palavrasReservadas). Se ocorrer um erro durante a leitura do arquivo, uma mensagem de erro é impressa no console. */

    private void PopularMapa(String path){
        TabelaSimbolosReservados palavrasReservadas = new TabelaSimbolosReservados();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                analisarLinha(linha, palavrasReservadas);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo minificado: " + e.getMessage());
        }
    }

    private void analisarLinha(String linha, TabelaSimbolosReservados palavrasReservadas) {
        boolean dentroString = false; //Um flag para verificar se o caractere atual está dentro de uma string delimitada por aspas simples (').
        StringBuilder palavraAtual = new StringBuilder(); // Um StringBuilder para construir a palavra ou símbolo atual.
        boolean dentroComentarioLinha = false; // Flag para verificar se o caractere está dentro de um comentario

        // ma regex que filtra caracteres especiais, exceto letras (incluindo acentos),
        //dígitos, pontuação ABNT (pontos, vírgulas, etc.) e espaços.
        String regex = "[^a-zA-Z0-9À-ÖØ-öø-ÿ,.:;!?\\s']";

        for (int i = 0; i < linha.length(); i++) {
            char c = linha.charAt(i);

            if (dentroComentarioLinha) {
                break;
            }

            if (c == '\'') { // Se o caractere é uma aspa simples, alterna o estado de dentroString e adiciona o caractere à palavra atual.
                dentroString = !dentroString;
                palavraAtual.append(c);
            } else if (dentroString) { // Se está dentro de uma string, adiciona o caractere à palavra atual.
                palavraAtual.append(c);
                // Se o caractere é um espaço, tabulação, nova linha, carriage return, ponto e vírgula, dois pontos, ponto
                // parêntese aberto ou fechado, considera como um delimitador de palavras.
            } else if (c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == ';' || c == '(' || c == ':' || c == '.' || c == ')') {
                // Processar a palavra atual
                processarPalavra(palavraAtual.toString(), palavrasReservadas);
                palavraAtual.setLength(0); // Limpar a palavra atual

                // Processar o caractere separadamente, se não for um espaço em branco
                if (c != ' ' && c != '\t' && c != '\n' && c != '\r') {
                    processarPalavra(String.valueOf(c), palavrasReservadas);
                }
                // Verifica se a palavra está dentro de um comentario.
            } else if (c == '{') {
                dentroComentarioLinha = true;
                break;

            } else if (Character.toString(c).matches(regex)) {//Se o caractere corresponde à regex de caracteres especiais (exceto 
            // pontuação ABNT), processa a palavra atual e limpa o StringBuilder.
                processarPalavra(palavraAtual.toString(), palavrasReservadas);
                palavraAtual.setLength(0); // Limpar a palavra atual
            } else {
                palavraAtual.append(c);
            }
        }
        // Processar a última palavra da linha
        processarPalavra(palavraAtual.toString(), palavrasReservadas);
    }

// Método para processar uma palavra e adicionar ao mapa de lexemas
private void processarPalavra(String palavra, TabelaSimbolosReservados palavrasReservadas) {
    // Verifica se a palavra está vazia
    if (palavra.isEmpty()) {
        return;
    }

    // Verifica se a palavra é uma palavra reservada
    if (palavrasReservadas.Pesquisar(palavra) != 0) {
        // Se for uma palavra reservada, adiciona ao mapa de lexemas com o símbolo correspondente
        this.mapaLexemas.put(palavra, palavrasReservadas.BuscarSimbolo(palavra));
    } else {
        try {
            // Detecta o tipo da palavra (constante string, constante numérica ou identificador)
            switch (detectarTipoPalavra(palavra)) {
                case "STRING_CONST":
                    // Se for uma constante de string, adiciona ao mapa de lexemas como uma constante de string
                    this.mapaLexemas.put(palavra, palavrasReservadas.inserirConst(palavra, "STRING_CONST"));
                    break;
                case "NUM_CONST":
                    // Se for uma constante numérica, adiciona ao mapa de lexemas como uma constante numérica
                    this.mapaLexemas.put(palavra, palavrasReservadas.inserirConst(palavra, "NUM_CONST"));
                    break;
                case "ID":
                    // Se for um identificador, adiciona ao mapa de lexemas como um identificador
                    this.mapaLexemas.put(palavra, palavrasReservadas.InserirID(palavra));
                    break;
            }
        } catch (Exception e) {
            // Em caso de erro ao processar a palavra, exibe a mensagem de erro e encerra o programa
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}

// Método para detectar o tipo da palavra (constante string, constante numérica ou identificador)
private String detectarTipoPalavra(String palavra) throws Exception {
    // Verifica se a palavra é uma constante de string
    if (palavra.length() >= 2 && palavra.charAt(0) == '\'' && palavra.charAt(palavra.length() - 1) == '\'') {
        return "STRING_CONST";
    }
    // Verifica se a palavra é uma constante numérica
    else if (palavra.chars().allMatch(Character::isDigit)) {
        return "NUM_CONST";
    }
    // Verifica se a palavra é um identificador
    else if (!Character.isDigit(palavra.charAt(0))) {
        return "ID";
    } else {
        // Caso não se enquadre em nenhum dos tipos, lança uma exceção com a mensagem de erro
        throw new Exception("Falha ao processar arquivo. Erro ao declarar: " + palavra);
    }
}

    private void Listando() {
        JFrame frame = new JFrame("Tabela de Lexemas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        LexemaTableModel tableModel = new LexemaTableModel(mapaLexemas);
        JTable table = new JTable(tableModel);
    
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
    
        frame.pack();
        frame.setVisible(true);
    }


    public void Executar(){
        this.Listando();
    }
}

