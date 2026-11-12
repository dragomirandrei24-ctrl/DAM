package com.example.aplicatie_seminar_4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public class Drona implements Parcelable {

    // Enum pentru Spinner
    public enum CategorieDrona {
        HOBBY, PROFESIONALA, INDUSTRIALA, MILITARA
    }

    private String model;                 // String (din EditText)
    private int autonomieMinute;          // int (din EditText numeric)
    private boolean areCamera4K;          // boolean (din Switch)
    private String tipControl;            // String (din RadioGroup / RadioButton)
    private CategorieDrona categorie;     // enum (din Spinner)
    private float ratingPerformanta;      // float (din RatingBar)
    private String[] optiuniExtra;        // String[] (din CheckBox-uri)

    public Drona(String model, int autonomieMinute, boolean areCamera4K,
                 String tipControl, CategorieDrona categorie,
                 float ratingPerformanta, String[] optiuniExtra) {
        this.model = model;
        this.autonomieMinute = autonomieMinute;
        this.areCamera4K = areCamera4K;
        this.tipControl = tipControl;
        this.categorie = categorie;
        this.ratingPerformanta = ratingPerformanta;
        this.optiuniExtra = optiuniExtra;
    }

    // Constructorul pentru Parcelable
    protected Drona(Parcel in) {
        model = in.readString();
        autonomieMinute = in.readInt();
        areCamera4K = in.readByte() != 0;
        tipControl = in.readString();
        String catName = in.readString();
        categorie = catName != null ? CategorieDrona.valueOf(catName) : CategorieDrona.HOBBY;
        ratingPerformanta = in.readFloat();
        optiuniExtra = in.createStringArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(model);
        dest.writeInt(autonomieMinute);
        dest.writeByte((byte) (areCamera4K ? 1 : 0));
        dest.writeString(tipControl);
        dest.writeString(categorie != null ? categorie.name() : CategorieDrona.HOBBY.name());
        dest.writeFloat(ratingPerformanta);
        dest.writeStringArray(optiuniExtra);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Drona> CREATOR = new Creator<Drona>() {
        @Override
        public Drona createFromParcel(Parcel in) {
            return new Drona(in);
        }

        @Override
        public Drona[] newArray(int size) {
            return new Drona[size];
        }
    };

    // Formatat exact ca în captura de ecran din prezentare
    @Override
    public String toString() {
        return "Drona{" +
                "Model='" + model + '\'' +
                ",\nAutonomie=" + autonomieMinute + " min" +
                ",\nAreCamera4K=" + areCamera4K +
                ",\nControl='" + tipControl + '\'' +
                ",\nCategorie=" + categorie +
                ",\nRating=" + ratingPerformanta +
                ",\nOptiuniExtra=" + Arrays.toString(optiuniExtra) +
                '}';
    }
}