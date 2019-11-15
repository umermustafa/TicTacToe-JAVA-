package com.packages.TicTacToe;

import java.util.Scanner;

public class TicTac {

	public char [][]board=new char[3][3];
	public char currentPlayer;
	public TicTac() {
		// TODO Auto-generated constructor stub
		board=new char[3][3];
		currentPlayer='x';
		initializeBoard();
	}
	public boolean placeMove(int f,int s) {
		if (f>=0 && f<3) {
			if (s>=0 && s<3) {
				if (board[f][s]=='-') {
					board[f][s]=currentPlayer;
					return true;
				}
			}
		}
		return false;
	}
	public void changePlayer() {
		if (currentPlayer=='x') {
			currentPlayer='o';
		}
		else {
			currentPlayer='x';
		}
	}
	public void initializeBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j]='-';
			}
		}
	}
	public boolean isFull() {
		boolean flag=true;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j]=='-') {
					flag= false;
				}
			}
		}
		return flag;
	}
	public boolean rowCheck(){
		for (int i = 0; i < board.length; i++) {
			if (win(board[i][0], board[i][1],board[i][2])) {
				return true;
			}
		}
		return false;		
	}
	public boolean colCheck() {
		for (int i = 0; i < board.length; i++) {
			if (win(board[0][i],board[1][i],board[2][i])) {
				return true;
			}
		}
		return false;
	}
	public boolean diagnolCheck() {
		if (win(board[0][0],board[1][1],board[2][2]) || win(board[0][2],board[1][1],board[2][0])) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean win(char c1,char c2,char c3) {
		if (c1!='-' && c1==c2 && c2==c3) {
			return true;
		}
		else {
			return false;
		}
	}
	public void printBoard() {
		System.out.println(" -------------");
		for (int i = 0; i < board.length; i++) {
			System.out.print(" | ");
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]+" | ");
			}
			System.out.println();
			System.out.println(" -------------");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTac ticTac=new TicTac();
		int counter=0;
		String again="";
		Scanner scanner=new Scanner(System.in);
		do {
			do {
				ticTac.printBoard();
				System.out.println("User ("+ticTac.currentPlayer+") Make a move");
				String move=scanner.next();
				int firstNumber=Integer.parseInt(move.substring(0,1))-1;
				int secondNumber=Integer.parseInt(move.substring(1,2))-1;
				if (!ticTac.isFull()) {
					if (ticTac.placeMove(firstNumber, secondNumber)) {
						if (ticTac.rowCheck() || ticTac.colCheck() || ticTac.diagnolCheck()) {
							break;
						}
						ticTac.changePlayer();
						counter++;
					}
				}
			} while (counter<9);
			if (counter==9 && !(ticTac.rowCheck() || ticTac.colCheck() || ticTac.diagnolCheck())) {
				System.out.println("Game is being draw");
			}
			else {
				System.out.println("User "+ticTac.currentPlayer+" won");
			}
			System.out.println("Press Y if you want to play again");
			again=scanner.next();
		} while (again.equalsIgnoreCase("y"));
		
		
	//	System.out.println(firstNumber);
		//System.out.println(secondNumber);
		
	}

}
