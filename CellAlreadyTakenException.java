package OXOExceptions;

public class CellAlreadyTakenException extends OXOMoveException{

    public CellAlreadyTakenException() {

    }
    public CellAlreadyTakenException(String s) {
        super(s);
    }

    public CellAlreadyTakenException(int row, int column) {
        super(row, column);
    }

    @Override
    public String toString() {
        return "CellAlreadyTakenException";
    }
}
