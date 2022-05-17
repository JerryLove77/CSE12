
/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * Sources used: None 
 * 
 * Concrete class of RPS providing determineWinner and main method
 */

import java.util.Scanner;

/**
 * Concrete class of RPS providing determineWinner and main method
 */
public class RPS extends RPSAbstract {
    
    /**
     * constructor of RPS.java
     * @param String[] moves the possible moves
     */
    public RPS(String[] moves) {
        this.possibleMoves = moves;
        this.playerMoves = new String[MAX_GAMES];
        this.cpuMoves = new String[MAX_GAMES];
    }

    /**
     * Takes the user move, the CPU move, and determines who wins.
     * @param playerMove - move of the player
     * @param cpuMove - move of the CPU
     * @return -1 for invalid move, 0 for tie, 1 for player win, 2 for cpu win
     */
    public int determineWinner(String playerMove, String cpuMove){
        if(!isValidMove(playerMove) || !isValidMove(cpuMove)){
            return INVALID_INPUT_OUTCOME;
        }
        int player = 0;
        int cpu =0;
        int l = possibleMoves.length-1;
        for(int i = 0; i < possibleMoves.length; i++){
            if(playerMove.equals(possibleMoves[i])){
                player = i;
            }
            if(cpuMove.equals(possibleMoves[i])){
                cpu = i;
            }
        }
        if(player == cpu){
            return TIE_OUTCOME;
        }
        if(player == 0 && cpu == l){
            return CPU_WIN_OUTCOME;
        }
        else if(player == l && cpu == 0){
            return PLAYER_WIN_OUTCOME;
        }
        else if(cpu - player ==1){
            return PLAYER_WIN_OUTCOME;
        }
        else if(player-cpu ==1){
            return CPU_WIN_OUTCOME;
        }
        else{
            return TIE_OUTCOME;
        }
    }

    /**
     * Main method that reads user input, generates cpu move, and plays game
     * 
     * @param args - arguments passed in from command line in String form
     */
    public static void main(String[] args) {
        // If command line args are provided use those as the possible moves
        String[] moves = new String[args.length];
        if (args.length >= MIN_POSSIBLE_MOVES) {
            for (int i = 0; i < args.length; i++) {
                moves[i] = args[i];
            }
        } else {
            moves = RPS.DEFAULT_MOVES;
        }
        // Create new game and scanner
        RPS game = new RPS(moves);
        Scanner in = new Scanner(System.in);

        // While user does not input "q", play game
        System.out.println(PROMPT_MOVE);
        String str = in.nextLine();
        while(!str.equals(QUIT)){
            String cpumove = game.genCPUMove();
            if(game.isValidMove(str)){
                game.play(str,cpumove);
            }
            else{
                System.out.println(INVALID_INPUT);
            }
            System.out.println(PROMPT_MOVE);
            str = in.nextLine();
        }
        game.end();
        in.close();
    }
}

