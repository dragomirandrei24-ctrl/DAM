package ase.laborator5;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.List;

public class Computer implements Parcelable {
    Integer ram;
    Integer storage;
    String Manufacter;
    Date purchaceDate;
    Boolean touchScreen;
    public List<String> OptiuniExtra;

    public Boolean getTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(Boolean touchScreen) {
        this.touchScreen = touchScreen;
    }

    public List<String> getOptiuniExtra() {
        return OptiuniExtra;
    }

    public void setOptiuniExtra(List<String> optiuniExtra) {
        OptiuniExtra = optiuniExtra;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public String getManufacter() {
        return Manufacter;
    }

    public void setManufacter(String manufacter) {
        Manufacter = manufacter;
    }

    public Date getPurchaceDate() {
        return purchaceDate;
    }

    public void setPurchaceDate(Date purchaceDate) {
        this.purchaceDate = purchaceDate;
    }

    public static final Creator<Computer> CREATOR = new Creator<Computer>() {
        @Override
        public Computer createFromParcel(Parcel in) {
            return new Computer(in);
        }

        @Override
        public Computer[] newArray(int size) {
            return new Computer[size];
        }
    };

    @Override
    public String toString() {
        return "Computer{" +
                "ram=" + ram +
                ", storage=" + storage +
                ", Manufacter='" + Manufacter + '\'' +
                ", purchaceDate=" + purchaceDate +
                ", touchScreen=" + touchScreen +
                ", OptiuniExtra=" + OptiuniExtra +
                '}';
    }

    public Computer(Integer ram, Integer storage, String manufacter, Date purchaceDate, Boolean touchScreen, List<String> optiuniExtra) {
        this.ram = ram;
        this.storage = storage;
        Manufacter = manufacter;
        this.purchaceDate = purchaceDate;
        this.touchScreen = touchScreen;
        OptiuniExtra = optiuniExtra;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Computer(Parcel in){
        ram = in.readInt();
        storage = in.readInt();
        Manufacter = in.readString();
        purchaceDate = (Date) in.readSerializable();
        touchScreen = in.readByte() != 0;
        OptiuniExtra = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(ram != null ? ram : 0);
        dest.writeInt(storage != null ? storage : 0);
        dest.writeString(Manufacter);
        dest.writeSerializable(purchaceDate);
        dest.writeByte((byte) (Boolean.TRUE.equals(touchScreen) ? 1 : 0));
        dest.writeStringList(OptiuniExtra);
    }
}
