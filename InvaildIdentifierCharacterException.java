package OXOExceptions;

public class InvaildIdentifierCharacterException extends InvalidIdentifierException{

    private char character;
    private RowOrColumn type;

    public InvaildIdentifierCharacterException() {
    }

    @Override
    public String toString() {
        return "InvaildIdentifierCharacterException";
    }
}
