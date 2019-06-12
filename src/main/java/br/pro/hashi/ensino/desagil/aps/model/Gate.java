package br.pro.hashi.ensino.desagil.aps.model;

public abstract class Gate implements SignalEmitter, SignalReceiver {
    private final String name;
    private final int inputSize;
    private final int outputSize;
    // --Commented out by Inspection (12/06/2019 16:41):private final int outputSize;

    protected Gate(String name, int inputSize, int outputSize) {
        this.name = name;
        this.inputSize = inputSize;
        this.outputSize = outputSize;
    }

    public String toString() {
        return name;
    }

    public int getInputSize() {
        return inputSize;
    }

// --Commented out by Inspection START (12/06/2019 16:39):
//    public int getOutputSize() {
//        return outputSize;
//    }
// --Commented out by Inspection STOP (12/06/2019 16:39)
}
