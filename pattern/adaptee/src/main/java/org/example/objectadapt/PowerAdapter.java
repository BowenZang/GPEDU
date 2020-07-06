package org.example.objectadapt;

import org.example.classadapt.AC220;
import org.example.classadapt.DC5V;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-03 11:46:01
 */
public class PowerAdapter implements DC5V {

    private final AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5V() {
        int adapterInput = ac220.outputAC220V();
        int adapterOutput = adapterInput/44;
        System.out.println("Using adapter : input(AC) : " + adapterInput + ", output(DC) : " + adapterOutput);
        return adapterOutput;
    }
}
