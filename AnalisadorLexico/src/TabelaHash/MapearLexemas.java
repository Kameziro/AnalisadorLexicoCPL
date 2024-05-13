package TabelaHash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MapearLexemas {
    
    // Criando um HashMap que mapeia nomes para idades
    private HashMap<String, Simbolo> mapaIdades;

    public MapearLexemas(String path){
        this.mapaIdades = new HashMap<>();
        this.PopularMapa(path);
    }

    // Adicionando elementos ao HashMap
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
        boolean dentroString = false;
        StringBuilder palavraAtual = new StringBuilder();
    
        for (int i = 0; i < linha.length(); i++) {
            char c = linha.charAt(i);
    
            if (c == '\'') {
                dentroString = !dentroString;
                palavraAtual.append(c);
                if (!dentroString) {
                    processarPalavra(palavraAtual.toString(), palavrasReservadas);
                    palavraAtual.setLength(0); // Limpar a palavra atual
                }
            } else if (dentroString) {
                palavraAtual.append(c);
            } else if (c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == ';' || c == '(' || c == ')') {
                processarPalavra(palavraAtual.toString(), palavrasReservadas);
                palavraAtual.setLength(0); // Limpar a palavra atual
    
                // Processar o caractere separadamente, se não for um espaço em branco
                if (c != ' ' && c != '\t' && c != '\n' && c != '\r') {
                    processarPalavra(String.valueOf(c), palavrasReservadas);
                }
            } else {
                palavraAtual.append(c);
            }
        }
    
        // Processar a última palavra da linha
        processarPalavra(palavraAtual.toString(), palavrasReservadas);
    }

    private void processarPalavra(String palavra, TabelaSimbolosReservados palavrasReservadas) {
        if (palavra.isEmpty()) {
            return;
        }

        if (palavrasReservadas.Pesquisar(palavra) != 0) {
            this.mapaIdades.put(palavra, palavrasReservadas.BuscarSimbolo(palavra));
        } else {
            try {
                switch (detectarTipoPalavra(palavra)) {
                    case "STRING_CONST":
                        this.mapaIdades.put(palavra, palavrasReservadas.inserirConst(palavra, "STRING_CONST"));
                        break;
                    case "NUM_CONST":
                        this.mapaIdades.put(palavra, palavrasReservadas.inserirConst(palavra, "NUM_CONST"));
                        break;
                    case "ID":
                        this.mapaIdades.put(palavra, palavrasReservadas.InserirID(palavra));
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
    }

    private String detectarTipoPalavra(String palavra) throws Exception {
        if (palavra.length() >= 2 && palavra.charAt(0) == '\'' && palavra.charAt(palavra.length() - 1) == '\'') {
            return "STRING_CONST";
        } else if (palavra.chars().allMatch(Character::isDigit)) {
            return "NUM_CONST";
        } else if (!Character.isDigit(palavra.charAt(0))) {
            return "ID";
        } else {
            throw new Exception("Falha ao processar arquivo. Erro ao declarar: " + palavra);
        }
    }

    private void Listando() {
        JFrame frame = new JFrame("Tabela de Lexemas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        LexemaTableModel tableModel = new LexemaTableModel(mapaIdades);
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
