package hello.dev.DrivingSchool.controller;

import hello.dev.DrivingSchool.exception.DadosNaoEncontradosException;
import hello.dev.DrivingSchool.model.dto.ApiErrorsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @Autowired
    MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = BAD_REQUEST)
    public List<ApiErrorsDTO> handle(MethodArgumentNotValidException exception) {
        List<ApiErrorsDTO> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ApiErrorsDTO erro = new ApiErrorsDTO(e.getField(), mensagem);
            dto.add(erro);
        });
        return dto;
    }

    @ExceptionHandler(DadosNaoEncontradosException.class)
    @ResponseStatus(code = BAD_REQUEST)
    public ApiErrorsDTO handleDadosNaoEncontradosException(DadosNaoEncontradosException ex) {
        return new ApiErrorsDTO(null, ex.getMessage());
    }

    @ExceptionHandler(DateTimeException.class)
    @ResponseStatus(code = BAD_REQUEST)
    public ApiErrorsDTO handleDataInvalidaException(DadosNaoEncontradosException ex) {
        return new ApiErrorsDTO("data", "Data inválida");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(code = BAD_REQUEST)
    public ApiErrorsDTO handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ApiErrorsDTO(null, "Dados inválidos");
    }
}
