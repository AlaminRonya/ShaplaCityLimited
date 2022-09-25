package com.example.shapla_city_limited.validation;

import com.example.shapla_city_limited.dto.RequestClientDto;

import java.util.function.Function;

public interface ClientValidator extends Function<RequestClientDto, ClientValidator.ValidationResult> {
    static ClientValidator isPhoneNumberValid(){
        return request -> new PhoneNumberValidator().test(request.getPhoneNumber()) ? ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }
    static ClientValidator isWhatsAppNumberValid(){
        return request -> new PhoneNumberValidator().test(request.getContactWhatsApp()) ? ValidationResult.SUCCESS : ValidationResult.WHATS_APP_NUMBER_NOT_VALID;
    }
    default ClientValidator and(ClientValidator other){
        return appUser -> {
            ValidationResult result = this.apply(appUser);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(appUser) : result;
        };
    }

    enum ValidationResult{
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        WHATS_APP_NUMBER_NOT_VALID
    }
}
