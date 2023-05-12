package com.algaworks.algafood.core.validation;

import org.springframework.beans.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;
import java.math.BigDecimal;

public class ValorZeroIncluiDescricaoValidator implements ConstraintValidator<ValorZeroIncluiDescricao, Object> {

    private String valorField;
    private String descricaoField;
    private String descricaoObrigatoria;

    @Override
    public void initialize(ValorZeroIncluiDescricao constraint) {
        this.valorField = constraint.valorField();
        this.descricaoField = constraint.descricaoField();
        this.descricaoObrigatoria = constraint.descricaoObrigatoria();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        boolean valido = true;

        try {
            BigDecimal valor = (BigDecimal) BeanUtils.getPropertyDescriptor(obj.getClass(), valorField)
                    .getReadMethod().invoke(obj);
            String descricao = (String) BeanUtils.getPropertyDescriptor(obj.getClass(), descricaoField)
                    .getReadMethod().invoke(obj);

            if (valor != null && BigDecimal.ZERO.compareTo(valor) == 0 && descricao != null) {
                valido = descricao.toLowerCase().contains(this.descricaoObrigatoria.toLowerCase());
            }
            
            return valido;
        } catch (Exception e) {
            throw new ValidationException(e);
        }
    }
}
