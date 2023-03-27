
# Gerenciador de Vendas
Este é um exemplo de aplicação desktop simples para gerenciamento de vendas. A aplicação é escrita em Java e utiliza a biblioteca Swing para construir a interface gráfica.

# Funcionamento
A aplicação permite que o usuário adicione produtos a uma lista de vendas. Cada produto é composto por um nome, preço e quantidade. Quando o usuário adiciona um produto, o aplicativo calcula o subtotal e atualiza o total da venda. Quando a venda é finalizada, a lista de produtos é limpa e o total é reiniciado.

# Uso
Para executar a aplicação, basta compilar e executar o arquivo GerenciadorDeVendas.java. Uma vez iniciada a aplicação, o usuário pode adicionar produtos à lista preenchendo os campos de entrada e clicando no botão "Adicionar". O usuário pode finalizar a venda clicando no botão "Vender". O total da venda é exibido na tela em uma label.

# Descrição do Código
O código é composto por uma classe principal chamada GerenciadorDeVendas, que estende a classe JFrame, tornando-a uma janela que pode ser exibida na tela. A classe principal contém uma lista de produtos, campos de entrada para adicionar produtos, botões para adicionar produtos e finalizar a venda, e uma label para exibir o total da venda. A lista de produtos é implementada como um objeto DefaultListModel<String> e é exibida na tela usando um objeto JList<String>. Os campos de entrada incluem um JTextField para o nome do produto, um JTextField para o preço do produto e um JSpinner para a quantidade de produtos a serem adicionados. O preço é um número decimal, que é convertido em um double. A quantidade é um número inteiro, que é convertido em um int.

O botão "Adicionar" adiciona um produto à lista de produtos. O botão "Vender" finaliza a venda e limpa a lista. Quando um produto é adicionado, o aplicativo calcula o subtotal e atualiza o total da venda. O total é exibido em uma label na tela.

# Dev. Caio Bello
