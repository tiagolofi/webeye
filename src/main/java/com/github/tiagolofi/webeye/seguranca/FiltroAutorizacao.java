package com.github.tiagolofi.webeye.seguranca;

import java.io.IOException;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.github.tiagolofi.webeye.mensageria.Mensagens;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class FiltroAutorizacao implements ContainerRequestFilter {

    @ConfigProperty(name = "CHAVE_PERMISSAO_CONSUMO") // liberação de consumo por outra aplicação
    private String chavePermissaoConsumo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        String chavePermissaoConsumoHeader = requestContext.getHeaderString("Chave-Permissao-Consumo");

        if (chavePermissaoConsumoHeader == null || !chavePermissaoConsumoHeader.equals(chavePermissaoConsumo)) {
            requestContext.abortWith(Response.status(401)
                .entity(Mensagens.NAO_AUTORIZADO.getMensagem())
                .build());
        }

    }
}
