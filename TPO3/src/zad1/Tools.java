package zad1;

import org.yaml.snakeyaml.Yaml;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

public class Tools {

    static Options createOptionsFromYaml(String fileName) throws Exception{
        Yaml yaml = new Yaml();
        FileReader reader = new FileReader(fileName);
        Map<String, Object> data = yaml.load(reader);

        String host = (String) data.get("host");
        int port = (int) data.get("port");
        boolean concurMode = (boolean) data.get("concurMode");
        boolean showSendRes = (boolean) data.get("showSendRes");
        Map<String, List<String>> clientsMap = (Map<String, List<String>>) data.get("clientsMap");

        reader.close();
        return new Options(host, port, concurMode, showSendRes, clientsMap);
    }
}
