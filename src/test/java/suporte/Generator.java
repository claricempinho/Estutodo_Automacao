package suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {
    public static String dataHoraParaArquivo(){
        //variavel do tipo timestamp que pega a data e hora do sistema
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        //retorna a data e hora no formato de ano mes hora
        return new SimpleDateFormat("yyyMMddhhmmss").format(ts);
    }
}
