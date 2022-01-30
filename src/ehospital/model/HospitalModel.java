package ehospital.model;

import java.util.Date;

public abstract class HospitalModel {
    protected long id;
    private Date data_date;
    private Integer active;
    private long r;

    public long getR() {
        return r;
    }

    public void setR(long r) {
        this.r = r;
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData_date() {
        return data_date;
    }

    public void setData_date(Date data_date) {
        this.data_date = data_date;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
