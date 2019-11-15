package com.packages.TicTacToe;

import java.util.Scanner;

public class Tic_Tac_Toe {

	char currentPlayer;
	char [][]board=new char[3][3];
	
	//Constructor
	
	public Tic_Tac_Toe() {
		// TODO Auto-generated constructor stub
		currentPlayer='x';
		createBoard();
	}
	public void changePlayer() {
		if (currentPlayer=='x') {
			currentPlayer='o';
		}
		else {
			currentPlayer='x';
		}
	}
	private boolean move(int f,int s) {
		if (f>=0 && f<3 && s>=0 && s<3) {
			if (board[f][s]=='-') {
				board[f][s]=currentPlayer;
				return true;
			}
		}
		return false;
	}
	public void createBoard () {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j]='-';
			}
		}
	}
	public void printBoard() {
		System.out.println("-------------");
		for (int i = 0; i < board.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]+" | ");
			}
			System.out.println();
			System.out.println("------------");
		}
	}
	public boolean rowCheck () {
		for (int i = 0; i < board.length; i++) {
			if (win(board[i][0],board[i][1],board[i][2])) {
				return true;
			}
		}
		return false;
	}
	public boolean colCheck() {
		for (int i = 0; i < board.length; i++) {
			if (win(board[0][i], board[1][i],board[2][i])) {
				return true;
			}
		}
		return false;
	}
	public boolean diagnolCheck() {
		if (win(board[0][0], board[1][1], board[2][2]) || win(board[0][2],board[1][1], board[2][0])) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean win(char c1,char c2,char c3) {
		return c1!='-' && c1==c2 && c2==c3;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String again;
		Scanner scanner=new Scanner(System.in);
		do {
			Tic_Tac_Toe tic_Tac_Toe=new Tic_Tac_Toe();
			tic_Tac_Toe.printBoard();
			int counter=0;
			do {
				System.out.print("User ("+tic_Tac_Toe.currentPlayer+"):");
				String input=scanner.next().trim();

				int first=Integer.parseInt(input.substring(0,1))-1;
				int second=Integer.parseInt(input.substring(1,2))-1;

				if (tic_Tac_Toe.move(first,second)) {
					if (tic_Tac_Toe.rowCheck() || tic_Tac_Toe.colCheck() || tic_Tac_Toe.diagnolCheck()) {
						break;
					}
					tic_Tac_Toe.changePlayer();
					counter++;
				}
				tic_Tac_Toe.printBoard();
			} while (counter<9);
			if (!(tic_Tac_Toe.rowCheck() || tic_Tac_Toe.colCheck() || tic_Tac_Toe.diagnolCheck())) {
				System.out.println("Game is being draw");
			}
			else {
				System.out.println("Player "+tic_Tac_Toe.currentPlayer+" has won");
			}
			tic_Tac_Toe.printBoard();
			System.out.println("Press y if you wnat to play again");
			again=scanner.next().trim().toLowerCase();

		} while (again.equals("y"));

		scanner.close();
	}

}
