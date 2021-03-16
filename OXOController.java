package OXOExceptions;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class OXOController
{
    OXOModel gameModel;
    private int count = 1;

    public OXOController(OXOModel model)
    {
        gameModel = model;
        gameModel.setCurrentPlayer(gameModel.getPlayerByNumber(0));
    }

    public void handleIncomingCommand(String command) throws OXOMoveException{

        if(command.length() != 2){
            throw new InvaildIdentifierLengthException();
        }
        if (command.charAt(0)<65 || command.charAt(0)>105){
            throw new InvaildIdentifierCharacterException();
        }
        if (command.charAt(0)>73 && command.charAt(0)<97){
            throw new InvaildIdentifierCharacterException();
        }
        if (command.charAt(1)<48 || command.charAt(1)>57){
            throw new InvaildIdentifierCharacterException();
        }

        int x = 0;
        if ((command.charAt(0) - 'a') >= 0) x = command.charAt(0) - 'a';
        else x = command.charAt(0) - 'A';
        int y = command.charAt(1) - '1';

        if(x > gameModel.getNumberOfRows() || x < 0){
            throw new OutsideCellRangeException();
        }
        if(y > gameModel.getNumberOfColumns() || y < 0){
            throw new OutsideCellRangeException();
        }

        if (gameModel.getCellOwner(x,y) != null) {
            throw new CellAlreadyTakenException();
        }

        gameModel.setCellOwner(x , y, gameModel.getCurrentPlayer());
/*        for (int i = 0; i < 3; i++) {
            if (check(i) != null) {
                gameModel.setWinner(gameModel.getCurrentPlayer());
                break;
            }
        }*/


/*        int cnt = 1;
            for (int i = y ; i <= gameModel.getNumberOfColumns(); i++) {
                if (gameModel.getCellOwner(x, i) == gameModel.getCellOwner(x, i-1)) cnt++;
                if (cnt == gameModel.getWinThreshold()) gameModel.setWinner(gameModel.getCellOwner(x, y));
                if (gameModel.getCellOwner(x, i) != gameModel.getCellOwner(x, y-1)) break;
            }
            for (int i = y - 1; i >= -1; i--) {
                if (gameModel.getCellOwner(x, i) == gameModel.getCellOwner(x, i+1)) cnt++;
                if (cnt == gameModel.getWinThreshold()) gameModel.setWinner(gameModel.getCellOwner(x, y));
                if (gameModel.getCellOwner(x, i) != gameModel.getCellOwner(x, i+1)) break;
            }
            if (cnt >= gameModel.getWinThreshold()) gameModel.setWinner(gameModel.getCellOwner(x, y));*/

        if (count == gameModel.getNumberOfRows() * gameModel.getNumberOfColumns()) gameModel.setGameDrawn();

        changeCurrentPlayer();
    }



/*    private OXOPlayer check(int i) {



        if (gameModel.getCellOwner(i,0) == gameModel.getCellOwner(i,1)
                && gameModel.getCellOwner(i,0) == gameModel.getCellOwner(i,2)){
            if (gameModel.getCellOwner(i,0)==null) return null;
            if (gameModel.getCellOwner(i,0).letter== 'O') return gameModel.getPlayerByNumber(0);
            else return gameModel.getPlayerByNumber(1);
        }

        if (gameModel.getCellOwner(0,i) == gameModel.getCellOwner(1,i)
                && gameModel.getCellOwner(0,i) == gameModel.getCellOwner(2,i)){
            if (gameModel.getCellOwner(0,i)==null) return null;
            if (gameModel.getCellOwner(0,i).letter== 'O') return gameModel.getPlayerByNumber(0);
            else return gameModel.getPlayerByNumber(1);
        }

        if (gameModel.getCellOwner(0,0) == gameModel.getCellOwner(1,1)
                && gameModel.getCellOwner(0,0) == gameModel.getCellOwner(2,2)){
            if (gameModel.getCellOwner(i,i)==null) return null;
            if (gameModel.getCellOwner(i,i).letter== 'O') return gameModel.getPlayerByNumber(0);
            else if(gameModel.getCellOwner(i,i).letter=='X') return gameModel.getPlayerByNumber(1);
            return null;
        }

        if (gameModel.getCellOwner(0,2) == gameModel.getCellOwner(1,1)
                && gameModel.getCellOwner(0,2) == gameModel.getCellOwner(2,0)){
            if (gameModel.getCellOwner(i,2-i) == null) return null;
            if (gameModel.getCellOwner(i,2-i).letter == 'O') return gameModel.getPlayerByNumber(0);
            else if(gameModel.getCellOwner(i,2-i).letter=='X') return gameModel.getPlayerByNumber(1);
            return null;
        }
        return null;
    }*/



    private void changeCurrentPlayer() {
        gameModel.setCurrentPlayer(gameModel.getPlayerByNumber(count % gameModel.getNumberOfPlayers()));
        count++;
    }

}

