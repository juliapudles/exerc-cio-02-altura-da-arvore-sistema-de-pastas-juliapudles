import java.util.ArrayList;
import java.util.List;

public class Ex05PreOrdem {

    static class No {
        String etapa;
        No esquerda;
        No direita;

        No(String etapa) {
            this.etapa = etapa;
        }
    }

    //funcao auxiliar que faz o percurso de verdade
    //ordem: no atual -> esquerda -> direita
    static void preOrdemRec(No atual, List<String> resultado) {
        //se chegou em no inexistente, para
        if (atual == null) {
            return;
        }

        //adiciona o no atual antes de descer
        resultado.add(atual.etapa);

        //desce para esquerda
        preOrdemRec(atual.esquerda, resultado);

        //desce para direita
        preOrdemRec(atual.direita, resultado);
    }

    //funcao principal que o main vai chamar
    static List<String> preOrdem(No raiz) {
        List<String> resultado = new ArrayList<>();
        preOrdemRec(raiz, resultado);
        return resultado;
    }

    public static void main(String[] args) {
        //montando a arvore
        No raiz = new No("Build");
        raiz.esquerda = new No("Testes");
        raiz.direita = new No("Deploy");
        raiz.esquerda.esquerda = new No("Lint");

        List<String> ordem = preOrdem(raiz);

        System.out.println("Ordem de execucao: " + ordem);
        //esperado: [Build, Testes, Lint, Deploy]
    }
}