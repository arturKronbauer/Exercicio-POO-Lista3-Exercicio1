package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enumeradas.StatusPedido;

public class Pedido {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date momento;
	private StatusPedido status;

	private Cliente cliente;
	private List<ItensPedido> itens = new ArrayList<>();

	

	public Pedido(Date momento, StatusPedido status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}
	
	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItensPedido> getItens() {
		return itens;
	}

	public void addItem(ItensPedido item) {
		itens.add(item);
	}

	public void removeItem(ItensPedido item) {
		itens.remove(item);
	}

	public double total() {
		double sum = 0.0;
		for (ItensPedido item : itens) {
			sum += item.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento do pedido: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Status do pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("\n Itens do Pedido:\n");
		for (ItensPedido item : itens) {
			sb.append(item + "\n");
		}
		sb.append("Valor Total: R$");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
