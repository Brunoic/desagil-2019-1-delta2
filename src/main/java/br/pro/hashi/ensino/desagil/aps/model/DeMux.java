package br.pro.hashi.ensino.desagil.aps.model;

public class DeMux extends Gate {
    private final NandGate nandGateA;
    private final NandGate nandGateB;
    private final NandGate nandGateC;
    private final NandGate nandGateD;
    private final NandGate nandGateE;

    public DeMux() {
        super("DeMux", 2, 2);
        this.nandGateA = new NandGate();
        this.nandGateB = new NandGate();
        this.nandGateC = new NandGate();
        this.nandGateD = new NandGate();
        this.nandGateE = new NandGate();

        this.nandGateD.connect(1, this.nandGateB);
        this.nandGateD.connect(0, this.nandGateB);

        this.nandGateE.connect(1, this.nandGateC);
        this.nandGateE.connect(0, this.nandGateC);

        this.nandGateB.connect(1, this.nandGateA);

    }

    @Override
    public boolean read(int outputPin) {
        if (outputPin < 0 || outputPin > 1) {
            throw new IndexOutOfBoundsException(outputPin);
        }
        if (outputPin == 0) {
            return this.nandGateD.read(0);
        } else {
            return this.nandGateE.read(0);

        }
    }


    @Override
    public void connect(int inputPin, SignalEmitter emitter) {
        if (inputPin < 0 || inputPin > 1) {
            throw new IndexOutOfBoundsException(inputPin);
        }
        if (inputPin == 0) {
            this.nandGateB.connect(0, emitter);
            this.nandGateC.connect(1, emitter);

        } else {
            this.nandGateA.connect(0, emitter);
            this.nandGateA.connect(1, emitter);
        }

    }

}
