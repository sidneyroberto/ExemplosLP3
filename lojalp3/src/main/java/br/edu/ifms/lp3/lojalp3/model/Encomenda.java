package br.edu.ifms.lp3.lojalp3.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Encomenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
    private Integer quantidade;
    
	@NotEmpty
    private Double valorTotal;
    
    private LocalDate dataHorarioEncomenda;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
    		name = "encomenda_produto", 
    		joinColumns = {@JoinColumn(columnDefinition = "produto_id")}, 
    		inverseJoinColumns= {@JoinColumn(columnDefinition = "encomenda_id")})
    private List<Produto> produtos;

	@Override
	public String toString() {
		return "Encomenda [id=" + id + ", quantidade=" + quantidade + ", valorTotal=" + valorTotal
				+ ", dataHorarioEncomenda=" + dataHorarioEncomenda + ", cliente=" + cliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Encomenda other = (Encomenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getDataHorarioEncomenda() {
		return dataHorarioEncomenda;
	}

	public void setDataHorarioEncomenda(LocalDate dataHorarioEncomenda) {
		this.dataHorarioEncomenda = dataHorarioEncomenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
    
}
