public class ListNode {

    private Node refNode;
    private int length = 0;

    /**
     * Adiciona um novo conteúdo no início da lista.
     */
    public void add(String content) {
        Node newNode = new Node();
        newNode.content = content;
        newNode.prox = this.refNode;
        this.refNode = newNode;
        this.length++;
    }

    /**
     * Remove o primeiro nó da lista e o retorna.
     */
    public Node remove() {
        if (this.refNode == null) {
            return null;
        }
        this.length--;
        Node rem = this.refNode;
        this.refNode = this.refNode.prox;
        return rem;
    }

    /**
     * Imprime a lista de conteúdos.
     */
    public void imprimir() {
        System.out.println("Lista Normal/invertida:");
        Node currentNode = this.refNode;
        while (currentNode != null) {
            System.out.println(currentNode.content);
            currentNode = currentNode.prox;
        }
    }

    /**
     * Retorna uma lista invertida da lista original.
     */
    public ListNode invert() {
        ListNode invertedList = new ListNode();
        Node currentNode = this.refNode;
        while (currentNode != null) {
            invertedList.add(currentNode.content);
            currentNode = currentNode.prox;
        }
        return invertedList;
    }

    /**
     * Adiciona um novo conteúdo na posição i da lista.
     * Se a posição for inválida, o conteúdo é adicionado no início.
     */
    public void add(String content, int i) {
        if (i <= 0 || i > this.length + 1) {
            add(content);
            return;
        }

        if (i == 1) {
            Node newNode = new Node();
            newNode.content = content;
            newNode.prox = this.refNode;
            this.refNode = newNode;
            this.length++;
            return;
        }

        Node newNode = new Node();
        newNode.content = content;

        Node currentNode = this.refNode;
        for (int count = 1; count < i - 1; count++) {
            currentNode = currentNode.prox;
        }

        newNode.prox = currentNode.prox;
        currentNode.prox = newNode;
        this.length++;
    }

    /**
     * Substitui o conteúdo do nó na posição i da lista.
     * Se a posição for inválida, não faz nada.
     */
    public void replace(String content, int i) {
        if (i < 1 || i > this.length) {
            return;
        }

        Node currentNode = this.refNode;
        for (int count = 1; count < i; count++) {
            currentNode = currentNode.prox;
        }

        currentNode.content = content;
    }

    /**
     * Retorna uma nova lista com a quantidade de elementos especificada por length,
     * todos com o mesmo conteúdo.
     */
    public ListNode newList(int length, String content) {
        ListNode newList = new ListNode();
        for (int i = 0; i < length; i++) {
            newList.add(content);
        }
        return newList;
    }

    /**
     * Retorna o nó na posição i da lista.
     */
    public Node getNode(int i) {
        if (i < 0 || i >= this.length) {
            return null;
        }

        Node currentNode = this.refNode;
        for (int count = 0; count < i; count++) {
            currentNode = currentNode.prox;
        }

        return currentNode;
    }

    /**
     * Classe interna que representa um nó da lista.
     */
    private class Node {
        private String content;
        private Node prox;
    }

    /**
     * Método principal para testar a classe ListNode.
     */
    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.add("Prova");
        list.add("Lista");
        list.add("Invertida");

        list.imprimir();

        ListNode invertedList = list.invert();
        invertedList.imprimir();
    }

}
