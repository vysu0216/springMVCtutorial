import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class StringProcessing {
    public List<String> getStringBinaryList(String msg) throws UnsupportedEncodingException {

        List<String> binaryArr = new ArrayList<>();

        char msgChars[] = msg.toCharArray();

        for (int i = 0; i < msg.length(); i++) {
            String bin = Integer.toBinaryString(msgChars[i]);
            int cnt = CypherConstants.BIT_CAPACITY - bin.length();
            for (int k = 0; k < cnt; k++) {
                bin = "0" + bin;
            }
            binaryArr.add(bin);
        }
        return binaryArr;
    }


    public String getMsgFromBinary(List<String> binaryArr) {
        StringBuilder messageBuilder = new StringBuilder();
        String msg;
        for (String binary : binaryArr) {
            messageBuilder.append((char) Integer.parseInt(binary, 2));
        }
        msg = String.valueOf(messageBuilder);
        return msg;
    }
}
