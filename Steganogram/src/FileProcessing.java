import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProcessing {

    private File file = new File(CypherConstants.FILE_PATH);
    private StringBuilder sb = new StringBuilder();
    private StringProcessing stringProcessing = new StringProcessing();

    public String fileProcess(String operation, String msg) {
        String res = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader is = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(is);
            String line;

            if (operation.equals(CypherConstants.CYPHER_OPERATION)) {

                for (String code : stringProcessing.getStringBinaryList(msg)) {
                    for (char c : code.toCharArray()) {
                        if (c == '1')
                            sb.append(br.readLine().trim() + " " + "\n");
                        else sb.append(br.readLine().trim() + "\n");
                    }
                }
                while ((line = br.readLine()) != null) {
                    sb.append(line.trim() + "\n");
                }
                res = CypherConstants.CYPHER_OPERATION;
                fis.close();
                br.close();
                is.close();

                PrintWriter out = new PrintWriter(file);
                out.write(sb.toString());
                out.close();
            } else if (operation.equals(CypherConstants.DECYPHER_OPERATION)) {
                List binaryList = new ArrayList<>();
                String charCode = "";
                int i = 0;
                int j = 0;
                while ((line = br.readLine()) != null) {
                    if (i == CypherConstants.BIT_CAPACITY) {
                        binaryList.add(charCode);
                        i = 0;
                        j++;
                        charCode = "";
                    }
                    if (line.charAt(line.length() - 1) == ' ')
                        charCode = charCode + '1';
                    else charCode = charCode + '0';
                    i++;

                }

                res = stringProcessing.getMsgFromBinary(binaryList);
                fis.close();
                br.close();
                is.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    public String fileProcess(String operation) {
        return fileProcess(operation, null);
    }

}
