package com.detectordeincendiobackend.domain.service;

import com.detectordeincendiobackend.MqttGateway;
import com.detectordeincendiobackend.domain.model.StatusCasa;
import com.detectordeincendiobackend.domain.repository.StatusCasaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MqttService {
    private MqttGateway mqttGateway;

    private StatusCasaRepository statusCasaRepository;

    private ObjectMapper objectMapper;

    private StatusCasa splitMessage(String message) {
        String[] dados = message.split(";");
        if(dados.length == 5) {
            return new StatusCasa(dados[0], dados[1], dados[2], dados[3], dados[4]);
        }
        return new StatusCasa();
    }

    public void analizaValores(String message) {
        StatusCasa status = splitMessage(message);
        sendStatus(convertJson(status));
        if(status.getHasIncendio()) {
            sendAlert("incendio");
        }

        //statusCasaRepository.save(status);
    }

    public void sendAlert(String mss) {
        mqttGateway.sendToMqtt(mss, "/casa/incendio");
    }

    public void sendStatus(String mss) {
        mqttGateway.sendToMqtt(mss, "/casa/sensores");
    }

    public String convertJson(StatusCasa statusCasa) {
        try {
            return objectMapper.writeValueAsString(statusCasa);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
