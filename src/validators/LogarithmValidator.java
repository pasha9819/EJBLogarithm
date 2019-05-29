package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validators.LogarithmValidator")
public class LogarithmValidator implements Validator<Double> {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent,
                         Double aDouble) throws ValidatorException {
        /* true - if aDouble is value of argument
         false - if aDouble is value of base */
        boolean aDoubleIsArgument = uiComponent.getId().equals("arg");

        uiComponent.getAttributes().put("style", "");

        if (aDouble == null){
            throwError(uiComponent, "Вы пропустили поле!");
        }

        //noinspection ConstantConditions
        if (aDouble <= 0){
            String paramName = aDoubleIsArgument ? "Аргумент должен " : "Основание должно ";
            throwError(uiComponent, paramName + "быть положительным!");
        }

        if (aDouble == 1 && !aDoubleIsArgument){
            throwError(uiComponent, "Основание не может равняться 1!");
        }
    }

    private void throwError(UIComponent uiComponent, String message) throws ValidatorException{
        FacesMessage mes = new FacesMessage(message);
        mes.setSeverity(FacesMessage.SEVERITY_ERROR);
        uiComponent.getAttributes().put("style", "border-color: red;");
        throw new ValidatorException(mes);
    }
}
