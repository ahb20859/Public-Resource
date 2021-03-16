package OXOExceptions;

class InvalidIdentifierException extends CellDoesNotExistException{

    private int length;

    public InvalidIdentifierException() {
    }

    @Override
    public String toString() {
        return "InvalidIdentifierException";
    }
}
