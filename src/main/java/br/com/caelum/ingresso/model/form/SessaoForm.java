package br.com.caelum.ingresso.model.form;

import java.time.LocalTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoForm {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	private Integer salaId;
	
	@DateTimeFormat(pattern="HH:mm")
	@NotNull
	private LocalTime horario;
	
	@NotNull
	private Integer filemId;
	
	public Sessao toSessao(SalaDao salaDao, FilmeDao filmeDao){
		Filme filme = filmeDao.findOne(filemId);
		Sala sala = salaDao.findOne(salaId);
		Sessao sessao = new Sessao(this.horario, filme, sala);
		return sessao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSalaId() {
		return salaId;
	}

	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Integer getFilemId() {
		return filemId;
	}

	public void setFilemId(Integer filemId) {
		this.filemId = filemId;
	}
}
