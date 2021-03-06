package br.com.dio.desafio;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/aaaa");

		Curso curso = new Curso();
		curso.setTitulo("Curso java");
		curso.setDescricao("Descri??o curso java");
		curso.setCargaHoraria(8);

		Curso curso2 = new Curso();
		curso2.setTitulo("Curso javascript");
		curso2.setDescricao("Descri??o curso javascript");
		curso2.setCargaHoraria(8);

		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Mentoria de java");
		mentoria.setDescricao("descricao mentoria java");
		mentoria.setData(LocalDate.now());

		/*
		 * System.out.println(curso); System.out.println(mentoria);
		 */

		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descri??o Bootcamp Java Developer");
		bootcamp.getConteudos().add(curso);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);

		Dev devCamila = new Dev();
		devCamila.setNome("Camila");
		devCamila.inscreverBootcamp(bootcamp);
		System.out.println("Conteudos Inscritos " + devCamila.getConteudoIncritos());
		devCamila.progredir();
		devCamila.progredir();
		devCamila.progredir();
		System.out.println("-");
		System.out.println("Conteudos Inscritos " + devCamila.getConteudoIncritos());
		System.out.println("Conteudos Concluidos " + devCamila.getConteudoConcluidos());
		System.out.println("XP:" + devCamila.calcularXp());

		System.out.println("----------------");

		Dev devJoao = new Dev();
		devJoao.setNome("Joao");
		devJoao.inscreverBootcamp(bootcamp);
		System.out.println("Conteudos Inscritos " + devJoao.getConteudoIncritos());
		devJoao.progredir();
		System.out.println("-");
		System.out.println("Conteudos Inscritos " + devCamila.getConteudoIncritos());
		System.out.println("Conteudos Concluidos " + devJoao.getConteudoConcluidos());
		System.out.println("XP:" + devJoao.calcularXp());

	}

}
