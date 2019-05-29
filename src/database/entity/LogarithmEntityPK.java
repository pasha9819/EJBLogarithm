package database.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class LogarithmEntityPK implements Serializable {
    private double arg;
    private double base;

    public LogarithmEntityPK() {
    }

    public LogarithmEntityPK(double arg, double base) {
        this.arg = arg;
        this.base = base;
    }

    @Column(name = "arg", nullable = false, precision = 0)
    @Id
    public double getArg() {
        return arg;
    }

    public void setArg(double arg) {
        this.arg = arg;
    }

    @Column(name = "base", nullable = false, precision = 0)
    @Id
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogarithmEntityPK that = (LogarithmEntityPK) o;
        return Double.compare(that.arg, arg) == 0 &&
                Double.compare(that.base, base) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(arg, base);
    }
}
