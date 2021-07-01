package br.com.application.tdd.jpa;

import org.junit.Ignore;
import org.junit.Test;

import br.com.application.domain.Colaborador;
import br.com.application.domain.Usuario;
import br.com.application.enumerator.UsuarioEnum;
import br.com.application.enumerator.UsuarioStatus;
import br.com.application.persistence.jpa.ColaboradorPersistence;
import br.com.application.persistence.jpa.UsuarioPersistence;

public class UsuarioTest {
	
	@Test
	public void usuarioA() throws Exception {
		
		ColaboradorPersistence colaboradorPersistence = new ColaboradorPersistence();
		Colaborador colaborador = colaboradorPersistence.findBy(Long.parseLong("1"));
		
		UsuarioPersistence usuarioPersistence = new UsuarioPersistence();
		Usuario usuario = new Usuario();
		usuario.setUsername(colaborador.getNomeCompleto());
		usuario.setPerfil(UsuarioEnum.EXTERNAL);
		usuario.setStatus(UsuarioStatus.INATIVO);
		usuario.setEmail(colaborador.getEmail());
		usuario.setPassword(null);
		colaborador.setUsuario(usuario);
		
		
		usuarioPersistence.save(usuario);
		colaboradorPersistence.merge(colaborador);
	}
	
	@Test
	public void usuarioB() throws Exception {
		
		ColaboradorPersistence colaboradorPersistence = new ColaboradorPersistence();
		Colaborador colaborador = colaboradorPersistence.findBy(Long.parseLong("2"));
		
		UsuarioPersistence usuarioPersistence = new UsuarioPersistence();
		Usuario usuario = new Usuario();
		usuario.setUsername(colaborador.getNomeCompleto());
		usuario.setPerfil(UsuarioEnum.EXTERNAL);
		usuario.setStatus(UsuarioStatus.INATIVO);
		usuario.setEmail(colaborador.getEmail());
		usuario.setPassword(null);
		colaborador.setUsuario(usuario);
		
		
		usuarioPersistence.save(usuario);
		colaboradorPersistence.merge(colaborador);
	}
	
	@Test
	public void usuarioC() throws Exception {
		
		ColaboradorPersistence colaboradorPersistence = new ColaboradorPersistence();
		Colaborador colaborador = colaboradorPersistence.findBy(Long.parseLong("3"));
		
		UsuarioPersistence usuarioPersistence = new UsuarioPersistence();
		Usuario usuario = new Usuario();
		usuario.setUsername(colaborador.getNomeCompleto());
		usuario.setPerfil(UsuarioEnum.EXTERNAL);
		usuario.setStatus(UsuarioStatus.INATIVO);
		usuario.setEmail(colaborador.getEmail());
		usuario.setPassword(null);
		colaborador.setUsuario(usuario);
		
		
		usuarioPersistence.save(usuario);
		colaboradorPersistence.merge(colaborador);
	}
	
	@Test
	public void usuarioD() throws Exception {
		
		ColaboradorPersistence colaboradorPersistence = new ColaboradorPersistence();
		Colaborador colaborador = colaboradorPersistence.findBy(Long.parseLong("4"));
		
		UsuarioPersistence usuarioPersistence = new UsuarioPersistence();
		Usuario usuario = new Usuario();
		usuario.setUsername(colaborador.getNomeCompleto());
		usuario.setPerfil(UsuarioEnum.EXTERNAL);
		usuario.setStatus(UsuarioStatus.INATIVO);
		usuario.setEmail(colaborador.getEmail());
		usuario.setPassword(null);
		colaborador.setUsuario(usuario);
		
		
		usuarioPersistence.save(usuario);
		colaboradorPersistence.merge(colaborador);
	}
	
	@Test
	public void usuarioE() throws Exception {
		
		ColaboradorPersistence colaboradorPersistence = new ColaboradorPersistence();
		Colaborador colaborador = colaboradorPersistence.findBy(Long.parseLong("5"));
		
		UsuarioPersistence usuarioPersistence = new UsuarioPersistence();
		Usuario usuario = new Usuario();
		usuario.setUsername(colaborador.getNomeCompleto());
		usuario.setPerfil(UsuarioEnum.EXTERNAL);
		usuario.setStatus(UsuarioStatus.INATIVO);
		usuario.setEmail(colaborador.getEmail());
		usuario.setPassword(null);
		colaborador.setUsuario(usuario);
		
		
		usuarioPersistence.save(usuario);
		colaboradorPersistence.merge(colaborador);
	}
	
	@Test
	public void usuarioF() throws Exception {
		
		ColaboradorPersistence colaboradorPersistence = new ColaboradorPersistence();
		Colaborador colaborador = colaboradorPersistence.findBy(Long.parseLong("6"));
		
		UsuarioPersistence usuarioPersistence = new UsuarioPersistence();
		Usuario usuario = new Usuario();
		usuario.setUsername(colaborador.getNomeCompleto());
		usuario.setPerfil(UsuarioEnum.EXTERNAL);
		usuario.setStatus(UsuarioStatus.INATIVO);
		usuario.setEmail(colaborador.getEmail());
		usuario.setPassword(null);
		colaborador.setUsuario(usuario);
		
		
		usuarioPersistence.save(usuario);
		colaboradorPersistence.merge(colaborador);
	}
	
	@Test
	public void usuarioG() throws Exception {
		
		ColaboradorPersistence colaboradorPersistence = new ColaboradorPersistence();
		Colaborador colaborador = colaboradorPersistence.findBy(Long.parseLong("7"));
		
		UsuarioPersistence usuarioPersistence = new UsuarioPersistence();
		Usuario usuario = new Usuario();
		usuario.setUsername(colaborador.getNomeCompleto());
		usuario.setPerfil(UsuarioEnum.EXTERNAL);
		usuario.setStatus(UsuarioStatus.INATIVO);
		usuario.setEmail(colaborador.getEmail());
		usuario.setPassword(null);
		colaborador.setUsuario(usuario);
		
		
		usuarioPersistence.save(usuario);
		colaboradorPersistence.merge(colaborador);
	}
	
	@Test
	public void usuarioH() throws Exception {
		
		ColaboradorPersistence colaboradorPersistence = new ColaboradorPersistence();
		Colaborador colaborador = colaboradorPersistence.findBy(Long.parseLong("8"));
		
		UsuarioPersistence usuarioPersistence = new UsuarioPersistence();
		Usuario usuario = new Usuario();
		usuario.setUsername(colaborador.getNomeCompleto());
		usuario.setPerfil(UsuarioEnum.EXTERNAL);
		usuario.setStatus(UsuarioStatus.INATIVO);
		usuario.setEmail(colaborador.getEmail());
		usuario.setPassword(null);
		colaborador.setUsuario(usuario);
		
		
		usuarioPersistence.save(usuario);
		colaboradorPersistence.merge(colaborador);
	}
	
	@Test
	public void usuarioI() throws Exception {
		
		ColaboradorPersistence colaboradorPersistence = new ColaboradorPersistence();
		Colaborador colaborador = colaboradorPersistence.findBy(Long.parseLong("9"));
		
		UsuarioPersistence usuarioPersistence = new UsuarioPersistence();
		Usuario usuario = new Usuario();
		usuario.setUsername(colaborador.getNomeCompleto());
		usuario.setPerfil(UsuarioEnum.EXTERNAL);
		usuario.setStatus(UsuarioStatus.INATIVO);
		usuario.setEmail(colaborador.getEmail());
		usuario.setPassword(null);
		colaborador.setUsuario(usuario);
		
		
		usuarioPersistence.save(usuario);
		colaboradorPersistence.merge(colaborador);
	}

}
