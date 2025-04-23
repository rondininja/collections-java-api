package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarrinhoDeCompras {
    //atributo

    private List<Item> itemList;

    public CarrinhoDeCompras(){
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add(item);
    }

    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();
        if (!this.itemList.isEmpty()) {
            Iterator var3 = this.itemList.iterator();

            while (var3.hasNext()) {
                Item i = (Item)var3.next();
                if (i.getNome().equalsIgnoreCase(nome)){
                    itensParaRemover.add(i);
                }
            }

            this.itemList.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        if (this.itemList.isEmpty()) {
            throw new RuntimeException("A lista está vazia!");
        } else {
            double valorItem;
            for(Iterator var3 = this.itemList.iterator(); var3.hasNext(); valorTotal += valorItem) {
                Item item = (Item)var3.next();
                valorItem = item.getPreco() * (double) item.getQuantidade();
            }

            return valorTotal;
        }
    }

    public void exibirItens() {
        if (!this.itemList.isEmpty()) {
            System.out.println(this.itemList);
        } else {
            System.out.println("A lista está vazia!");
        }

    }

    public String toString() {
        return "CarrinhoDeCompras{itens=" + this.itemList + "}";
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.adicionarItem("Lápis", 2.0, 3);
        carrinhoDeCompras.adicionarItem("Lápis", 2.0, 3);
        carrinhoDeCompras.adicionarItem("Caderno", 35.0, 1);
        carrinhoDeCompras.adicionarItem("Borracha", 2.0, 2);
        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.removerItem("Lápis");
        carrinhoDeCompras.exibirItens();
        System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
    }
}
