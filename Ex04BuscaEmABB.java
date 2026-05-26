public class Ex04_BuscaEmABB {

    static class No {
        int codigo;
        No esquerda;
        No direita;

        No(int codigo) {
            this.codigo = codigo;
        }
    }

    //insere um novo codigo respeitando as regras da ABB
    //menores vao para esquerda, maiores para direita
    static No inserir(No atual, int codigo) {
        if (atual == null) {
            return new No(codigo);
        }

        if (codigo < atual.codigo) {
            atual.esquerda = inserir(atual.esquerda, codigo);
        } else if (codigo > atual.codigo) {
            atual.direita = inserir(atual.direita, codigo);
        }

        return atual;
    }

    //busca um codigo na ABB sem precisar ver todos os nos
    static boolean buscar(No raiz, int codigo) {
        No atual = raiz;

        while (atual != null) {
            //achou o produto
            if (codigo == atual.codigo) {
                return true;
            }

            //se o codigo e menor, vai para esquerda
            if (codigo < atual.codigo) {
                atual = atual.esquerda;
            } else {
                //se e maior, vai para direita
                atual = atual.direita;
            }
        }

        //saiu do laco sem achar, produto nao existe
        return false;
    }

    public static void main(String[] args) {
        //montando a ABB inserindo os codigos
        No raiz = null;
        raiz = inserir(raiz, 50);
        raiz = inserir(raiz, 30);
        raiz = inserir(raiz, 70);
        raiz = inserir(raiz, 20);
        raiz = inserir(raiz, 40);

        System.out.println("Busca pelo codigo 40: " + buscar(raiz, 40));
        //esperado: true

        System.out.println("Busca pelo codigo 70: " + buscar(raiz, 70));
        //esperado: true

        System.out.println("Busca pelo codigo 99: " + buscar(raiz, 99));
        //esperado: false
    }
}