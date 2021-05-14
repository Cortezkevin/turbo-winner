package edu.pe.idat.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarProyecto(:monto, :area, :descripcion, :empresa, :fecha, :nombre)}", nativeQuery = true)
	void registrarProyecto(@Param("monto") Double monto, @Param("area") Double area,
			@Param("descripcion") String descripcion, @Param("empresa") String empresa, @Param("fecha") String fecha,
			@Param("nombre") String nombre);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarProyecto(:idproyecto,:monto, :area, :descripcion, :empresa, :fecha, :nombre)}", nativeQuery = true)
	void actualizarProyecto(@Param("idproyecto") Integer idproyecto, @Param("monto") Double monto,
			@Param("area") Double area, @Param("descripcion") String descripcion, @Param("empresa") String empresa,
			@Param("fecha") String fecha, @Param("nombre") String nombre);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantEliminarProyecto(:idproyecto)}", nativeQuery = true)
	void eliminarProyecto(@Param("idproyecto") Integer idproyecto);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantObtenerProyecto(:idproyecto)}", nativeQuery = true)
	List<Proyecto> BuscarProyecto(@Param("idproyecto") Integer idproyecto);
}
