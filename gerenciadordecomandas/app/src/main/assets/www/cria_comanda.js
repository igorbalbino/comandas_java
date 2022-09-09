function criaComanda() {
	let nomeCliente = document.getElementById("nome_cliente").innerText;
	let pedidoCliente = document.getElementById("pedido_cliente").innerText;
	console.log(nomeCliente);
	
	if(!!window.GerenciadorComanda) {
		GerenciadorComanda.criaComanda(nomeCliente, pedidoCliente);
	} else {
		console.log("Instância Java não existe.");
		alert("Instância Java não existe.");
	}
}

window.showNoMercy = function () {
    console.log("asasasasas \n\n");
    alert("asasasasas \n\nasasasasas \n\n");
}