package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {

	private String nome;
	private Set<Conteudo> conteudoIncritos = new LinkedHashSet<Conteudo>();
	private Set<Conteudo> conteudoConcluidos = new LinkedHashSet<Conteudo>();

	public void inscreverBootcamp(Bootcamp bootcamp) {
		this.conteudoIncritos.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscritos().add(this);

	}

	public void progredir() {
		Optional<Conteudo> conteudo = this.conteudoIncritos.stream().findFirst();
		if (conteudo.isPresent()) {
			this.conteudoConcluidos.add(conteudo.get());
			this.conteudoIncritos.remove(conteudo.get());
		} else {
			System.err.println("Voc? n?o esta matriculado em nenhum conte?do!");
		}
	}

	public double calcularXp() {
		return this.conteudoConcluidos.stream()
				.mapToDouble(conteudo -> conteudo.calcularXp())
				.sum();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getConteudoIncritos() {
		return conteudoIncritos;
	}

	public void setConteudoIncritos(Set<Conteudo> conteudoIncritos) {
		this.conteudoIncritos = conteudoIncritos;
	}

	public Set<Conteudo> getConteudoConcluidos() {
		return conteudoConcluidos;
	}

	public void setConteudoConcluidos(Set<Conteudo> conteudoConcluidos) {
		this.conteudoConcluidos = conteudoConcluidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conteudoConcluidos == null) ? 0 : conteudoConcluidos.hashCode());
		result = prime * result + ((conteudoIncritos == null) ? 0 : conteudoIncritos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Dev other = (Dev) obj;
		if (conteudoConcluidos == null) {
			if (other.conteudoConcluidos != null)
				return false;
		} else if (!conteudoConcluidos.equals(other.conteudoConcluidos))
			return false;
		if (conteudoIncritos == null) {
			if (other.conteudoIncritos != null)
				return false;
		} else if (!conteudoIncritos.equals(other.conteudoIncritos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
