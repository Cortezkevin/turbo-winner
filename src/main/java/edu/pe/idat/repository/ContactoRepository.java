package edu.pe.idat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarConsulta(:nombre, :email, :asunto, :telefono, :mensaje)}", nativeQuery = true)
	void registrarConsulta(@Param("nombre") String nombre, @Param("email") String email,
			@Param("asunto") String asunto, @Param("telefono") String telefono, @Param("mensaje") String mensaje);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarConsulta(:idconsulta, :nombre, :email, :asunto, :telefono, :mensaje)}", nativeQuery = true)
	void actualizarConsulta(@Param("idconsulta") Integer idconsulta,@Param("nombre") String nombre, @Param("email") String email,
			@Param("asunto") String asunto, @Param("telefono") String telefono, @Param("mensaje") String mensaje);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantEliminarConsulta(:idconsulta)}", nativeQuery = true)
	void eliminarConsulta(@Param("idconsulta") Integer idconsulta);
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantObtenerConsulta(:idconsulta)}", nativeQuery = true)
	void BuscarConsulta(@Param("idconsulta") Integer idconsulta);
}
