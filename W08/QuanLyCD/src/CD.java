import java.io.Serializable;

public class CD implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String maCD;
    private String tuaCD, caSy;
    private int soBaiHat;
    private double giaThanh;

    public CD(String maCD, String tuaCD, String caSy, int soBaiHat, double giaThanh) {
        this.maCD = maCD;
        this.tuaCD = tuaCD;
        this.caSy = caSy;
        this.soBaiHat = soBaiHat;
        this.giaThanh = giaThanh;
    }

    public CD(String maCD) {
        this(maCD, "", "", 0, 0.0);
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public void setTuaCD(String tuaCD) {
        this.tuaCD = tuaCD;
    }

    public String getCaSy() {
        return caSy;
    }

    public void setCaSy(String caSy) {
        this.caSy = caSy;
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        this.soBaiHat = soBaiHat;
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        this.giaThanh = giaThanh;
    }

    public String getMaCD() {
        return maCD;
    }

    @Override
    public boolean equals(Object obj) {
        return this.maCD.equalsIgnoreCase(((CD) obj).maCD);
    }
}