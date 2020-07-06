package org.example.classadapt;

/**
 * adapter
 * @author 003169
 * @since Create by BowenZang on 2020-07-03 11:40:43
 */
public class PowerAdapter extends AC220 implements DC5V {

    @Override
    public int outputDC5V() {
        int adapterInput = super.outputAC220V();
        int adapterOutput = adapterInput/44;
        System.out.println("Using adapter : input(AC) : " + adapterInput + ", output(DC) : " + adapterOutput);
        return adapterOutput;
    }

}
