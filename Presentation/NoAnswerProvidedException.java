package Presentation;

public class NoAnswerProvidedException extends IllegalArgumentException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NoAnswerProvidedException() {
        super("Internal error. The provided answer is not excepted.\n");
    }
    

    
}
