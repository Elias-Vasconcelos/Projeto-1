package br.com.Elias.domain.dao;

import br.com.Elias.domain.Domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {

    public Boolean cadastrar (Cliente cliente);

    public void excluir (Long cpf);

    public void alterar (Cliente cliente);

    public Cliente consutar(Long cpf);

    public Collection<Cliente> buscarTodos() ;
}
