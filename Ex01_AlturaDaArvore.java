public class Ex01_AlturaDaArvore {

    static class No {
        String nome;
        No esquerda;
        No direita;

        No(String nome) {
            this.nome = nome;
        }
    }

    static int altura(No raiz) {
        //se a arvore esta vazia, altura e zero
        if (raiz == null) {
            return 0;
        }

        //desce pelos dois lados
        int alturaEsquerda = altura(raiz.esquerda);
        int alturaDireita = altura(raiz.direita);

        //pega o maior lado e soma 1 pelo no atual
        int maiorAltura = Math.max(alturaEsquerda, alturaDireita);
        return 1 + maiorAltura;
    }

    public static void main(String[] args) {
        //montando a arvore
        No raiz = new No("Empresa");
        raiz.esquerda = new No("RH");
        raiz.direita = new No("TI");
        raiz.esquerda.esquerda = new No("Recrutamento");

        System.out.println("Altura da arvore: " + altura(raiz));
        //esperado: 3

        System.out.println("Altura da arvore vazia: " + altura(null));
        //esperado: 0
    }
}