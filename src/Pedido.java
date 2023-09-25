import java.util.ArrayList;
import java.util.List;

class Pedido {
    private List<PedidoItem> itens = new ArrayList<>();

    public void adicionarItem(PedidoItem item) {
        itens.add(item);
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(PedidoItem::getPreco).sum();
    }

    public List<PedidoItem> getItens() {
        return itens;
    }
}