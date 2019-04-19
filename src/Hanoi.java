import java.util.List;
import java.util.Scanner;

public class Hanoi {

	public static void main(String[] args) {
		String linha = "";
		boolean sair = false;
		String entrada = "";
		String origem = "";
		String destino = "";
		int discos = 3;
		int torreA[] = {0,0,0,0,0,0};
		int torreB[] = {0,0,0,0,0,0};
		int torreC[] = {0,0,0,0,0,0};
		int movimentos = 0;
		int ideaisMov = 0;
		
		Scanner ler = new Scanner (System.in);
		
		System.out.println("Torre de Hanoi");
		System.out.println("O objetivo do jogo é mover todos os discos da torre A para a torre C.");
		System.out.println("Regra 1: Só é possível mover um disco por vez");
		System.out.println("Regra 2: Um disco maior não pode ficar sobre um disco menor");
		System.out.println("Para mover: [torre origem][torre destino] exemplo: ab ");
		System.out.println("");
		System.out.println("Quantidade de discos (Entre 3 e 6):  ");
		discos = ler.nextInt();
		
		if(discos > 6) {
			discos = 6;
		}
		if(discos < 3) {
			discos = 3;
		}
		ideaisMov = (int) (Math.pow(2,discos)- 1);
		
		torreA = inicializar(torreA, discos);
		
		while(!sair) {
			for (int i = 5; i >= 0 ; i--) {
				linha = "";
				linha =  linha + desenhoTorre(torreA[i]);
				linha =  linha + desenhoTorre(torreB[i]);
				linha =  linha + desenhoTorre(torreC[i]);
				System.out.println(linha);
			}
			System.out.println(repetir(33,"-"));
			System.out.println(repetir(5 , " ") + "A" + repetir(10, " ") + "B" + repetir( 10, " ") + "C" );
			System.out.println("movimentos: " + movimentos);
			if(valorTopo(torreC)==1 && indiceTopo(torreC) == discos-1) {
				System.out.println(" Você ganhou");
				System.out.println(" em " + movimentos + " movimentos. ");
				System.out.println("A quantidade ideal de movimentos é " + ideaisMov);
				sair =  true;	
			}
			else {
				entrada = ler.next();
				if(entrada.equalsIgnoreCase("sair")) {
					sair = true;
				}
				else if(entrada.length() == 2) {
					origem = entrada.substring(0, 1);
					destino = entrada.substring(1);
					if(origem.equalsIgnoreCase("a")) {
						if(destino.equalsIgnoreCase("b")) {
							if(valorTopo(torreA) < valorTopo(torreB)) {
								torreB[indiceTopo(torreB)+1] = torreA[indiceTopo(torreA)];
								torreA[indiceTopo(torreA)] = 0;
								movimentos = movimentos +1;
							}
						}
						else if(destino.equalsIgnoreCase("c")) {
							if(valorTopo(torreA) < valorTopo(torreC)) {
								torreC[indiceTopo(torreC)+1] = torreA[indiceTopo(torreA)];
								torreA[indiceTopo(torreA)] = 0;
								movimentos = movimentos +1;
							}
						}
					}
					else if (origem.equalsIgnoreCase("b")) {
						if(destino.equalsIgnoreCase("a")) {
							if(valorTopo(torreB) < valorTopo(torreA)) {
								torreA[indiceTopo(torreA)+1] = torreB[indiceTopo(torreB)];
								torreB[indiceTopo(torreB)] = 0;
								movimentos = movimentos +1;
							}	
						}
						else if(destino.equalsIgnoreCase("c")) {
							if(valorTopo(torreB) < valorTopo(torreC)) {
								torreC[indiceTopo(torreC)+1] = torreB[indiceTopo(torreB)];
								torreB[indiceTopo(torreB)] = 0;
								movimentos = movimentos +1;
							}	
						}	
					}
					else if (origem.equalsIgnoreCase("c")) {
						if(destino.equalsIgnoreCase("b")) {
							if(valorTopo(torreC) < valorTopo(torreB)) {
								torreB[indiceTopo(torreB)+1] = torreC[indiceTopo(torreC)];
								torreC[indiceTopo(torreC)] = 0;
								movimentos = movimentos +1;
							}		
						}
						else if(destino.equalsIgnoreCase("a")) {
							if(valorTopo(torreC) < valorTopo(torreA)) {
								torreA[indiceTopo(torreA)+1] = torreC[indiceTopo(torreC)];
								torreC[indiceTopo(torreC)] = 0;
								movimentos = movimentos +1;
							}	
						}
					}
				}
			}
			
		}
		
		

	}
	
	public static int[] inicializar(int torre[],int quantDiscos){
		int tam = quantDiscos;
		for (int i = 0; i < quantDiscos; i++) {
			torre[i] = tam;
			tam--;
		}
		return torre;		
	}
	public static String desenhoTorre(int disco) {
		switch (disco) {
			case 1:
				return "     #     ";
			case 2:
				return "    ###    ";
			case 3:
				return "   #####   ";
			case 4:
				return "  #######  ";
			case 5:
				return " ######### ";
			case 6:
				return "###########";	
			default:
				return "     |     ";
		}
	}
	public static String repetir(int quant, String entrada) {
		String resultado = "";
		for (int i = 0; i < quant ; i++) {
			resultado = resultado + entrada;
		}
		return resultado;
	}
	public static int valorTopo(int torre[]) {
		for (int i = torre.length - 1; i >= 0; i--) {
			if(torre[i] != 0) {
				return torre[i];
			}	
		} 
		return 7;
	}
	public static int indiceTopo(int torre[]) {
		for (int i = torre.length - 1; i >= 0; i--) {
			if(torre[i] != 0) {
				return i;
			}	
		} 
		return -1;
	}
}

