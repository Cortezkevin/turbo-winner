package edu.pe.idat.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import edu.pe.idat.model.Proforma;

@Repository
public interface ProformaRepository extends JpaRepository<Proforma, Integer> {

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarProforma(:cliente, :direccion, :importe, :nomproyecto)}", nativeQuery = true)
	void registrarProforma(@Param("cliente") String cliente, @Param("direccion") String direccion,
			@Param("importe") Double importe, @Param("nomproyecto") String nomproyecto);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarProforma(:idproforma,:cliente, :direccion, :importe, :nomproyecto)}", nativeQuery = true)
	void actualizarProforma(@Param("idproforma") Integer idproforma, @Param("cliente") String cliente, @Param("direccion") String direccion,
			@Param("importe") Double importe, @Param("nomproyecto") String nomproyectoe);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantEliminarProforma(:idproforma)}", nativeQuery = true)
	void eliminarProforma(@Param("idproforma") Integer idproforma);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantObtenerProforma(:idproforma)}", nativeQuery = true)
	List<Proforma> BuscarProforma(@Param("idproforma") Integer idproforma);
}
