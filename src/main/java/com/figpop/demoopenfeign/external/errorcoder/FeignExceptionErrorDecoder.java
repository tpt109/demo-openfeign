package com.figpop.demoopenfeign.external.errorcoder;

import com.figpop.demoopenfeign.exceptions.model.BadRequestException;
import com.figpop.demoopenfeign.exceptions.model.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignExceptionErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 400:
                return new BadRequestException();
            case 404:
                return new NotFoundException(response.reason());
            default:
                return new Exception("Generic error");
        }
    }
}
