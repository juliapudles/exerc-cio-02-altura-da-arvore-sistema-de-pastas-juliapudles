public class Ex03AlturaDeUmNo {

    static class No {
        int id;
        No esquerda;
        No direita;

        No(int id) {
            this.id = id;
        }
    }

    //busca e retorna o no com o id alvo, ou null se nao achar
    static No buscarNo(No atual, int alvo) {
        if (atual == null) {
            return null;
        }

        if (atual.id == alvo) {
            return atual;
        }

        //tenta achar na esquerda primeiro
        No resultadoEsquerda = buscarNo(atual.esquerda, alvo);
        if (resultadoEsquerda != null) {
            return resultadoEsquerda;
        }

        //se nao achou na esquerda, tenta na direita
        return buscarNo(atual.direita, alvo);
    }

    //calcula a altura a partir de um no especifico
    static int alturaSubarvore(No raiz) {
        if (raiz == null) {
            return 0;
        }

        int alturaEsquerda = alturaSubarvore(raiz.esquerda);
        int alturaDireita = alturaSubarvore(raiz.direita);

        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    //funcao principal: acha o no e mede a altura dele
    static int alturaDoNo(No raiz, int alvo) {
        //primeiro busca o no alvo
        No noAlvo = buscarNo(raiz, alvo);

        //se nao achou, retorna -1
        if (noAlvo == null) {
            return -1;
        }

        //se achou, mede a altura a partir dele
        return alturaSubarvore(noAlvo);
    }

    public static void main(String[] args) {
        //montando a arvore
        No raiz = new No(1);
        raiz.esquerda = new No(2);
        raiz.direita = new No(3);
        raiz.esquerda.esquerda = new No(4);
        raiz.esquerda.direita = new No(5);

        System.out.println("Altura do no 1 (raiz): " + alturaDoNo(raiz, 1));
        //esperado: 3

        System.out.println("Altura do no 2: " + alturaDoNo(raiz, 2));
        //esperado: 2

        System.out.println("Altura do no 4 (folha): " + alturaDoNo(raiz, 4));
        //esperado: 1

        System.out.println("Altura do no 99 (nao existe): " + alturaDoNo(raiz, 99));
        //esperado: -1
    }
}