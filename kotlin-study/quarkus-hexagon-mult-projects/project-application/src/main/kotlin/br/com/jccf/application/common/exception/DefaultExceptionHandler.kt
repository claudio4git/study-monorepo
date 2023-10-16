package br.com.jccf.application.common.exception

import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class DefaultExceptionHandler : ExceptionMapper<Throwable> {

    override fun toResponse(exception: Throwable?): Response {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(exception?.message)
            .build()
    }
}
