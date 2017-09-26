import java.io.UnsupportedEncodingException;

public class CodeDecode {

    static private FileProcessing fp = new FileProcessing();

    public static void main(String[] args) throws UnsupportedEncodingException {
        cypher("!");
        deCypher();
    }

    public static void cypher(String msgToEncode) throws UnsupportedEncodingException {
        String inputMsg = new String(msgToEncode.getBytes("utf8"));
        System.out.println(fp.fileProcess(CypherConstants.CYPHER_OPERATION, inputMsg));
    }

    ;

    public static void deCypher() {
        System.out.println(fp.fileProcess(CypherConstants.DECYPHER_OPERATION));
    }

}

interface CypherConstants {
    static final String CYPHER_OPERATION = "cypher";
    static final String DECYPHER_OPERATION = "decypher";
    static final String FILE_PATH = "E:\\Shop_branch\\Steganogram\\resources\\text_to_code.txt";
    static final int BIT_CAPACITY = 11;
}
