package tictacohno;

import java.util.List;

public class TicTacOhNo {

	public static void main(String[] args) {
		
		int maxN = 5;
		
		for(int n=1; n<=maxN; n++) {
		
			List<Board> boardList = Board.generateBoards(n);
			int count = boardList.size();
			
			int sumLongestChainZero = 0;
			int sumLongestChainOne = 0;
			int sumChainWin = 0;
			int sumChainTie = 0;
			int sumChainLoss = 0;
			int temp0, temp1;
			int wins = 0;
			int ties = 0;
			int losses = 0;
			for(Board b : boardList) {
				temp0 = b.getLongestChain(0);
				temp1 = b.getLongestChain(1);
				sumLongestChainZero += temp0;
				sumLongestChainOne += temp1;
				if(temp1 > temp0) {
					wins++;
					sumChainWin += temp1;
					sumChainLoss += temp0;
				} else if(temp1 == temp0) {
					ties++;
					sumChainTie += temp1;
				} else {
					losses++;
					sumChainLoss += temp1;
					sumChainWin += temp0;
				}
				//b.printBoard();
			}
			System.out.println("n = "+n);
			System.out.println("expected longest chain RIT = "+((double)sumLongestChainOne/count));
			System.out.println("expected longest chain UR = "+((double)sumLongestChainZero/count));
			System.out.println("win percentage = "+((double)wins/count)*100);
			System.out.println("tie percentage = "+((double)ties/count)*100);
			System.out.println("loss percentage = "+((double)losses/count)*100);
			System.out.println("expected win chain length = "+((double)sumChainWin/(count-ties)));
			System.out.println("expected tie chain length = "+((double)sumChainTie/ties));
			System.out.println("expected loss chain length = "+((double)sumChainLoss/(count-ties)));
			System.out.println();
		}
	}

}
