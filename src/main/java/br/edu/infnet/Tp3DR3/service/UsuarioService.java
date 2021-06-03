package br.edu.infnet.Tp3DR3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.Tp3DR3.model.negocio.Usuario;
import br.edu.infnet.Tp3DR3.model.repository.IUsuarioRepository;


@Service
public class UsuarioService {
	@Autowired
	private IUsuarioRepository usuarioRepository;
	Usuario usuario = new Usuario();
	
	public void salvar(Usuario usuario)
	{
		usuarioRepository.save(usuario);
		this.usuario = usuario;
	}
	
	public Usuario consultarCadastro() {
		return usuario;
	}
	public Usuario consultarPorID(Integer id)
	{
		return usuarioRepository.findById(id).get();
	}
	
	public void excluir(Integer id) 
	{
		usuarioRepository.deleteById(id);
	}
	
}
