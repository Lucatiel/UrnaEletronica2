package br.edu.ifpb.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpb.dao.CandidatoDAO;
import br.edu.ifpb.entidades.Candidato;

@RequestScoped	
@ManagedBean
public class CandidatoBean {

	private Candidato candidato;

	public CandidatoBean() {

		this.candidato = new Candidato();		
	}

	public void cadastrarCandidato(){

		CandidatoDAO candidatoDAO = new CandidatoDAO();
		candidatoDAO.insert(candidato);
		addMessage("Cadastro Realizado!!");
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}


	public void deletarCandidato(){

		CandidatoDAO candidatoDAO = new CandidatoDAO();
		candidatoDAO.delete(candidato);
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}


}