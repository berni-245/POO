public class InvalidGradeException extends RuntimeException{
    private static final String DEFAULT_MESSAGE = "An invalid grade was input";
    //por qué falla si no pongo static?
    InvalidGradeException(String errorMessage){
        super(errorMessage);
    }

    InvalidGradeException(){
        super(DEFAULT_MESSAGE);
    }
}
