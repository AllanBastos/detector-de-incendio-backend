package com.detectordeincendiobackend.domain.service;

import com.detectordeincendiobackend.MqttGateway;
import com.detectordeincendiobackend.domain.model.StatusCasa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MqttService {
    private MqttGateway mqttGateway;

    private StatusCasa splitMessage(String message) {
        String[] dados = message.split(";");
        if(dados.length == 4) {
            return new StatusCasa(dados[0], dados[1], dados[2], dados[3]);
        }
        return new StatusCasa();
    }

    public void analizaValores(String message) {
        StatusCasa status = splitMessage(message);

        //analiza os dados

        sendAlert();
    }

    public void sendAlert() {
        mqttGateway.sendToMqtt("incendio", "/casa/incendio");
        mqttGateway.sendToMqtt("incendio", "/incendio");
        //manda para usuario
    }
}
