package OXOExceptions;

public class CellDoesNotExistException extends OXOMoveException{

    public CellDoesNotExistException() {

    }

    @Override
    public String toString() {
        return "CellDoesNotExistException";
    }
}
