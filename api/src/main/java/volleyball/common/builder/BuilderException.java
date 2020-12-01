package volleyball.common.builder;

public class BuilderException extends Exception {

    public BuilderException(String msg) {
        super(msg);
    }

    public BuilderException(Exception e) {
        super(e);
    }
}
