import java.util.*;

public class SistemaDePedidos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pedido> pedidos = new ArrayList<>();

        while (true) {
            exibirMenu();
            int opcao = 0;
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Insira um número.");
                scanner.next(); // Limpar o buffer do scanner
                continue;
            }

            switch (opcao) {
                case 1:
                    criarNovoPedido(pedidos);
                    break;
                case 2:
                    adicionarItemAoPedido(pedidos, scanner);
                    break;
                case 3:
                    calcularTotalDoPedido(pedidos);
                    break;
                case 4:
                    listarItensDoPedido(pedidos);
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("1. Criar Pedido");
        System.out.println("2. Adicionar Item ao Pedido");
        System.out.println("3. Calcular Total do Pedido");
        System.out.println("4. Listar Itens do Pedido");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarNovoPedido(List<Pedido> pedidos) {
        Pedido novoPedido = new Pedido();
        pedidos.add(novoPedido);
        System.out.println("Pedido criado.");
    }

    private static void adicionarItemAoPedido(List<Pedido> pedidos, Scanner scanner) {
        if (pedidos.isEmpty()) {
            System.out.println("Crie um pedido primeiro.");
            return;
        }

        System.out.print("Digite o nome do item: ");
        String nomeItem = scanner.next();
        double precoItem = 0;
        try {
            System.out.print("Digite o preço do item: ");
            precoItem = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Preço inválido. Insira um número.");
            scanner.next(); // Limpar o buffer do scanner
            return;
        }

        PedidoItem item = new PedidoItem(nomeItem, precoItem);
        Pedido ultimoPedido = pedidos.get(pedidos.size() - 1);
        ultimoPedido.adicionarItem(item);
        System.out.println("Item adicionado ao pedido.");
    }

    private static void calcularTotalDoPedido(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Crie um pedido primeiro.");
            return;
        }

        Pedido pedidoAtual = pedidos.get(pedidos.size() - 1);
        double total = pedidoAtual.calcularTotal();
        System.out.println("Total do pedido: " + total);
    }

    private static void listarItensDoPedido(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Crie um pedido primeiro.");
            return;
        }

        Pedido pedidoParaListar = pedidos.get(pedidos.size() - 1);
        List<PedidoItem> itensDoPedido = pedidoParaListar.getItens();
        System.out.println("Itens do pedido:");
        for (PedidoItem item : itensDoPedido) {
            System.out.println(item.getNome() + ": " + item.getPreco());
        }
    }
}