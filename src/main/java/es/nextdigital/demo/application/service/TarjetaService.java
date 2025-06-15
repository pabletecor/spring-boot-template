package es.nextdigital.demo.application.service;

import es.nextdigital.demo.adapter.in.rest.dto.ActivarTarjetaDTO;
import es.nextdigital.demo.adapter.out.repositories.TarjetaRepository;
import es.nextdigital.demo.application.models.Tarjeta;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TarjetaService {

    private final TarjetaRepository tarjetaRepo;

    public TarjetaService(TarjetaRepository tarjetaRepo) {
        this.tarjetaRepo = tarjetaRepo;
    }

    @Transactional
    public void activarTarjeta(ActivarTarjetaDTO dto) {
        Tarjeta tarjeta = tarjetaRepo.findByNumero(dto.getNumeroTarjeta())
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));

        if (tarjeta.isActiva()) {
            throw new RuntimeException("La tarjeta ya está activada");
        }

        tarjeta.setActiva(true);
        tarjetaRepo.save(tarjeta);
    }
}
