package com.shimanskii;

public class CustomObject {

    String name;
    long id;
    int age;
    float weight;
    double credits;

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public float getWeight() {
        return weight;
    }

    public double getCredits() {
        return credits;
    }

    public CustomObject() {
    }

    public CustomObject(String name, long id, int age, float weight, double credits) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.credits = credits;
    }

    @Override
    public int hashCode() {

        // id==007 gives hard-coded hash

        if (this.id==007){
            return 777;
        }

        else {int result = 17;

            result = 31 * result + name.hashCode();
            result = 31 * result + (int) id ;
            result = 31 * result + age;
            result = 31 * result + Float.floatToIntBits(weight);
            long creditsLong = Double.doubleToLongBits(credits);
            result = 31 * result + (int) creditsLong ;

            return result;}

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomObject that = (CustomObject) o;
        return id == that.id &&
                age == that.age &&
                Float.compare(that.weight, weight) == 0 &&
                Double.compare(that.credits, credits) == 0 &&

                name.equals(that.name);
    }

    @Override
    public String toString() {
        String description;
        description = "Custom object named " + getName() + " , aged "+  getAge() + ", with id " + getId() + " , in possession of " + getCredits() + " credits. ";

        return description;
    }
}
