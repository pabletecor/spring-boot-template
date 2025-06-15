package es.nextdigital.demo.adapter.out.repositories;

import es.nextdigital.demo.application.models.Cajero;
import es.nextdigital.demo.application.models.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
