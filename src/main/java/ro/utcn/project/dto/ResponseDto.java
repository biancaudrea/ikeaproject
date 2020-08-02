package ro.utcn.project.dto;

public class ResponseDto {

    private String message;
    private String optionPaneType;

    public ResponseDto(String message, String severity) {
        this.message = message;
        this.optionPaneType = severity;
    }

    public String getMessage() {
        return message;
    }

    public String getOptionPaneType() {
        return optionPaneType;
    }
}