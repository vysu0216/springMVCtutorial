
public class Operate {

    Operate(String message, String key) {
        this.message = message;
        this.key = key;
    }

    Operate() {
    }

    private char[] alphabet =
            {
                    'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к',
                    'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                    'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'
            };

    private String key;
    private String message;

    private String operation;

    private char[][] vizhenerMatrix;

    private char[][] baseMatrix;
    private char[][] messKeyMatrix;

    private void setVizhenerMatrix() {
        vizhenerMatrix = new char[key.length() + 1][alphabet.length];
        vizhenerMatrix[0] = baseMatrix[0];
        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < baseMatrix.length; j++) {
                if (baseMatrix[j][0] == key.charAt(i)) {
                    vizhenerMatrix[i + 1] = baseMatrix[j];
                }
            }
        }
    }

    private void fillMessKeyMatrix(String message, String key) {
        messKeyMatrix = new char[2][message.length()];
        messKeyMatrix[0] = message.toCharArray();
        int i = 0;
        met:
        while (i < message.length()) {
            for (int j = 0; j < key.length(); j++) {
                if (message.toCharArray()[i] == ' ') {
                    messKeyMatrix[1][i] = ' ';
                    j--;
                } else {
                    messKeyMatrix[1][i] = key.toCharArray()[j];
                }

                if (i == message.length() - 1)
                    break met;
                i++;
            }
        }
    }

    private void cypherMessage() {
        char[] cyphered = new char[message.length()];
        for (int i = 0; i < messKeyMatrix[0].length; i++) {

            int iPosition = key.indexOf(messKeyMatrix[1][i]) + 1;
            int jPosition;

            if (operation.equals("1")) {

                jPosition = new String(vizhenerMatrix[0]).indexOf(messKeyMatrix[0][i]);
                if (jPosition == -1) {
                    cyphered[i] = ' ';
                } else cyphered[i] = vizhenerMatrix[iPosition][jPosition];
            } else {
                jPosition = new String(vizhenerMatrix[iPosition]).indexOf(messKeyMatrix[0][i]);
                if (jPosition == -1) {
                    cyphered[i] = ' ';
                } else cyphered[i] = vizhenerMatrix[0][jPosition];
            }
        }
        System.out.println(cyphered);
    }


    public void fillAllMatrixes(String operation) {

        this.operation = operation;
        setBaseMatrix();
        setVizhenerMatrix();

        if (operation.equals("1")) {
            this.operation = operation;
            fillMessKeyMatrix(message, key);

            cypherMessage();
        }

        if (operation.equals("2")) {
            fillMessKeyMatrix(message, key);
            cypherMessage();
        }

    }

    public void setBaseMatrix() {
        baseMatrix = new char[33][33];
        for (int i = 0; i < baseMatrix.length; i++) {
            for (int j = 0; j < baseMatrix.length - i; j++) {
                baseMatrix[i][j] = alphabet[j + i];
            }
            for (int k = 0; k < i; k++) {
                baseMatrix[i][baseMatrix.length - i + k] = alphabet[k];
            }
        }
    }
}
