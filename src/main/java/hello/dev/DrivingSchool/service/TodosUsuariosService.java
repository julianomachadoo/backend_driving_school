package hello.dev.DrivingSchool.service;

import org.springframework.stereotype.Service;

import static java.lang.Integer.parseInt;

@Service
public class TodosUsuariosService {
//        extends UsuarioService {

//    @Override
//    public Usuario cadastrar(CadastroDeUsuarioForm cadastroDeUsuarioForm) {
//        return null;
//    }
//
//    public List<UsuarioDTO> listarTodos() {
//        List<UsuarioDTO> usuarios = usuarioRepository
//                .findAll().stream().map(this::converterUsuario).toList();
//        if (usuarios.isEmpty()) throw new DadosNaoEncontradosException("Usuario não encontrado");
//        return usuarios;
//    }
//
//    public List<UsuarioDTO> pesquisaPorNome(String nome) {
//        List<UsuarioDTO> usuarios = usuarioRepository
//                .findByNomeContainingIgnoreCase(nome).stream().map(this::converterUsuario).toList();
//        if (usuarios.isEmpty()) throw new DadosNaoEncontradosException("Usuario não encontrado");
//        return usuarios;
//    }
//
//    public List<UsuarioDTO> pesquisaPorCPF(String cpf) {
//        Optional<Usuario> usuario = usuarioRepository.findByCpf(cpf);
//        if (usuario.isEmpty()) throw new DadosNaoEncontradosException("Usuario não encontrado");
//        return Collections.singletonList(converterUsuario(usuario.get()));
//    }
//
//    public List<UsuarioDTO> pesquisaPorEmail(String email) {
//        List<UsuarioDTO> usuarios = usuarioRepository
//                .findByEmailContainingIgnoreCase(email).stream().map(this::converterUsuario).collect(Collectors.toList());
//        if (usuarios.isEmpty()) throw new DadosNaoEncontradosException("Usuario não encontrado");
//        return usuarios;
//    }
//
//    public List<UsuarioDTO> pesquisaPorTipoUsuario(String tipoUsuario) {
//        try {
//        TipoUsuario.valueOf(tipoUsuario.toUpperCase());
//        } catch (IllegalArgumentException e) {
//            throw new DadosNaoEncontradosException("Tipo de usuario inválido");
//        }
//        return usuarioRepository.findByTipoDeUsuario(tipoUsuario).stream().map(this::converterUsuario).collect(Collectors.toList());
//    }
//
//    public List<UsuarioDTO> pesquisaPorData(String dataInicio, String dataFim) {
//        LocalDate localDateInicio = converterData(dataInicio);
//        LocalDate localDateFim = converterData(dataFim);
//        List<UsuarioDTO> usuarios = usuarioRepository
//                .encontrarPorData(localDateInicio, localDateFim)
//                .stream().map(this::converterUsuario)
//                .toList();
//        if (usuarios.isEmpty()) throw new DadosNaoEncontradosException("Usuario não encontrado");
//        return usuarios;
//    }
//
//    public void atualizaUsuario(AtualizaUsuarioForm atualizaUsuarioForm, String id) {
//        Usuario usuarioEncontrado = usuarioRepository.getReferenceById(id);
//        if (atualizaUsuarioForm.getNome() != null) usuarioEncontrado.setNome(atualizaUsuarioForm.getNome());
//        if (atualizaUsuarioForm.getEmail() != null) usuarioEncontrado.setEmail(atualizaUsuarioForm.getEmail());
//        if (atualizaUsuarioForm.getSenha() != null) usuarioEncontrado.setSenha(atualizaUsuarioForm.getSenha());
//        if (atualizaUsuarioForm.getTelefone() != null) usuarioEncontrado.setTelefone(atualizaUsuarioForm.getTelefone());
//        if (atualizaUsuarioForm.getLogradouro() != null) usuarioEncontrado.getEndereco().setLogradouro(atualizaUsuarioForm.getLogradouro());
//        if (atualizaUsuarioForm.getCep() != null) usuarioEncontrado.getEndereco().setCEP(atualizaUsuarioForm.getCep());
//        if (atualizaUsuarioForm.getNumero() != null) usuarioEncontrado.getEndereco().setNumero(parseInt(atualizaUsuarioForm.getNumero()));
//        if (atualizaUsuarioForm.getCidade() != null) usuarioEncontrado.getEndereco().setCidade(atualizaUsuarioForm.getCidade());
//        if (atualizaUsuarioForm.getComplemento() != null) usuarioEncontrado.getEndereco().setComplemento(atualizaUsuarioForm.getComplemento());
//    }
//
//    public void removerUsuario(Long id) {
//        try {
//            usuarioRepository.deleteById(String.valueOf(id));
//        } catch (EmptyResultDataAccessException e) {
//            throw new DadosNaoEncontradosException("Usuario não encontrado");
//        }
//    }
//
//    protected UsuarioDTO converterUsuario(Usuario usuario) {
//        UsuarioDTO usuarioDTO = new UsuarioDTO(
//                usuario.getId(),
//                usuario.getNome(),
//                usuario.getEmail(),
//                usuario.getSenha(),
//                usuario.getCpf(),
//                usuario.getDataDeNascimento(),
//                usuario.getDataCadastro(),
//                usuario.getEndereco(),
//                usuario.getTelefone(),
//                usuario.getClass().toString().substring(36));
//
//        if (usuario.getClass().equals(Aluno.class)) {
//            ((Aluno) usuario).getTipoCNHList().forEach(tipoCNH -> usuarioDTO.getTipoCNHList().add(tipoCNH));
//        }
//        return usuarioDTO;
//    }
//
//    public void login(LoginUsuarioForm loginUsuario) {
//        Optional<Usuario> usuario = usuarioRepository.findByEmail(loginUsuario.getEmail());
//        if (usuario.isEmpty()) throw new DadosNaoEncontradosException("Usuario ou senha inválidos");
//        if (!Objects.equals(usuario.get().getSenha(), loginUsuario.getSenha()))
//            throw new DadosNaoEncontradosException("Usuario ou senha inválidos");
//    }
}
