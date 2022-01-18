/**
 * @author Neal Tamayao Acoba
 * @version 1.0
 */
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minijuegos {
	
	static ArrayList<Integer> p1Pos = new ArrayList<Integer>();
	static ArrayList<Integer> p2Pos = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rng = new Random();
		int usrChoice = 0;
		int gameChoice = 0;
		int setChoice = 0;
		
		System.out.println("Minijuegos");
		System.out.println();
		
		do {
			usrChoice = opcionDeMenu(scan, usrChoice);
			
			if (usrChoice < 1 || usrChoice > 5) {
				System.out.println("Unknown option. Try again.");
			}
			else {
				if (usrChoice == 1) {
					opcionDeJuegos(scan, rng, gameChoice, setChoice);
				}
				
				else if (usrChoice == 2) {
					System.out.println("Minijuegos en Java");
					System.out.println("Programado con Eclipse para la UF2 de MP03.");
					System.out.println("All rights reserved. ™ ® © 2021");
					System.out.println();
				}
				
				else if (usrChoice == 3) {
					System.out.println("Autor: Yamanagi Kira");
					System.out.println();
				}
				
				else if (usrChoice == 4) {
					System.out.println("Versión 1.0");
					System.out.println();
				}
				
				else if (usrChoice == 5) {
					System.out.println("¡Gracias por jugar! Hasta la proxima vez.");
					System.exit(0);
				}
			}
			System.out.println();
		} while (usrChoice != 5);
		
		scan.close();

	}
	
	public static int opcionDeMenu(Scanner scan, int mOpt) {
		System.out.println("1 - Jugar");
		System.out.println("2 - Información");
		System.out.println("3 - Autor");
		System.out.println("4 - Versión");
		System.out.println("5 - Salir");
		System.out.printf("Opción: ");
		mOpt = scan.nextInt();
		System.out.println();
		return mOpt;
	}
	
	public static void opcionDeJuegos(Scanner scan, Random cpu, int gOpt, int sOpt) {
		do {
			System.out.println("1 - Janken");
			System.out.println("2 - Buscaminas");
			System.out.println("3 - 3 en raya");
			System.out.println("4 - Volver");
			System.out.printf("Opción: ");
			gOpt = scan.nextInt();
			System.out.println();
			
			if (gOpt == 1) {
				System.out.println("Janken");
				System.out.println();
				sOpt = opcionDeModo(scan, sOpt);
				if (sOpt == 1) {
					janken2P(scan);
				}
				
				else if (sOpt == 2) {
					jankenVsAI(scan, cpu);
				}
				
				else if (sOpt == 3) {
					break;
				}
			}
			
			else if (gOpt == 2) {
				System.out.println("Buscaminas 10x10");
				System.out.println();
				juegoBuscaminas(scan, cpu);
			}
			
			else if (gOpt == 3) {
				System.out.println("3 en raya PvP");
				System.out.println();
				juego3EnRaya(scan);
			}
			
			else if (gOpt == 4) {
				break;
			}
			
			else if (gOpt > 4 || gOpt < 1) {
				System.out.println("Unknown option. Try again.");
			}
			System.out.println();
		} while (gOpt != 4);
	}
	
	public static int opcionDeModo(Scanner scan, int sOpt) {
		System.out.println("1 - 2 jugadores");
		System.out.println("2 - vs AI");
		System.out.println("3 - Volver");
		System.out.printf("Opción: ");
		sOpt = scan.nextInt();
		System.out.println();
		if (sOpt > 4 || sOpt < 1) {
			System.out.println("Unknown option. Try again.");
		}
		System.out.println();
		return sOpt;
	}
	
	public static void janken2P(Scanner scan) {
		char retry = ' ';
		do {
			scan.nextLine();
			System.out.printf("Introduce el nombre del P1: ");
			String player1 = scan.nextLine();
			System.out.println("El nombre del P1 es " + player1 + ".");
			System.out.println();
			
			System.out.printf("Introduce el nombre del P2: ");
			String player2 = scan.nextLine();
			System.out.println("El nombre del P2 es " + player2 + ".");
			System.out.println();
			
			String item1 = "Piedra";
			String item2 = "Papel";
			String item3 = "Tijeras";
			
			System.out.printf("Introduce el elección del P1 (1 - Piedra, 2 - Papel, 3 - Tijeras): ");
			int p1item = scan.nextInt();
			System.out.println();
			
			if (p1item == 1) {
				System.out.println(player1 + " ha elegido " + item1 + ".");
			}
			else if (p1item == 2) {
				System.out.println(player1 + " ha elegido " + item2 + ".");
			}
			else if (p1item == 3) {
				System.out.println(player1 + " ha elegido " + item3 + ".");
			}
			else {
				while (p1item > 3 || p1item < 1) {
					System.out.println("Ha introducido una elección error.");
					System.out.printf("Introducir una elección correcta: ");
					p1item = scan.nextInt();
					System.out.println();
					if (p1item == 1) {
						System.out.println(player1 + " ha elegido " + item1 + ".");
						break;
					}
					else if (p1item == 2) {
						System.out.println(player1 + " ha elegido " + item2 + ".");
						break;
					}
					else if (p1item == 3) {
						System.out.println(player1 + " ha elegido " + item3 + ".");
						break;
					}
				}
			}
			System.out.println();
			
			System.out.printf("Introduce el elección del P2 (1 - Piedra, 2 - Papel, 3 - Tijeras): ");
			int p2item = scan.nextInt();
			System.out.println();
			
			if (p2item == 1) {
				System.out.println(player2 + " ha elegido " + item1 + ".");
			}
			else if (p2item == 2) {
				System.out.println(player2 + " ha elegido " + item2 + ".");
			}
			else if (p2item == 3) {
				System.out.println(player2 + " ha elegido " + item3 + ".");
			}
			else {
				while (p2item > 3 || p2item < 1) {
					System.out.println("Ha introducido una elección error.");
					System.out.printf("Introducir una elección correcta: ");
					p2item = scan.nextInt();
					System.out.println();
					if (p2item == 1) {
						System.out.println(player1 + " ha elegido " + item1 + ".");
						break;
					}
					else if (p2item == 2) {
						System.out.println(player1 + " ha elegido " + item2 + ".");
						break;
					}
					else if (p2item == 3) {
						System.out.println(player1 + " ha elegido " + item3 + ".");
						break;
					}
				}
			}
			System.out.println();
			
			if (p1item == p2item) {
				System.out.println(player1 + " y " + player2 + " están empatados.");
			}
			else if (p1item == 1) {
				if (p2item == 2) {
					System.out.println(player2 + " es el/la ganador/a.");
				}
				else if (p2item == 3) {
					System.out.println(player1 + " es el/la ganador/a.");
				}
			}
			else if (p1item == 2) {
				if (p2item == 1) {
					System.out.println(player1 + " es el/la ganador/a.");
				}
				else if (p2item == 3) {
					System.out.println(player2 + " es el/la ganador/a.");
				}
			}
			else if (p1item == 3) {
				if (p2item == 1) {
					System.out.println(player2 + " es el/la ganador/a.");
				}
				else if (p2item == 2) {
					System.out.println(player1 + " es el/la ganador/a.");
				}
			}
			System.out.println();
			
			System.out.printf("¿Jugáis otra vez? (y/n): ");
			retry = scan.next().charAt(0);
			
			if (retry == 'y' || retry == 'Y') {
				System.out.println();
			}
			else if (retry == 'n' || retry == 'N') {
				System.out.println();
				break;
			}
		} while (retry != 'n' || retry != 'N');
	}
	
	public static void jankenVsAI(Scanner scan, Random cpu) {
		char retry = ' ';
		do {
			scan.nextLine();
			System.out.printf("Introduce el nombre del jugador: ");
			String player = scan.nextLine();
			System.out.println();
			System.out.println(player + ", let's go!");
			System.out.println();
			
			String item1 = "Piedra";
			String item2 = "Papel";
			String item3 = "Tijeras";
			
			System.out.printf("Es tu turno (1 - Piedra, 2 - Papel, 3 - Tijeras): ");
			int playeritem = scan.nextInt();
			System.out.println();
			
			if (playeritem == 1) {
				System.out.println("Has elegido " + item1 + ".");
			}
			else if (playeritem == 2) {
				System.out.println("Has elegido " + item2 + ".");
			}
			else if (playeritem == 3) {
				System.out.println("Has elegido " + item3 + ".");
			}
			else {
				while (playeritem > 3 || playeritem < 1) {
					System.out.println("Ha introducido una elección error.");
					System.out.printf("Introducir una elección correcta: ");
					playeritem = scan.nextInt();
					System.out.println();
					if (playeritem == 1) {
						System.out.println(player + " ha elegido " + item1 + ".");
						break;
					}
					else if (playeritem == 2) {
						System.out.println(player + " ha elegido " + item2 + ".");
						break;
					}
					else if (playeritem == 3) {
						System.out.println(player + " ha elegido " + item3 + ".");
						break;
					}
				}
			}
			System.out.println();
			
			int cpuitem = cpu.nextInt(3)+1;
			
			if (cpuitem == 1) {
				System.out.println("He elegido " + item1 + ".");
			}
			else if (cpuitem == 2) {
				System.out.println("He elegido " + item2 + ".");
			}
			else if (cpuitem == 3) {
				System.out.println("He elegido " + item3 + ".");
			}
			System.out.println();
			
			if (playeritem == cpuitem) {
				System.out.println("Estamos empatados.");
			}
			else if (playeritem == 1) { 
				if (cpuitem == 2) {
					System.out.println("Yo gané. Mejor suerte la próxima vez, " + player + ".");
				}
				else if (cpuitem == 3) {
					System.out.println("Yo perdí. GG, " + player + ".");
				}
			}
			else if (playeritem == 2) {
				if (cpuitem == 1) {
					System.out.println("Yo perdí. GG, " + player + ".");
				}
				else if (cpuitem == 3) {
					System.out.println("Yo gané. Mejor suerte la próxima vez, " + player + ".");
				}
			}
			else if (playeritem == 3) {
				if (cpuitem == 1) {
					System.out.println("Yo gané. Mejor suerte la próxima vez, " + player + ".");
				}
				else if (cpuitem == 2) {
					System.out.println("Yo perdí. GG, " + player + ".");
				}
			}
			System.out.println();
			
			System.out.printf("¿Juegas otra vez? (y/n): ");
			retry = scan.next().charAt(0);
			
			if (retry == 'y' || retry == 'Y') {
				System.out.println();
			}
			else if (retry == 'n' || retry == 'N') {
				System.out.println();
				break;
			}
		}while (retry != 'n' || retry != 'N');
	}
	
	public static void juegoBuscaminas(Scanner scan, Random rng) {
		char retry = ' ';
		do {
			int[][] matrix = new int [10][10];
			int[][] userMatrix = new int[10][10];
			
			matrix = rngMatrix(rng, matrix);
			
			userMatrix = zeroMatrix(userMatrix);
			System.out.println();
			
			int matrixRow = 0;
			matrixRow = pedirFilaYColumna(scan, "Dime la fila (0 a 9): ");
			int matrixColumn = 0; 
			matrixColumn = pedirFilaYColumna(scan, "Dime la columna (0 a 9): ");
			
			int counter = 0;
			while (counter < matrix.length) {
				if (matrix[matrixRow][matrixColumn] == 0) {
					System.out.println();
					System.out.println("No es bomba.");
					for (int i = 0; i < userMatrix.length; i++) {
						for (int j = 0; j < userMatrix[i].length; j++) {
							userMatrix[matrixRow][matrixColumn] = 2;
							System.out.print(userMatrix[i][j] + " ");
						}
						System.out.println();
					}
					System.out.println();
					matrixRow = pedirFilaYColumna(scan, "Dime la fila (0 a 9): ");
					matrixColumn = pedirFilaYColumna(scan, "Dime la columna (0 a 9): ");
					counter++;
				}
				else {
					System.out.println();
					System.out.println("¡Has perdido!");
					for (int i = 0; i < userMatrix.length; i++) {
						for (int j = 0; j < userMatrix[i].length; j++) {
							userMatrix[matrixRow][matrixColumn] = 3;
							System.out.print(userMatrix[i][j] + " ");
						}
						System.out.println();
					}
					break;
				}
			}
			System.out.println();
			
			System.out.printf("¿Juegas otra vez? (y/n): ");
			retry = scan.next().charAt(0);
			
			if (retry == 'y' || retry == 'Y') {
				System.out.println();
			}
			else if (retry == 'n' || retry == 'N') {
				System.out.println();
				break;
			}
		}while (retry != 'n' || retry != 'N');
	}
	
	public static int[][] rngMatrix(Random rng, int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				float mineProb = rng.nextFloat();
				if (mineProb < 1.0f && mineProb > 0.10f) {
					matrix[i][j] = 0;
				}
				else {
					matrix[i][j] = 1;
				}
			}
		}
		
		return matrix;
	}
	
	public static int[][] zeroMatrix(int[][] matrix2) {
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2[i].length; j++) {
				matrix2[i][j] = 0;
				System.out.print(matrix2[i][j] + " ");
			}
			System.out.println();
		}
		
		return matrix2;
	}
	
	public static int pedirFilaYColumna(Scanner scan, String msg) {
		System.out.printf(msg);
		int num = scan.nextInt();
		
		return num;
	}
	
	public static void juego3EnRaya(Scanner scan) {
		char retry = ' ';
		do {
			char[][] board = {{' ', '|', ' ', '|', ' '},
					{'-','+','-','+','-'},
					{' ', '|', ' ', '|', ' '},
					{'-','+','-','+','-'},
					{' ', '|', ' ', '|', ' '}};
			
			printBoard(board);
			System.out.println();
			
			while (true) {
				System.out.printf("Introduce el puesto de P1 (1-9): ");
				int p1In = scan.nextInt();
				while (p1Pos.contains(p1In) || p2Pos.contains(p1In)) {
					System.out.printf("Posicion tomada. introduce otro posicion: ");
					p1In = scan.nextInt();
				}
				playerPiece(board, p1In, "P1");
				System.out.println();
				printBoard(board);
				String winner = winChkr();
				System.out.println();
				if (winner.length() > 0) {
					System.out.println(winner);
					break;
				}
				System.out.printf("Introduce el puesto de P2 (1-9): ");
				int p2In = scan.nextInt();
				while (p2Pos.contains(p2In) || p1Pos.contains(p2In)) {
					System.out.printf("Posicion tomada. introduce otro posicion: ");
					p2In = scan.nextInt();
				}
				playerPiece(board, p2In, "P2");
				System.out.println();
				printBoard(board);
				winner = winChkr();
				System.out.println();
				if (winner.length() > 0) {
					System.out.println(winner);
					break;
				}
			}
			System.out.println();
			
			System.out.printf("¿Jugáis otra vez? (y/n): ");
			retry = scan.next().charAt(0);
			
			if (retry == 'y' || retry == 'Y') {
				System.out.println();
			}
			else if (retry == 'n' || retry == 'N') {
				System.out.println();
				break;
			}
		}while (retry != 'n' || retry != 'N');
	}
	
	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void playerPiece(char[][] board, int pos, String user) {
		char piece = ' '; 
		if (user.equals("P1")) {
			piece = 'X';
			p1Pos.add(pos);
		}
		else if (user.equals("P2")) {
			piece = 'O';
			p2Pos.add(pos);
		}
		
		switch (pos) {
			case 1:
				board[0][0] = piece;
				break;
			case 2:
				board[0][2] = piece;
				break;
			case 3:
				board[0][4] = piece;
				break;
			case 4:
				board[2][0] = piece;
				break;
			case 5:
				board[2][2] = piece;
				break;
			case 6:
				board[2][4] = piece;
				break;
			case 7:
				board[4][0] = piece;
				break;
			case 8:
				board[4][2] = piece;
				break;
			case 9:
				board[4][4] = piece;
				break;
			default:
				break;
		}
	}
	
	public static String winChkr() {
		List tRow = Arrays.asList(1, 2, 3);
		List mRow = Arrays.asList(4, 5, 6);
		List bRow = Arrays.asList(7, 8, 9);
		List lCol = Arrays.asList(1, 4, 7);
		List mCol = Arrays.asList(2, 5, 8);
		List rCol = Arrays.asList(3, 6, 9);
		List diagonal1 = Arrays.asList(1, 5, 9);
		List diagonal2 = Arrays.asList(3, 5, 7);
		
		List<List> winningLine = new ArrayList<List>();
		winningLine.add(tRow);
		winningLine.add(mRow);
		winningLine.add(bRow);
		winningLine.add(lCol);
		winningLine.add(mCol);
		winningLine.add(rCol);
		winningLine.add(diagonal1);
		winningLine.add(diagonal2);
		
		for (List win : winningLine) {
			if (p1Pos.containsAll(win)) {
				return "P1 ha ganado.";
			}
			
			else if (p2Pos.containsAll(win)) {
				return "P2 ha ganado.";
			}
			
			else if (p1Pos.size() + p2Pos.size() == 9) {
				return "Estan empatados.";
			}
		}
		
		return "";
	}

}
