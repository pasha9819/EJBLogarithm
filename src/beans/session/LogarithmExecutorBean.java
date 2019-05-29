package beans.session;

import javax.ejb.Stateless;

import java.io.Serializable;

import static java.lang.Math.log;

@Stateless
public class LogarithmExecutorBean implements Serializable {
    public double logarithm(double arg, double base){
        return log(arg) / log(base);
    }
}
