import TabelaHash.MapearLexemas;

public class App {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\Pichau\\Documents\\AnalisadorLexicoCPL\\test.pas";
        MapearLexemas map = new MapearLexemas(path);
        map.Executar();
    }
}
