package OXOExceptions;

public class InvaildIdentifierLengthException extends InvalidIdentifierException{

    int length;

    public InvaildIdentifierLengthException() {
    }

    @Override
    public String toString() {
        return "InvaildIdentifierLengthException";
    }
}
