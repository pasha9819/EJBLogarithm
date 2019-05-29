package beans.managed;

import beans.session.LogarithmExecutorBean;
import database.DataBaseUtil;
import database.entity.LogarithmEntity;
import database.entity.LogarithmEntityPK;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

@ManagedBean
@SessionScoped
@XmlRootElement
public class LogarithmBean implements Serializable {
    private double arg;
    private double base;
    private double result;

    @EJB
    @XmlTransient
    private LogarithmExecutorBean logarithmExecutorBean;

    @EJB
    @XmlTransient
    private DataBaseUtil dataBaseUtil;

    public LogarithmBean(){    }

    public LogarithmBean(double arg, double base, double result) {
        this.arg = arg;
        this.base = base;
        this.result = result;
    }

    public double getArg() {
        return arg;
    }

    public void setArg(double arg) {
        this.arg = arg;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String calcResult(){
        LogarithmEntity logarithm = dataBaseUtil.select(new LogarithmEntityPK(arg, base));
        if (logarithm == null) {
            result = logarithmExecutorBean.logarithm(arg, base);
            dataBaseUtil.insert(new LogarithmEntity(arg, base, result));
        }
        else {
            result = logarithm.getResult();
        }
        return "/result.xhtml?faces-redirect=true";
    }
}
