package br.com.Elias.domain.dao;

import br.com.Elias.domain.Domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteDAO implements  IClienteDAO{

    private Map<Long, Cliente> map;

    public ClienteDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if( this.map.containsKey(cliente.getCpf())){
            return false;
        }

        this.map.put(cliente.getCpf(), cliente );
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);
        if ( clienteCadastrado != null){
            this.map.remove(clienteCadastrado.getCpf());
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
        if ( clienteCadastrado != null){
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setEstado(cliente.getEstado());
        }
    }

    @Override
    public Cliente consutar(Long cpf) {
       if (cpf != null){
           return this.map.get(cpf);
       }else return null;

    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }

}
