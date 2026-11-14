package com.example.practia;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Casca implements Parcelable {

    public String model;
    public int autonomieOre;
    public  TipCasca tipCasca;
    public boolean areNoiseCancelling;

    public Casca(String model, int autonomieOre, TipCasca tipCasca, boolean areNoiseCancelling) {
        this.model = model;
        this.autonomieOre = autonomieOre;
        this.tipCasca = tipCasca;
        this.areNoiseCancelling = areNoiseCancelling;
    }

    public Casca() {
        this.model = "";
        this.autonomieOre = 0;
        this.tipCasca = TipCasca.IN_EAR;
        this.areNoiseCancelling = true;
    }

    protected Casca(Parcel in) {
        model = in.readString();
        autonomieOre = in.readInt();
        areNoiseCancelling = in.readByte() != 0;
    }

    public static final Creator<Casca> CREATOR = new Creator<Casca>() {
        @Override
        public Casca createFromParcel(Parcel in) {
            return new Casca(in);
        }

        @Override
        public Casca[] newArray(int size) {
            return new Casca[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(model);
        parcel.writeInt(autonomieOre);
        parcel.writeByte((byte) (areNoiseCancelling ? 1 : 0));
    }

    @Override
    public String toString() {
        return "Casca{" +
                "model='" + model + '\'' +
                ", autonomieOre=" + autonomieOre +
                ", tipCasca=" + tipCasca +
                ", areNoiseCancelling=" + areNoiseCancelling +
                '}';
    }
}
