package org.example.interfaceadapt;

import org.example.classadapt.AC220;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-03 17:52:44
 */
public class PowerAdapter implements DC {

    private final AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int output5V() {
        int adapterInput = ac220.outputAC220V();
        int adapterOutput = adapterInput/44;
        System.out.println("Using adapter : input(AC) : " + adapterInput + ", output(DC) : " + adapterOutput);
        return adapterOutput;
    }

    @Override
    public int output12V() {
        return 0;
    }

    @Override
    public int output24V() {
        return 0;
    }

    @Override
    public int output36V() {
        return 0;
    }
}
