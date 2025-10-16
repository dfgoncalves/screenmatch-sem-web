package br.com.alura.screenmatch.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public interface IDataConverter {

    <T> T getData(String json, Class<T> classe);
}
