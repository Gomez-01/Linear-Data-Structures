public class Main {
    public static void main(String[] args) {

        // Testes No Duplo(ou Simples)
        No_Duplo teste = new No_Duplo();
        System.out.println(teste.estaVazia());
        teste.inserirInicio(1);
        teste.inserirInicio(2);
        teste.inserirInicio(3);
        teste.inserirInicio(4);
        teste.imprimirLista();
        teste.inserirFim(6);
        System.out.println(teste.estaVazia());
        teste.imprimirLista();
        teste.removerFim();
        teste.imprimirLista();
        teste.removerInicio();
        teste.imprimirLista();
        teste.removerInicio();
        teste.removerInicio();
        teste.imprimirLista();
        teste.removerInicio();
        teste.imprimirLista();
        teste.removerInicio();

    }
}