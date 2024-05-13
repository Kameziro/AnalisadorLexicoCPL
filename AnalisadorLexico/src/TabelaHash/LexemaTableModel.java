package TabelaHash;

import javax.swing.table.AbstractTableModel;
import java.util.Map;

public class LexemaTableModel extends AbstractTableModel {
    private final String[] colunas = {"Token", "Lexema", "Tipo"};
    private final Map<String, Simbolo> mapaIdades;

    public LexemaTableModel(Map<String, Simbolo> mapaIdades) {
        this.mapaIdades = mapaIdades;
    }

    @Override
    public int getRowCount() {
        return mapaIdades.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] lexemas = mapaIdades.keySet().toArray(new String[0]);
        String lexema = lexemas[rowIndex];
        Simbolo simbolo = mapaIdades.get(lexema);

        switch (columnIndex) {
            case 0:
                return simbolo.getNumeroToken(); // Supondo que Simbolo tenha um método para obter o número do token
            case 1:
                return lexema;
            case 2:
                return simbolo.getTipo(); // Supondo que Simbolo tenha um método para obter o tipo
            default:
                return null;
        }
    }
}