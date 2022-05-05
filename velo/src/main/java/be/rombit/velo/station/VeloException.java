package be.rombit.velo.station;

public class VeloException extends RuntimeException {

    public VeloException(String message) {
        super(message);
    }

    public VeloException(Exception exception) {
        super(exception);
    }

}
