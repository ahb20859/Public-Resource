package OXOExceptions;

public class OutsideCellRangeException extends CellDoesNotExistException{

    private char character;
    private RowOrColumn type;

    public OutsideCellRangeException() {

    }

    @Override
    public String toString() {
        return "OutsideCellRangeException";
    }
}
