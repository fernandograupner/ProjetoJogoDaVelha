import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        Scanner scanner = new Scanner(System.in);
        boolean jogoAtivo = true;

        System.out.println("Bem-vindo ao Jogo da Velha!");

        while (jogoAtivo) {
            tabuleiro.imprimirTabuleiro();
            System.out.println("Jogador " + tabuleiro.getJogadorAtual() + ", insira sua jogada (linha de 1 a 3):");
            int linha = scanner.nextInt() - 1;
            System.out.println("Jogador " + tabuleiro.getJogadorAtual() + ", insira sua jogada (coluna de 1 a 3):");
            int coluna = scanner.nextInt() - 1;

            if (!tabuleiro.realizarJogada(linha, coluna)) {
                System.out.println("Jogada inválida! Tente novamente.");
                continue;
            }

            if (tabuleiro.verificarVencedor()) {
                tabuleiro.imprimirTabuleiro();
                System.out.println("Parabéns, jogador " + tabuleiro.getJogadorAtual() + "! Você venceu!");
                jogoAtivo = false;
            } else if (tabuleiro.verificarEmpate()) {
                tabuleiro.imprimirTabuleiro();
                System.out.println("O jogo terminou em empate!");
                jogoAtivo = false;
            } else {
                tabuleiro.alternarJogador();
            }
        }

        scanner.close();
        System.out.println("Fim do jogo.");
    }
}