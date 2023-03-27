/**@author Caio B. Zamana
 * 
 * O código é um exemplo de aplicação desktop simples para gerenciamento de vendas.
 *  Abaixo, serão explicados pontos do código.*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//A classe GerenciadorDeVendas estende a classe JFrame, o que significa que ela é uma janela que pode ser exibida na tela.
public class GerenciadorDeVendas extends JFrame {
	private DefaultListModel<String> produtosModel;
	private JList<String> produtosList;
	private JTextField nomeProdutoField, precoProdutoField;
	private JSpinner quantidadeSpinner;
	private JLabel totalLabel;
	private double total = 0;

	public GerenciadorDeVendas() {
		super("Gerenciador de Vendas");

		// Inicializa a lista de produtos
		// A variável produtosModel é um objeto do tipo DefaultListModel<String>, que é
		// uma lista de strings que será usada para armazenar os produtos adicionados. A
		// variável produtosList é um objeto do tipo JList<String>, que é uma lista que
		// será exibida na tela.
		produtosModel = new DefaultListModel<String>();
		produtosList = new JList<String>(produtosModel);
		JScrollPane produtosScrollPane = new JScrollPane(produtosList);
		produtosScrollPane.setPreferredSize(new Dimension(200, 100));

		// Inicializa os campos de entrada
		// Os campos de entrada incluem o nome do produto, o preço do produto e a
		// quantidade de produtos a serem adicionados. O preço é um número decimal, que
		// será convertido em um double. A quantidade é um número inteiro, que será
		// convertido em um int.
		nomeProdutoField = new JTextField(10);
		precoProdutoField = new JTextField(10);
		quantidadeSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));

		// Inicializa os botões
		// Existem dois botões: o botão "Adicionar", que adiciona um produto à lista, e
		// o botão "Vender", que finaliza a venda e limpa a lista.
		JButton adicionarButton = new JButton("Adicionar");
		adicionarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarProduto();
			}
		});

		JButton venderButton = new JButton("Vender");
		venderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarVenda();
			}
		});

		// Inicializa a label do total
		// A variável total é um double que mantém o total da venda atual. A variável
		// totalLabel é um objeto do tipo JLabel que exibe o valor total na tela.
		totalLabel = new JLabel("Total: R$ 0,00");

		// Cria o painel principal
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);

		c.gridx = 0;
		c.gridy = 0;
		panel.add(new JLabel("Produtos:"), c);

		c.gridx = 1;
		c.gridy = 0;
		panel.add(produtosScrollPane, c);

		c.gridx = 0;
		c.gridy = 1;
		panel.add(new JLabel("Nome:"), c);

		c.gridx = 1;
		c.gridy = 1;
		panel.add(nomeProdutoField, c);

		c.gridx = 0;
		c.gridy = 2;
		panel.add(new JLabel("Preço:"), c);

		c.gridx = 1;
		c.gridy = 2;
		panel.add(precoProdutoField, c);

		c.gridx = 0;
		c.gridy = 3;
		panel.add(new JLabel("Quantidade:"), c);

		c.gridx = 1;
		c.gridy = 3;
		panel.add(quantidadeSpinner, c);

		c.gridx = 2;
		c.gridy = 1;
		panel.add(adicionarButton, c);

		c.gridx = 2;
		c.gridy = 2;
		panel.add(venderButton, c);

		c.gridx = 2;
		c.gridy = 3;
		panel.add(totalLabel, c);

		// Configura a janela principal
		// O método construtor GerenciadorDeVendas() inicializa os componentes da
		// janela, incluindo a lista de produtos, os campos de entrada, os botões e a
		// label do total. Também configura a janela principal.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// O método adicionarProduto() é chamado quando o botão "Adicionar" é
	// pressionado. Ele pega os valores dos campos de entrada, calcula o subtotal e
	// atualiza o total. Em seguida, ele formata uma string que representa o produto
	// e adiciona essa string à lista de produtos. Por fim, atualiza a label do
	// total.

	private void adicionarProduto() {
		String nome = nomeProdutoField.getText();
		double preco = Double.parseDouble(precoProdutoField.getText());
		int quantidade = (int) quantidadeSpinner.getValue();

		double subtotal = preco * quantidade;
		total += subtotal;

		String produto = String.format("%s (%d x R$ %.2f = R$ %.2f)", nome, quantidade, preco, subtotal);
		produtosModel.addElement(produto);

		totalLabel.setText(String.format("Total: R$ %.2f", total));
	}

	// O método realizarVenda() é chamado quando o botão "Vender" é pressionado. Ele
	// exibe uma mensagem informando que a venda foi realizada com sucesso, imprime
	// o total da venda no console e limpa os campos de entrada, a lista de produtos
	// e o total.
	private void realizarVenda() {
		JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");

		System.out.println(total + "R$");

		// Limpa os campos de entrada
		nomeProdutoField.setText("");
		precoProdutoField.setText("");
		quantidadeSpinner.setValue(1);

		// Limpa a lista de produtos
		produtosModel.clear();

		// Zera o total
		total = 0;
		totalLabel.setText("Total: R$ 0,00");
	}

	// O método main() é responsável por criar a janela e executar o programa. Ele
	// usa o método invokeLater() da classe SwingUtilities para garantir que a
	// janela seja criada e exibida na thread de eventos do Swing.

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GerenciadorDeVendas();

			}

		});
	}
}


