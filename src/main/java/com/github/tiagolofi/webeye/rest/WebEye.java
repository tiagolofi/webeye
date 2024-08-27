package com.github.tiagolofi.webeye.rest;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.jboss.resteasy.reactive.RestHeader;

import com.github.tiagolofi.webeye.mensageria.Mensagens;
import com.github.tiagolofi.webeye.modelos.MonitoramentoRequisicao;
import com.github.tiagolofi.webeye.mongo.Monitoramento;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("/traces")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WebEye {

    @RestHeader("Chave-Permissao-Consumo")
    String chavePermissaoConsumo;

    @POST
    @Path("/new")
    public Response no(MonitoramentoRequisicao requisicao) { 

        Monitoramento monitoramento = new Monitoramento();

        ZonedDateTime dataHora = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        monitoramento.setTimestamp(dataHora.format(formatter));
        monitoramento.setService(requisicao.service);
        monitoramento.setUrl(requisicao.url);
        monitoramento.setInformations(requisicao.informations);
        monitoramento.persist();

        return Response.status(201)
            .entity(Mensagens.ADICIONADO.getMensagem())
            .build();
    }

    @GET
    @Path("/list")
    public List<Monitoramento> retornaTudo() {
        return Monitoramento.listAll();
    }

    @DELETE
    @Path("/recycle")
    public Response reciclar() {
        Monitoramento.deleteAll();
        return Response.status(200)
            .entity(Mensagens.DELETADO.getMensagem())
            .build();
    } 

}
