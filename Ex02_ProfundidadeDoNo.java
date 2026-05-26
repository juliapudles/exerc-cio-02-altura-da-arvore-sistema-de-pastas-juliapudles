public class Ex02_ProfundidadeDoNo {

    static class No {
        int id;
        No esquerda;
        No direita;

        No(int id) {
            this.id = id;
        }
    }

    //funcao publica que o main vai chamar
    static int profundidade(No raiz, int alvo) {
        return profundidadeAux(raiz, alvo, 0);
    }

    //funcao auxiliar que carrega o nivel atual
    static int profundidadeAux(No atual, int alvo, int nivel) {
        //no nao existe, retorna -1 que significa "nao encontrado"
        if (atual == null) {
            return -1;
        }

        //achou o alvo, retorna o nivel em que esta
        if (atual.id == alvo) {
            return nivel;
        }

        //busca no lado esquerdo
        int resultadoEsquerda = profundidadeAux(atual.esquerda, alvo, nivel + 1);

        //se achou na esquerda, ja retorna
        if (resultadoEsquerda != -1) {
            return resultadoEsquerda;
        }

        //senao busca no lado direito
        return profundidadeAux(atual.direita, alvo, nivel + 1);
    }

    public static void main(String[] args) {
        //montando a arvore
        No raiz = new No(1);
        raiz.esquerda = new No(2);
        raiz.direita = new No(3);
        raiz.esquerda.esquerda = new No(4);

        System.out.println("Profundidade do no 1 (raiz): " + profundidade(raiz, 1));
        //esperado: 0

        System.out.println("Profundidade do no 2: " + profundidade(raiz, 2));
        //esperado: 1

        System.out.println("Profundidade do no 4: " + profundidade(raiz, 4));
        //esperado: 2

        System.out.println("Profundidade do no 99 (nao existe): " + profundidade(raiz, 99));
        //esperado: -1
    }
}