package es.nextdigital.demo.application.service;

import es.nextdigital.demo.adapter.out.repositories.MovimientoRepository;
import es.nextdigital.demo.application.models.Movimiento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {

    private final MovimientoRepository movimientoRepository;

    public MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    public List<Movimiento> obtenerMovimientosPorCuenta(Long cuentaId) {
        return movimientoRepository.findByCuentaId(cuentaId);
    }

}
