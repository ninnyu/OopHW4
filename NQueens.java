/* 	Oops HW 4
 * 	@author NinnYu Chin
 * 	Instruction:	Write a program that finds and prints all the solutions to the N-Queens 
 *			problem for a given N. At the end of your program, print how many 
 *			solutions were found.
 */

import java.util.*;

public class NQueens {
	public static void main ( String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter number of queens: ");
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		
		createBoard(board, n);
		solveNQueens(board, n, 0);
		System.out.printf("The number of solutions for %d number of Queens: %d.", n, solutionCount);
		
		sc.close();
	}
	
	public static int solutionCount = 0;
	
	//Initializes the board.
	static void createBoard (int[][] board, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	//Prints the board. 0 means empty space. 1 means queens.
	static void printBoard (int[][] board, int n) {
		solutionCount++;
		for (int i = 0; i < n; i++) {
			System.out.print("{");
			for (int j = 0; j < n; j++) {
				System.out.printf("%2d", board[i][j]);
			}
			System.out.println(" }");
		}
		System.out.println();
	}
	
	//Finds if it is safe to place a queen.
	static boolean isSafe (int[][] board, int n, int r, int c) {
		//Looks across the row for a queen.
		for (int i = 0; i < c; i++) {
			if (board[r][i] == 1)
				return false;
		}
		
		//Looks at diagonal for a queen.
		for (int i=r, j=c; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}
		
		//Looks at the other diagonal for a queen.
		for (int i=r, j=c; j >= 0 && i < n; i++, j--) {
			if (board[i][j] == 1)
				return false;
		}
		return true;
	}
	
	//Recursively finds a solution to the N-Queens problem.
	static boolean solveNQueens (int[][] board, int n, int c) {
		if (c >= n) {
			printBoard(board, n);
			return true;
		}
		
		for (int i = 0; i < n; i++) {
			if (isSafe (board, n, i, c)) {
				board [i][c] = 1;
				
				solveNQueens (board, n, c+1);
				
				board[i][c] = 0;
			}
		}
		return false;
	}
}


