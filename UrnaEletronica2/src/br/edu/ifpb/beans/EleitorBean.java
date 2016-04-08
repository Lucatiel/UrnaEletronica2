package br.edu.ifpb.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpb.dao.EleitorDAO;
import br.edu.ifpb.entidades.Eleitor;

@RequestScoped	
@ManagedBean
public class EleitorBean {

	private Eleitor eleitor;

	public EleitorBean() {

		this.eleitor = new Eleitor();		
	}

	public void cadastrarEleitor(){

		EleitorDAO eleitorDAO = new EleitorDAO();
		eleitorDAO.insert(eleitor);
		addMessage("Cadastro Realizado!!");
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void deletarEleitor(){
		EleitorDAO eleitorDAO = new EleitorDAO();
		eleitorDAO.delete(eleitor);
	}

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}



}
