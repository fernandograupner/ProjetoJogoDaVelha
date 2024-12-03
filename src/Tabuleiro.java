class Tabuleiro {
        private char[][] tabuleiro;
        private char jogadorAtual;

        public Tabuleiro() {
            tabuleiro = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    tabuleiro[i][j] = ' ';
                }
            }
            jogadorAtual = 'X';
        }

        public char getJogadorAtual() {
            return jogadorAtual;
        }

        public void alternarJogador() {
            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
        }

        public boolean realizarJogada(int linha, int coluna) {
            if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3 || tabuleiro[linha][coluna] != ' ') {
                return false;
            }
            tabuleiro[linha][coluna] = jogadorAtual;
            return true;
        }

        public boolean verificarVencedor() {
            for (int i = 0; i < 3; i++) {
                // Verifica linhas
                if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                    return true;
                }
                // Verifica colunas
                if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual) {
                    return true;
                }
            }
            // Verifica diagonais
            if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) {
                return true;
            }
            if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
                return true;
            }
            return false;
        }

        public boolean verificarEmpate() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tabuleiro[i][j] == ' ') {
                        return false;
                    }
                }
            }
            return true;
        }

        public void imprimirTabuleiro() {
            System.out.println(" 1   2   3 ");
            for (int i = 0; i < 3; i++) {
                System.out.println(" " + tabuleiro[i][0] + " | " + tabuleiro[i][1] + " | " + tabuleiro[i][2]);
                if (i < 2) {
                    System.out.println("---+---+---");
                }
            }
        }
}
