package main;

public class TestePilha {
    public static void main(String[] args) {
        Pilha pilhaIdoso = new Pilha(TipoLista.IDOSO);

        pilhaIdoso.inserir();
        pilhaIdoso.inserir();
        pilhaIdoso.inserir();

        System.out.println("Senhas na pilha IDOSO:");
        System.out.println(pilhaIdoso.listar());

        // Chamar uma senha
        pilhaIdoso.chamar();

        System.out.println("Senhas na pilha IDOSO após chamar uma senha:");
        System.out.println(pilhaIdoso.listar());

        // Listar as senhas na pilha após chamar uma senha
        System.out.println("Senhas na pilha IDOSO após chamar uma senha:");
        System.out.println(pilhaIdoso.listar());

        // Atender a próxima senha
        System.out.println(pilhaIdoso.atender());

        // Listar as senhas na pilha após atender uma senha
        System.out.println("Senhas na pilha IDOSO após atender uma senha:");
        System.out.println(pilhaIdoso.listar());
    }

}
