package oliver.com.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import oliver.com.user.model.Usuario;

@RepositoryRestResource(path="usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
	
	@RestResource(path="buscar-username")
	public Usuario findByUsername(@Param("nombre") String username);
}
