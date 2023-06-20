package com.detectordeincendiobackend.api;

import com.detectordeincendiobackend.domain.model.StatusCasa;
import com.detectordeincendiobackend.domain.repository.StatusCasaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/status")
public class StatusCasaController {
    private StatusCasaRepository statusCasaRepository;

    @GetMapping
    public List<StatusCasa> listar() {
        return statusCasaRepository.findAll();
    }

    @GetMapping("/{statusId}")
    public ResponseEntity<StatusCasa> buscar(@PathVariable Long statusId) {
        return statusCasaRepository.findById(statusId)
                .map(status -> ResponseEntity.ok(status))
                .orElse(ResponseEntity.notFound().build());
    }
}
