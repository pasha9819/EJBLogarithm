package database.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "logarithm", schema = "tnp")
@IdClass(LogarithmEntityPK.class)
public class LogarithmEntity {
    private double arg;
    private double base;
    private double result;

    public LogarithmEntity() {
    }

    public LogarithmEntity(double arg, double base, double result) {
        this.arg = arg;
        this.base = base;
        this.result = result;
    }

    @Id
    @Column(name = "arg", nullable = false, precision = 0)
    public double getArg() {
        return arg;
    }

    public void setArg(double arg) {
        this.arg = arg;
    }

    @Id
    @Column(name = "base", nullable = false, precision = 0)
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    @Basic
    @Column(name = "result", nullable = false, precision = 0)
    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogarithmEntity that = (LogarithmEntity) o;
        return Double.compare(that.arg, arg) == 0 &&
                Double.compare(that.base, base) == 0 &&
                Double.compare(that.result, result) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(arg, base, result);
    }
}
